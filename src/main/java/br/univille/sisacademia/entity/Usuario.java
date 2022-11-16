package br.univille.sisacademia.entity;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    private long id;
    private String nome;
    private String sexo;
    private String telefone;
    private String endereco;
    private Date dataNascimento;
    private float altura;
    private float peso;
    private int idade;
    private boolean alergico;
    private ArrayList<Alergia> listaAlergias = new ArrayList<Alergia>();
    private Rotina rotinaAtual;
    private Dieta dietaAtual;
    
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
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public boolean isAlergico() {
        return alergico;
    }
    public void setAlergico(boolean alergico) {
        this.alergico = alergico;
    }
    public ArrayList<Alergia> getListaAlergias() {
        return listaAlergias;
    }
    public void setListaAlergias(ArrayList<Alergia> listaAlergias) {
        this.listaAlergias = listaAlergias;
    }
    public Rotina getRotinaAtual() {
        return rotinaAtual;
    }
    public void setRotinaAtual(Rotina rotinaAtual) {
        this.rotinaAtual = rotinaAtual;
    }
    public Dieta getDietaAtual() {
        return dietaAtual;
    }
    public void setDietaAtual(Dieta dietaAtual) {
        this.dietaAtual = dietaAtual;
    }
}
