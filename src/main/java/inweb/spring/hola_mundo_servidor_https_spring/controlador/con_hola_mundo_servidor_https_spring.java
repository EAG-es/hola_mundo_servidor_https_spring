package inweb.spring.hola_mundo_servidor_https_spring.controlador;

import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.configuraciones.Resources;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import static inweb.spring.servidor_https_spring.controlador.pagina_inicio_factoria.k_ok_txt;
import static inweb.spring.servidor_https_spring.controlador.pagina_inicio_factoria.k_titulo_txt;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author emilio
 */
@Controller
public class con_hola_mundo_servidor_https_spring {
    public static String k_in_ruta = "in/inweb/spring/hola_mundo_servidor_https_spring/controlador/in";
    public static String k_hola_mundo = "hola_mundo";
    public static String k_index_html = k_hola_mundo + "/index.html";
    
    @GetMapping("hola_mundo")
    public String hola_mundo(Model model) throws Exception {
        oks ok = new oks();
        ResourceBundle in;
        try {
            in = ResourceBundles.getBundle(k_in_ruta);
            String texto = tr.in(in, "¡Hola Mundo! ");
            model.addAttribute(k_titulo_txt, texto);
        } catch (Exception e) {
            in = ResourceBundles.getBundle(k_in_ruta);
            ok.setTxt(tr.in(in, "Excepción inesperada "), e);
            model.addAttribute(k_ok_txt, ok.getTxt());
        }
        return k_index_html;
    }
    
}
