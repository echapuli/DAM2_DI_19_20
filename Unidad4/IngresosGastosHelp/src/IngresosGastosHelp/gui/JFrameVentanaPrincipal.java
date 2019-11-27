/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngresosGastosHelp.gui;

import IngresosGastosHelp.gui.tableModels.IngresosGastosTableModel;
import IngresosGastosHelp.logica.LogicaNegocio;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import javax.help.HelpBroker;
import javax.help.HelpSet;


/**
 *
 * @author Eduardo
 */
public class JFrameVentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFrameVentanaPrincipal
     */
    public JFrameVentanaPrincipal() {
        initComponents();
        //Metemos la ayuda
        try 
        {
            // Carga el fichero de ayuda
            File fichero = new File("src"+File.separator+"help"+File.separator+"help_set.hs");
            URL hsURL = fichero.toURI().toURL();
            // Crea el HelpSet y el HelpBroker            
            HelpSet helpset = new HelpSet(null, hsURL);
            HelpBroker hb = helpset.createHelpBroker();

            // sale la ayuda desde la opción del menú y dando al f1 en la ventana
            hb.enableHelpOnButton(jMenuItemAyuda, "ventana_principal", helpset);
            hb.enableHelpKey(getRootPane(),"ventana_principal",helpset);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }        
        jTableingresosGastos.setModel(new IngresosGastosTableModel(LogicaNegocio.getListaIngresosgastos())); //creamos el objeto pasandole al constructor la lista  de la clase logicaNegocio
        //centrar ventana en la pantalla
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize(); //recuperamos tamaño pantalla
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width/2, height/2);		
        setLocationRelativeTo(null);	
        refrescaTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneIngresosGastos = new javax.swing.JScrollPane();
        jTableingresosGastos = new javax.swing.JTable();
        jPanelPie = new javax.swing.JPanel();
        jLabelBalance = new javax.swing.JLabel();
        jTextFieldBalance = new javax.swing.JTextField();
        jMenuBarIngresosGastos = new javax.swing.JMenuBar();
        jMenuAlta = new javax.swing.JMenu();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableingresosGastos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneIngresosGastos.setViewportView(jTableingresosGastos);

        getContentPane().add(jScrollPaneIngresosGastos, java.awt.BorderLayout.CENTER);

        jLabelBalance.setText("Balance: ");

        jTextFieldBalance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanelPieLayout = new javax.swing.GroupLayout(jPanelPie);
        jPanelPie.setLayout(jPanelPieLayout);
        jPanelPieLayout.setHorizontalGroup(
            jPanelPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPieLayout.createSequentialGroup()
                .addContainerGap(262, Short.MAX_VALUE)
                .addComponent(jLabelBalance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelPieLayout.setVerticalGroup(
            jPanelPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPieLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanelPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBalance)
                    .addComponent(jTextFieldBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        getContentPane().add(jPanelPie, java.awt.BorderLayout.PAGE_END);

        jMenuAlta.setText("Alta");
        jMenuAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuAltaMousePressed(evt);
            }
        });
        jMenuBarIngresosGastos.add(jMenuAlta);

        jMenuHelp.setText("?");
        jMenuHelp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuHelp.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jMenuItemAyuda.setText("Ayuda");
        jMenuHelp.add(jMenuItemAyuda);

        jMenuBarIngresosGastos.add(jMenuHelp);

        setJMenuBar(jMenuBarIngresosGastos);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuAltaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuAltaMousePressed

        JDialogAlta DialogoAlta = new JDialogAlta(this, true);
        DialogoAlta.setVisible(true);
        refrescaTabla();
    }//GEN-LAST:event_jMenuAltaMousePressed

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
            java.util.logging.Logger.getLogger(JFrameVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameVentanaPrincipal().setVisible(true);
            }
        });
    }
    private void refrescaTabla(){
        IngresosGastosTableModel ctm = (IngresosGastosTableModel) jTableingresosGastos.getModel();  //recupero el TableModel de la tabla
        ctm.refrescar();  //lanzo su metodo para refrescarlo
        double balance=LogicaNegocio.getBalance();
        if (balance<0) //balance negativo ponemos el jTextFieldBalance a color de texto rojo
            jTextFieldBalance.setForeground(Color.RED);
        else //balance positivo ponemos el jTextFieldBalance a color de texto verde
            jTextFieldBalance.setForeground(Color.GREEN);
        //recordar poner al jTextFieldBalance el atributo horizontalAlignment	RIGHT
        jTextFieldBalance.setText(new DecimalFormat("#0.00#").format(balance)); // redondea a 2 decimales);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelBalance;
    private javax.swing.JMenu jMenuAlta;
    private javax.swing.JMenuBar jMenuBarIngresosGastos;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItemAyuda;
    private javax.swing.JPanel jPanelPie;
    private javax.swing.JScrollPane jScrollPaneIngresosGastos;
    private javax.swing.JTable jTableingresosGastos;
    private javax.swing.JTextField jTextFieldBalance;
    // End of variables declaration//GEN-END:variables
}
