package com.example.myapplication;

public class Aluno
{
    //Atributos
    private int matricula;
    private String nome;
    private String curso;

    //Método Construtor
    public Aluno()
    {}

    //Método Construtor II
    public Aluno(int matricula, String nome, String curso)
    {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    //Get & Set
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
