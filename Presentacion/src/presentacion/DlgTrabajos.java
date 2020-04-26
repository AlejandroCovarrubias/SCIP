/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidades.Administrador;
import entidades.Cliente;
import entidades.Concepto;
import entidades.Insumo;
import entidades.Servicio;
import entidades.TipoTrabajo;
import entidades.Trabajo;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.INegocio;
import presentacion.utils.TextPrompt;

/**
 *
 * @author Alejandro Galindo
 */
public class DlgTrabajos extends javax.swing.JDialog {

    private INegocio fachada;

    private Trabajo trabajo;

    private Modals modal;

    private FrmMain parent;

    private List<Cliente> clientes = new ArrayList<>();

    /**
     * Creates new form DlgTrabajos
     */
    public DlgTrabajos(java.awt.Frame parent, boolean modal, Modals mode, Trabajo trabajo, INegocio fachada) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.parent = (FrmMain) parent;

        this.fachada = fachada;
        this.trabajo = trabajo;
        this.modal = mode;
        listaClientes();

        if (mode == Modals.AGREGAR) {
            txtModal.setText("AGREGAR TRABAJO");
            btnModal.setText("AGREGAR");
            this.setTitle("AGREGAR TRABAJO");
            TextPrompt folio = new TextPrompt("FOLIO DE TRABAJO", textFolio);
            folio.changeAlpha(0.75f);
            textFolio.setEnabled(false);

            TextPrompt concepto = new TextPrompt("CONCEPTO", text_Concepto);
            concepto.changeAlpha(0.75f);

            TextPrompt costo = new TextPrompt("COSTO", text_Costo);
            costo.changeAlpha(0.75f);

            TextPrompt cantidad = new TextPrompt("CANTIDAD", text_Cantidad);
            cantidad.changeAlpha(0.75f);

            TextPrompt entrega = new TextPrompt("NOMBRE DE QUIEN ENTREGA", textNombreEntrega);
            entrega.changeAlpha(0.75f);

            Date todayDate = new Date();

            datePicker.setDate(
                    Instant.ofEpochMilli(todayDate.getTime())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());

            //Lo pone seleccionado por default, y como no te deja deseleccionar, siempre tendra tipo
            //Estaba pensado pero no lo pusimos
            radioEvaluativo.setSelected(true);

        } else if (mode == Modals.EDITAR) {
            txtModal.setText("EDITAR TRABAJO");
            btnModal.setText("EDITAR");
            this.setTitle("EDITAR TRABAJO");

            TextPrompt concepto = new TextPrompt("CONCEPTO", text_Concepto);
            concepto.changeAlpha(0.75f);

            TextPrompt costo = new TextPrompt("COSTO", text_Costo);
            costo.changeAlpha(0.75f);

            TextPrompt cantidad = new TextPrompt("CANTIDAD", text_Cantidad);
            cantidad.changeAlpha(0.75f);

            textFolio.setText("" + trabajo.getFolioTrabajo());
            textFolio.setEnabled(false);
            textNombreEntrega.setText(trabajo.getNombreDeQuienEntrega());
            textArea_Descrita.setText(trabajo.getFallaCliente());
            textArea_Localizada.setText(trabajo.getFallaEncontrada());

            datePicker.setDate(
                    Instant.ofEpochMilli(trabajo.getFechaEstimada().getTime())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());

            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).equals(trabajo.getCliente())) {
                    comboClientes.setSelectedIndex(i);
                }
            }

            String tipo = trabajo.getTipoTrabajo().toString();
            if (tipo.equals("EVALUATIVO")) {
                radioEvaluativo.setSelected(true);
            } else if (tipo.equals("PREVENTIVO")) {
                radioPreventivo.setSelected(true);
            } else if (tipo.equals("TOTAL")) {
                radioTotal.setSelected(true);
            } else if (tipo.equals("PARCIAL")) {
                radioParcial.setSelected(true);
            }

            actualizarTablaConceptos();
            //Poner los conceptos
        }
    }

    private String validarFecha() {
        Date fechaActual = new Date();
        Date fechaSeleccionada;

        if (datePicker.getDateStringOrEmptyString().equals("")) {
            return "Fecha con formato incorrecto";
        } else {
            return "";
        }
    }

    private void listaClientes() {
        clientes = fachada.getClientes();
        DefaultComboBoxModel dml = new DefaultComboBoxModel();
        for (Cliente cliente : clientes) {
            dml.addElement(cliente.getRazonSocial());
        }
        comboClientes.setModel(dml);
    }

    private void actualizarTablaConceptos() {
        List<Concepto> conceptos = trabajo.getConceptos();
        vaciarTablas();

        DefaultTableModel conceptosTM = (DefaultTableModel) tablaConceptos.getModel();
        Object rowData[] = new Object[3];

        for (int i = 0; i < conceptos.size(); i++) {
            if (conceptos.get(i) instanceof Insumo) {
                rowData[0] = conceptos.get(i).getDescripcion();
                rowData[1] = ((Insumo) conceptos.get(i)).getCantidad();
                rowData[2] = conceptos.get(i).getCosto();
            } else {
                rowData[0] = conceptos.get(i).getDescripcion();
                rowData[1] = "";
                rowData[2] = conceptos.get(i).getCosto();
            }
            conceptosTM.addRow(rowData);
        }
    }

    private void vaciarTablas() {
        while (tablaConceptos.getRowCount() > 0) {
            ((DefaultTableModel) tablaConceptos.getModel()).removeRow(0);
        }
    }

    private String validar() {
        String mensaje = "";

        mensaje = mensaje + validarFecha();

        if (textArea_Descrita.getText().equals("")) {
            mensaje = mensaje + "Escriba la falla del cliente l\n\r";
        }
        if (textArea_Localizada.getText().equals("")) {
            mensaje = mensaje + "Escriba la falla localizada \n\r";
        }

        return mensaje;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        txtModal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textFolio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        radioEvaluativo = new javax.swing.JRadioButton();
        radioPreventivo = new javax.swing.JRadioButton();
        radioTotal = new javax.swing.JRadioButton();
        radioParcial = new javax.swing.JRadioButton();
        comboClientes = new javax.swing.JComboBox<>();
        opt_AgregarCliente = new javax.swing.JLabel();
        textNombreEntrega = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea_Descrita = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea_Localizada = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaConceptos = new javax.swing.JTable();
        text_Concepto = new javax.swing.JTextField();
        text_Costo = new javax.swing.JTextField();
        check_Insumo = new javax.swing.JCheckBox();
        btn_Aniadir = new javax.swing.JButton();
        btn_Quitar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        text_Cantidad = new javax.swing.JTextField();
        btnModal = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        datePicker = new com.github.lgooddatepicker.components.DatePicker();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtModal.setText("MODALIDAD");
        txtModal.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setText("#");
        jLabel2.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N

        textFolio.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N

        jLabel3.setText("Tipo:");
        jLabel3.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N

        radioEvaluativo.setBackground(new java.awt.Color(255, 255, 255));
        btnGroup.add(radioEvaluativo);
        radioEvaluativo.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        radioEvaluativo.setText("EVALUATIVO");

        radioPreventivo.setBackground(new java.awt.Color(255, 255, 255));
        btnGroup.add(radioPreventivo);
        radioPreventivo.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        radioPreventivo.setText("PREVENTIVO");

        radioTotal.setBackground(new java.awt.Color(255, 255, 255));
        btnGroup.add(radioTotal);
        radioTotal.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        radioTotal.setText("REPARACIÓN TOTAL");

        radioParcial.setBackground(new java.awt.Color(255, 255, 255));
        btnGroup.add(radioParcial);
        radioParcial.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        radioParcial.setText("REPARACIÓN PARCIAL");

        comboClientes.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N

        opt_AgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_add_2.png"))); // NOI18N
        opt_AgregarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt_AgregarClienteMouseClicked(evt);
            }
        });

        textNombreEntrega.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(radioEvaluativo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioPreventivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioParcial))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(opt_AgregarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(textNombreEntrega)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFolio)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioEvaluativo, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(radioPreventivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioParcial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboClientes)
                    .addComponent(opt_AgregarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(textNombreEntrega))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Fecha estimada de entrega:");
        jLabel1.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setText("FALLA DESCRITA POR EL CLIENTE");
        jLabel4.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N

        textArea_Descrita.setColumns(20);
        textArea_Descrita.setRows(5);
        textArea_Descrita.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(textArea_Descrita);

        jLabel6.setText("FALLA LOCALIZADA");
        jLabel6.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N

        textArea_Localizada.setColumns(20);
        textArea_Localizada.setRows(5);
        textArea_Localizada.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(textArea_Localizada);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel7.setText("DESGLOSE DE COSTOS");
        jLabel7.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N

        tablaConceptos.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        tablaConceptos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CONCEPTO", "CANTIDAD", "COSTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaConceptos.setRowHeight(24);
        tablaConceptos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane3.setViewportView(tablaConceptos);

        text_Concepto.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N

        text_Costo.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N

        check_Insumo.setText("INSUMO");
        check_Insumo.setBackground(new java.awt.Color(255, 255, 255));
        check_Insumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_InsumoActionPerformed(evt);
            }
        });

        btn_Aniadir.setText("AÑADIR");
        btn_Aniadir.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        btn_Aniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AniadirActionPerformed(evt);
            }
        });

        btn_Quitar.setText("QUITAR");
        btn_Quitar.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        btn_Quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QuitarActionPerformed(evt);
            }
        });

        btn_Modificar.setText("MODIFICAR");
        btn_Modificar.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });

        text_Cantidad.setEnabled(false);
        text_Cantidad.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane3)
                    .addComponent(text_Concepto)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(text_Costo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check_Insumo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text_Cantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Aniadir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Quitar)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(text_Concepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_Costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_Insumo)
                    .addComponent(btn_Aniadir)
                    .addComponent(text_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Quitar)
                    .addComponent(btn_Modificar))
                .addContainerGap())
        );

        btnModal.setText("MODALIDAD");
        btnModal.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        btnModal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModalActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        datePicker.setBackground(new java.awt.Color(255, 255, 255));
        datePicker.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnModal)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtModal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtModal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModalActionPerformed
        String resultado = "";
        String validar = "";
        if (modal == Modals.AGREGAR) {
            validar = validar();

            if (validar.equals("")) {
                trabajo.setCliente(clientes.get(comboClientes.getSelectedIndex()));
                trabajo.setNombreDeQuienEntrega(textNombreEntrega.getText());
                trabajo.setAdministrador((Administrador) fachada.getUsuario(1)); //Necesita haber un usuario
                trabajo.setFechaCreacion(new Date());
                Date dateEstimada = Date.from(datePicker.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
                trabajo.setFechaEstimada(dateEstimada);
                trabajo.setFallaCliente(textArea_Descrita.getText());
                trabajo.setFallaEncontrada(textArea_Localizada.getText());

                if (radioEvaluativo.isSelected()) {
                    trabajo.setTipoTrabajo(TipoTrabajo.EVALUATIVO);
                } else if (radioTotal.isSelected()) {
                    trabajo.setTipoTrabajo(TipoTrabajo.TOTAL);
                } else if (radioParcial.isSelected()) {
                    trabajo.setTipoTrabajo(TipoTrabajo.PARCIAL);
                } else if (radioPreventivo.isSelected()) {
                    trabajo.setTipoTrabajo(TipoTrabajo.PREVENTIVO);
                }

                resultado = fachada.agregarTrabajo(trabajo);
            } else {
                resultado = validar;
            }
        } else if (modal == Modals.EDITAR) {
            validar = validar();

            if (validar.equals("")) {
                Trabajo trabajoTemp = this.trabajo;

                //            String[] split = textFechaEstimada.getText().split("/");
                trabajoTemp.setCliente(clientes.get(comboClientes.getSelectedIndex()));
                trabajoTemp.setNombreDeQuienEntrega(textNombreEntrega.getText());
                trabajoTemp.setAdministrador((Administrador) fachada.getUsuario(1));
                trabajoTemp.setFechaCreacion(new Date());
                Date dateEstimada = Date.from(datePicker.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
                trabajoTemp.setFechaEstimada(dateEstimada);
                trabajoTemp.setFallaCliente(textArea_Descrita.getText());
                trabajoTemp.setFallaEncontrada(textArea_Localizada.getText());

                if (radioEvaluativo.isSelected()) {
                    trabajoTemp.setTipoTrabajo(TipoTrabajo.EVALUATIVO);
                } else if (radioTotal.isSelected()) {
                    trabajoTemp.setTipoTrabajo(TipoTrabajo.TOTAL);
                } else if (radioParcial.isSelected()) {
                    trabajoTemp.setTipoTrabajo(TipoTrabajo.PARCIAL);
                } else if (radioPreventivo.isSelected()) {
                    trabajoTemp.setTipoTrabajo(TipoTrabajo.PREVENTIVO);
                }

                resultado = fachada.editarTrabajo(trabajoTemp);
            } else {
                resultado = validar();
            }
        }
        JOptionPane.showMessageDialog(this, resultado, this.modal.toString(), JOptionPane.INFORMATION_MESSAGE);
        if (validar.equals("")) {
            this.dispose();
        }
    }//GEN-LAST:event_btnModalActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int showConfirmDialog = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas cancelar esta acción?", "Cancelar", JOptionPane.YES_NO_OPTION);

        if (showConfirmDialog == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void check_InsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_InsumoActionPerformed
        if (check_Insumo.isSelected()) {
            text_Cantidad.setEnabled(true);
        } else {
            text_Cantidad.setEnabled(false);
        }
        text_Cantidad.revalidate();
    }//GEN-LAST:event_check_InsumoActionPerformed

    private void btn_AniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AniadirActionPerformed
        if (!text_Concepto.getText().equals("") && !text_Costo.getText().equals("") && text_Costo.getText().matches("^\\d+.?\\d+$")) {
            if (!check_Insumo.isSelected()) {
                this.trabajo.getConceptos().add(new Servicio(null, text_Concepto.getText(), Double.valueOf(text_Costo.getText())));
            } else {
                if (!text_Cantidad.getText().equals("") || text_Cantidad.getText().matches("^\\d+")) {
                    this.trabajo.getConceptos().add(new Insumo(Integer.valueOf(text_Cantidad.getText()), null, text_Concepto.getText(), Double.valueOf(text_Costo.getText())));
                }else{
                    JOptionPane.showMessageDialog(this, "Coloque una cantidad no decimal", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            text_Concepto.setText("");
            text_Cantidad.setText("");
            text_Costo.setText("");
            actualizarTablaConceptos();
        }else{
            JOptionPane.showMessageDialog(this, "Rellene todos los campos", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_AniadirActionPerformed

    private void opt_AgregarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_AgregarClienteMouseClicked
        DlgClientes dlgClientes = new DlgClientes(parent, true, Modals.AGREGAR, new Cliente(), this.fachada);
        dlgClientes.setVisible(true);
        listaClientes();
    }//GEN-LAST:event_opt_AgregarClienteMouseClicked

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ModificarActionPerformed

    private void btn_QuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QuitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_QuitarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btnModal;
    private javax.swing.JButton btn_Aniadir;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Quitar;
    private javax.swing.JCheckBox check_Insumo;
    private javax.swing.JComboBox<String> comboClientes;
    private com.github.lgooddatepicker.components.DatePicker datePicker;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel opt_AgregarCliente;
    private javax.swing.JRadioButton radioEvaluativo;
    private javax.swing.JRadioButton radioParcial;
    private javax.swing.JRadioButton radioPreventivo;
    private javax.swing.JRadioButton radioTotal;
    private javax.swing.JTable tablaConceptos;
    private javax.swing.JTextArea textArea_Descrita;
    private javax.swing.JTextArea textArea_Localizada;
    private javax.swing.JTextField textFolio;
    private javax.swing.JTextField textNombreEntrega;
    private javax.swing.JTextField text_Cantidad;
    private javax.swing.JTextField text_Concepto;
    private javax.swing.JTextField text_Costo;
    private javax.swing.JLabel txtModal;
    // End of variables declaration//GEN-END:variables
}
