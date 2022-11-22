package br.univille.sisacademia.entity;

public class Exercicio {
    private long id;
    private String nome;
    private String imagem;
    private String nivelRecomendado;
    private CategoriaExercicio categoria;

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
    public String getNivelRecomendado() {
        return nivelRecomendado;
    }
    public void setNivelRecomendado(String nivelRecomendado) {
        this.nivelRecomendado = nivelRecomendado;
    }
    public CategoriaExercicio getCategoria() {
        return categoria;
    }
    public void setCategoria(CategoriaExercicio categoria) {
        this.categoria = categoria;
    }
}
