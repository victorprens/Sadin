/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.datosBasicos.vendedores;

import controlador.Coordinador;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.vo.datosBasicos.VendedorVO;
import utilidades.Formulario;
import vista.datosBasicos.ForcedListSelectionModel;

/**
 *
 * @author Victor Del Rio Prens
 */
public class Vendedores extends javax.swing.JFrame {
    private final String noHayVendedores = "Actualmente no existen vendedores dentro de la base de datos.";
    private final String ningunVendedorSeleccionado = "Por favor seleccione un vendedor.";
    private final String vendedorEliminado = "El vendedor fue eliminado con exito.";
    private final String vendedorNoEliminado = "Existe un problema al tratar de eliminar el vendedor.";
    private final String confirmacionEliminar = "¿Desea eliminar este vendedor?";
    Coordinador coordinador;
    DefaultTableModel model;
    
    /**
     * Creates new form Vendedores
     */
    public Vendedores() {
        initComponents();
        setLocationRelativeTo(null);
        model = (DefaultTableModel) tablaVendedores.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tablaVendedores.setDefaultRenderer(String.class, centerRenderer);
        tablaVendedores.setDefaultRenderer(Integer.class, centerRenderer);
        tablaVendedores.setSelectionModel(new ForcedListSelectionModel());
    }

    /**
     * Permite crear una fila dentro de la tabla
     * @param codigo
     * @param nombre
     * @param siglas
     */
    public void crearFila(int codigo, String nombre, String siglas){
        model.addRow(new Object[]{codigo, nombre, siglas});
    }
    
    /**
     * Toma el ultimo vendedor seleccionado dentro de la tabla y lo retorna
     * @return 
     */
    public VendedorVO obtenerVendedorSeleccionado(){
        VendedorVO vendedorSeleccionado = null;
        int index = tablaVendedores.getSelectedRow();
        if(index != -1){
            TableModel tableModel = tablaVendedores.getModel();
            vendedorSeleccionado = new VendedorVO();
            vendedorSeleccionado.setCodigo(Integer.parseInt(tableModel.getValueAt(index, 0).toString()));
            vendedorSeleccionado.setNombre(tableModel.getValueAt(index, 1).toString());
            vendedorSeleccionado.setSiglas(tableModel.getValueAt(index, 2).toString());
            
        } else {
            JOptionPane.showMessageDialog(null, ningunVendedorSeleccionado);
        }
        return vendedorSeleccionado;
    }
    
    /**
     * Toma todos los vendedores que se encuentran dentro de la base de datos y 
     * las ingresa en la tabla
     */
    public void llenarTabla(){
        Formulario.eliminarTodasLasFilas(model);
        List<VendedorVO> vendedores = coordinador.buscarTodosLosVendedores();
        if(!vendedores.isEmpty()){
            for (VendedorVO vendedor : vendedores) {
                crearFila(vendedor.getCodigo(), vendedor.getNombre(), vendedor.getSiglas());
            }
        } else {
            JOptionPane.showMessageDialog(null, noHayVendedores);
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

        campoBusqueda = new javax.swing.JTextField();
        botonRefrescarTabla = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();
        etiquetaTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        campoBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoBusquedaKeyPressed(evt);
            }
        });

        botonRefrescarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRefrescarTablaActionPerformed(evt);
            }
        });

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/datosBasicos/delete_32.png"))); // NOI18N
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/datosBasicos/home_32.png"))); // NOI18N
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/datosBasicos/pencil_32.png"))); // NOI18N
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/datosBasicos/plus_32.png"))); // NOI18N
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        etiquetaTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        etiquetaTitulo.setText("Vendedores");

        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Siglas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tablaVendedores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonRefrescarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonAgregar, botonEditar, botonEliminar, botonRefrescarTabla, botonSalir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaTitulo)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonSalir)
                    .addComponent(botonEditar)
                    .addComponent(botonEliminar)
                    .addComponent(botonAgregar)
                    .addComponent(botonRefrescarTabla))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botonAgregar, botonEditar, botonEliminar, botonRefrescarTabla, botonSalir});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBusquedaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tablaVendedores.getModel());
            tablaVendedores.setRowSorter(rowSorter);
            String text = campoBusqueda.getText();
            if (text.trim().length() == 0) {
                rowSorter.setRowFilter(null);
            } else {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
        }
    }//GEN-LAST:event_campoBusquedaKeyPressed

    private void botonRefrescarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRefrescarTablaActionPerformed
        llenarTabla();
    }//GEN-LAST:event_botonRefrescarTablaActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        VendedorVO vendedor = obtenerVendedorSeleccionado();
        if(vendedor != null){
            int confirmacion = JOptionPane.showConfirmDialog(null, confirmacionEliminar);
            if(JOptionPane.YES_OPTION == confirmacion){
                boolean eliminada = coordinador.eliminarVendedor(vendedor.getCodigo());
                if(eliminada){
                    int fila = tablaVendedores.convertRowIndexToModel(tablaVendedores.getSelectedRow());
                    model = (DefaultTableModel)tablaVendedores.getModel();
                    model.removeRow(fila);
                    JOptionPane.showMessageDialog(null, vendedorEliminado);
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, vendedorNoEliminado);
                }
            }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        int fila = tablaVendedores.convertRowIndexToModel(tablaVendedores.getSelectedRow());
        if(fila != -1){
            TableModel modelo = tablaVendedores.getModel();
            EditarVendedor editarVendedor = new EditarVendedor();
            editarVendedor.setVisible(true);
            editarVendedor.setCoordinador(coordinador);
            editarVendedor.getCampoCodigo().setText(modelo.getValueAt(fila, 0).toString());
            editarVendedor.getCampoNombre().setText(modelo.getValueAt(fila, 1).toString());
            editarVendedor.getCampoSiglas().setText(modelo.getValueAt(fila, 2).toString());
        } else {
            JOptionPane.showMessageDialog(null, ningunVendedorSeleccionado);
        }
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        CrearVendedor crearVendedor = new CrearVendedor();
        crearVendedor.setVisible(true);
        crearVendedor.setCoordinador(coordinador);
    }//GEN-LAST:event_botonAgregarActionPerformed

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonRefrescarTabla;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVendedores;
    // End of variables declaration//GEN-END:variables
}
