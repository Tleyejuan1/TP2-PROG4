package com.utn.restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class RestauranteApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestauranteApplication.class, args);
    }

    // cuando springboot corre todo luego inicia, SINO CON ESTE LINK
    @EventListener(ApplicationReadyEvent.class)
    public void abrirPaginaAlArranque() {
        String url = "http://localhost:8080/index.html";
        
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(url));
            } else {
                // Sistemas que para linux y demas
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
            }
        } catch (Exception e) {
            System.err.println("No se pudo abrir el navegador solo, pero entrá acá: " + url);
        }
    }
}