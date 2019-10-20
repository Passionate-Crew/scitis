package ClasseUml;

import Scitis.BaseDeDonnee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoeudQuestion extends Noeud{
    
    private String [] questionNoeud = new String [3];
    private String compNoeud;
    private String ouiNoeud;
    private String nonNoeud;
    
    //Va chercher la methode de la base de donnée pour instancier le tableau
    public NoeudQuestion(String numNoeud){
        super(numNoeud);
        List<String> tableau = BaseDeDonnee.rechercherNoeud(numNoeud);
        //System.out.println(Arrays.toString(tableau));
        for(int i = 0 ; i < 3 ; i++) {
            this.questionNoeud[i] = tableau.get(i+1);
        }
        this.compNoeud = tableau.get(4);
        this.ouiNoeud = tableau.get(5);
        this.nonNoeud = tableau.get(6);
    }

    public String getNoeudNon(){
        return this.nonNoeud;
    }
     public String getNoeudOui(){
        return this.ouiNoeud;
    }
     public String getQuestion(int i){
        return this.questionNoeud[i];
    }
     public String getCompetence(){
        return this.compNoeud;
    }
}
