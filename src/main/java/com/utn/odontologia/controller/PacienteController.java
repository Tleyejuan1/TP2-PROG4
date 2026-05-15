package com.utn.odontologia.controller;

import com.utn.odontologia.model.Paciente;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    private List<Paciente> listaPacientes = new ArrayList<>();

    @PostMapping
    public String registrarPaciente(@RequestBody Paciente pac) {
        listaPacientes.add(pac);
        return "Paciente registrado con éxito: " + pac.getNombre();
    }

    @GetMapping
    public List<Paciente> listarTodos() {
        return listaPacientes;
    }

    @GetMapping("/menores")
    public List<Paciente> listarMenores() {
        LocalDate hoy = LocalDate.now();
        List<Paciente> menores = new ArrayList<>();
        for (Paciente p : listaPacientes) {
            if (p.getFechaNacimiento() != null) {
                int edad = Period.between(p.getFechaNacimiento(), hoy).getYears();
                if (edad < 18) {
                    menores.add(p);
                }
            }
        }
        return menores;
    }
}