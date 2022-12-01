package br.univille.sisacademia.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Campo nome não pode ser em branco")
    private String nome;
    @Pattern(regexp = "Masculino|Feminino", flags = Pattern.Flag.CANON_EQ, message = "Valor inválido, utilize Masculino ou Feminino")
    private String sexo;
    @NotBlank(message = "Campo Telefone não pode ser em branco")
    @NumberFormat
    private String telefone;
    @NotBlank(message = "Campo Endereço não pode ser em branco")
    private String endereco;
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Este campo deve conter uma data no passado")
    @NotNull(message = "Campo Data de Nascimento não pode ser em branco")
    private Date dataNascimento;
    @NotNull(message = "Campo Altura não pode ser em branco")
    private float altura;
    @NotNull(message = "Campo Peso não pode ser em branco")
    private float peso;
    @NotNull(message = "Campo Idade não pode ser em branco")
    private int idade;
    private boolean alergico;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Alergia> listaAlergias = new ArrayList<Alergia>();
    @ManyToOne
    private Rotina rotinaAtual;
    @ManyToOne
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

    public List<Alergia> getListaAlergias() {
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
