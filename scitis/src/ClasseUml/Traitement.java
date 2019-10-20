
package ClasseUml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Traitement {

    private DataUser d;
    private Image im;
    private Questionnaire1 f;
    private Reponse r;
    private NoeudQuestion q;
    private NoeudReponse qr;
    private Domaines dom = new Domaines();
    private List<String> listMarque;
    private String[] tab;
    private int iNeSaisPas;

        int iGraph = 0;
    
    public Traitement() {
        this.listMarque = new LinkedList<String>();
        
        this.tab = new String[5];
        this.iNeSaisPas = 0;
        this.iGraph = 0;
        this.im = new Image();
        
    }
    
    public void setQuestionnaire(Questionnaire1 fen) {
        this.f = fen;
    }
    
    public void setDataUser(DataUser du) {
        this.d = du;
    }
    public void getImage() { 
        if(this.im.getIImage() >= 2){
            if (this.im.getRangList()<this.im.getSizeList()-1){
                this.im.IncrRangList();
            }else{
                this.im.ReinitRangList();
            }
            this.im.ReinitIImage();
            
        } else {
            this.im.IncrIImage();
        }
        f.setIconeScitis(this.im.GetCheminImage());
    }
    
    
    public void passerNoeudSuivant(String numNoeud) {
        this.q = new NoeudQuestion(numNoeud);
        f.initComponents(q.getNumNoeud(), q.getQuestion(this.iNeSaisPas));
    }
    
    //Traitement appuie sur bonton OUI
    public void traitementOui() {
        this.iNeSaisPas = 0;
    //traitement des 6 premiers noeuds
        if(Integer.parseInt(q.getNumNoeud()) < 7) {
            //Noeud 6
            if (Integer.parseInt(q.getNumNoeud()) == 6) {
                this.tab[Integer.parseInt(q.getNumNoeud())-2] = "oui";
                this.traitementNoeud6();
            } else {
                //Noeud 1
                if(Integer.parseInt(q.getNumNoeud()) == 1) {
                    this.d.setTypeEtude("oui");
                //Noeud 2-5
                } else {
                    this.tab[Integer.parseInt(q.getNoeudOui())-3] = "oui";
                    System.out.println(Arrays.toString(this.tab));
                }
                //On genere le prochain noeud Question
                NoeudQuestion n = new NoeudQuestion(q.getNoeudOui());
                this.q = n;
                //On modifie la question de la fenetre
                f.setLableQuestion(q.getQuestion(0));
            }
    //traitement generale
        } else {
            System.out.println("5");
            if(!q.getCompetence().equals("null") && !d.getCompetence().contains(q.getCompetence())) {
                this.d.addCompetence(new Competence(q.getCompetence()));
            }
            listMarque.add(q.getNumNoeud());
            
            if (!listMarque.contains(q.getNoeudOui())) {
                this.listMarque.add(q.getNoeudOui());
                System.out.println("6");
                if(Integer.parseInt(q.getNoeudOui())<1000){
                    //On genere le prochain noeud Question
                    this.q = new NoeudQuestion(q.getNoeudOui());
                    //On modifie la question de la fenetre
                    f.setLableQuestion(q.getQuestion(0));
                } else {
                    boolean c = false;
                    //On regarde s'il reste des oui a traiter
                    for(int x = iGraph ; x < this.tab.length ; x++) {
                        if(tab[x] == "oui") {
                            c = true;
                        }
                    }
                    //Ajout domaine liste utilisateur
                    if(!this.d.getDomaines().contains(q.getNoeudOui())) {
                        this.d.addDomaines(q.getNoeudOui());
                    }
                    if(c == true) {
                        //On passe au prochain graph "oui"
                        this.traitementNoeud6();
                    } else {
                        //Plus de "oui" a traiter. Time to finish = comparaison + affichage
                        this.traitementFinal();
                    }
                }   
            } else {
                this.traitementNoeud6();
            }
        }
    }
    
    //Traitement appuie sur Bonton NON
    public void traitementNon() {
        this.iNeSaisPas = 0;
    //traitement des 6 premiers noeuds
        if(Integer.parseInt(q.getNumNoeud()) < 7) {
        //Traitement Speciale du noeud6
            if(Integer.parseInt(q.getNumNoeud()) == 6) {
                this.tab[Integer.parseInt(q.getNumNoeud())-2] = "non";
                this.traitementNoeud6();
            //Noeud 2-6
            } else {
                //Noeud 1
                if(Integer.parseInt(q.getNumNoeud()) == 1) {
                    this.d.setTypeEtude("non");
                } else {
                
                    this.tab[Integer.parseInt(q.getNoeudNon())-3] = "non";
                    System.out.println(Arrays.toString(this.tab));
                }
                //On genere le prochain noeud Question
                this.q = new NoeudQuestion(q.getNoeudNon());
                //On modifie la question de la fenetre
                f.setLableQuestion(q.getQuestion(0));
            }
    //traitement generale
        } else {
            System.out.println("5");
            listMarque.add(q.getNumNoeud());
            if (!listMarque.contains(q.getNoeudNon())) {
                this.listMarque.add(q.getNoeudNon());
                System.out.println("6");
                if(Integer.parseInt(q.getNoeudNon())<1000) {
                    this.q = new NoeudQuestion(q.getNoeudNon());
                    f.setLableQuestion(q.getQuestion(0));
                } else {
                    boolean c = false;
                    //On regarde s'il reste des oui a traiter
                    for(int x = iGraph ; x < this.tab.length ; x++) {
                        if(tab[x] == "oui") {
                            c = true;
                        }
                    }
                    //Ajout domaine liste utilisateur
                    if(!this.d.getDomaines().contains(q.getNoeudNon())) {
                        this.d.addDomaines(q.getNoeudNon());
                    }
                    if(c == true) {
                        //On passe au prochain graph "oui"
                        this.traitementNoeud6();
                    } else {
                        //Plus de "oui" a traiter. Time to finish = comparaison + affichage
                        this.traitementFinal();
                    }
                }   
            } else {
                this.traitementNoeud6();
            }
        }
    }
    
    public void traitementFinal() {
        //On genere le prochain noeud Final
        System.out.println("Nombre de competence user : "+d.sizeComp());
        System.out.println("Nombre de domaine user : "+d.sizeDom());
        //Il n'y a qu'un domaine dans la liste de l'utilisateur
        int indice = 0;
        
        //Cas ou il n'y a aucun domaine mais des competences    
        if(d.sizeDom() == 0 && d.sizeComp() > 0) {
            int[] tab = new int[35];
            for(int i =0 ; i< tab.length ; i++) {
                System.out.println(((Integer)(i+1001)).toString());
                NoeudReponse testr = new NoeudReponse(((Integer)(i+1001)).toString());
                System.out.println(d.getCompetence());
                System.out.println(dom.getAllCompetence(testr.getNomDomaine()));
                //tab[i] = this.comparaison(d.getCompetence(), dom.getAllCompetence(testr.getNomDomaine()));
                tab[i] = dom.comparaison(d.getCompetence(), testr.getNomDomaine());
            }
            int u = tab[0];
            System.out.println(Arrays.toString(tab));
            for(int i =0 ; i< tab.length ; i++) {
                System.out.println(i);
                System.out.println(u);
                if(u < tab[i]) {
                    u = tab[i];
                    indice = i;
                }
            }
            System.out.println(u);
            System.out.println(indice);
            this.qr = new NoeudReponse(((Integer)(indice+1001)).toString());
            
        //Cas ou il y a plusieurs domaines   
        } else if(d.sizeDom() > 1) {
            int[] tab = new int[d.sizeDom()];
            
            for(int i =0 ; i< d.getDomaines().size() ; i++) {
                NoeudReponse testr = new NoeudReponse(d.getDomaines(i));
                System.out.println(d.getDomaines(i));
                System.out.println(testr.getNomDomaine());
                System.out.println(d.getCompetence());
                System.out.println(dom.getAllCompetence(testr.getNomDomaine()));
                tab[i] = dom.comparaison(d.getCompetence(), testr.getNomDomaine());
            }
            int u = tab[0];
            System.out.println(Arrays.toString(tab));
            for(int i =0 ; i< tab.length ; i++) {
                System.out.println(u);
                System.out.println(i);
                if(u < tab[i]) {
                    u = tab[i];
                    indice = i;
                }
            }
            System.out.println(u);
            System.out.println(indice);
            this.qr = new NoeudReponse(d.getDomaines(indice));
        //Cas ou il n'y a qu'un domaine
        } else if(d.sizeDom() == 1){
            this.qr = new NoeudReponse(d.getDomaines(0));
        }
        
        //Cas ou il n'y a aucun domaine et aucunes competences
        if (d.sizeDom() == 0 && d.sizeComp() == 0) {
            this.qr = new NoeudReponse("9999");
            this.f.setVisible(false);
            this.r = new Reponse(this.qr.getNomDomaine());
        } else { 
            //Affichage des etudes
            Etude e = new Etude(qr.getNomDomaine(), d.getTypeEtude());
            String res = "<html><center><h1>"+qr.getNomDomaine()+"</h1></center><br><br>";
            for (int i=2 ; i < e.getNbEcole() ; i++) {
                if(e.getEcole(i).length() < 63) {
                    res += e.getEcole(i)+"<br>";
                } else {
                    String l = "";
                    boolean fini = true;
                    int y = 0;
                    String str[] = e.getEcole(i).split(",");
                    while (y < str.length) {
                        while (fini == true && y < str.length) {
                            if ((l.length()+str[y].length()) < 63) {
                                l += str[y]+", ";
                                y++;
                            } else {
                                l += "<br> ";
                                fini = false;
                            }
                        }
                        res += l;
                        l = str[y];
                        y++;
                        if(y == str.length) {
                            res += l+"<br>";
                        }
                        fini = true;
                    }
                }
            }
            this.r = new Reponse(res);
            this.f.setVisible(false);
        }
    }
    
    public void traitementNoeud6() {
        boolean err = false;
        String s = "";
        System.out.print(iGraph);
        int u;
        for(u = iGraph ; !s.equals("oui") && u < this.tab.length; u++) {
            s = this.tab[u];
            System.out.println(this.tab[u]);
            System.out.println(u);
        }
        iGraph = u;
        System.out.println(iGraph);
        if(!s.equals("oui")) {
            err = true;
        }
        iGraph -= 1;
        System.out.println(iGraph);
        if(err == false) {
            NoeudQuestion q2 = new NoeudQuestion(Integer.toString(iGraph+2));
            //On genere le prochain noeud Question
            this.q = new NoeudQuestion(q2.getCompetence());
            //On modifie la question de la fenetre
            f.setLableQuestion(q.getQuestion(0));
            iGraph++;
        } else if(!d.isEmpty()){
            this.traitementFinal();
        } else {
            this.traitementFinal();
        }
    }
    
    
    public void traitementJeNeSaisPas() {
        this.iNeSaisPas++;
        if(this.iNeSaisPas < 3){
            f.setLableQuestion(q.getQuestion(this.iNeSaisPas));
        } else {
            traitementNon();
        }
    }
    
}