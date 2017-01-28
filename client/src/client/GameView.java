package client;

import javax.swing.JOptionPane;

public class GameView extends javax.swing.JFrame {

    public GameView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        suitGroup = new javax.swing.ButtonGroup();
        heightGroup = new javax.swing.ButtonGroup();
        bidPanel = new javax.swing.JPanel();
        suitSpades = new javax.swing.JToggleButton();
        suitNoTrumps = new javax.swing.JToggleButton();
        suitHearts = new javax.swing.JToggleButton();
        suitDiamonds = new javax.swing.JToggleButton();
        suitClubs = new javax.swing.JToggleButton();
        suitPass = new javax.swing.JToggleButton();
        suitsLabel = new javax.swing.JLabel();
        heightsLabel = new javax.swing.JLabel();
        height7 = new javax.swing.JToggleButton();
        height6 = new javax.swing.JToggleButton();
        height5 = new javax.swing.JToggleButton();
        height4 = new javax.swing.JToggleButton();
        height3 = new javax.swing.JToggleButton();
        height2 = new javax.swing.JToggleButton();
        height1 = new javax.swing.JToggleButton();
        sendButton = new javax.swing.JButton();
        playerThis = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        player1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        player2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        player3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        suitGroup.add(suitSpades);
        suitSpades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/S.jpg"))); // NOI18N
        suitSpades.setText("SPADES");

        suitGroup.add(suitNoTrumps);
        suitNoTrumps.setText("NO TRUMPS");

        suitGroup.add(suitHearts);
        suitHearts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/H.jpg"))); // NOI18N
        suitHearts.setText("HEARTS");

        suitGroup.add(suitDiamonds);
        suitDiamonds.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/D.jpg"))); // NOI18N
        suitDiamonds.setText("DIAMONDS");

        suitGroup.add(suitClubs);
        suitClubs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/C.jpg"))); // NOI18N
        suitClubs.setText("CLUBS");

        suitGroup.add(suitPass);
        suitPass.setText("PASS");

        suitsLabel.setText("SUITS:");

        heightsLabel.setText("HEIGHTS:");

        heightGroup.add(height7);
        height7.setText("7");

        heightGroup.add(height6);
        height6.setText("6");

        heightGroup.add(height5);
        height5.setText("5");

        heightGroup.add(height4);
        height4.setText("4");

        heightGroup.add(height3);
        height3.setText("3");

        heightGroup.add(height2);
        height2.setText("2");

        heightGroup.add(height1);
        height1.setText("1");

        sendButton.setText("SEND");

        javax.swing.GroupLayout bidPanelLayout = new javax.swing.GroupLayout(bidPanel);
        bidPanel.setLayout(bidPanelLayout);
        bidPanelLayout.setHorizontalGroup(
            bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bidPanelLayout.createSequentialGroup()
                .addGroup(bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bidPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(suitsLabel)
                            .addGroup(bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(suitSpades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(suitNoTrumps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(suitHearts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(suitDiamonds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(suitClubs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(suitPass, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(bidPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(height1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heightsLabel)
                    .addComponent(height7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(height6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(height5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(height4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(height3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(height2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        bidPanelLayout.setVerticalGroup(
            bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bidPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suitsLabel)
                    .addComponent(heightsLabel))
                .addGroup(bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bidPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suitNoTrumps)
                            .addComponent(height7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suitSpades)
                            .addComponent(height6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suitHearts)
                            .addComponent(height5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suitDiamonds)
                            .addComponent(height4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suitClubs)
                            .addComponent(height3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suitPass)
                            .addComponent(height2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(height1)
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bidPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jLabel3.setText("Bid:");

        javax.swing.GroupLayout playerThisLayout = new javax.swing.GroupLayout(playerThis);
        playerThis.setLayout(playerThisLayout);
        playerThisLayout.setHorizontalGroup(
            playerThisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerThisLayout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel3)
                .addContainerGap(344, Short.MAX_VALUE))
        );
        playerThisLayout.setVerticalGroup(
            playerThisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerThisLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 106, Short.MAX_VALUE))
        );

        jLabel2.setText("Bid:");

        javax.swing.GroupLayout player1Layout = new javax.swing.GroupLayout(player1);
        player1.setLayout(player1Layout);
        player1Layout.setHorizontalGroup(
            player1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, player1Layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        player1Layout.setVerticalGroup(
            player1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player1Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jLabel2)
                .addContainerGap(304, Short.MAX_VALUE))
        );

        jLabel4.setText("Bid:");

        javax.swing.GroupLayout player2Layout = new javax.swing.GroupLayout(player2);
        player2.setLayout(player2Layout);
        player2Layout.setHorizontalGroup(
            player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player2Layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        player2Layout.setVerticalGroup(
            player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, player2Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jLabel1.setText("Bid:");

        javax.swing.GroupLayout player3Layout = new javax.swing.GroupLayout(player3);
        player3.setLayout(player3Layout);
        player3Layout.setHorizontalGroup(
            player3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 113, Short.MAX_VALUE))
        );
        player3Layout.setVerticalGroup(
            player3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player3Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel1)
                .addContainerGap(297, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(player2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(playerThis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(bidPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(player3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bidPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerThis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(player3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameView().setVisible(true);
            }
        });
    }
    
    void displayErrorMesage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bidPanel;
    private javax.swing.JToggleButton height1;
    private javax.swing.JToggleButton height2;
    private javax.swing.JToggleButton height3;
    private javax.swing.JToggleButton height4;
    private javax.swing.JToggleButton height5;
    private javax.swing.JToggleButton height6;
    private javax.swing.JToggleButton height7;
    private javax.swing.ButtonGroup heightGroup;
    private javax.swing.JLabel heightsLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel player1;
    private javax.swing.JPanel player2;
    private javax.swing.JPanel player3;
    private javax.swing.JPanel playerThis;
    private javax.swing.JButton sendButton;
    private javax.swing.JToggleButton suitClubs;
    private javax.swing.JToggleButton suitDiamonds;
    private javax.swing.ButtonGroup suitGroup;
    private javax.swing.JToggleButton suitHearts;
    private javax.swing.JToggleButton suitNoTrumps;
    private javax.swing.JToggleButton suitPass;
    private javax.swing.JToggleButton suitSpades;
    private javax.swing.JLabel suitsLabel;
    // End of variables declaration//GEN-END:variables
}
