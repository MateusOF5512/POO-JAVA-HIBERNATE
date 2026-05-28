package org.example.model;


import jakarta.persistence.*;
import jdk.jfr.Enabled;



@Entity
@Table(name = "alunos")
public class Aluno {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAluno;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;


    public Aluno() {
    }

    public Aluno(Integer idAluno, String nome, Curso curso) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.curso = curso;
    }

    public Aluno(String nome, Curso curso) {
        this.nome = nome;
        this.curso = curso;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public String getNome() {
        return nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
