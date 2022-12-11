package br.univille.sisacademia.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.univille.sisacademia.entity.Prato;

public class DietaDTO {
    private long id;
    private String nome;
    private float calorias;
    private List<Prato> listaPratos = new ArrayList<Prato>();
    private Prato pratoSelecionado;
    private Date dataInicio;
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
    public float getCalorias() {
        return calorias;
    }
    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }
    public List<Prato> getListaPratos() {
        return listaPratos;
    }
    public void setListaPratos(List<Prato> listaPratos) {
        this.listaPratos = listaPratos;
    }
    public Prato getPratoSelecionado() {
        return pratoSelecionado;
    }
    public void setPratoSelecionado(Prato pratoSelecionado) {
        this.pratoSelecionado = pratoSelecionado;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public float caloriaGastoTotal(){
        for(int i =0; i < listaPratos.size(); i++){
            calorias = +listaPratos.get(i).calculaCaloriasAlimento();
        }
        return calorias;
        }
    }

