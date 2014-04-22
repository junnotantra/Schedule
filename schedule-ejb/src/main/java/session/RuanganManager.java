/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import com.rpl.entities.Periode;
import com.rpl.entities.Ruangan;
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
public class RuanganManager {

    @PersistenceContext(unitName = "com.rpl_schedule-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    public List<Ruangan> getAllRuangan() {  
        Query query = em.createNamedQuery("Ruangan.findAll");  
        return query.getResultList();    
    }  
    public Ruangan update(Ruangan ruangan) {
        return em.merge(ruangan);
    }
    public void persist(Ruangan ruangan) {
        try {
            //em.getTransaction().begin();
            em.persist(ruangan);
            //em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    public void remove(Ruangan ruangan){
        Ruangan del= em.merge(ruangan);
        em.remove(del);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
