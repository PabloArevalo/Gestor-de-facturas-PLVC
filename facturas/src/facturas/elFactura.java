/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class elFactura extends javax.swing.JInternalFrame {
DefaultTableModel modelo;
    /**
     * Creates new form elFactura
     */
    public elFactura() {
        initComponents();
        /*fecFactura,subtFactura,descFactura,ivaFactura,totFact
ura,respFactura,tipFactura,iceFactura,Usuario_cedUsuario,Proveedor_rucProveedor
*/
        String cabecera[]={"# Factura","Fecha","SubTotal","Descuento","IVA","Total","Responsable","tipo","ice","propietario","Emisor"};
        String datos[][]={};
        modelo=new DefaultTableModel(datos,cabecera);
        jTable1.setModel(modelo);
         jTextField1.setText("");
        jTextField1.requestFocus();
        mostrar();
    }
private void mostrar(){
for (int i = 0; i < modelo.getRowCount(); i++) {
           modelo.removeRow(i);
           i-=1;
       }
conectar con=new  conectar();
Connection reg=con.conexion();
        Statement st;
    try {
        st = reg.createStatement();
         ResultSet rs=st.executeQuery("select*from factura");
        while(rs.next()){
/*,,,,,,,,,*/  
            String num=rs.getString("idFactura");
            String a=rs.getString("fecFactura");
            String b=rs.getString("subtFactura");
            String c=rs.getString("descFactura");
            String d=rs.getString("ivaFactura");
            String e=rs.getString("totFactura");
            String f=rs.getString("respFactura");
            String g=rs.getString("tipFactura");  
            String h=rs.getString("iceFactura"); 
            String i=rs.getString("Usuario_cedUsuario");  
            String j=rs.getString("Proveedor_rucProveedor");  
            Object datos[]={num,a,b,c,d,e,f,g,h,i,j};
            modelo.addRow(datos);
            }
    } catch (SQLException ex) {
        Logger.getLogger(elProveedor.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Eliminar Factura");
        setAutoscrolls(true);

        jLabel1.setText("Numero Factura:");

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
conectar con=new  conectar();
Connection reg=con.conexion();
        String ced=jTextField1.getText();
        Statement st;
    try {
        st = reg.createStatement();
        String sql="delete from factura where idFactura="+ced;
             int rs=st.executeUpdate(sql);
             if(rs==1){
        JOptionPane.showMessageDialog(null, "Se ha borrado el registro");
        }
        else{
       JOptionPane.showMessageDialog(null, "No se pudo borrar el registro");
        }
        
        mostrar();
        jTextField1.setText("");
// TODO add your handling code here:
    } catch (SQLException ex) {
        Logger.getLogger(elFactura.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
