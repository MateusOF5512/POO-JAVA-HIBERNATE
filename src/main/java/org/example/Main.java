package org.example;

import org.example.dao.alunoDAO;
import org.example.dao.cursoDAO;
import org.example.model.Aluno;
import org.example.model.Curso;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        cursoDAO cursoDAO = new cursoDAO();
        alunoDAO alunoDAO = new alunoDAO();


        Curso c1 = new Curso("Desenvolvimento de Sistemas");
        cursoDAO.inserirCurso(c1);

        Curso c2 = new Curso("Programação Orinetada a Objetovos");
        cursoDAO.inserirCurso(c2);

        Curso c3 = new Curso("Gestão de TI");
        cursoDAO.inserirCurso(c3);



        }
    }

