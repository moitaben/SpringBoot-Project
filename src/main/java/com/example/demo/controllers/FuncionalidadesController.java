package com.example.demo.controllers;


import com.example.demo.services.FuncionalidadeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionalidadesController {

@Autowired
FuncionalidadeServices FuncionalidadeServices;


    @GetMapping("/contar/{palabra}")
    public String contarLetras(@PathVariable String palabra){
      String total =   FuncionalidadeServices.contarLetras(palabra);
      return total;
    }

    @GetMapping("/{palabra}")
    public String consonantesMayusculas(@PathVariable String palabra){
        String resultado= FuncionalidadeServices.consonantesMayusculas(palabra);
        return resultado;
    }

    @GetMapping("/traduce/{palabra}")
    public String traducir(@PathVariable String palabra){
       String traducido = FuncionalidadeServices.traducir(palabra);
       return traducido;
    }

}
