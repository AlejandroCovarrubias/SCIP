/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidades.Cliente;
import entidades.Trabajo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.INegocio;

/**
 *
 * @author Alejandro Galindo
 */
public class PnlTrabajos extends javax.swing.JPanel {
    
    private static PnlTrabajos instance;
    
    private INegocio fachada;
    
    private FrmMain parent;
    
    private Trabajo trabajo;
    
    private List<Trabajo> trabajos = new ArrayList<>();

    /**
     * Creates new form PnlTrabajos
     */
    private PnlTrabajos(INegocio fachada, FrmMain parent) {
        initComponents();
        this.setSize(1044, 570);
        this.fachada = fachada;
        this.trabajo = new Trabajo();
        
    }
    
    public static PnlTrabajos getInstance(INegocio fachada, FrmMain parent){
        if(instance == null){
            instance = new PnlTrabajos(fachada, parent);
        }
        return instance;
    }
    
    private void actualizarTabla() {
        trabajos = fachada.getTrabajos();
        vaciarTablas();
        DefaultTableModel trabajosTM = (DefaultTableModel) tablaTrabajos.getModel();
        Object rowData[] = new Object[4];

        for (int i = 0; i < trabajos.size(); i++) {
            rowData[0] = trabajos.get(i).getFolioTrabajo();
            rowData[1] = trabajos.get(i).getCliente().getRazonSocial();
            rowData[2] = trabajos.get(i).getFallaCliente();
            rowData[3] = trabajos.get(i).getTipoTrabajo();
            trabajosTM.addRow(rowData);
        }
    }

    private void vaciarTablas() {
        while (tablaTrabajos.getRowCount() > 0) {
            ((DefaultTableModel) tablaTrabajos.getModel()).removeRow(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        opt_Eliminar = new javax.swing.JLabel();
        opt_Editar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTrabajos = new javax.swing.JTable();
        opt_Agregar = new javax.swing.JLabel();
        btn_Todos = new javax.swing.JButton();
        btn_Evaluativo = new javax.swing.JButton();
        btn_Preventivo = new javax.swing.JButton();
        btn_Total = new javax.swing.JButton();
        btn_Parcial = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setBackground(new java.awt.Color(255, 255, 255));

        opt_Eliminar.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        opt_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_delete.png"))); // NOI18N
        opt_Eliminar.setText("ELIMINAR");
        opt_Eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt_EliminarMouseClicked(evt);
            }
        });

        opt_Editar.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        opt_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_edit.png"))); // NOI18N
        opt_Editar.setText("EDITAR");
        opt_Editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt_EditarMouseClicked(evt);
            }
        });

        tablaTrabajos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaTrabajos.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        tablaTrabajos.setForeground(new java.awt.Color(102, 102, 102));
        tablaTrabajos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Cliente", "Falla", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTrabajos.setRowHeight(32);
        tablaTrabajos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablaTrabajos.setSelectionForeground(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(tablaTrabajos);

        opt_Agregar.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        opt_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_add.png"))); // NOI18N
        opt_Agregar.setText("AGREGAR");
        opt_Agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt_AgregarMouseClicked(evt);
            }
        });

        btn_Todos.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        btn_Todos.setText("TODOS");
        btn_Todos.setMaximumSize(new java.awt.Dimension(190, 40));
        btn_Todos.setMinimumSize(new java.awt.Dimension(190, 40));
        btn_Todos.setPreferredSize(new java.awt.Dimension(190, 40));

        btn_Evaluativo.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        btn_Evaluativo.setText("EVALUATIVO");
        btn_Evaluativo.setMaximumSize(new java.awt.Dimension(190, 40));
        btn_Evaluativo.setMinimumSize(new java.awt.Dimension(190, 40));
        btn_Evaluativo.setPreferredSize(new java.awt.Dimension(190, 40));

        btn_Preventivo.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        btn_Preventivo.setText("PREVENTIVO");
        btn_Preventivo.setMaximumSize(new java.awt.Dimension(190, 40));
        btn_Preventivo.setMinimumSize(new java.awt.Dimension(190, 40));
        btn_Preventivo.setPreferredSize(new java.awt.Dimension(190, 40));

        btn_Total.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        btn_Total.setText("REPARACIÓN TOTAL");
        btn_Total.setMaximumSize(new java.awt.Dimension(190, 40));
        btn_Total.setMinimumSize(new java.awt.Dimension(190, 40));
        btn_Total.setPreferredSize(new java.awt.Dimension(190, 40));

        btn_Parcial.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        btn_Parcial.setText("REPARACIÓN PARCIAL");
        btn_Parcial.setMaximumSize(new java.awt.Dimension(190, 40));
        btn_Parcial.setMinimumSize(new java.awt.Dimension(190, 40));
        btn_Parcial.setPreferredSize(new java.awt.Dimension(190, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(448, 448, 448)
                        .addComponent(opt_Agregar)
                        .addGap(18, 18, 18)
                        .addComponent(opt_Editar)
                        .addGap(18, 18, 18)
                        .addComponent(opt_Eliminar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Todos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(btn_Evaluativo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(btn_Preventivo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(btn_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btn_Parcial, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Todos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Evaluativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Preventivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Parcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opt_Eliminar)
                    .addComponent(opt_Editar)
                    .addComponent(opt_Agregar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void opt_EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_EliminarMouseClicked
        int index = tablaTrabajos.getSelectedRow();
        if(index >= 0){
            
        }else{
            JOptionPane.showMessageDialog(this, "Escoge un Trabajo de la lista", "No se puede eliminar", JOptionPane.OK_OPTION);
        }
        actualizarTabla();
    }//GEN-LAST:event_opt_EliminarMouseClicked

    private void opt_EditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_EditarMouseClicked
        int index = tablaTrabajos.getSelectedRow();
        if(index >= 0){
            
        }else{
            JOptionPane.showMessageDialog(this, "Escoge un Trabajo de la lista", "No se puede editar", JOptionPane.OK_OPTION);
        }
        actualizarTabla();
    }//GEN-LAST:event_opt_EditarMouseClicked

    private void opt_AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_AgregarMouseClicked
        DlgTrabajos dlgTrabajos = new DlgTrabajos(parent, true, Modals.AGREGAR, new Trabajo(), fachada);
        dlgTrabajos.setVisible(true);
        actualizarTabla();
    }//GEN-LAST:event_opt_AgregarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Evaluativo;
    private javax.swing.JButton btn_Parcial;
    private javax.swing.JButton btn_Preventivo;
    private javax.swing.JButton btn_Todos;
    private javax.swing.JButton btn_Total;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel opt_Agregar;
    private javax.swing.JLabel opt_Editar;
    private javax.swing.JLabel opt_Eliminar;
    private javax.swing.JTable tablaTrabajos;
    // End of variables declaration//GEN-END:variables
}