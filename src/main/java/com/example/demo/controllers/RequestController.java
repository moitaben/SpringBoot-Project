package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RequestController {

    @RequestMapping("/guardarjugador")
    public String formulario(Model model) {
        return "guardardatos";
    }
@RequestMapping("/listar")
  public String listarJugadores(Model model) {
    ArrayList<modeloJugador> jugadores = funcionalidadeService.listarJugadores();
    model.addAttribute("jugadores", jugadores);
    return "listaJugadores";
  }

}
