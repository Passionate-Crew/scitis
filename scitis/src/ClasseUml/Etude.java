package ClasseUml;

import Scitis.BaseDeDonnee;
import java.util.Arrays;
import java.util.List;

public class Etude {
    private String nomEtude;
    private String tempsEtudes;
    private String[] tabEcoles;
    
    //Va chercher la methode de la base de donnée pour instancier le tableau
    public Etude(String nomEtude, String typeEtude){
        System.out.println(nomEtude);
        System.out.println(typeEtude);
        List<String> tableau = BaseDeDonnee.rechercherEtude(nomEtude, typeEtude);
        this.nomEtude = tableau.get(0);
        this.tempsEtudes = tableau.get(1);
        this.tabEcoles = new String [tableau.size()];
        for(int i = 2 ; i < tableau.size() ; i++) {
            this.tabEcoles[i] = tableau.get(i);
        }
    }
    public String getNonNomaines(){
        return this.nomEtude;
    }
     public String getTTempsEtudes(){
        return this.tempsEtudes;
    }
    public String getEcole(int i){
        return this.tabEcoles[i];
    }
    public String[] getEcole(){
        return this.tabEcoles;
    }
     public int getNbEcole(){
        return this.tabEcoles.length;
    }
}
