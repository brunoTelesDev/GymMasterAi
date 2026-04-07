package com.gymmaster.ai.controller;

import com.gymmaster.ai.service.WorkoutService; // Import necessário!
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired; // Import necessário!
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workouts")
@Tag(name = "Treinos")
public class WorkoutController {

    @Autowired // LINHA 14: Diz ao Spring para conectar o Service automaticamente
    private WorkoutService workoutService;

    @Operation(summary = "Gera um treino via IA")
    @PostMapping("/gerar")
    public String criarTreino(@RequestParam String nome, @RequestParam String objetivo) {
        // Aqui o Controller chama o Service para gerar o treino
        return workoutService.gerarTreino(nome, objetivo);
    }
}