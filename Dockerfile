# syntax=docker/dockerfile:1

# Comments are provided throughout this file to help you get started.
# If you need more help, visit the Dockerfile reference guide at
# https://docs.docker.com/engine/reference/builder/

################################################################################
# Pick a base image to serve as the foundation for the other build stages in
# this file.
#
# For illustrative purposes, the following FROM command
# is using the alpine image (see https://hub.docker.com/_/alpine).
# By specifying the "latest" tag, it will also use whatever happens to be the
# most recent version of that image when you build your Dockerfile.
# If reproducability is important, consider using a versioned tag
# (e.g., alpine:3.17.2) or SHA (e.g., alpine@sha256:c41ab5c992deb4fe7e5da09f67a8804a46bd0592bfdf0b1847dde0e0889d2bff).
FROM ubuntu:jammy as base

RUN apt-get update && \
    apt-get -y install openjdk-17-jdk openjdk-17-jre ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f
# Idioma Español
RUN apt-get -y install language-pack-es 

# JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
# export JAVA_HOME
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
RUN export JAVA_HOME
# PATH=$PATH:$JAVA_HOME/bin
# export PATH
ENV PATH=$PATH:$JAVA_HOME/bin
RUN export PATH
# Poner en Español
ENV LANG=es_ES.UTF-8
RUN export LANG
ENV LANGUAGE=es_ES.UTF-8
RUN export LANGUAGE
ENV LC_ALL=es_ES.UTF-8
RUN export LC_ALL

CMD ["java", "-version"]

################################################################################
# Create a stage for building/compiling the application.
#
# The following commands will leverage the "base" stage above to generate
# a "hello world" script and make it executable, but for a real application, you
# would issue a RUN command for your application's build process to generate the
# executable. For language-specific examples, take a look at the Dockerfiles in
# the Awesome Compose repository: https://github.com/docker/awesome-compose
# 
# NOTA: No se utiliza el escenario de construcción
# 
# FROM base as build
# COPY <<EOF /bin/hello.sh
# #!/bin/sh
# echo Hello world from $(whoami)! In order to get your application running in a container, take a look at the comments in the Dockerfile to get started.
# EOF
# RUN chmod +x /bin/hello.sh
# 
################################################################################
# Create a final stage for running your application.
#
# The following commands copy the output from the "build" stage above and tell
# the container runtime to execute it when the image is run. Ideally this stage
# contains the minimal runtime dependencies for the application as to produce
# the smallest image possible. This often means using a different and smaller
# image than the one used for building the application, but for illustrative
# purposes the "base" image is used here.
FROM base AS final

# Crear la carpeta de aplicaciones Java
RUN mkdir /java-17-openjdk
RUN chmod o+rwx /java-17-openjdk
# Crear la carpeta de salida de volume -v<ruta host>:<ruta contenedor>
RUN mkdir /java-17-openjdk/output
RUN chmod o+rwx /java-17-openjdk/output

# Copy the executable from the "build" stage.
# COPY --from=build /bin/hello.sh /bin/
COPY ./target/*.jar /java-17-openjdk

# Create a non-privileged user that the app will run under.
# See https://docs.docker.com/develop/develop-images/dockerfile_best-practices/#user
# Crear usuario
ARG UID=10001
RUN adduser \
    --disabled-password \
    --gecos "" \
    --home "/nonexistent" \
    --shell "/sbin/nologin" \
    --no-create-home \
    --uid "${UID}" \
    appuser

# Poner el usuario no interactivo, para ejecución 
USER appuser
# Puerto mapeados (expuestos) host:docker. Se debe usar -p 8443:443 al usar la imagen
EXPOSE 8443:443
# What the container should run when it is started.
# Entrypoint de shell ... o no shell ["...", "..."]
# ENTRYPOINT java
# Comando sin shell
# CMD ["java", "-jar", "/java-17-openjdk/hola_mundo-1.0.jar"]
# Comando de shell
CMD java -jar /java-17-openjdk/hola_mundo_servidor_https_spring-1.0.jar | tee -a /java-17-openjdk/output/hola_mundo.txt 
