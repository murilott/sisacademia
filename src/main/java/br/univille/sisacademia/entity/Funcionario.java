package br.univille.sisacademia.entity;

import java.util.ArrayList;

public class Funcionario {
    private long id;
    private String nome;
    private String sexo;
    private String telefone;
    private String cargo;
    private ArrayList<Usuario> listaClientes = new ArrayList<Usuario>();
    
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
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public ArrayList<Usuario> getListaClientes() {
        return listaClientes;
    }
    public void setListaClientes(ArrayList<Usuario> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
