package com.gymmaster.ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    private final ChatClient chatClient;

    // O Spring Boot 3.4+ injeta o Builder automaticamente
    public WorkoutService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String gerarTreino(String nome, String objetivo) {
        String prompt = "Crie um treino de musculação focado em " + objetivo + " para o aluno " + nome;

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}