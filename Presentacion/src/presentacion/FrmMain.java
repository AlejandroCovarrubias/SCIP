/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import calendario.PnlCalendar;
import javax.swing.JOptionPane;
import negocio.*;

/**
 *
 * @author Alejandro Galindo
 */
public class FrmMain extends javax.swing.JFrame {
    
    private INegocio instance;
    
    private PnlClientes pnlClientes;
    
    private PnlTrabajos pnlTrabajos;
    
    private PnlCalendar calendario;
    
    private PnlInsumos pnlInsumos;
    

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
        this.setTitle("Sistema de Comunicación y Presupuesto");
        this.setLocationRelativeTo(null);
        this.setSize(1280, 720);
        this.instance = NegocioSCIP.getFacade();
        opt_calendarioMouseClicked(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        opt_trabajos = new javax.swing.JLabel();
        opt_calendario = new javax.swing.JLabel();
        opt_clientes = new javax.swing.JLabel();
        opt_usuarios = new javax.swing.JLabel();
        opt_reportes = new javax.swing.JLabel();
        opt_insumos = new javax.swing.JLabel();
        opt_salir = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setMaximumSize(new java.awt.Dimension(240, 650));
        jPanel2.setMinimumSize(new java.awt.Dimension(240, 650));
        jPanel2.setPreferredSize(new java.awt.Dimension(240, 650));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setMaximumSize(new java.awt.Dimension(240, 80));
        jPanel5.setMinimumSize(new java.awt.Dimension(240, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_indio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        opt_trabajos.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        opt_trabajos.setForeground(new java.awt.Color(153, 153, 153));
        opt_trabajos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_trabajo.png"))); // NOI18N
        opt_trabajos.setText("TRABAJOS");
        opt_trabajos.setIconTextGap(20);
        opt_trabajos.setMaximumSize(new java.awt.Dimension(220, 50));
        opt_trabajos.setMinimumSize(new java.awt.Dimension(220, 50));
        opt_trabajos.setPreferredSize(new java.awt.Dimension(220, 50));
        opt_trabajos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt_trabajosMouseClicked(evt);
            }
        });

