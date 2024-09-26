package com.example.myapplication;

public class Usuario
{
    //1) Atributos
    private String nome;
    private String endereco;
    private String cpf;
    private String cargo;

    // Método construtor
    public Usuario()
    {
    }

    //Método Construtor II
    public Usuario(String nome, String endereco, String cpf, String cargo) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.cargo = cargo;
    }

    //Get & Set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    //ToString


    @Override
    public String toString()
    {
        return "Nome:" + nome +
                "Endereco:" + endereco +
                "\n CPF:" + cpf +
                "Cargo:" + cargo;
    }
}