/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_hospital;

/**
 *
 * @author johnn
 */
public class MenuCitas extends javax.swing.JFrame {

    /**
     * Creates new form MenuCitas
     */
    public MenuCitas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NuevaCita = new javax.swing.JButton();
        EditarFechaCita = new javax.swing.JButton();
        MostrarCita = new javax.swing.JButton();
        CancelarCita = new javax.swing.JButton();
        AtenderCita = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("   Menu Citas   ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        NuevaCita.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NuevaCita.setText("Nueva Cita");
        NuevaCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NuevaCitaMouseClicked(evt);
            }
        });
        NuevaCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaCitaActionPerformed(evt);
            }
        });

        EditarFechaCita.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EditarFechaCita.setText("Editar Fecha");
        EditarFechaCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditarFechaCitaMouseClicked(evt);
            }
        });

        MostrarCita.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MostrarCita.setText("Mostrar Cita");
        MostrarCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MostrarCitaMouseClicked(evt);
            }
        });

        CancelarCita.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CancelarCita.setText("Cancelar Cita");

        AtenderCita.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AtenderCita.setText("Atender Cita");

        jButton1.setText("Volver a Menu");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EditarFechaCita)
                            .addComponent(NuevaCita)
                            .addComponent(MostrarCita)
                            .addComponent(CancelarCita)
                            .addComponent(AtenderCita)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jButton1)))
                .addGap(60, 60, 60))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AtenderCita, CancelarCita, EditarFechaCita, MostrarCita, NuevaCita});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(NuevaCita)
                .addGap(18, 18, 18)
                .addComponent(EditarFechaCita)
                .addGap(18, 18, 18)
                .addComponent(MostrarCita)
                .addGap(18, 18, 18)
                .addComponent(CancelarCita)
                .addGap(18, 18, 18)
                .addComponent(AtenderCita)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AtenderCita, CancelarCita, EditarFechaCita, MostrarCita, NuevaCita});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NuevaCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NuevaCitaActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        MenuPrincipal mp= new MenuPrincipal();
        mp.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void NuevaCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NuevaCitaMouseClicked
        // TODO add your handling code here:
        AgregarCita ac= new AgregarCita();
        ac.setVisible(true);
        dispose();
    }//GEN-LAST:event_NuevaCitaMouseClicked

    private void EditarFechaCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditarFechaCitaMouseClicked
        // TODO add your handling code here:
        EditarFechaCita edc= new EditarFechaCita();
        edc.setVisible(true);
        dispose();
    }//GEN-LAST:event_EditarFechaCitaMouseClicked

    private void MostrarCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MostrarCitaMouseClicked
        // TODO add your handling code here:
        MostrarCitta mc= new MostrarCitta();
        mc.setVisible(true);
        dispose();
    }//GEN-LAST:event_MostrarCitaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuCitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtenderCita;
    private javax.swing.JButton CancelarCita;
    private javax.swing.JButton EditarFechaCita;
    private javax.swing.JButton MostrarCita;
    private javax.swing.JButton NuevaCita;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
