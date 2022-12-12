package br.univille.sisacademia.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Rotina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private float tempo = 0;
    private float calorias;
    // @OneToMany
    @OneToMany(cascade = { CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
    @JoinColumn(name = "rotina_id")
    private List<Treino> listaTreinos = new ArrayList<Treino>();
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataInicio;
    private String nomeTreinos = "";

    public float duracao() {
        // futuramente verificar se a lista de treinos possui algum treino que tem a variável "repetições"
        // com o valor "falso" para evitar erros
        tempo = 0;
        for ( int i = 0; i < listaTreinos.size(); i++ ) {
            tempo += listaTreinos.get(i).getDuracao();
        }

        return tempo;
    }

    public String retornaTreinos() {
        for ( int i=0; i < listaTreinos.size(); i++) {
            if ( listaTreinos.get(i).getNome() != null ) {
                nomeTreinos += (listaTreinos.get(i).getNome() + "; ");
            }
        }

        return nomeTreinos;
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
