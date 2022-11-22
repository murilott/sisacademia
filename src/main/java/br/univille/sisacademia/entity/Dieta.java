package br.univille.sisacademia.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Dieta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private float calorias;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Prato> listaPratos = new ArrayList<Prato>();
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    public List<Prato> getListaPratos() {
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
