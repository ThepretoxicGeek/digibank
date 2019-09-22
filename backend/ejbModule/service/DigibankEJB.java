package service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.DIgibankEntity;

/**
 * Session Bean implementation class DigibankEJB
 */
@Stateless
@LocalBean
public class DigibankEJB {

	@PersistenceContext
	private EntityManager em;
	
    public DigibankEJB() {
        // TODO Auto-generated constructor stub
    }

    public void addNew(DIgibankEntity digibankEntity)
    {
    	System.out.println("============================");
    	//System.out.println(digibankEntity.getName());
    	em.persist(digibankEntity);
    	System.out.println("============================");
    }
    
    public List<DIgibankEntity> getAllTransactions() {
		return new ArrayList<DIgibankEntity>(
				em.createQuery("Select transactions From digibank_tbl AS transactions", DIgibankEntity.class).getResultList());
	}
}
