package org.example.dao;

import org.example.model.Aluno;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class alunoDAO {

    public void  inserirAluno(Aluno aluno){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(aluno);
            transaction.commit();
            System.out.println("Alunos cadastrado via Hibernate!");

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }


        public Aluno buscarAlunoComCurso(Integer idAluno) {
            try (Session session = HibernateUtil
                    .getSessionFactory()
                    .openSession()
            ){
                String hql = "Select a from Aluno a join fetch a.curso " +
                        "Where a.idAluno = :idAluno";
                return session.createQuery(hql, Aluno.class)
                        .setParameter("idAluno", idAluno)
                        .uniqueResult();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }


        public void atualizarAluno(Aluno aluno){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()
        ){
            transaction = session.beginTransaction();
            session.merge(aluno);
            transaction.commit();
            System.out.println("Alunos atualizados com sucesso!");
        }catch (Exception e){
        if (transaction != null)
            transaction.rollback();
        e.printStackTrace();}
        }


    public void removerAluno(Aluno aluno){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()
        ){
            transaction = session.beginTransaction();
            session.remove(aluno);
            transaction.commit();
            System.out.println("Alunos removidos com sucesso!");
        }catch (Exception e){
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();}
    }







    }
