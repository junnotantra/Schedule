/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import com.rpl.entities.Periode;
import com.rpl.entities.SeminarSidang;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import session.PeriodeManager;
import session.SmnSdgManager;

/**
 *
 * @author Esa_Lucu
 */
@Named(value = "seminarSidangMBean")
@Dependent
public class SeminarSidangMBean implements Serializable {
    @EJB
    private SmnSdgManager seminarSidangManager;

    private SeminarSidang seminarSidang;
    private List<SeminarSidang> listSeminarSidang;
    private List<Long> listIdSeminarSidang;
    /**
     * Creates a new instance of PeriodeMBean
     */
    public SeminarSidangMBean() {
    }
    
    public List<SeminarSidang>getListSeminarSidang() {  
        if((listSeminarSidang == null) || (listSeminarSidang.isEmpty()))            
            refresh();  
        return listSeminarSidang;  
    }  
    
    public List<Long>getListIdSeminarSidang() {  
        listSeminarSidang =  getListSeminarSidang();
        listIdSeminarSidang = new ArrayList();
        for(int i=0; i<listSeminarSidang.size();i++){
            listIdSeminarSidang.add(listSeminarSidang.get(i).getIdSmnsdg());
        }
        return listIdSeminarSidang;  
    }  
    
    
  
    
    public void refresh() {  
        listSeminarSidang = seminarSidangManager.getAllSeminarSidang();
    }  
  
    /** 
     * returns details of a customer. Useful for displaying in a form a customer's details 
     * @return 
     */  
    public SeminarSidang getDetails() {  
        return seminarSidang;  
    } 
    
    
  
    /** 
     * Action handler - Called when a line in the table is clicked 
     * @param periode 
     * @return 
     */  
    public String showDetails(Periode periode) {  
        this.seminarSidang = seminarSidang;  
        return "EditSeminarSidang"; // will display CustomerDetails.xml JSF page  
    } 
    
    public String goAdd() {  
        this.seminarSidang = new SeminarSidang();  
        return "AddSeminarSidang"; // will display CustomerDetails.xml JSF page  
    } 
  
    /** 
     * Action handler - update the customer model in the database. 
     * called when one press the update button in the form 
     * @return 
     */  
    public String update() {  
        System.out.println("###UPDATE###");  
        seminarSidang = seminarSidangManager.update(seminarSidang);  
        return "ListSeminarSidang"; // will display the customer list in a table  
    }  
  
    /** 
     * Action handler - returns to the list of customers in the table 
     */  
    public String list() {  
        System.out.println("###LIST###");  
        return "ListSeminarSidang";  
    }  
    
    public String addNew() {
        seminarSidangManager.persist(seminarSidang);
        listSeminarSidang.add(seminarSidang);
  //      refresh();
        return "ListSeminarSidang";
        
    }
    public String delete(SeminarSidang seminarSidang){
        this.seminarSidang = seminarSidang;
        seminarSidangManager.remove(seminarSidang);
        refresh();
        return "ListSeminarSidang";
    }
//    public void clearPeriode(AjaxBehaviorEvent event)
//            throws AbortProcessingException {
//        periode.setIdPeriode(null);
//        periode.setSemPeriode(null);
//        periode.setThnPeriode(null);
//       // periode.setJnsKlmnMhs("");
//      //  periode.setIdKa("");
//    }
    
}
