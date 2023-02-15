package inweb.spring.hola_mundo_servidor_https_spring;

import innui.modelos.errores.oks;
import innui.modelos.modelos;
import inweb.spring.hola_mundo_servidor_https_spring.controlador.Pagina_inicio;
import inweb.spring.servidor_https_spring.Servidor_https_spring;
import inweb.spring.servidor_https_spring.controlador.Pagina_inicio_factoria;
import static java.lang.System.exit;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Opcional
public class Hola_mundo_servidor_https_spring extends Servidor_https_spring {

    public static void main(String[] args) {
        oks ok = new oks();
        try {
            Hola_mundo_servidor_https_spring servidor_https_spring 
                    = new Hola_mundo_servidor_https_spring();
            servidor_https_spring.run(ok, Hola_mundo_servidor_https_spring.class, args);
        } catch (Exception e) {
            ok.setTxt(e);
        }
        if (ok.es == false) {
            System.err.println(ok.txt);
            exit(1);
        }
        // Quitado:        
        //   SpringApplication.run(Servidor_https_spring.class, args);
    }

    @Override
    public boolean run(oks ok, Object... extra_array) throws Exception {
        try {
            if (ok.es == false) { return ok.es; }
            iniciar(ok);
            if (ok.es) {
                while (true) {
                    Pagina_inicio_factoria.setPagina_inicio(new Pagina_inicio());
                    if (ok.es == false) { break; }
                    super.run(ok, extra_array);
                    break;
                }
                terminar(ok);
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }

    @Override
    public boolean iniciar(oks ok, Object... extra_array) throws Exception {
        if (ok.es == false) { return ok.es; }
        super.iniciar(ok, extra_array);
        if (ok.getGravedad() > oks.k_gravedad_baja) { return ok.es; }
        ok.iniciar();
        _iniciar_desde_clase(modelos.class, ok);
        if (ok.getGravedad() > oks.k_gravedad_baja) { return ok.es; }
        ok.iniciar();
        _iniciar_desde_clase(Hola_mundo_servidor_https_spring.class, ok);
        if (ok.getGravedad() > oks.k_gravedad_baja) { return ok.es; }
        ok.iniciar();
        return ok.es;
    }

    @Override
    public boolean terminar(oks ok, Object... extra_array) throws Exception {
        if (ok.es == false) { return ok.es; }
        super.terminar(ok, extra_array);
        if (ok.getGravedad() > oks.k_gravedad_baja) { return ok.es; }
        ok.iniciar();
        _terminar_desde_clase(modelos.class, ok);
        if (ok.getGravedad() > oks.k_gravedad_baja) { return ok.es; }
        ok.iniciar();
        _terminar_desde_clase(Hola_mundo_servidor_https_spring.class, ok);
        if (ok.getGravedad() > oks.k_gravedad_baja) { return ok.es; }
        ok.iniciar();
        return ok.es;
    }
}
