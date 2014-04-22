/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import com.rpl.entities.Periode;
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
 * @author Junta
 */
@Stateless
@LocalBean
public class PeriodeManager {
    @PersistenceContext(unitName = "com.rpl_schedule-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    

    public List<Periode> getAllPeriode() {  
        Query query = em.createNamedQuery("Periode.findAll");  
        return query.getResultList();    
    }  
    public Periode update(Periode periode) {
        return em.merge(periode);
    }
    public void persist(Periode periode) {
        try {
            //em.getTransaction().begin();
            em.persist(periode);
            //em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    public void remove(Periode periode){
        Periode del= em.merge(periode);
        em.remove(del);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
