package com.example.demo.services;

import com.example.demo.repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.models.modeloJugador;
import com.example.demo.repositories.JugadorRepository;
import java.util.ArrayList;


class ResponseData {
    public String translatedText;
}

class Traducido {
    public ResponseData responseData;
}


@Service
public class funcionalidadeServices {
    @Autowired
    JugadorRepository  jugadorRepository;
    @Autowired
    RestTemplate restTemplate;



    private boolean esConsonante(char letra) {
        return "bcdfghjklmnñpqrstvwxyz".contains(String.valueOf(letra).toLowerCase());
    }

    public String contarLetras(String palabra) {
        int consonantes = 0;
        int vocales = 0;
        for (int x = 0; x < palabra.length(); x++) {
            char letra = palabra.charAt(x);
            if (esConsonante(letra)) {
                consonantes++;
            } else  {
                vocales++;
            }
        }

        return "La palabra " + palabra + " tiene un total de : " + consonantes + " consonantes y " + vocales + " vocales ";
    }


    public String consonantesMayusculas(String palabra) {
        String mayusculas = "";
        for (int i = 0; i < palabra.length(); i++) {
            if (esConsonante(palabra.charAt(i))) {
                mayusculas += Character.toUpperCase(palabra.charAt(i));
            } else {
                mayusculas += palabra.charAt(i);
            }
        }
        return mayusculas;
    }

    public String traducir(String frase) {
        String url = "https://api.mymemory.translated.net/get?q=" + frase + "&langpair=es|en";
        Traducido json = restTemplate.getForObject(url, Traducido.class);
        return json.responseData.translatedText;
    }

    public ArrayList<modeloJugador> listarJugadores() {
        return (ArrayList<modeloJugador>) jugadorRepository.findAll();
    }

    public modeloJugador guardarJugador(modeloJugador jugador) {
        return jugadorRepository.save(jugador);
    }
}







