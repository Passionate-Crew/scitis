
package ClasseUml;

import java.util.ArrayList;
import java.util.List;

public class DataUser {
    
    private List<Competence> listCompetence;
    private List<String> listDomaines;
    private String typeEtude;
    
    public DataUser(){
        this.listCompetence=new ArrayList<>();
        this.listDomaines=new ArrayList<>();
    }
    
    //Methode pour listCompetence
    public Competence getCompetence(int i){
        return this.listCompetence.get(i);
    }
    
    public List<Competence> getCompetence(){
        return this.listCompetence;
    }
    
    public void addCompetence(Competence c){
        this.listCompetence.add(c);
    }
    
    public int sizeComp(){
        return this.listCompetence.size();
    }
    
    //Methode pour listDomaine

    public String getDomaines(int i){
        return this.listDomaines.get(i);
    }
    
    public List<String> getDomaines(){
        return this.listDomaines;
    }
    
    public void addDomaines(String numNoeudReponse){
        this.listDomaines.add(numNoeudReponse);
    }
    
    public int sizeDom(){
        return this.listDomaines.size();
    }
    
    public boolean isEmpty(){
        return this.listDomaines.isEmpty();
    }
    
    //Methode pour typeEtude
    public void setTypeEtude(String t) {
        this.typeEtude = t;
    }
    
    public String getTypeEtude() {
        return(this.typeEtude);
    }
}
