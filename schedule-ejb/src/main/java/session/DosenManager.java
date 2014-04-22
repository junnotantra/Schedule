/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import com.rpl.entities.Dosen;
import java.util.List;
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
public class DosenManager {

    @PersistenceContext(unitName = "com.rpl_schedule-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
//    @Resource
//    private javax.transaction.UserTransaction utx;

    public List<Dosen> getAllDosen() {  
        Query query = em.createNamedQuery("Dosen.findAll");  
        return query.getResultList();    
    }  
  
    public Dosen update(Dosen dosen) {  
        return em.merge(dosen);  
    }

    public void persist(Dosen dosen) {  
        em.persist(dosen);  
    }  

}
