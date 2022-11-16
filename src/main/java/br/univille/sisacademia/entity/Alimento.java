package br.univille.sisacademia.entity;

import java.util.ArrayList;

public class Alimento {
    private long id;
    private String nome;
    private String imagem;
    private float porcao;
    private float calPorcao;
    private CategoriaAlimento categoria;
    private ArrayList<Alergia> listaAlergias = new ArrayList<Alergia>();

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
    public String getImagem() {
        return imagem;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    public float getPorcao() {
        return porcao;
    }
    public void setPorcao(float porcao) {
        this.porcao = porcao;
    }
    public float getCalPorcao() {
        return calPorcao;
    }
    public void setCalPorcao(float calPorcao) {
        this.calPorcao = calPorcao;
    }
    public CategoriaAlimento getCategoria() {
        return categoria;
    }
    public void setCategoria(CategoriaAlimento categoria) {
        this.categoria = categoria;
    }
}
