package com.giovana.desafio02.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_participante")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;

    @ManyToMany
    @JoinTable(name = "tb_participante_atividade", // tabela de associação
            joinColumns = @JoinColumn(name = "participante_id"), // fk da tb_participante
            inverseJoinColumns = @JoinColumn(name = "atividade_id") // fk da tb_atividade
    )
    private List<Atividade> atividades = new ArrayList<>();

    public Participante(){}

    public Participante(Integer id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participante that)) return false;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
