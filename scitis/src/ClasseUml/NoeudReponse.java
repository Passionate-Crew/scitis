
package ClasseUml;

import Scitis.BaseDeDonnee;
import java.util.List;

public class NoeudReponse extends Noeud {

    private String nomDomaine;
    
    //Va chercher la methode de la base de donnée pour instancier le tableau
    public NoeudReponse(String numNoeud) {
        super(numNoeud);
        List<String> tableau = BaseDeDonnee.rechercherNoeud(numNoeud);
        this.nomDomaine = tableau.get(1);
    }
    
     public String getNomDomaine(){
        return this.nomDomaine;
    }


    
}
