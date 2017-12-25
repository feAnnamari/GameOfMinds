/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felulet;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import vezerlo.Vezerlo;

/**
 *
 * @author Annamari
 */
public class JatekVegePanel extends javax.swing.JPanel {

    private boolean nyert;
    private final String NYERO_HATTER_ELERES = "/kepek/nyeres.png";
    private final String VESZTETT_HATTER_ELERES = "/kepek/vesztetthatter.png";
    private Image nyeresHatter;
    private Image vesztesHatter;
    private final Image tuzijatekKep = new ImageIcon(this.getClass().getResource("/kepek/tuzijatek.gif")).getImage();
    private Image hatter; 
    private int lepesSzam;

    public void setLepesSzam(int lepesSzam) {
        this.lepesSzam = lepesSzam;
    }
    
    
    
    private Vezerlo vezerlo;

    public void setVezerlo(Vezerlo vezerlo) {
        this.vezerlo = vezerlo;
    }

    
    public JatekVegePanel() {
        initComponents();
        beallitas();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int kezdox, kezdoy, szelesseg, magassag;
        g.drawImage(hatter, 0, 0, this.getWidth(), this.getHeight(), this);
        if(nyert)
        {
            g.drawImage(tuzijatekKep, 0, 0, tuzijatekKep.getWidth(this), tuzijatekKep.getHeight(this), this);
        }
    }

    public boolean isNyert() {
        return nyert;
    }

    public void setNyert(boolean nyert) {
        this.nyert = nyert;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUjJatek = new javax.swing.JButton();
        btnKilepes = new javax.swing.JButton();
        lblLepesSzam = new javax.swing.JLabel();

        setLayout(null);

        btnUjJatek.setBackground(new java.awt.Color(51, 51, 51));
        btnUjJatek.setFont(new java.awt.Font("Vivaldi", 0, 48)); // NOI18N
        btnUjJatek.setText("Új játék");
        btnUjJatek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUjJatekActionPerformed(evt);
            }
        });
        add(btnUjJatek);
        btnUjJatek.setBounds(180, 210, 270, 70);

        btnKilepes.setBackground(new java.awt.Color(51, 51, 51));
        btnKilepes.setFont(new java.awt.Font("Vivaldi", 0, 36)); // NOI18N
        btnKilepes.setText("Kilépés");
        btnKilepes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKilepesActionPerformed(evt);
            }
        });
        add(btnKilepes);
        btnKilepes.setBounds(210, 290, 210, 60);

        lblLepesSzam.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblLepesSzam.setForeground(new java.awt.Color(255, 255, 255));
        lblLepesSzam.setText("1");
        add(lblLepesSzam);
        lblLepesSzam.setBounds(190, 158, 20, 22);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUjJatekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUjJatekActionPerformed
        vezerlo.alaphelyzetbeallit();
        vezerlo.megoldastGyart();
        vezerlo.jatekVegeFrametElrejt();
    }//GEN-LAST:event_btnUjJatekActionPerformed

    private void btnKilepesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKilepesActionPerformed
        vezerlo.dialogusAblak();
    }//GEN-LAST:event_btnKilepesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKilepes;
    private javax.swing.JButton btnUjJatek;
    private javax.swing.JLabel lblLepesSzam;
    // End of variables declaration//GEN-END:variables

    public void beallitas() {
        if(nyert)
        {
            hatter = nyeresHatter;
            lblLepesSzam.setText(Integer.toString(lepesSzam));
            lblLepesSzam.setVisible(true);
        }
        if(!nyert)
        {
            hatter = vesztesHatter;
            lblLepesSzam.setVisible(false);
        }     
        repaint();
    }

    public void szovegBeallitas(ResourceBundle bundle) 
    {
        nyeresHatter = new ImageIcon(this.getClass().getResource(bundle.getString("nyeresHatterEleres"))).getImage();
        vesztesHatter = new ImageIcon(this.getClass().getResource(bundle.getString("vesztesHatterEleres"))).getImage();
        btnUjJatek.setText(bundle.getString("btnUjJatek.text"));
        btnKilepes.setText(bundle.getString("btnKilepes.text"));
        beallitas();
    }

}
