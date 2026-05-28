package org.example.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    private String nomeCurso;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Aluno> alunos;

    public Curso() {
        this.alunos = new ArrayList<Aluno>();
    }

    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Curso(String nomeCurso, List<Aluno> alunos) {
        this.nomeCurso = nomeCurso;
        this.alunos = alunos;
    }

    public Curso(String nomeCurso, List<Aluno> alunos, Integer idCurso) {
        this.nomeCurso = nomeCurso;
        this.alunos = alunos;
        this.idCurso = idCurso;
    }



    public String getNomeCurso() {
        return nomeCurso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public Integer getIdCurso() {
        return idCurso;
    }




    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
}