        opt_calendario.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        opt_calendario.setForeground(new java.awt.Color(153, 153, 153));
        opt_calendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_calendar.png"))); // NOI18N
        opt_calendario.setText("CALENDARIO");
        opt_calendario.setIconTextGap(20);
        opt_calendario.setMaximumSize(new java.awt.Dimension(220, 50));
        opt_calendario.setMinimumSize(new java.awt.Dimension(220, 50));
        opt_calendario.setPreferredSize(new java.awt.Dimension(220, 50));
        opt_calendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt_calendarioMouseClicked(evt);
            }
        });

        opt_clientes.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        opt_clientes.setForeground(new java.awt.Color(153, 153, 153));
        opt_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_client.png"))); // NOI18N
        opt_clientes.setText("CLIENTES");
        opt_clientes.setIconTextGap(20);
        opt_clientes.setMaximumSize(new java.awt.Dimension(220, 50));
        opt_clientes.setMinimumSize(new java.awt.Dimension(220, 50));
        opt_clientes.setPreferredSize(new java.awt.Dimension(220, 50));
        opt_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt_clientesMouseClicked(evt);
            }
        });

        opt_usuarios.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        opt_usuarios.setForeground(new java.awt.Color(153, 153, 153));
        opt_usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_users.png"))); // NOI18N
        opt_usuarios.setText("USUARIOS");
        opt_usuarios.setIconTextGap(20);
        opt_usuarios.setMaximumSize(new java.awt.Dimension(220, 50));
        opt_usuarios.setMinimumSize(new java.awt.Dimension(220, 50));
        opt_usuarios.setPreferredSize(new java.awt.Dimension(220, 50));
        opt_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt_usuariosMouseClicked(evt);
            }
        });

        opt_reportes.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        opt_reportes.setForeground(new java.awt.Color(153, 153, 153));
        opt_reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_report.png"))); // NOI18N
        opt_reportes.setText("REPORTES");
        opt_reportes.setIconTextGap(20);
        opt_reportes.setMaximumSize(new java.awt.Dimension(220, 50));
        opt_reportes.setMinimumSize(new java.awt.Dimension(220, 50));
        opt_reportes.setPreferredSize(new java.awt.Dimension(220, 50));
        opt_reportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt_reportesMouseClicked(evt);
            }
        });

        opt_insumos.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        opt_insumos.setForeground(new java.awt.Color(153, 153, 153));
        opt_insumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_insumos.png"))); // NOI18N
        opt_insumos.setText("INSUMOS");
        opt_insumos.setIconTextGap(20);
        opt_insumos.setMaximumSize(new java.awt.Dimension(220, 50));
        opt_insumos.setMinimumSize(new java.awt.Dimension(220, 50));
        opt_insumos.setPreferredSize(new java.awt.Dimension(220, 50));
        opt_insumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt_insumosMouseClicked(evt);
            }
        });

        opt_salir.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        opt_salir.setForeground(new java.awt.Color(153, 153, 153));
        opt_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_exit.png"))); // NOI18N
        opt_salir.setText("SALIR");
        opt_salir.setIconTextGap(20);
        opt_salir.setMaximumSize(new java.awt.Dimension(220, 50));
        opt_salir.setMinimumSize(new java.awt.Dimension(220, 50));
        opt_salir.setPreferredSize(new java.awt.Dimension(220, 50));
        opt_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt_salirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(opt_reportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(opt_calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opt_trabajos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opt_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opt_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opt_insumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opt_salir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(opt_calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(opt_trabajos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(opt_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(opt_reportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(opt_insumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(opt_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(opt_salir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTitulo.setFont(new java.awt.Font("Lato", 1, 36)); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_account.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("HUEMAC");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 397, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlPrincipal.setMaximumSize(new java.awt.Dimension(1044, 570));
        pnlPrincipal.setMinimumSize(new java.awt.Dimension(1044, 570));
        pnlPrincipal.setPreferredSize(new java.awt.Dimension(1044, 570));

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opt_calendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_calendarioMouseClicked
        pnlPrincipal.removeAll();
        pnlPrincipal.revalidate();
        txtTitulo.setText("CALENDARIO");
        
        this.calendario = PnlCalendar.getInstance(instance, this, instance.getUsuario(1));
        calendario.setSize(pnlPrincipal.getSize());
        calendario.setBorder(pnlPrincipal.getBorder());
        pnlPrincipal.add(calendario);
        pnlPrincipal.setVisible(true);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
    }//GEN-LAST:event_opt_calendarioMouseClicked

    private void opt_trabajosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_trabajosMouseClicked
        pnlPrincipal.removeAll();
        pnlPrincipal.revalidate();
        txtTitulo.setText("TRABAJOS");
        
        this.pnlTrabajos = PnlTrabajos.getInstance(instance, this);
        pnlTrabajos.setSize(pnlPrincipal.getSize());
        pnlTrabajos.setBorder(pnlPrincipal.getBorder());
        pnlPrincipal.add(pnlTrabajos);
        pnlTrabajos.setVisible(true);
        pnlTrabajos.revalidate();
        pnlTrabajos.repaint();
    }//GEN-LAST:event_opt_trabajosMouseClicked

    private void opt_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_clientesMouseClicked
        pnlPrincipal.removeAll();
        pnlPrincipal.revalidate();
        txtTitulo.setText("CLIENTES");
        
        //Consigue y ajusta el panel
        this.pnlClientes = PnlClientes.getInstance(instance, this);
        pnlClientes.setSize(pnlPrincipal.getSize());
        pnlClientes.setBorder(pnlPrincipal.getBorder());
        pnlPrincipal.add(pnlClientes);
        pnlClientes.setVisible(true);
        pnlClientes.revalidate();
        pnlClientes.repaint();
    }//GEN-LAST:event_opt_clientesMouseClicked

    private void opt_reportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_reportesMouseClicked
        pnlPrincipal.removeAll();
        pnlPrincipal.revalidate();
        txtTitulo.setText("REPORTES");
    }//GEN-LAST:event_opt_reportesMouseClicked

    private void opt_insumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_insumosMouseClicked
        pnlPrincipal.removeAll();
        pnlPrincipal.revalidate();
        txtTitulo.setText("INSUMOS");
        
        //Consigue y ajusta el panel
        this.pnlInsumos = PnlInsumos.getInstance(instance, this);
        pnlInsumos.setSize(pnlPrincipal.getSize());
        pnlInsumos.setBorder(pnlPrincipal.getBorder());
        pnlPrincipal.add(pnlInsumos);
        pnlInsumos.setVisible(true);
        pnlInsumos.revalidate();
        pnlInsumos.repaint();
    }//GEN-LAST:event_opt_insumosMouseClicked

    private void opt_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_usuariosMouseClicked
        pnlPrincipal.removeAll();
        pnlPrincipal.revalidate();
        txtTitulo.setText("USUARIOS");
    }//GEN-LAST:event_opt_usuariosMouseClicked

    private void opt_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_salirMouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "¿Quieres cerrar la aplicación?", "Salir del sistema", JOptionPane.YES_NO_OPTION);
        
        if(confirm == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_opt_salirMouseClicked

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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel opt_calendario;
    private javax.swing.JLabel opt_clientes;
    private javax.swing.JLabel opt_insumos;
    private javax.swing.JLabel opt_reportes;
    private javax.swing.JLabel opt_salir;
    private javax.swing.JLabel opt_trabajos;
    private javax.swing.JLabel opt_usuarios;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
