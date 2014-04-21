/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import com.rpl.entities.Periode;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import session.PeriodeManager;

/**
 *
 * @author Junta
 */
@Named(value = "periodeMBean")
@SessionScoped
public class PeriodeMBean implements Serializable {
    @EJB
    private PeriodeManager periodeManager;

    private Periode periode;
    private List<Periode> listPeriode;
    /**
     * Creates a new instance of PeriodeMBean
     */
    public PeriodeMBean() {
    }
    
    public List<Periode>getListPeriode() {  
        if((listPeriode == null) || (listPeriode.isEmpty()))            
            refresh();  
        return listPeriode;  
    }  
  
    public void refresh() {  
        listPeriode = periodeManager.getAllPeriode();
    }  
  
    /** 
     * returns details of a customer. Useful for displaying in a form a customer's details 
     * @return 
     */  
    public Periode getDetails() {  
        return periode;  
    } 
    
    
  
    /** 
     * Action handler - Called when a line in the table is clicked 
     * @param periode 
     * @return 
     */  
    public String showDetails(Periode periode) {  
        this.periode = periode;  
        return "EditPeriode"; // will display CustomerDetails.xml JSF page  
    } 
    
    public String goAdd() {  
        this.periode = new Periode();  
        return "AddPeriode"; // will display CustomerDetails.xml JSF page  
    } 
  
    /** 
     * Action handler - update the customer model in the database. 
     * called when one press the update button in the form 
     * @return 
     */  
    public String update() {  
        System.out.println("###UPDATE###");  
        periode = periodeManager.update(periode);  
        return "ListPeriode"; // will display the customer list in a table  
    }  
  
    /** 
     * Action handler - returns to the list of customers in the table 
     */  
    public String list() {  
        System.out.println("###LIST###");  
        return "ListPeriode";  
    }  
    
    public String addNew() {
        periodeManager.persist(periode);
        listPeriode.add(periode);
  //      refresh();
        return "ListPeriode";
        
    }
    
    public void clearPeriode(AjaxBehaviorEvent event)
            throws AbortProcessingException {
        periode.setIdPeriode(null);
        periode.setSemPeriode(null);
        periode.setThnPeriode(null);
       // periode.setJnsKlmnMhs("");
      //  periode.setIdKa("");
    }
}
