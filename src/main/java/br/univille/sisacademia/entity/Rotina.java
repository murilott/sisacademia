package br.univille.sisacademia.entity;

import java.util.ArrayList;
import java.util.Date;

public class Rotina {
    private long id;
    private String nome;
    private ArrayList<Treino> listaTreinos = new ArrayList<>();
    private Date dataInicio;

    public float duracao() {
        return 0;
    }

    public float caloriaGastoTotal() {
        return 0;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public ArrayList<Treino> getListaTreinos() {
        return listaTreinos;
    }
    public void setListaTreinos(ArrayList<Treino> listaTreinos) {
        this.listaTreinos = listaTreinos;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
}
