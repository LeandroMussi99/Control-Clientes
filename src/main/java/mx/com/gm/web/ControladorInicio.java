package mx.com.gm.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.Errors;

@Controller
@Slf4j  // acceso a la variable log 
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String Inicio(Model model, @AuthenticationPrincipal User user) {
        var personas = personaService.listaPersona();
        log.info("ejecutando el controlador Spring MVC"); // logs para la consola
        log.info("usuario que hizo login:" + user);
        model.addAttribute("personas", personas);
        var saldoTotal = 0D;
        for(var p: personas){
        saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) { // estos argumentoes deben ir siempre juntos
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        persona = personaService.enonctrarPersona(persona); // le pasamos la persona porque ya esta enlazada con el id
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
