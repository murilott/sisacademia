package br.univille.sisacademia.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import javax.persistence.Id;

@Entity
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String imagem;
    private float porcao;
    private float calPorcao;
    private String categoria;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Alergia> listaAlergias = new ArrayList<Alergia>();

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
    
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
    public List<Alergia> getListaAlergias() {
        return listaAlergias;
    }
    public void setListaAlergias(ArrayList<Alergia> listaAlergias) {
        this.listaAlergias = listaAlergias;
    }
}
