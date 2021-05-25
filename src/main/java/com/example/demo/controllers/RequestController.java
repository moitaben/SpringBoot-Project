package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import com.example.demo.models.modeloJugador;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.services.funcionalidadeServices;
import org.springframework.context.annotation.Bean;

@Controller
public class RequestController {

@Bean
	public modeloJugador getmodeloJugador(){
		return new modeloJugador();
	}

    @Autowired
    funcionalidadeServices funcionalidadeServices;

    @Autowired
    modeloJugador modeloJugador;

    @RequestMapping("/guardarjugador")
    public String formulario(Model model) {
        return "guardardatos";
    }

    @RequestMapping("/listar")
  public String listarJugadores(Model model) {
    ArrayList<modeloJugador> jugadores = funcionalidadeServices.listarJugadores();
    model.addAttribute("jugadores", jugadores);
    return "listajugadores";
  }

}
