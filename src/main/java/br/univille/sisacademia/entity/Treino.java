package br.univille.sisacademia.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import javax.persistence.Id;

@Entity
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private float duracao;
    private boolean repete;
    private int serie;
    private int repeticoes;
    private String intensidade;
    private float calGasto;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    private Exercicio exercicio;

    public float calculaCaloriasExercicio() {
        calGasto = (serie * repeticoes) * exercicio.getCaloriaMedia();
        return calGasto;
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
    public float getDuracao() {
        return duracao;
    }
    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }
    public boolean isRepete() {
        return repete;
    }
    public void setRepete(boolean repete) {
        this.repete = repete;
    }
    public int getSerie() {
        return serie;
    }
    public void setSerie(int serie) {
        this.serie = serie;
    }
    public int getRepeticoes() {
        return repeticoes;
    }
    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }
    public String getIntensidade() {
        return intensidade;
    }
    public void setIntensidade(String intensidade) {
        this.intensidade = intensidade;
    }
    public float getCalGasto() {
        return calGasto;
    }
    public void setCalGasto(float calGasto) {
        this.calGasto = calGasto;
    }
    public Exercicio getExercicio() {
        return exercicio;
    }
    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }
}
