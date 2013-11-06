package com.mycompany.hibernate.repositories;

import com.mycompany.hibernate.entities.ExampleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 */

@Service
public class ExampleDalService {
    @Autowired
    private javax.persistence.EntityManagerFactory emf;

    /**
     * Returns all entities from db
     * @return
     */
    public List<ExampleEntity> getAllEntities(){
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createNamedQuery("getExampleEntities");
            return query.getResultList();
        }
        finally {
            em.close();
        }
    }


    /**
     * Returns entities by name
     * @param name
     * @return
     * @throws Exception
     */
    public List<ExampleEntity> getEntitiesByName(String name) throws Exception {
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createNamedQuery("getExampleByName").setParameter("name", name);
            return query.getResultList();
        }
        finally {
            em.close();
        }
    }


    /**
     * Find an entity by id
     * @param id
     * @return
     * @throws Exception
     */
    public ExampleEntity getExampleById(int id) throws Exception {
        ExampleEntity profile;
        EntityManager em = emf.createEntityManager();
        try{
            profile = em.find(ExampleEntity.class, id);
        }
        finally {
            em.close();
        }
        return profile;
    }

    /**
     * Update an entity
     * @param entity
     * @request.representation.mediaType application/xml
     */
    public ExampleEntity updateEntity (ExampleEntity entity) throws Exception {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return entity;
    }


    /**
     * Remove an entity by id
     * @param id
     */
    public void removeEntity(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            ExampleEntity exampleEntity = em.find(ExampleEntity.class, id);
            em.remove(exampleEntity);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }

    /**
     * Count entities
     * @return
     */
    public long countEntities() {
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createNamedQuery("countExampleEntities");
            return (Long)query.getSingleResult();
        }
        finally {
            em.close();
        }
    }
}
