package br.com.projeto.projeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversaoTemperatura {

    // Conversão de Celsius para Fahrenheit
    @GetMapping("/celsiusParaFahrenheit")
    public String celsiusParaFahrenheit(@RequestParam("grau") double grau) {
        double fahrenheit = (grau * 9/5) + 32;
        return grau + "ºC é igual a " + fahrenheit + "ºF";
    }

    // Conversão de Fahrenheit para Celsius
    @GetMapping("/fahrenheitParaCelsius")
    public String fahrenheitParaCelsius(@RequestParam("grau") double grau) {
        double celsius = (grau - 32) * 5/9;
        return grau + "ºF é igual a " + celsius + "ºC";
    }
}
