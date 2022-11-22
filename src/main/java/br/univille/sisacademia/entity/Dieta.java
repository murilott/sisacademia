package br.univille.sisacademia.entity;

import java.util.ArrayList;
import java.util.Date;

public class Dieta {
    private long id;
    private String nome;
    private float calorias;
    private ArrayList<Prato> listaPratos = new ArrayList<Prato>();
    private Date dataInicio;

    public float caloriaTotal() {
        for ( int i = 0; i < listaPratos.size(); i++ ) {
            calorias =+ listaPratos.get(i).calculaCaloriasAlimento();
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
    public ArrayList<Prato> getListaPratos() {
        return listaPratos;
    }
    public void setListaPratos(ArrayList<Prato> listaPratos) {
        this.listaPratos = listaPratos;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
}
