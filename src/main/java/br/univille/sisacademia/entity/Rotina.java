package br.univille.sisacademia.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import javax.persistence.Id;

@Entity
public class Rotina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private float tempo;
    private float calorias;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Treino> listaTreinos = new ArrayList<Treino>();
    private Date dataInicio;

    public float duracao() {
        // futuramente verificar se a lista de treinos possui algum treino que tem a variável "repetições"
        // com o valor "falso" para evitar erros
        for ( int i = 0; i < listaTreinos.size(); i++ ) {
            tempo =+ listaTreinos.get(i).getDuracao();
        }
        return tempo;
    }

    public float caloriaGastoTotal() {
        for ( int i = 0; i < listaTreinos.size(); i++ ) {
            calorias =+ listaTreinos.get(i).calculaCaloriasExercicio();
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
}
