/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felulet;

import java.awt.Color;
import vezerlo.Vezerlo;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Annamari
 */
public class JobbPanel extends javax.swing.JPanel {

    private Image hatter = new ImageIcon(this.getClass().getResource("/kepek/hatter.jpg")).getImage(); 
    
    private Vezerlo vezerlo;

    public void setVezerlo(Vezerlo vezerlo) {
        this.vezerlo = vezerlo;
    }
            
    public JobbPanel() {
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int kezdox, kezdoy, szelesseg, magassag;
	g.drawImage(hatter, 0, 0, this.getWidth(), this.getHeight(), null); 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIcon1 = new javax.swing.JButton();
        btnIcon2 = new javax.swing.JButton();
        btnIcon3 = new javax.swing.JButton();
        btnIcon4 = new javax.swing.JButton();
        btnIcon5 = new javax.swing.JButton();
        btnIcon6 = new javax.swing.JButton();
        btnIcon7 = new javax.swing.JButton();
        btnIcon8 = new javax.swing.JButton();
        btnIcon9 = new javax.swing.JButton();
        btnNewGame = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnReady = new javax.swing.JButton();
        btnKilepes = new javax.swing.JButton();
        btnTalcara = new javax.swing.JButton();
        btnSugo = new javax.swing.JButton();
        btnVissza = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));

        btnIcon1.setBackground(new java.awt.Color(51, 51, 51));
        btnIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/01_ikon.png"))); // NOI18N
        btnIcon1.setMaximumSize(new java.awt.Dimension(424, 461));
        btnIcon1.setPreferredSize(new java.awt.Dimension(424, 461));
        btnIcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIcon1ActionPerformed(evt);
            }
        });

        btnIcon2.setBackground(new java.awt.Color(51, 51, 51));
        btnIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/02_ikon.png"))); // NOI18N
        btnIcon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIcon2ActionPerformed(evt);
            }
        });

        btnIcon3.setBackground(new java.awt.Color(51, 51, 51));
        btnIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/03_ikon.png"))); // NOI18N
        btnIcon3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIcon3ActionPerformed(evt);
            }
        });

        btnIcon4.setBackground(new java.awt.Color(51, 51, 51));
        btnIcon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/04_ikon.png"))); // NOI18N
        btnIcon4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIcon4ActionPerformed(evt);
            }
        });

        btnIcon5.setBackground(new java.awt.Color(51, 51, 51));
        btnIcon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/05_ikon.png"))); // NOI18N
        btnIcon5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIcon5ActionPerformed(evt);
            }
        });

        btnIcon6.setBackground(new java.awt.Color(51, 51, 51));
        btnIcon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/06_ikon.png"))); // NOI18N
        btnIcon6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIcon6ActionPerformed(evt);
            }
        });

        btnIcon7.setBackground(new java.awt.Color(51, 51, 51));
        btnIcon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/07_ikon.png"))); // NOI18N
        btnIcon7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIcon7ActionPerformed(evt);
            }
        });

        btnIcon8.setBackground(new java.awt.Color(51, 51, 51));
        btnIcon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/08_ikon.png"))); // NOI18N
        btnIcon8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIcon8ActionPerformed(evt);
            }
        });

        btnIcon9.setBackground(new java.awt.Color(51, 51, 51));
        btnIcon9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/09_ikon.png"))); // NOI18N
        btnIcon9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIcon9ActionPerformed(evt);
            }
        });

        btnNewGame.setBackground(new java.awt.Color(51, 51, 51));
        btnNewGame.setForeground(new java.awt.Color(102, 102, 102));
        btnNewGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/new_game.png"))); // NOI18N
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(51, 51, 51));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/exit.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnReady.setBackground(new java.awt.Color(51, 51, 51));
        btnReady.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/ready.png"))); // NOI18N
        btnReady.setEnabled(false);
        btnReady.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadyActionPerformed(evt);
            }
        });

        btnKilepes.setBackground(new java.awt.Color(51, 51, 51));
        btnKilepes.setText("X");
        btnKilepes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKilepesActionPerformed(evt);
            }
        });

        btnTalcara.setBackground(new java.awt.Color(51, 51, 51));
        btnTalcara.setText("_");
        btnTalcara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTalcaraActionPerformed(evt);
            }
        });

        btnSugo.setBackground(new java.awt.Color(51, 51, 51));
        btnSugo.setText("?");

        btnVissza.setBackground(new java.awt.Color(51, 51, 51));
        btnVissza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/vissza.png"))); // NOI18N
        btnVissza.setEnabled(false);
        btnVissza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisszaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReady, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVissza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSugo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTalcara)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKilepes))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnExit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(btnIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(btnIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(btnIcon5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(btnIcon6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnIcon7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(btnIcon8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(btnIcon9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnKilepes)
                        .addComponent(btnTalcara)
                        .addComponent(btnSugo))
                    .addComponent(btnVissza, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReady, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIcon5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIcon6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIcon7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIcon8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIcon9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnIcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIcon1ActionPerformed
        vezerlo.ikontBerak(1);
    }//GEN-LAST:event_btnIcon1ActionPerformed

    private void btnIcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIcon2ActionPerformed
        vezerlo.ikontBerak(2);
    }//GEN-LAST:event_btnIcon2ActionPerformed

    private void btnIcon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIcon3ActionPerformed
        vezerlo.ikontBerak(3);
    }//GEN-LAST:event_btnIcon3ActionPerformed

    private void btnIcon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIcon4ActionPerformed
        vezerlo.ikontBerak(4);
    }//GEN-LAST:event_btnIcon4ActionPerformed

    private void btnIcon5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIcon5ActionPerformed
        vezerlo.ikontBerak(5);
    }//GEN-LAST:event_btnIcon5ActionPerformed

    private void btnIcon6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIcon6ActionPerformed
        vezerlo.ikontBerak(6);
    }//GEN-LAST:event_btnIcon6ActionPerformed

    private void btnIcon7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIcon7ActionPerformed
        vezerlo.ikontBerak(7);
    }//GEN-LAST:event_btnIcon7ActionPerformed

    private void btnIcon8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIcon8ActionPerformed
        vezerlo.ikontBerak(8);
    }//GEN-LAST:event_btnIcon8ActionPerformed

    private void btnIcon9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIcon9ActionPerformed
        vezerlo.ikontBerak(9);
    }//GEN-LAST:event_btnIcon9ActionPerformed

    private void btnVisszaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisszaActionPerformed
        vezerlo.visszaVon();
    }//GEN-LAST:event_btnVisszaActionPerformed

    private void btnReadyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadyActionPerformed
        vezerlo.keszenallas();
    }//GEN-LAST:event_btnReadyActionPerformed

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        vezerlo.alaphelyzetbeallit();
    }//GEN-LAST:event_btnNewGameActionPerformed

    private void btnTalcaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTalcaraActionPerformed
        vezerlo.talcaraRak();
    }//GEN-LAST:event_btnTalcaraActionPerformed

    private void btnKilepesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKilepesActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnKilepesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnIcon1;
    private javax.swing.JButton btnIcon2;
    private javax.swing.JButton btnIcon3;
    private javax.swing.JButton btnIcon4;
    private javax.swing.JButton btnIcon5;
    private javax.swing.JButton btnIcon6;
    private javax.swing.JButton btnIcon7;
    private javax.swing.JButton btnIcon8;
    private javax.swing.JButton btnIcon9;
    private javax.swing.JButton btnKilepes;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnReady;
    private javax.swing.JButton btnSugo;
    private javax.swing.JButton btnTalcara;
    private javax.swing.JButton btnVissza;
    // End of variables declaration//GEN-END:variables

    public void keszenAlloGombBeallit(boolean aktivitas) {
        btnReady.setEnabled(aktivitas);
    }

    public void visszaGombValtas(boolean aktivitas) {
        btnVissza.setEnabled(aktivitas);
    }
}
