package br.univille.sisacademia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoriaExercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private float caloriaMedia;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getCaloriaMedia() {
        return caloriaMedia;
    }
    public void setCaloriaMedia(float caloriaMedia) {
        this.caloriaMedia = caloriaMedia;
    }
}
