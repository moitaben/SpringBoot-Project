package com.example.demo.controllers;


import com.example.demo.models.modeloJugador;
import com.example.demo.services.funcionalidadeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class funcionalidadesController {

    @Autowired
    funcionalidadeServices funcionalidadeServices;


    @GetMapping("/contar/{palabra}")
    public String contarLetras(@PathVariable String palabra) {
        String total = funcionalidadeServices.contarLetras(palabra);
        return total;
    }

    @GetMapping("/{palabra}")
    public String consonantesMayusculas(@PathVariable String palabra) {
        String resultado = funcionalidadeServices.consonantesMayusculas(palabra);
        return resultado;
    }

    @GetMapping("/traduce/{palabra}")
    public String traducir(@PathVariable String palabra) {
        String traducido = funcionalidadeServices.traducir(palabra);
        return traducido;
    }

    @PostMapping("/guarda")
    public String insertaJugador(@RequestParam Map<String, String> body) {
        modeloJugador jugador = new modeloJugador();
        jugador.setNombre(body.get("nombre"));
        jugador.setEquipo(body.get("equipo"));
        jugador.setGoles(Integer.parseInt(body.get("goles")));
        funcionalidadeServices.guardarJugador(jugador);
        return "he guardado los datos del jugador";
    }

}