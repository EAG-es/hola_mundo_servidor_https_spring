/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inweb.spring.hola_mundo_servidor_https_spring.controlador;

import innui.modelos.errores.oks;
import static inweb.spring.hola_mundo_servidor_https_spring.controlador.con_hola_mundo_servidor_https_spring.k_hola_mundo;
import inweb.spring.servidor_https_spring.controlador.pagina_inicio_factoria;
import java.util.ResourceBundle;
import org.springframework.ui.Model;

/**
 *
 * @author emilio
 */
public class pagina_inicio extends pagina_inicio_factoria {
    public static String k_in_ruta = "in/inweb/spring/hola_mundo_servidor_https_spring/controlador/in";

    @Override
    public String presentar_inicio(Model model, oks ok, Object... extra_array) throws Exception {
        ResourceBundle in;
        String text = "redirect:" + k_hola_mundo;
        return text;
    }

}
