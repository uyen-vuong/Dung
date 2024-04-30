/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import model.User;

/**
 *
 * @author Admin
 */
public class HomeFrm extends javax.swing.JFrame {

    /**
     * Creates new form HomeFrm
     */
    private User user;
    public HomeFrm(User user) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.user = user;
        textName.setText(user.getFullname());
        if(user.getRole().getId() == 2){
            buttonManageLibrarian.setVisible(false);
        }
    }

    public User getUser() {
        return user;
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
        jLabel2 = new javax.swing.JLabel();
        buttonBorrow = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        buttonReturn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        buttonManageImport = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        buttonReport = new javax.swing.JButton();
        buttonSupplier = new javax.swing.JButton();
        textName = new javax.swing.JLabel();
        buttonManageLibrarian = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(51, 0, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Trang chủ");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        buttonBorrow.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonBorrow.setText("Quản lý mượn");
        buttonBorrow.setBorder(new javax.swing.border.MatteBorder(null));
        buttonBorrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBorrowActionPerformed(evt);
            }
        });

        buttonExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonExit.setText("Đăng Xuất");
        buttonExit.setBorder(new javax.swing.border.MatteBorder(null));
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        buttonReturn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonReturn.setText("Quản lý trả");
        buttonReturn.setBorder(new javax.swing.border.MatteBorder(null));
        buttonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReturnActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setText("Quản lý người đọc");
        jButton4.setBorder(new javax.swing.border.MatteBorder(null));

        buttonManageImport.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonManageImport.setText("Quản lý nhập hàng");
        buttonManageImport.setBorder(new javax.swing.border.MatteBorder(null));
        buttonManageImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonManageImportActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setText("Quản lý đầu sách");
        jButton6.setBorder(new javax.swing.border.MatteBorder(null));

        buttonReport.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonReport.setText("Thống kê");
        buttonReport.setBorder(new javax.swing.border.MatteBorder(null));
        buttonReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReportActionPerformed(evt);
            }
        });

        buttonSupplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonSupplier.setText("Quản lý nhà cung cấp");
        buttonSupplier.setBorder(new javax.swing.border.MatteBorder(null));
        buttonSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupplierActionPerformed(evt);
            }
        });

        textName.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        textName.setText("tên ");
        textName.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        buttonManageLibrarian.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonManageLibrarian.setText("Quản lý thủ thư");
        buttonManageLibrarian.setBorder(new javax.swing.border.MatteBorder(null));
        buttonManageLibrarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonManageLibrarianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonManageImport, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(buttonManageLibrarian, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(buttonBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(buttonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(buttonSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(buttonReport, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(425, 425, 425)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(191, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textName))
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBorrow)
                    .addComponent(buttonReturn)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(buttonSupplier)
                    .addComponent(buttonReport))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonManageImport)
                    .addComponent(buttonManageLibrarian))
                .addGap(7, 7, 7)
                .addComponent(buttonExit)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBorrowActionPerformed
        // TODO add your handling code here:
        ManageBorrowFrm frm = new ManageBorrowFrm(user);
        this.setVisible(false);
        frm.setVisible(true);
    }//GEN-LAST:event_buttonBorrowActionPerformed

    private void buttonManageImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonManageImportActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ManageImportFrm frm = new ManageImportFrm(this.getUser());
        frm.setVisible(true);
    }//GEN-LAST:event_buttonManageImportActionPerformed

    private void buttonManageLibrarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonManageLibrarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonManageLibrarianActionPerformed

    private void buttonSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupplierActionPerformed
        // TODO add your handling code here:
        ManageSupplierFrm frm = new ManageSupplierFrm(user);
        this.setVisible(false);
        frm.setVisible(true);
    }//GEN-LAST:event_buttonSupplierActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        // TODO add your handling code here:
        LoginFrm frm = new LoginFrm();
        this.setVisible(false);
        frm.setVisible(true);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReportActionPerformed
        // TODO add your handling code here:
        ReportFrm frm = new ReportFrm(user);
        this.setVisible(false);
        frm.setVisible(true);
    }//GEN-LAST:event_buttonReportActionPerformed

    private void buttonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnActionPerformed
        // TODO add your handling code here:
        ManageReturnFrm frm = new ManageReturnFrm(user);
        this.setVisible(false);
        frm.setVisible(true);
    }//GEN-LAST:event_buttonReturnActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HomeFrm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBorrow;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonManageImport;
    private javax.swing.JButton buttonManageLibrarian;
    private javax.swing.JButton buttonReport;
    private javax.swing.JButton buttonReturn;
    private javax.swing.JButton buttonSupplier;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel textName;
    // End of variables declaration//GEN-END:variables
}
