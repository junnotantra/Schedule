/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import com.rpl.entities.Periode;
import com.rpl.entities.SeminarSidang;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Esa_Lucu
 */
@Stateless
@LocalBean
public class SmnSdgManager {

    @PersistenceContext(unitName = "com.rpl_schedule-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    

    public List<SeminarSidang> getAllSeminarSidang() {  
        Query query = em.createNamedQuery("SeminarSidang.findAll");  
        return query.getResultList();    
    }  
    public SeminarSidang update(SeminarSidang seminarSidang) {
        return em.merge(seminarSidang);
    }
    public void persist(SeminarSidang seminarSidang) {
        try {
            //em.getTransaction().begin();
            em.persist(seminarSidang);
            //em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    public void remove(SeminarSidang seminarSidang){
        SeminarSidang del= em.merge(seminarSidang);
        em.remove(del);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
