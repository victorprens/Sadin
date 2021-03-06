/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.datosBasicos.fuentesDeIngresos;

import controlador.Coordinador;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.vo.datosBasicos.FuenteDeIngresosVO;
import utilidades.Formulario;

/**
 *
 * @author Victor Del Rio Prens
 */
public class CrearFuenteDeIngresos extends javax.swing.JFrame {
    final String fuenteDeIngresosCreada = "la fuente de ingresos fue creada con exito.";
    final String fuenteDeIngresosNoCreada = "Problemas al crear la fuente de ingresos.";
    Coordinador coordinador;
    List<Object> campos;
    List<Object> botones;
    /**
     * Creates new form CrearFuenteDeIngresos
     */
    public CrearFuenteDeIngresos() {
        initComponents();
        setLocationRelativeTo(null);
        campos = Formulario.obtenerElementos(JTextField.class, getComponents());
        botones = Formulario.obtenerElementos(JButton.class, getComponents());
    }

    /**
     * Toma todos los campos que se encuentran dentro del formulario y los retorna
     * @return 
     */
    public FuenteDeIngresosVO obtenerFuenteDeIngresos(){
        FuenteDeIngresosVO fuenteDeIngresos = new FuenteDeIngresosVO(campoNombre.getText());
        return fuenteDeIngresos;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoNombre = new javax.swing.JTextField();
        etiquetaTitulo = new javax.swing.JLabel();
        etiquetaDescripcion = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etiquetaTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        etiquetaTitulo.setText("Crear Fuente De Ingresos");

        etiquetaDescripcion.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        etiquetaDescripcion.setText("Nombre:");

        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/datosBasicos/save_32.png"))); // NOI18N
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/datosBasicos/home_32.png"))); // NOI18N
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(etiquetaTitulo))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonGuardar, botonSalir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonGuardar)
                    .addComponent(botonSalir))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botonGuardar, botonSalir});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if(Formulario.validarCamposVacios(campos)){
            boolean creada = coordinador.crearFuenteDeIngresos(obtenerFuenteDeIngresos());
            Formulario.limpiarCampos(campos);
            String mensaje = (creada) ? fuenteDeIngresosCreada : fuenteDeIngresosNoCreada;
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

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
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JLabel etiquetaDescripcion;
    private javax.swing.JLabel etiquetaTitulo;
    // End of variables declaration//GEN-END:variables
}
