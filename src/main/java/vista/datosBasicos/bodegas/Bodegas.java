/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.datosBasicos.bodegas;

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
import modelo.vo.datosBasicos.BodegaVO;
import utilidades.Formulario;
import vista.datosBasicos.ForcedListSelectionModel;

/**
 *
 * @author Victor Del Rio Prens
 */
public class Bodegas extends javax.swing.JFrame {
    private final String noHayBodegas = "Actualmente no existen bodegas dentro de la base de datos.";
    private final String ningunaBodegaSeleccionada = "Por favor seleccione una bodega.";
    private final String bodegaEliminada = "La bodega fue eliminada con exito.";
    private final String bodegaNoEliminada = "Existe un problema al tratar de eliminar la bodega.";
    private final String confirmacionEliminar = "¿Desea eliminar esta bodega?";
    Coordinador coordinador;
    DefaultTableModel model;
    
    /**
     * Creates new form Busqueda
     */
    public Bodegas() {
        initComponents();
        setLocationRelativeTo(null);
        model = (DefaultTableModel) tablaBodegas.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tablaBodegas.setDefaultRenderer(String.class, centerRenderer);
        tablaBodegas.setDefaultRenderer(Integer.class, centerRenderer);
        tablaBodegas.setSelectionModel(new ForcedListSelectionModel());
    }
    
    /**
     * Permite crear una fila dentro de la tabla
     * @param codigo
     * @param nombre
     * @param direccion
     * @param responsable
     * @param telefonos 
     */
    public void crearFila(int codigo, String nombre, String direccion, String responsable, String telefonos){
        model.addRow(new Object[]{codigo, nombre, direccion, responsable, telefonos});
    }
    
    /**
     * Toma la ultima bodega seleccionada dentro de la tabla y la retorna
     * @return 
     */
    public BodegaVO obtenerBodegaSeleccionada(){
        BodegaVO bodegaSeleccionada = null;
        int index = tablaBodegas.getSelectedRow();
        if(index != -1){
            TableModel tableModel = tablaBodegas.getModel();
            bodegaSeleccionada = new BodegaVO();
            bodegaSeleccionada.setCodigo(Integer.parseInt(tableModel.getValueAt(index, 0).toString()));
            bodegaSeleccionada.setNombre(tableModel.getValueAt(index, 1).toString());
            bodegaSeleccionada.setDireccion(tableModel.getValueAt(index, 2).toString());
            bodegaSeleccionada.setResponsable(tableModel.getValueAt(index, 3).toString());
            bodegaSeleccionada.setTelefonos(tableModel.getValueAt(index, 4).toString());
        } else {
            JOptionPane.showMessageDialog(null, ningunaBodegaSeleccionada);
        }
        return bodegaSeleccionada;
    }
    
    /**
     * Toma todas las bodegas que se encuentran dentro de la base de datos y 
     * las ingresa en la tabla
     */
    public void llenarTabla(){
        Formulario.eliminarTodasLasFilas(model);
        List<BodegaVO> bodegas = coordinador.buscarTodasLasBodegas();
        if(!bodegas.isEmpty()){
            for (BodegaVO bodega : bodegas) {
                crearFila(bodega.getCodigo(), bodega.getNombre(), bodega.getDireccion(), bodega.getResponsable(), bodega.getTelefonos());
            }
        } else {
            JOptionPane.showMessageDialog(null, noHayBodegas);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBodegas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        botonEliminar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();
        campoBusqueda = new javax.swing.JTextField();
        botonRefrescarTabla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tablaBodegas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Direccion", "Responsable", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaBodegas);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Bodegas");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                .addGap(211, 211, 211))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonAgregar, botonEditar, botonEliminar, botonRefrescarTabla, botonSalir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonSalir)
                    .addComponent(botonEditar)
                    .addComponent(botonEliminar)
                    .addComponent(botonAgregar)
                    .addComponent(botonRefrescarTabla))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botonAgregar, botonEditar, botonEliminar, botonRefrescarTabla, botonSalir});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        BodegaVO bodega = obtenerBodegaSeleccionada();
        if(bodega != null){
            int confirmacion = JOptionPane.showConfirmDialog(null, confirmacionEliminar);
            if(JOptionPane.YES_OPTION == confirmacion){
                boolean eliminada = coordinador.eliminarBodega(bodega.getCodigo());
                if(eliminada){
                    int fila = tablaBodegas.convertRowIndexToModel(tablaBodegas.getSelectedRow());
                    model = (DefaultTableModel)tablaBodegas.getModel();
                    model.removeRow(fila);
                    JOptionPane.showMessageDialog(null, bodegaEliminada);
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, bodegaNoEliminada);
                }
            }
        }

    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        int fila = tablaBodegas.convertRowIndexToModel(tablaBodegas.getSelectedRow());
        if(fila != -1){
            TableModel modelo = tablaBodegas.getModel();
            EditarBodega editarBodega = new EditarBodega();
            editarBodega.setVisible(true);
            editarBodega.setCoordinador(coordinador);
            editarBodega.getCampoCodigo().setText(modelo.getValueAt(fila, 0).toString());
            editarBodega.getCampoNombre().setText(modelo.getValueAt(fila, 1).toString());
            editarBodega.getCampoDireccion().setText(modelo.getValueAt(fila, 2).toString());
            editarBodega.getCampoResponsable().setText(modelo.getValueAt(fila, 3).toString());
            editarBodega.getCampoTelefonos().setText(modelo.getValueAt(fila, 4).toString());
        } else {
            JOptionPane.showMessageDialog(null, ningunaBodegaSeleccionada);
        }
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        CrearBodega crearBodega = new CrearBodega();
        crearBodega.setVisible(true);
        crearBodega.setCoordinador(coordinador);
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void campoBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBusquedaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tablaBodegas.getModel());
            tablaBodegas.setRowSorter(rowSorter);
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

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_botonSalirActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaBodegas;
    // End of variables declaration//GEN-END:variables
}
