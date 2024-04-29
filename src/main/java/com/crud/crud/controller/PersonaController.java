package com.crud.crud.controller;

import com.crud.crud.model.Persona;
import com.crud.crud.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sound.midi.Soundbank;
import java.util.Optional;

@Controller
public class PersonaController {

    @Autowired
    private IPersonaService iPersonaService;

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("usuarios", iPersonaService.getAll());
        return "index";
    }

    @GetMapping("/nuevo_usuario")
    public String formUsuario() {
        return "nuevo_usuario";
    }

    @GetMapping("/modificar/{id}")
    public String modificarUsuario(@PathVariable Long id, Model model) {

        Optional<Persona> personaOptional = iPersonaService.findById(id);

        model.addAttribute("usuariosModificar", personaOptional);

        return "modificar_usuario";
    }

    @PostMapping("/crear")
    public String crearNuevoUsuario(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido,
            @RequestParam("correo") String correo) {

        Optional<Persona> personaop;

        if (id != null) {

            personaop = iPersonaService.findById(id);


            if (personaop.isPresent()) {
                Persona per = personaop.get();
                per.setNombre(nombre);
                per.setApellido(apellido);
                per.setCorreo(correo);

                iPersonaService.save(per);
                return "redirect:/";
            }
        } else {

            Persona persona = new Persona();
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setCorreo(correo);

            iPersonaService.save(persona);
        }


        return "redirect:/";
    }

}
