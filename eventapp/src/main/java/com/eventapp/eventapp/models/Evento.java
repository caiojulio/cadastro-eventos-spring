package com.eventapp.eventapp.models;


import jakarta.persistence.*;

@Entity
public class Evento {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int codigo;

    @Column(name="nome")
    private String nome;

    @Column(name="local")
    private String local;

    @Column(name="data")
    private String data;

    @Column(name="horario")
    private String horario;


    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
