package br.univille.sisacademia.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.univille.sisacademia.entity.Treino;

public class RotinaDTO {
    private long id;
    private String nome;
    private float tempo;
    private float calorias;
    private List<Treino> listaTreinos = new ArrayList<Treino>();
    private Treino treinoSelecionado;
    private Date dataInicio;

    public float duracao() {
        // futuramente verificar se a lista de treinos possui algum treino que tem a
        // variável "repetições"
        // com o valor "falso" para evitar erros
        for (int i = 0; i < listaTreinos.size(); i++) {
            tempo = +listaTreinos.get(i).getDuracao();
        }

        return tempo;
    }

    public Treino getTreinoSelecionado() {
        return treinoSelecionado;
    }

    public void setTreinoSelecionado(Treino treinoSelecionado) {
        this.treinoSelecionado = treinoSelecionado;
    }

    public float caloriaGastoTotal() {
        for (int i = 0; i < listaTreinos.size(); i++) {
            calorias = +listaTreinos.get(i).calculaCaloriasExercicio();
        }

        return calorias;
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

    public List<Treino> getListaTreinos() {
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

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }
}
