package ClasseUml;

import Scitis.MainScitis;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Questionnaire1 extends javax.swing.JFrame {
    
    private Traitement t;
    private javax.swing.JButton ButtonJenesaispas;
    private javax.swing.JButton ButtonNon;
    private javax.swing.JButton ButtonOui;
    private javax.swing.JLabel ImageScitis;
    private javax.swing.JLabel LabelQuestion;  
    private javax.swing.JScrollPane jScrollPane;
        
    public void setTraitement(Traitement t) {
        this.t = t; 
    }
    
    //Methode utile pour modifier la question
    public void setLableQuestion(String s) {
        this.LabelQuestion.setText(s);
    }
    
    //methode utile pour modifier l'image
    public void setIconeScitis(String s) {
        ImageScitis.setIcon(new javax.swing.ImageIcon(getClass().getResource(s)));
    }
   
    //Methode qui créer la fenetre et initialise ces composants
    @SuppressWarnings("unchecked")                        
    public void initComponents(String numNoeud,String question) {

        ImageScitis = new javax.swing.JLabel();
        ButtonOui = new javax.swing.JButton();
        ButtonJenesaispas = new javax.swing.JButton();
        ButtonNon = new javax.swing.JButton();
        LabelQuestion = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ImageScitis.setBackground(new java.awt.Color(255, 255, 255));
        ImageScitis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Impossible est un mot que.png")));

        ButtonOui.setFont(new java.awt.Font("Tahoma", 1, 13));
        ButtonOui.setText("Oui");
        //Lambda expression Java 8
        ButtonOui.addActionListener((java.awt.event.ActionEvent evt) -> {
            ButtonOuiActionPerformed(evt);
        });

        ButtonJenesaispas.setFont(new java.awt.Font("Tahoma", 1, 13));
        ButtonJenesaispas.setText("Je ne sais pas");
        //Lambda expression en Java 8
        ButtonJenesaispas.addActionListener((java.awt.event.ActionEvent evt) -> {
            ButtonJenesaispasActionPerformed(evt);
        });

        ButtonNon.setFont(new java.awt.Font("Tahoma", 1, 13));
        ButtonNon.setText("Non");
        //Lambda expression en Java 8
        ButtonNon.addActionListener((java.awt.event.ActionEvent evt) -> {
            ButtonNonActionPerformed(evt);
        });

        LabelQuestion.setFont(new java.awt.Font("Tahoma", 0, 18));
        LabelQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelQuestion.setText(question);
        LabelQuestion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jScrollPane.setViewportView(LabelQuestion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(ImageScitis)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ButtonNon, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ButtonOui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButtonJenesaispas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(ImageScitis))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(ButtonOui, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(ButtonJenesaispas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(ButtonNon, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        this.setVisible(true);
        pack();
    }

    private void ButtonOuiActionPerformed(java.awt.event.ActionEvent evt) {
       t.traitementOui();
       t.getImage();
    }

    private void ButtonJenesaispasActionPerformed(java.awt.event.ActionEvent evt) { 
        t.traitementJeNeSaisPas();
    }
    
    private void ButtonNonActionPerformed(java.awt.event.ActionEvent evt) { 
        t.traitementNon();
        t.getImage();
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Questionnaire1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Questionnaire1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Questionnaire1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Questionnaire1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }     
}
