package com.example.demo.controllers;


import com.example.demo.models.modeloJugador;
import com.example.demo.services.FuncionalidadeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class FuncionalidadesController {

    @Autowired
    FuncionalidadeServices FuncionalidadeServices;


    @GetMapping("/contar/{palabra}")
    public String contarLetras(@PathVariable String palabra) {
        String total = FuncionalidadeServices.contarLetras(palabra);
        return total;
    }

    @GetMapping("/{palabra}")
    public String consonantesMayusculas(@PathVariable String palabra) {
        String resultado = FuncionalidadeServices.consonantesMayusculas(palabra);
        return resultado;
    }

    @GetMapping("/traduce/{palabra}")
    public String traducir(@PathVariable String palabra) {
        String traducido = FuncionalidadeServices.traducir(palabra);
        return traducido;
    }

    @PostMapping("/guarda")
    public String insertaJugador(@RequestParam Map<String, String> body) {
        modeloJugador jugador = new modeloJugador();
        jugador.setNombre(body.get("nombre"));
        jugador.setEquipo(body.get("equipo"));
        jugador.setGoles(Integer.parseInt(body.get("goles")));
        FuncionalidadeServices.guardarJugador(jugador);
        return "he guardado los datos del jugador";
    }

    @GetMapping("/listar")
    public String listarJugadores() {
        return FuncionalidadeServices.listarJugadores().toString();
    }

}