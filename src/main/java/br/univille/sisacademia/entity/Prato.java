package br.univille.sisacademia.entity;

public class Prato {
    private long id;
    private String periodo;
    private float quantidade;
    private float calorias;
    private Alimento alimento;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public float getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }
    public float getCalorias() {
        return calorias;
    }
    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }
    public Alimento getAlimento() {
        return alimento;
    }
    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }
}
