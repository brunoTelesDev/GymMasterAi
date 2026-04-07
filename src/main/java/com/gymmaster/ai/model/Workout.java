package com.gymmaster.ai.model;

import jakarta.persistence.*;

@Entity
@Table(name = "workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String objetivo;

    @Column(columnDefinition = "TEXT")
    private String treino;

    // Construtor vazio (obrigatório para o JPA)
    public Workout() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }
    public String getTreino() { return treino; }
    public void setTreino(String treino) { this.treino = treino; }
}