package ClasseUml;
import Scitis.BaseDeDonnee;
import java.io.*;

public abstract class Noeud {

    protected String numNoeud;
   
    public Noeud(String numNoeud) {
        this.numNoeud = numNoeud;
    }

    public String getNumNoeud(){
        return this.numNoeud;
    }
        
}
