/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import com.rpl.entities.Mahasiswa;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Junta
 */
@Named(value = "mahasiswaMBean")
@SessionScoped
public class MahasiswaMBean implements Serializable {
    @EJB
    private session.MahasiswaManager mahasiswaManager;
    private Mahasiswa mahasiswa;
    private List<Mahasiswa> listMahasiswa;

    /**
     * Creates a new instance of MahasiswaMBean
     */
    public MahasiswaMBean() {
    }
    
    public List<Mahasiswa>getListMahasiswa() {  
        if((listMahasiswa == null) || (listMahasiswa.isEmpty()))            
            refresh();  
        return listMahasiswa;  
    }  
  
    public void refresh() {  
        listMahasiswa = mahasiswaManager.getAllMahasiswa();
    }  
  
    /** 
     * returns details of a customer. Useful for displaying in a form a customer's details 
     * @return 
     */  
    public Mahasiswa getDetails() {  
        return mahasiswa;  
    } 
    
    
  
    /** 
     * Action handler - Called when a line in the table is clicked 
     * @param mahasiswa 
     * @return 
     */  
    public String showDetails(Mahasiswa mahasiswa) {  
        this.mahasiswa = mahasiswa;  
        return "EditMahasiswa"; // will display CustomerDetails.xml JSF page  
    } 
    
    public String goAdd() {  
        this.mahasiswa = new Mahasiswa();  
        return "AddMahasiswa"; // will display CustomerDetails.xml JSF page  
    } 
  
    /** 
     * Action handler - update the customer model in the database. 
     * called when one press the update button in the form 
     * @return 
     */  
    public String update() {  
        System.out.println("###UPDATE###");  
        mahasiswa = mahasiswaManager.update(mahasiswa);  
        return "ListMahasiswa"; // will display the customer list in a table  
    }  
  
    /** 
     * Action handler - returns to the list of customers in the table 
     */  
    public String list() {  
        System.out.println("###LIST###");  
        return "ListMahasiswa";  
    }  
    
    public String addNew() {
        mahasiswaManager.persist(mahasiswa);
//        listMahasiswa.add(mahasiswa);
        refresh();
        return "ListMahasiswa";
        
    }
    
    public String delete(Mahasiswa mahasiswa){
        this.mahasiswa = mahasiswa;
        mahasiswaManager.remove(this.mahasiswa);
        refresh();
        return "ListMahasiswa";
    }
    
    public void clearMahasiswa(AjaxBehaviorEvent event)
            throws AbortProcessingException {
        mahasiswa.setNim("");
        mahasiswa.setNmMhs("");
        mahasiswa.setAlmtMhs("");
       // mahasiswa.setJnsKlmnMhs("");
      //  mahasiswa.setIdKa("");
    }
}
