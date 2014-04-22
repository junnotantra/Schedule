/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import com.rpl.entities.JdwlSmnSdg;
import com.rpl.entities.SeminarSidang;
import com.rpl.entities.Ruangan;
import com.rpl.entities.Periode;
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
public class JadwalManager {
@PersistenceContext(unitName = "com.rpl_schedule-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    

    public List<JdwlSmnSdg> getAllJadwal() {  
        Query query = em.createNamedQuery("JdwlSmnSdg.findAll");  
        return query.getResultList();    
    }  
    public JdwlSmnSdg update(JdwlSmnSdg jdwl) {
        return em.merge(jdwl);
    }
    public void persist(JdwlSmnSdg jdwl) {
        try {
            //em.getTransaction().begin();
            em.persist(jdwl);
            //em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
     public void remove(JdwlSmnSdg jdw){
        JdwlSmnSdg del= em.merge(jdw);
        em.remove(del);
    }
    
    public boolean validateKAExist(){
        return true;
    }
    
    public boolean validateRuanganExist(){
        return true;
    }
    
    public boolean validatePeriodeExist(){
        return true;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
