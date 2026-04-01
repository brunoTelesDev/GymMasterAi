package com.gymmaster.ai.controller;

import com.gymmaster.ai.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping("/gerar")
    public String criarTreino(@RequestParam String nome, @RequestParam String objetivo) {
        return workoutService.gerarTreino(nome, objetivo);
    }
}