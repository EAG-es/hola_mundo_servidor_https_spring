package inweb.spring.hola_mundo_servidor_https_spring;

import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.errores.oks;
import innui.modelos.modelos;
import inweb.spring.hola_mundo_servidor_https_spring.controlador.pagina_inicio;
import inweb.spring.servidor_https_spring.Servidor_https_spring;
import inweb.spring.servidor_https_spring.controlador.pagina_inicio_factoria;
import static java.lang.System.exit;
import java.util.ResourceBundle;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hola_mundo_servidor_https_spring extends Servidor_https_spring {

    public static void main(String[] args) {
        oks ok = new oks();
        try {
            Hola_mundo_servidor_https_spring servidor_https_spring 
                    = new Hola_mundo_servidor_https_spring();
            // Object [] extra_array = { args };
            servidor_https_spring.run(ok, Hola_mundo_servidor_https_spring.class, args);
        } catch (Exception e) {
            ok.setTxt(e);
        }
        if (ok.es == false) {
            System.err.println(ok.txt);
            exit(1);
        }
//		SpringApplication.run(Servidor_https_spring.class, args);
    }

    @Override
    public boolean run(oks ok, Object... extra_array) throws Exception {
        try {
            if (ok.es == false) { return ok.es; }
            ResourceBundle in;
            iniciar(ok);
            if (ok.es) {
                while (true) {
                    pagina_inicio_factoria.setPagina_inicio(new pagina_inicio());
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
