/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import com.rpl.entities.Periode;
import com.rpl.entities.Ruangan;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import session.PeriodeManager;
import session.RuanganManager;

/**
 *
 * @author Esa_Lucu
 */
@Named(value = "ruanganMBean")
@Dependent
public class RuanganMBean implements Serializable {
    @EJB
    private RuanganManager ruanganManager;

    private Ruangan ruangan;
    private List<Ruangan> listRuangan;
    private List<String> listIdRuangan;
    /**
     * Creates a new instance of PeriodeMBean
     */
    public RuanganMBean() {
    }
    
    public List<Ruangan>getListRuangan() {  
        if((listRuangan == null) || (listRuangan.isEmpty()))            
            refresh();  
        return listRuangan;  
    }  
    
    public List<String>getListIdRuangan() {  
        listRuangan =  getListRuangan();
        listIdRuangan = new ArrayList();
        for(int i=0; i<listRuangan.size();i++){
            listIdRuangan.add(listRuangan.get(i).getIdRuangan());
        }
        return listIdRuangan;  
    }  
    
    
  
    
    public void refresh() {  
        listRuangan = ruanganManager.getAllRuangan();
    }  
  
    /** 
     * returns details of a customer. Useful for displaying in a form a customer's details 
     * @return 
     */  
    public Ruangan getDetails() {  
        return ruangan;  
    } 
    
    
  
    /** 
     * Action handler - Called when a line in the table is clicked 
     * @param periode 
     * @return 
     */  
    public String showDetails(Ruangan ruangan) {  
        this.ruangan = ruangan;  
        return "EditRuangan"; // will display CustomerDetails.xml JSF page  
    } 
    
    public String goAdd() {  
        this.ruangan = new Ruangan();  
        return "AddRuangan"; // will display CustomerDetails.xml JSF page  
    } 
  
    /** 
     * Action handler - update the customer model in the database. 
     * called when one press the update button in the form 
     * @return 
     */  
    public String update() {  
        System.out.println("###UPDATE###");  
        ruangan = ruanganManager.update(ruangan);  
        return "ListRuangan"; // will display the customer list in a table  
    }  
  
    /** 
     * Action handler - returns to the list of customers in the table 
     */  
    public String list() {  
        System.out.println("###LIST###");  
        return "ListRuangan";  
    }  
    
    public String addNew() {
        ruanganManager.persist(ruangan);
        listRuangan.add(ruangan);
  //      refresh();
        return "ListPeriode";
        
    }
    public String delete(Ruangan ruangan){
        this.ruangan = ruangan;
        ruanganManager.remove(ruangan);
        refresh();
        return "ListPeriode";
    }
//    public void clearPeriode(AjaxBehaviorEvent event)
//            throws AbortProcessingException {
//        ruangan.setIdPeriode(null);
//        ruangan.setSemPeriode(null);
//        ruangan.setThnPeriode(null);
//       // periode.setJnsKlmnMhs("");
//      //  periode.setIdKa("");
//    }
    
}
