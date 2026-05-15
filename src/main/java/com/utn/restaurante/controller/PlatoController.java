package com.utn.restaurante.controller; // Ruta completa de carpetas

import com.utn.restaurante.model.Plato; // Importo el modelo desde su carpeta
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/platos") // [cite: 14, 16]
public class PlatoController {

    private static final Logger logger = LoggerFactory.getLogger(PlatoController.class);
    
    // Lista en memoria como pide el trabajo [cite: 8, 12]
    private List<Plato> listaPlatos = new ArrayList<>();

    // PUNTO 1: Alta de Platos [cite: 7, 15]
    @PostMapping
    public String crearPlato(@RequestBody Plato plato) {
        listaPlatos.add(plato);
        logger.info("Se cargó un nuevo plato: {}", plato.getNombre());
        return "Registrado con éxito!";
    }

    // PUNTO 2: Listado Completo [cite: 9, 16]
    @GetMapping
    public List<Plato> listarTodos() {
        logger.info("Alguien pidió ver todo el menú");
        return listaPlatos;
    }

    // PUNTO 3: Consulta Individual por número [cite: 10, 17]
    @GetMapping("/{numero}")
    public Object obtenerPorNumero(@PathVariable int numero) {
        logger.info("Buscando el plato número {}", numero);
        for (Plato p : listaPlatos) {
            if (p.getNumeroPlato() == numero) {
                return p;
            }
        }
        return "Ese número de plato no existe.";
    }
}