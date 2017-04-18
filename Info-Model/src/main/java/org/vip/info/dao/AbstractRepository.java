package org.vip.info.dao;

import org.vip.info.model.*;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractRepository<T> {

    private EntityManagerFactory emf;

    public AbstractRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    protected void create(T t) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.persist(t);
        manager.getTransaction().commit();
        manager.close();
    }

    protected void remove(T t) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.remove(t);
        manager.getTransaction().commit();
        manager.close();
    }

    protected User find(long id) {
        return getEntityManager().find(User.class, id);
    }

    protected List<T> findAll(Class<T> clazz) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> rootEntry = cq.from(clazz);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = getEntityManager().createQuery(all);
        return allQuery.getResultList();
    }

    pr
}
