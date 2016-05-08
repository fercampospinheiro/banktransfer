package br.com.spread.banktransfer.infrastructure.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Fernando Pinheiro
 */
@Transactional
public abstract class AbstractDao<T,I extends Serializable> {
    @PersistenceContext
    private EntityManager em ;
    
    public abstract Class<T> getPojo();

    public void save(T t){
        em.persist(t);
    }
    
    public T update(T t){
        return em.merge(t);
    }
    
    public List<T> all(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getPojo());
        query.from(getPojo());
        return em.createQuery(query).getResultList();
    }
    
    public T getById(Integer id){
        return em.find(getPojo(), id);
    }
    
    public EntityManager getEntityManager(){
        return em;
    }
    
}
