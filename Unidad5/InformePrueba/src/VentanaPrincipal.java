
import java.io.File;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonMostrarInforme = new javax.swing.JButton();
        jComboBoxCiudad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonMostrarInforme.setText("Informe");
        jButtonMostrarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarInformeActionPerformed(evt);
            }
        });

        jComboBoxCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Berne", "Boston", "Chicago", "Dallas", "Lyon", "New York", "Olten", "Oslo", "Palo Alto", "Paris", "San Francisco", "Seattle", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxCiudad, 0, 254, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addComponent(jButtonMostrarInforme)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMostrarInforme))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMostrarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarInformeActionPerformed
        //al pulsar el botón mostramos el informe
        try {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();   //primero se carga el driver (en este caso es de HSQLDB
            Connection conexion=DriverManager.getConnection("jdbc:hsqldb:hsql://127.0.0.1/","sa","");  //ctreamos la conexión, los datos los sacamos del iReport en la definición del dataSource
            //ahora generamos el informe
            //si le pasasemos parámetros utilizatriamos la clase Map de Java (la clase Map almacenapares de clave-valor    
            Map parametros=new HashMap();
            System.out.print(jComboBoxCiudad.getSelectedItem());
            parametros.put("CIUDAD", jComboBoxCiudad.getSelectedItem());   
            //ahora vamos a utilizar la librería de Casper y para eso debemos tebnerla importada
            JasperPrint print=JasperFillManager.fillReport("informes"+File.separator+"reportPrueba.jasper", parametros,conexion);
            JasperExportManager.exportReportToPdfFile(print,"informes"+File.separator+"reportPrueba.pdf");
        }
        catch(Throwable e){
            e.printStackTrace();
 
        }
    }//GEN-LAST:event_jButtonMostrarInformeActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMostrarInforme;
    private javax.swing.JComboBox<String> jComboBoxCiudad;
    // End of variables declaration//GEN-END:variables
}
