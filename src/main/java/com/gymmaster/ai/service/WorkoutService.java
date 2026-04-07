package com.gymmaster.ai.service;

import com.gymmaster.ai.model.Workout;
import com.gymmaster.ai.repository.WorkoutRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    private final ChatClient chatClient;
    private final WorkoutRepository workoutRepository; // PRECISA DISSO AQUI

    // Adicione o Repository no construtor para o Spring injetar
    public WorkoutService(ChatClient.Builder chatClientBuilder, WorkoutRepository workoutRepository) {
        this.chatClient = chatClientBuilder.build();
        this.workoutRepository = workoutRepository;
    }

    public String gerarTreino(String nome, String objetivo) {
        String prompt = "Crie um treino de musculação focado em " + objetivo + " para o aluno " + nome;

        // 1. Pede o treino para a IA
        String respostaIA = chatClient.prompt()
                .user(prompt)
                .call()
                .content();

        // 2. CRIA O OBJETO E SALVA NO BANCO (A MÁGICA ACONTECE AQUI)
        Workout workout = new Workout();
        workout.setNome(nome);
        workout.setObjetivo(objetivo);
        workout.setTreino(respostaIA);

        workoutRepository.save(workout); // <--- SALVANDO NO MYSQL!

        return respostaIA;
    }
}