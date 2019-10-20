package Scitis;

import javax.swing.UIManager;
import ClasseUml.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainScitis {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Accueil1 fenAccueil;
                BaseDeDonnee BD;
                try {
                    BD = new BaseDeDonnee();
                    fenAccueil = new Accueil1();
                    fenAccueil.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
