
package ClasseUml;
import Scitis.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reponse extends javax.swing.JFrame {
                    
    private javax.swing.JButton Recommencer;
    private javax.swing.JLabel domaineTrouve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;    
    
    public Reponse(String res) {
        initComponents(res);
    }

    
    @SuppressWarnings("unchecked")                    
    private void initComponents(String domaineReponse) {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        domaineTrouve = new javax.swing.JLabel();
        Recommencer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/J'ai enfin trouver.png"))); 

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ton domaine est :");

        domaineTrouve.setFont(new java.awt.Font("Tahoma", 1, 18));
        domaineTrouve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        domaineTrouve.setText(domaineReponse);

        Recommencer.setFont(new java.awt.Font("Tahoma", 1, 13)); 
        Recommencer.setText("Recommencer");
        Recommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    RecommencerActionPerformed(evt);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Reponse.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Reponse.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Reponse.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .addComponent(domaineTrouve))//, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE
                    .addComponent(Recommencer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(domaineTrouve) //, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Recommencer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        this.setVisible(true);
        pack();
    }// </editor-fold>                       

    private void RecommencerActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException, InstantiationException, IllegalAccessException { 
        String args[] = null;
        Accueil1 fenAccueil = new Accueil1();
        fenAccueil.setVisible(true);
        this.setVisible(false);
    }       
}

