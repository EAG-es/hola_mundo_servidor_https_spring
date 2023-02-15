/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inweb.spring.hola_mundo_servidor_https_spring.controlador;

import innui.modelos.errores.oks;
import static inweb.spring.hola_mundo_servidor_https_spring.controlador.Con_hola_mundo_servidor_https_spring.k_hola_mundo;
import inweb.spring.servidor_https_spring.controlador.Pagina_inicio_factoria;
import org.springframework.ui.Model;

/**
 *
 * @author emilio
 */
public class Pagina_inicio extends Pagina_inicio_factoria {

    @Override
    public String presentar_inicio(Model model, oks ok, Object... extra_array) throws Exception {
        String text = "redirect:" + k_hola_mundo; // Orden de redirección a la página hola_mundo
        return text;
    }

}
