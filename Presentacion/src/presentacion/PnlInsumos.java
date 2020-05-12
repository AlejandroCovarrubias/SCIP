/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidades.Cliente;
import entidades.Insumo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocio.INegocio;

/**
 *
 * @author Alejandro Galindo
 */
public class PnlInsumos extends javax.swing.JPanel {

    private static PnlInsumos instance;

    private INegocio fachada;

    private FrmMain parent;

    private Insumo insumo;

    private List<Insumo> insumos = new ArrayList<>();

    /**
     * Creates new form PnlInsumos
     *
     * @param instance
     */
    private PnlInsumos(INegocio fachada, FrmMain parent) {
        initComponents();
        this.setSize(1044, 570);
        this.fachada = fachada;
        this.parent = parent;
        this.insumo = new Insumo();
        actualizarTabla();
    }

    public static PnlInsumos getInstance(INegocio fachada, FrmMain parent) {
        if (instance == null) {
            instance = new PnlInsumos(fachada, parent);
        }
        instance.actualizarTabla();
        return instance;
    }

    private void actualizarTabla() {
        insumos = fachada.getInsumos();
        vaciarTablas();
        DefaultTableModel insumosTM = (DefaultTableModel) tablaInsumos.getModel();
        Object rowData[] = new Object[4];

        for (int i = 0; i < insumos.size(); i++) {
            rowData[0] = insumos.get(i).getDescripcion();
            rowData[1] = "$" + insumos.get(i).getCosto();
            rowData[2] = insumos.get(i).getCantidad();

            if (insumos.get(i).getTrabajo() == null) {
                rowData[3] = "Este insumo no tiene un trabajo relacionado";
            } else {
                rowData[3] = insumos.get(i).getTrabajo().getFolioTrabajo();
            }
            insumosTM.addRow(rowData);
        }
    }
    
    private void actualizarTablaLike(String like) {
        insumos = fachada.getInsumosLike(like);
        vaciarTablas();
        DefaultTableModel insumosTM = (DefaultTableModel) tablaInsumos.getModel();
        Object rowData[] = new Object[4];

        for (int i = 0; i < insumos.size(); i++) {
            rowData[0] = insumos.get(i).getDescripcion();
            rowData[1] = "$" + insumos.get(i).getCosto();
            rowData[2] = insumos.get(i).getCantidad();

            if (insumos.get(i).getTrabajo() == null) {
                rowData[3] = "Este insumo no tiene un trabajo relacionado";
            } else {
                rowData[3] = insumos.get(i).getTrabajo().getFolioTrabajo();
            }
            insumosTM.addRow(rowData);
        }
    }

    private void vaciarTablas() {
        while (tablaInsumos.getRowCount() > 0) {
            ((DefaultTableModel) tablaInsumos.getModel()).removeRow(0);
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
        tablaInsumos = new javax.swing.JTable();
        optBuscar = new javax.swing.JLabel();
        tBuscar = new javax.swing.JTextField();

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

        tablaInsumos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaInsumos.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        tablaInsumos.setForeground(new java.awt.Color(102, 102, 102));
        tablaInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Costo", "Cantidad", "Trabajo"
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
        tablaInsumos.setRowHeight(64);
        tablaInsumos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablaInsumos.setSelectionForeground(new java.awt.Color(102, 102, 102));
        tablaInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaInsumosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaInsumos);

        optBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_search.png"))); // NOI18N
        optBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optBuscarMouseClicked(evt);
            }
        });

        tBuscar.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N

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
                        .addComponent(tBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(optBuscar)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(optBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(tBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opt_Eliminar)
                    .addComponent(opt_Editar)
                    .addComponent(opt_Agregar))
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void opt_AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_AgregarMouseClicked
        DlgInsumos dlgInsumos = new DlgInsumos(parent, true, Modals.AGREGAR, this.insumo, this.fachada);
        dlgInsumos.setVisible(true);
        actualizarTabla();
    }//GEN-LAST:event_opt_AgregarMouseClicked

    private void opt_EditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_EditarMouseClicked
        int index = tablaInsumos.getSelectedRow();

        if (index >= 0) {
            Insumo temp = this.insumos.get(index);
            if (temp.getTrabajo() == null) {
                DlgInsumos dlgInsumos = new DlgInsumos(parent, true, Modals.EDITAR, this.insumos.get(index), this.fachada);
                dlgInsumos.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this,
                        "El Insumo escogido pertenece al trabajo con folio "
                        + temp.getTrabajo().getFolioTrabajo()
                        + ". Por lo tanto no es posible editarlo. \n\r"
                        + "Edite el insumo desde el trabajo respectivo en la sección de Trabajos.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Escoge un Insumo de la lista", "No se puede editar", JOptionPane.OK_OPTION);
        }
        actualizarTabla();
    }//GEN-LAST:event_opt_EditarMouseClicked

    private void opt_EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_EliminarMouseClicked
        int index = tablaInsumos.getSelectedRow();

        if (index >= 0) {
            Insumo temp = this.insumos.get(index);
            if (temp.getTrabajo() == null) {
                int showConfirmDialog = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas eliminar el insumo escogido?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (showConfirmDialog == JOptionPane.YES_OPTION) {
                    fachada.eliminarInsumo(this.insumos.get(index));
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "El Insumo escogido pertenece al trabajo con folio "
                        + temp.getTrabajo().getFolioTrabajo()
                        + ". Por lo tanto no es posible eliminarlo. \n\r"
                        + "Elimine el insumo desde el trabajo respectivo en la sección de Trabajos.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Escoge un Insumo de la lista", "No se puede eliminar", JOptionPane.OK_OPTION);
        }
        actualizarTabla();

    }//GEN-LAST:event_opt_EliminarMouseClicked

    private void tablaInsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaInsumosMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int column = source.columnAtPoint(evt.getPoint());
        String s = source.getModel().getValueAt(row, column) + "";

        if (column == 3) {
            Insumo insumoTemp = insumos.get(row);
            if (insumoTemp.getTrabajo() != null) {
                DlgTrabajos dlgTrabajos = new DlgTrabajos(parent, true, Modals.VER, insumoTemp.getTrabajo(), fachada);
                dlgTrabajos.setVisible(true);
            }
        }
    }//GEN-LAST:event_tablaInsumosMouseClicked

    private void optBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optBuscarMouseClicked
        String buscar = tBuscar.getText();
        actualizarTablaLike(buscar);
    }//GEN-LAST:event_optBuscarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel optBuscar;
    private javax.swing.JLabel opt_Agregar;
    private javax.swing.JLabel opt_Editar;
    private javax.swing.JLabel opt_Eliminar;
    private javax.swing.JTextField tBuscar;
    private javax.swing.JTable tablaInsumos;
    // End of variables declaration//GEN-END:variables
}