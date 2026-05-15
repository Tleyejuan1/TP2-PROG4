package com.utn.restaurante; // Está en la carpeta raíz del proyecto

import com.utn.restaurante.model.Plato;
import com.utn.restaurante.controller.PlatoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class MenuApplication implements CommandLineRunner {

    @Autowired
    private PlatoController platoController;

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        int opcion = -1;

        Thread.sleep(1500); // Pausa para que no se pise con el arranque de Spring

        while (opcion != 0) {
            System.out.println("\n--- GESTIÓN DE MENÚ (UTN VM) ---");
            System.out.println("1. Cargar plato (POST)");
            System.out.println("2. Ver todo el menú (GET)");
            System.out.println("3. Buscar plato por ID (GET Param)");
            System.out.println("0. Salir");
            System.out.print("Elegí una opción: ");
            
            try {
                opcion = Integer.parseInt(sc.nextLine());

                if (opcion == 1) {
                    System.out.print("Número: ");
                    int num = Integer.parseInt(sc.nextLine());
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    System.out.print("Precio: ");
                    double pre = Double.parseDouble(sc.nextLine());
                    System.out.print("Descripción: ");
                    String desc = sc.nextLine();

                    platoController.crearPlato(new Plato(num, nom, pre, desc));
                    System.out.println("Cargado correctamente.");

                } else if (opcion == 2) {
                    platoController.listarTodos().forEach(p -> 
                        System.out.println(p.getNumeroPlato() + " - " + p.getNombre() + " ($" + p.getPrecio() + ")")
                    );
                } else if (opcion == 3) {
                    System.out.print("Número a buscar: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Object res = platoController.obtenerPorNumero(id);
                    
                    if (res instanceof Plato) {
                        Plato p = (Plato) res;
                        System.out.println("Encontrado: " + p.getNombre() + " [" + p.getDescripcion() + "]");
                    } else {
                        System.out.println(res);
                    }
                }
            } catch (Exception e) {
                System.out.println("Dato no válido, probá de nuevo.");
            }
        }
    }
}