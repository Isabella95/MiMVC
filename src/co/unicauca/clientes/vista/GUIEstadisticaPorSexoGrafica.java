
package co.unicauca.clientes.vista;

import co.unicauca.clientes.modelo.ClientesDB;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.text.DecimalFormat;
import java.util.Observable;

/**
 *
 * @author Libardo Pantoja, Ricardo Zambrano Es el primer primer observador.
 *
 */
public class GUIEstadisticaPorSexoGrafica extends javax.swing.JFrame implements java.util.Observer {

    private String profesion;
    
    /**
     * Constructor
     *
     * @param h horizontal position
     * @param v vertical position
     */
    public GUIEstadisticaPorSexoGrafica(int h, int v) {
        //observers = new ArrayList();
        initComponents();
        setSize(250, 330);
        setLocation(h, v);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGrafica = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLblMen = new javax.swing.JLabel();
        jLblwomen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Búsqueda de Clientes");
        setPreferredSize(new java.awt.Dimension(250, 300));

        jPanelGrafica.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGrafica.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelGrafica.setMinimumSize(new java.awt.Dimension(250, 300));
        jPanelGrafica.setPreferredSize(new java.awt.Dimension(250, 300));
        jPanelGrafica.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Hombres");
        jPanelGrafica.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Mujeres");
        jPanelGrafica.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, -1, -1));

        jLblMen.setText(".........");
        jPanelGrafica.add(jLblMen, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLblwomen.setText(".........");
        jPanelGrafica.add(jLblwomen, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     @Override    
     public void update(Observable obs, Object obj) {        
         ClientesDB cliDB = (ClientesDB) obs;        
         this.setTitle("Profesión: " + cliDB.getProfesion());        
         graficar(cliDB.getTotalHombres(), cliDB.getTotalMujeres());    
     }

    public void graficar(int hombres, int mujeres){
        jPanelGrafica.paint(jPanelGrafica.getGraphics());

        float total = hombres + mujeres;
        float gentlemen = ((hombres * 100) / total);
        float ladies = (mujeres * 100) / total;

        int men = (int) gentlemen;
        int women = (int) ladies;

        DecimalFormat df = new DecimalFormat(".00");
        jLblMen.setText(df.format(gentlemen) + " º/º");
        jLblwomen.setText(df.format(ladies) + " º/º");

        Graphics p = jPanelGrafica.getGraphics();
        p.drawRect(50, 55, 40, 200);
        p.drawRect(150, 55, 40, 200);

        int calculoHombres = (int) (200 - men * 2);
        int calculoHombresY = (int) men * 2;

        int calculoMujeres = (int) (200 - women * 2);
        int calculoMujeresY = (int) women * 2;

        p.setColor(Color.BLUE);
        p.fillRect(50, (55 + calculoHombres), 40, calculoHombresY);
        p.fillRect(150, (55 + calculoMujeres), 40, calculoMujeresY);
    }
    
    public void paint(Graphics g, int hombres, int damas){
      
    }
     
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
            java.util.logging.Logger.getLogger(GUIEstadisticaPorSexoGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIEstadisticaPorSexoGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIEstadisticaPorSexoGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIEstadisticaPorSexoGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIEstadisticaPorSexoGrafica(100, 100).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLblMen;
    private javax.swing.JLabel jLblwomen;
    private javax.swing.JPanel jPanelGrafica;
    // End of variables declaration//GEN-END:variables


}
