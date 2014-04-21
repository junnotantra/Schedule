/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import com.rpl.entities.Mahasiswa;
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
public class MahasiswaManager {
    @PersistenceContext(unitName = "com.rpl_schedule-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
//    @Resource
//    private javax.transaction.UserTransaction utx;

    public List<Mahasiswa> getAllMahasiswa() {  
        Query query = em.createNamedQuery("Mahasiswa.findAll");  
        return query.getResultList();    
    }  
  
    public Mahasiswa update(Mahasiswa mahasiswa) {  
        return em.merge(mahasiswa);  
    }

    public void persist(Object object) {  
        em.persist(object);  
    }  
}
