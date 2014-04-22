/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import com.rpl.entities.Ketersediaandosen;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import session.KetersediaanManager;

/**
 *
 * @author user
 */
@Named(value = "ketersediaanMBean")
@SessionScoped
public class KetersediaanMBean implements Serializable {
    @EJB
    private KetersediaanManager ketersediaanManager;

    /* models/properties */  
    private Ketersediaandosen ketersediaandosen; // for display/update/insert in a form  
    private List<Ketersediaandosen> listKetersediaandosen; // for display in a datatable  
    
    public KetersediaanMBean() {
        
    }
    public List<Ketersediaandosen>getListKetersediaan() {  
        if((listKetersediaandosen == null) || (listKetersediaandosen.isEmpty()))            
            refresh();  
        return listKetersediaandosen;  
    }
    
    public void refresh() {  
        listKetersediaandosen = ketersediaanManager.getAllKetersediaan();
    }  
  
/** 
     * returns details of a customer. Useful for displaying in a form a customer's details 
     * @return 
     */  
    public Ketersediaandosen getDetails() {  
        return ketersediaandosen;  
    } 
    
    
  
    /** 
     * Action handler - Called when a line in the table is clicked 
     * @param ketersediaandosen 
     * @return 
     */  
    public String showDetails(Ketersediaandosen ketersediaandosen) {  
        this.ketersediaandosen = ketersediaandosen;  
        return "EditKetersediaan"; // will display CustomerDetails.xml JSF page  
    } 
    
    public String goAdd() {  
        this.ketersediaandosen = new Ketersediaandosen();  
        return "AddKetersediaan"; // will display CustomerDetails.xml JSF page  
    } 
  
    /** 
     * Action handler - update the customer model in the database. 
     * called when one press the update button in the form 
     * @return 
     */  
    public String update() {  
        System.out.println("###UPDATE###");  
        ketersediaandosen = ketersediaanManager.update(ketersediaandosen);  
        return "ListKetersediaan"; // will display the customer list in a table  
    }  
  
    /** 
     * Action handler - returns to the list of customers in the table 
     */  
    public String list() {  
        System.out.println("###LIST###");  
        return "ListKetersediaan";  
    }  
    
    public String addNew() {
        ketersediaanManager.persist(ketersediaandosen);
        listKetersediaandosen.add(ketersediaandosen);
  //      refresh();
        return "ListKetersediaan";
        
    }
    
    public void clearKetersediaan(AjaxBehaviorEvent event)
            throws AbortProcessingException {
        ketersediaandosen.setIdKetersediaan(null);
        ketersediaandosen.setWaktuAwal(null);
        ketersediaandosen.setWaktuAkhir(null);
       
    }
}
