
import javafx.beans.property.SimpleStringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lassiazt
 */
public class VoyageClass {
    
    private String idvoyage;
    private String description;
    private String duree;
    private String prixvoyage;
    private String typevoyage;
    private String difficulte;
    private String nbpersmax;
    
 
    public VoyageClass(){};    
    
    public VoyageClass(String idvoyage, String description, String duree, String prixvoyage, String typevoyage, String difficulte, String nbpersmax ) {
        this.idvoyage = idvoyage;
        this.description = description;
        this.duree = duree;
        this.prixvoyage = prixvoyage;
        this.typevoyage = typevoyage;
        this.difficulte = difficulte;
        this.nbpersmax = nbpersmax;
    }
    /**
     * @return the idvoyage
     */
    public String getIdvoyage() {
        return idvoyage;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the duree
     */
    public String getDuree() {
        return duree;
    }

    /**
     * @param duree the duree to set
     */
    public void setDuree(String duree) {
        this.duree = duree;
    }

    /**
     * @return the prixvoyage
     */
    public String getPrixvoyage() {
        return prixvoyage;
    }

    /**
     * @param prixvoyage the prixvoyage to set
     */
    public void setPrixvoyage(String prixvoyage) {
        this.prixvoyage = prixvoyage;
    }

    /**
     * @return the typevoyage
     */
    public String getTypevoyage() {
        return typevoyage;
    }

    /**
     * @param typevoyage the typevoyage to set
     */
    public void setTypevoyage(String typevoyage) {
        this.typevoyage = typevoyage;
    }

    /**
     * @return the difficulte
     */
    public String getDifficulte() {
        return difficulte;
    }

    /**
     * @param difficulte the difficulte to set
     */
    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    /**
     * @return the nbpersmax
     */
    public String getNbpersmax() {
        return nbpersmax;
    }

    /**
     * @param nbpersmax the nbpersmax to set
     */
    public void setNbpersmax(String nbpersmax) {
        this.nbpersmax = nbpersmax;
    }
        
}
