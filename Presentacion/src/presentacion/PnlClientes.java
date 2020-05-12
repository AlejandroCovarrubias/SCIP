/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidades.Cliente;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import negocio.INegocio;

/**
 *
 * @author Alejandro Galindo
 */
public class PnlClientes extends javax.swing.JPanel {

    private static PnlClientes instance;

    private INegocio fachada;

    private FrmMain parent;

    private Cliente cliente;

    private List<Cliente> clientes = new ArrayList<>();

    /**
     * Creates new form PnlClientes
     *
     * @param instance
     */
    private PnlClientes(INegocio fachada, FrmMain parent) {
        initComponents();
        this.setSize(1044, 570);
        this.fachada = fachada;
        this.cliente = new Cliente();
        this.parent = parent;
        actualizarTabla();
    }

    public static PnlClientes getInstance(INegocio fachada, FrmMain parent) {
        if (instance == null) {
            instance = new PnlClientes(fachada, parent);
        }
        instance.actualizarTabla();
        return instance;
    }

    private void actualizarTabla() {
        clientes = fachada.getClientes();

        vaciarTablas();
        DefaultTableModel clientesTM = (DefaultTableModel) tablaClientes.getModel();
        Object rowData[] = new Object[4];

        for (int i = 0; i < clientes.size(); i++) {
            rowData[0] = clientes.get(i).getRFC();
            rowData[1] = clientes.get(i).getRazonSocial();
            rowData[2] = clientes.get(i).getTelefono();
            rowData[3] = clientes.get(i).getCorreo();
            clientesTM.addRow(rowData);
        }
    }
    
    private void actualizarTablaLike(String like) {
        clientes = fachada.getClientesLike(like);

        vaciarTablas();
        DefaultTableModel clientesTM = (DefaultTableModel) tablaClientes.getModel();
        Object rowData[] = new Object[4];

        for (int i = 0; i < clientes.size(); i++) {
            rowData[0] = clientes.get(i).getRFC();
            rowData[1] = clientes.get(i).getRazonSocial();
            rowData[2] = clientes.get(i).getTelefono();
            rowData[3] = clientes.get(i).getCorreo();
            clientesTM.addRow(rowData);
        }
    }

    private void vaciarTablas() {
        while (tablaClientes.getRowCount() > 0) {
            ((DefaultTableModel) tablaClientes.getModel()).removeRow(0);
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

        opt_Agregar = new javax.swing.JLabel();
        opt_Eliminar = new javax.swing.JLabel();
        opt_Editar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        optBuscar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1044, 570));
        setMinimumSize(new java.awt.Dimension(1044, 570));
        setPreferredSize(new java.awt.Dimension(1044, 570));

        opt_Agregar.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        opt_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_add.png"))); // NOI18N
        opt_Agregar.setText("AGREGAR");
        opt_Agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt_AgregarMouseClicked(evt);
            }
        });

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

        tablaClientes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaClientes.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        tablaClientes.setForeground(new java.awt.Color(102, 102, 102));
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RFC", "Razón Social", "Teléfono", "Correo Electrónico"
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
        tablaClientes.setRowHeight(64);
        tablaClientes.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablaClientes.setSelectionForeground(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(tablaClientes);

        txtBuscar.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N

        optBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_search.png"))); // NOI18N
        optBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optBuscarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opt_Agregar)
                        .addGap(18, 18, 18)
                        .addComponent(opt_Editar)
                        .addGap(18, 18, 18)
                        .addComponent(opt_Eliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optBuscar)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscar)
                    .addComponent(optBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opt_Eliminar)
                    .addComponent(opt_Editar)
                    .addComponent(opt_Agregar))
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void opt_AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_AgregarMouseClicked
        DlgClientes dlgClientes = new DlgClientes(parent, true, Modals.AGREGAR, this.cliente, this.fachada);
        dlgClientes.setVisible(true);
        actualizarTabla();
    }//GEN-LAST:event_opt_AgregarMouseClicked

    private void opt_EditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_EditarMouseClicked
        int index = tablaClientes.getSelectedRow();
        if (index >= 0) {
            DlgClientes dlgClientes = new DlgClientes(parent, true, Modals.EDITAR, this.clientes.get(index), this.fachada);
            dlgClientes.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Escoge un Cliente de la lista", "No se puede editar", JOptionPane.OK_OPTION);
        }
        actualizarTabla();
    }//GEN-LAST:event_opt_EditarMouseClicked

    private void opt_EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_EliminarMouseClicked
        int index = tablaClientes.getSelectedRow();
        if (index >= 0) {
            int showConfirmDialog = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas eliminar al Cliente con RFC" + clientes.get(index).getRFC() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (showConfirmDialog == JOptionPane.YES_OPTION) {
                fachada.eliminarCliente(this.clientes.get(index));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Escoge un Cliente de la lista", "No se puede eliminar", JOptionPane.OK_OPTION);
        }
        actualizarTabla();
    }//GEN-LAST:event_opt_EliminarMouseClicked

    private void optBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optBuscarMouseClicked
        String buscar = txtBuscar.getText();
        actualizarTablaLike(buscar);
    }//GEN-LAST:event_optBuscarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel optBuscar;
    private javax.swing.JLabel opt_Agregar;
    private javax.swing.JLabel opt_Editar;
    private javax.swing.JLabel opt_Eliminar;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
