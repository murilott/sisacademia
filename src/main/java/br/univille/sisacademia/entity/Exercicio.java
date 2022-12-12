package br.univille.sisacademia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.ManyToOne;

import javax.persistence.Id;

@Entity
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    // private String imagem;
    private String nivelRecomendado;
    //@ManyToOne
    //private CategoriaExercicio categoria;
    private String categoria;
    private float caloriaMedia;

    public float getCaloriaMedia() {
        return caloriaMedia;
    }
    public void setCaloriaMedia(float caloriaMedia) {
        this.caloriaMedia = caloriaMedia;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
    // public String getImagem() {
    //     return imagem;
    // }
    // public void setImagem(String imagem) {
    //     this.imagem = imagem;
    // }
    public String getNivelRecomendado() {
        return nivelRecomendado;
    }
    public void setNivelRecomendado(String nivelRecomendado) {
        this.nivelRecomendado = nivelRecomendado;
    }
}
