package com.example.aula5mobile.models;
import java.io.Serializable;

public class DisciplinaValue implements Serializable {
    private Long id;
    private String nome;


//
//    public DisciplinaValue(Long id, String nome){
//        this.id = id;
//        this.nome = nome;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
