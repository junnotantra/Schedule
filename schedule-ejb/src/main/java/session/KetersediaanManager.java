/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import com.rpl.entities.Ketersediaandosen;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author user
 */
@Stateless
@LocalBean
public class KetersediaanManager {
    @PersistenceContext(unitName = "com.rpl_schedule-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    //@Resource
    //private javax.transaction.UserTransaction utx;

     // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<Ketersediaandosen> getAllKetersediaan() {
        Query query = em.createNamedQuery("Ketersediaandosen.findAll");  
        return query.getResultList();
            }

    public Ketersediaandosen update(Ketersediaandosen ketersediaan) {
        return em.merge(ketersediaan);
    }

        public void persist(Ketersediaandosen ketersediaan) {  
        em.persist(ketersediaan);  
    }  


}
