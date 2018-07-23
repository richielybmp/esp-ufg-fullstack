/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbe_aula4.dao.impl;

import fbe_aula4.dao.HibernateUtil;
import fbe_aula4.dao.ProdutoDAO;
import fbe_aula4.model.Produto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Alunoinf_2
 */
public class ProdutoDAOImpl implements ProdutoDAO {

    SessionFactory sessionFactory = null;

    public ProdutoDAOImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Produto> getProdutos() {
        List<Produto> produtos = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            produtos = session.createQuery("from Produto").list(); // Produto é o nome da classe model

            //Criteria
//            Criteria criteria = session.createCriteria(Produto.class);
//            criteria.add(Restrictions.like("nome", "%ar%"));
//            produtos = criteria.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return produtos;
    }

    public Produto getProduto(String codigo) {
        Produto produto = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            produto = (Produto) session
                    .createQuery("from Produto p where p.codigo = :codigo")
                    .setString("codigo", codigo)
                    .uniqueResult();

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return produto;
    }

    public boolean addProduto(Produto produto) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            //session.persist(produto);
            session.save(produto);
//            session.saveOrUpdate(produto);
            session.getTransaction().commit();

        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    public boolean removeProduto(String codigo) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            
            Produto produto =(Produto)session
                    .createQuery("from Produto p where p.codigo = :codigo")
                    .setString("codigo", codigo)
                    .uniqueResult();
            session.delete(produto);
            
//            session.save(produto);
//            session.saveOrUpdate(produto);
            session.getTransaction().commit();

        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    public boolean putProduto(Produto produto) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(produto);
            session.getTransaction().commit();

        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }
}
