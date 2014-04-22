/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import com.rpl.entities.JdwlSmnSdg;
import com.rpl.entities.Periode;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import session.JadwalManager;
import session.PeriodeManager;
import session.RuanganManager;
import session.SmnSdgManager;

/**
 *
 * @author Esa_Lucu
 */
@Named(value = "jadwalMBean")
@Dependent
public class JadwalMBean implements Serializable{

    @EJB
    private JadwalManager jadwalManager;
//    private PeriodeManager periodeManager;
//    private RuanganManager ruanganManager;
//    @EJB
//    private SmnSdgManager seminarSidangManager;

    private JdwlSmnSdg jadwal;
    private List<JdwlSmnSdg> listJadwal;
    /**
     * Creates a new instance of PeriodeMBean
     */
    public JadwalMBean() {
    }
    
    public List<JdwlSmnSdg>getListJadwal() {  
        if((listJadwal == null) || (listJadwal.isEmpty()))            
            refresh();  
        return listJadwal;  
    }  
  
    public void refresh() {  
        listJadwal = jadwalManager.getAllJadwal();
    }  
  
    /** 
     * returns details of a customer. Useful for displaying in a form a customer's details 
     * @return 
     */  
    public JdwlSmnSdg getDetails() {  
        return jadwal;  
    } 
    
    
  
    /** 
     * Action handler - Called when a line in the table is clicked 
     * @param periode 
     * @return 
     */  
    public String showDetails(JdwlSmnSdg jadwal) {  
        this.jadwal = jadwal;  
        return "EditJadwal"; // will display CustomerDetails.xml JSF page  
    } 
    
    public String goAdd() {
        JdwlSmnSdg jd = new JdwlSmnSdg();
        jd = this.jadwal;
        this.jadwal = new JdwlSmnSdg();
        //jadwal.setIdSmnsdg(jd.);
        return "AddJadwal"; // will display CustomerDetails.xml JSF page  
    } 
  
    /** 
     * Action handler - update the customer model in the database. 
     * called when one press the update button in the form 
     * @return 
     */  
    public String update() {  
        System.out.println("###UPDATE###");  
        jadwal = jadwalManager.update(jadwal);  
        return "ListJadwal"; // will display the customer list in a table  
    }  
  
    /** 
     * Action handler - returns to the list of customers in the table 
     */  
    public String list() {  
        System.out.println("###LIST###");  
        return "ListPeriode";  
    }  
    
    public String addNew() {
        jadwalManager.persist(jadwal);
        listJadwal.add(jadwal);
  //      refresh();
        return "ListPeriode";
        
    }
      public String delete(JdwlSmnSdg jadwal){
        this.jadwal = jadwal;
        jadwalManager.remove(jadwal);
        refresh();
        return "ListPeriode";
    }
    
////    public void clearPeriode(AjaxBehaviorEvent event)
////            throws AbortProcessingException {
////        jadwal.setIdPeriode(null);
////        jadwal.setSemPeriode(null);
////        jadwal.setThnPeriode(null);
////       // periode.setJnsKlmnMhs("");
////      //  periode.setIdKa("");
////    }
    
}
