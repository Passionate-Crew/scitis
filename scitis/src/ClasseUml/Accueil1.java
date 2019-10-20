package ClasseUml;

import javax.swing.JFrame;
import javax.swing.JTextArea;

//Fenetre qui se lance au debut. Fenetre Accueil
public class Accueil1 extends javax.swing.JFrame {

    private javax.swing.JButton APropos;
    private javax.swing.JLabel CoucouIMG;
    private javax.swing.JButton Play;    
    
    public Accueil1() {
        initComponents();
    }
    @SuppressWarnings("unchecked")                      
    private void initComponents() {

        Play = new javax.swing.JButton();
        APropos = new javax.swing.JButton();
        CoucouIMG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Play.setFont(new java.awt.Font("Calibri", 0, 36));
        Play.setText("Commencer");
        //Lambda expression Java 8
        Play.addActionListener((java.awt.event.ActionEvent evt) -> {
            PlayActionPerformed(evt);
        });

        APropos.setText("A Propos");
        //Lambda expression Java 8
        APropos.addActionListener((java.awt.event.ActionEvent evt) -> {
            AProposActionPerformed(evt);
        });

        CoucouIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Coucou, tu veux jouer avec moi.png")));
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CoucouIMG)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(APropos, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Play, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(CoucouIMG)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Play, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(APropos, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        pack();
    }                       

    private void AProposActionPerformed(java.awt.event.ActionEvent evt) {           
        JFrame fenetre = new JFrame();
        JTextArea text = new JTextArea("\n  Cette application fut conçue dans un but pédagogique, lors d'un projet tuteuré,\n"
                             +"  au sein de l'IUT Informatique de Rangueil (Université Paul Sabatier).\n"
                             +"  L'application a pour but d’aider les étudiants à éclaircir leurs choix d’orientation.\n"
                             +"  En fonction des réponses que l’utilisateur choisira, l’application sera capable de lui proposer\n"
                             +"  un domaine d'étude ainsi qu'une liste d'études possibles pour l'orienter vers ce domaine\n"
                             +"  qui parait être le plus approprié pour lui.\n\n"
                             +"  Auteurs: ARTIGOUHA Noémy, BOIRON Grégoire, BUFFO Lucas et SHIN Sohun");
        text.setEditable(false);
        fenetre.setVisible(true);
        fenetre.getContentPane().add(text);
        fenetre.setTitle("A propos");
	fenetre.setBounds(50, 50, 600, 200);
	fenetre.setLocationRelativeTo(null);
	fenetre.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	fenetre.setVisible(true);
    }                                       

    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {
        //Creation objets
        DataUser d=new DataUser();
        Traitement t = new Traitement();
        Questionnaire1 q = new Questionnaire1();
        
        this.setVisible(false);
        
        //Connaissance des objets entre eux
        t.setDataUser(d);
        t.setQuestionnaire(q);
        q.setTraitement(t);
        
        t.passerNoeudSuivant("1");
        
    }                                    

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }          
}
