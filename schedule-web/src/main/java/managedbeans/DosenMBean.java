/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import com.rpl.entities.Dosen;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author user
 */

    
    @Named(value = "dosenMBean")
    @SessionScoped
    
    public class DosenMBean implements Serializable {
    @EJB
    private session.DosenManager dosenManager;
    private Dosen dosen;
    private List<Dosen> listDosen;

    /**
     * Creates a new instance of MahasiswaMBean
     */
    public DosenMBean() {
    }
    
    public List<Dosen>getListDosen() {  
        if((listDosen == null) || (listDosen.isEmpty()))            
            refresh();  
        return listDosen;  
    }  
  
    public void refresh() {  
        listDosen = dosenManager.getAllDosen();
    }  
  
    /** 
     * returns details of a customer. Useful for displaying in a form a customer's details 
     * @return 
     */  
    public Dosen getDetails() {  
        return dosen;  
    } 
    
    
  
    /** 
     * Action handler - Called when a line in the table is clicked 
     * @param dosen 
     * @return 
     */  
    public String showDetails(Dosen dosen) {  
        this.dosen = dosen;  
        return "EditDosen"; // will display CustomerDetails.xml JSF page  
    } 
    
    public String goAdd() {  
        this.dosen = new Dosen();  
        return "AddDosen"; // will display CustomerDetails.xml JSF page  
    } 
  
    /** 
     * Action handler - update the customer model in the database. 
     * called when one press the update button in the form 
     * @return 
     */  
    public String update() {  
        System.out.println("###UPDATE###");  
        dosen = dosenManager.update(dosen);  
        return "ListDosen"; // will display the customer list in a table  
    }  
  
    /** 
     * Action handler - returns to the list of customers in the table 
     */  
    public String list() {  
        System.out.println("###LIST###");  
        return "ListDosen";  
    }  
    
    public String addNew() {
        dosenManager.persist(dosen);
        listDosen.add(dosen);
  //      refresh();
        return "ListDosen";
        
    }
    
    public void clearDosen(AjaxBehaviorEvent event)
            throws AbortProcessingException {
        dosen.setNikDosen("");
        dosen.setNmDosen("");
        dosen.setAlamatDsn("");
       // mahasiswa.setJnsKlmnMhs("");
      //  mahasiswa.setIdKa("");
    }

}
