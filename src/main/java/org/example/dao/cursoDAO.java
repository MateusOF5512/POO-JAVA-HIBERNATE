package org.example.dao;

import org.example.model.Aluno;
import org.example.model.Curso;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class cursoDAO {

    public void  inserirCurso(Curso curso){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(curso);
            transaction.commit();
            System.out.println("Curso cadastrado via Hibernate!");

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Curso buscarCurso(Integer idCurso) {
        try (Session session = HibernateUtil
                .getSessionFactory()
                .openSession()
        ){
            return session.find(Curso.class, idCurso);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Curso> buscarCurso() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String sql = "select * from curso";
            return session.createQuery(sql, Curso.class).list();
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<Curso>();
        }

    }


    public void atualizarCurso(Curso curso){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()
        ){
            transaction = session.beginTransaction();
            session.merge(curso);
            transaction.commit();
            System.out.println("Alunos atualizados com sucesso!");
        }catch (Exception e){
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();}
    }


    public void removerCurso(Curso curso){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()
        ){
            transaction = session.beginTransaction();
            session.remove(curso);
            transaction.commit();
            System.out.println("Curso removido com sucesso!");
        }catch (Exception e){
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();}
    }







}
