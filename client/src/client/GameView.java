package client;

import java.awt.Component;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class GameView extends javax.swing.JFrame {

    public GameView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        suitGroup = new javax.swing.ButtonGroup();
        heightGroup = new javax.swing.ButtonGroup();
        cardGroup = new javax.swing.ButtonGroup();
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
        labelBidThis = new javax.swing.JLabel();
        bidThis = new javax.swing.JLabel();
        cardButton0 = new javax.swing.JToggleButton();
        cardButton1 = new javax.swing.JToggleButton();
        cardButton2 = new javax.swing.JToggleButton();
        cardButton3 = new javax.swing.JToggleButton();
        cardButton4 = new javax.swing.JToggleButton();
        cardButton5 = new javax.swing.JToggleButton();
        cardButton6 = new javax.swing.JToggleButton();
        cardButton7 = new javax.swing.JToggleButton();
        cardButton8 = new javax.swing.JToggleButton();
        cardButton9 = new javax.swing.JToggleButton();
        cardButton10 = new javax.swing.JToggleButton();
        cardButton11 = new javax.swing.JToggleButton();
        cardButton12 = new javax.swing.JToggleButton();
        player1 = new javax.swing.JPanel();
        labelBidPlayer1 = new javax.swing.JLabel();
        bidPlayer1 = new javax.swing.JLabel();
        cardPlayer10 = new javax.swing.JLabel();
        cardPlayer11 = new javax.swing.JLabel();
        cardPlayer12 = new javax.swing.JLabel();
        cardPlayer13 = new javax.swing.JLabel();
        cardPlayer14 = new javax.swing.JLabel();
        cardPlayer15 = new javax.swing.JLabel();
        cardPlayer16 = new javax.swing.JLabel();
        cardPlayer17 = new javax.swing.JLabel();
        cardPlayer18 = new javax.swing.JLabel();
        cardPlayer19 = new javax.swing.JLabel();
        cardPlayer110 = new javax.swing.JLabel();
        cardPlayer111 = new javax.swing.JLabel();
        cardPlayer112 = new javax.swing.JLabel();
        player2 = new javax.swing.JPanel();
        labelBidplayer2 = new javax.swing.JLabel();
        bidPlayer2 = new javax.swing.JLabel();
        cardPlayer20 = new javax.swing.JLabel();
        cardPlayer21 = new javax.swing.JLabel();
        cardPlayer22 = new javax.swing.JLabel();
        cardPlayer23 = new javax.swing.JLabel();
        cardPlayer24 = new javax.swing.JLabel();
        cardPlayer25 = new javax.swing.JLabel();
        cardPlayer26 = new javax.swing.JLabel();
        cardPlayer27 = new javax.swing.JLabel();
        cardPlayer28 = new javax.swing.JLabel();
        cardPlayer29 = new javax.swing.JLabel();
        cardPlayer210 = new javax.swing.JLabel();
        cardPlayer211 = new javax.swing.JLabel();
        cardPlayer212 = new javax.swing.JLabel();
        player3 = new javax.swing.JPanel();
        labelBidPlayer3 = new javax.swing.JLabel();
        bidPlayer3 = new javax.swing.JLabel();
        cardPlayer30 = new javax.swing.JLabel();
        cardPlayer31 = new javax.swing.JLabel();
        cardPlayer32 = new javax.swing.JLabel();
        cardPlayer33 = new javax.swing.JLabel();
        cardPlayer34 = new javax.swing.JLabel();
        cardPlayer35 = new javax.swing.JLabel();
        cardPlayer36 = new javax.swing.JLabel();
        cardPlayer37 = new javax.swing.JLabel();
        cardPlayer38 = new javax.swing.JLabel();
        cardPlayer39 = new javax.swing.JLabel();
        cardPlayer310 = new javax.swing.JLabel();
        cardPlayer311 = new javax.swing.JLabel();
        cardPlayer312 = new javax.swing.JLabel();

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
                        .addGap(21, 21, 21)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
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
                .addGroup(bidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bidPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(height1))
                    .addGroup(bidPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        labelBidThis.setText("Bid:");

        cardGroup.add(cardButton0);
        cardButton0.setName(""); // NOI18N

        cardGroup.add(cardButton1);

        cardGroup.add(cardButton2);

        cardGroup.add(cardButton3);

        cardGroup.add(cardButton4);

        cardGroup.add(cardButton5);

        cardGroup.add(cardButton6);

        cardGroup.add(cardButton7);

        cardGroup.add(cardButton8);

        cardGroup.add(cardButton9);

        cardGroup.add(cardButton10);

        cardGroup.add(cardButton11);

        cardGroup.add(cardButton12);

        javax.swing.GroupLayout playerThisLayout = new javax.swing.GroupLayout(playerThis);
        playerThis.setLayout(playerThisLayout);
        playerThisLayout.setHorizontalGroup(
            playerThisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerThisLayout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(labelBidThis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bidThis, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerThisLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(cardButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        playerThisLayout.setVerticalGroup(
            playerThisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerThisLayout.createSequentialGroup()
                .addGroup(playerThisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBidThis, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bidThis, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(playerThisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardButton0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(cardButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        labelBidPlayer1.setText("Bid:");

        cardPlayer10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B14.jpg"))); // NOI18N

        cardPlayer11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B14.jpg"))); // NOI18N

        cardPlayer12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B14.jpg"))); // NOI18N

        cardPlayer13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B14.jpg"))); // NOI18N

        cardPlayer14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B14.jpg"))); // NOI18N

        cardPlayer15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B14.jpg"))); // NOI18N

        cardPlayer16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B14.jpg"))); // NOI18N

        cardPlayer17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B14.jpg"))); // NOI18N

        cardPlayer18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B14.jpg"))); // NOI18N

        cardPlayer19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B14.jpg"))); // NOI18N

        cardPlayer110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B14.jpg"))); // NOI18N

        cardPlayer111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B14.jpg"))); // NOI18N

        cardPlayer112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B14.jpg"))); // NOI18N

        javax.swing.GroupLayout player1Layout = new javax.swing.GroupLayout(player1);
        player1.setLayout(player1Layout);
        player1Layout.setHorizontalGroup(
            player1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(player1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardPlayer16, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer15, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer17, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer19, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer18, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer110, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer111, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer112, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer13, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer12, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer14, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(player1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelBidPlayer1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bidPlayer1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(player1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardPlayer10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        player1Layout.setVerticalGroup(
            player1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(labelBidPlayer1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bidPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, player1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cardPlayer10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(cardPlayer18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer110, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer111, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer112, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        labelBidplayer2.setText("Bid:");

        cardPlayer20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B21.jpg"))); // NOI18N

        cardPlayer21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B21.jpg"))); // NOI18N

        cardPlayer22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B21.jpg"))); // NOI18N

        cardPlayer23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B21.jpg"))); // NOI18N

        cardPlayer24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B21.jpg"))); // NOI18N

        cardPlayer25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B21.jpg"))); // NOI18N

        cardPlayer26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B21.jpg"))); // NOI18N

        cardPlayer27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B21.jpg"))); // NOI18N

        cardPlayer28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B21.jpg"))); // NOI18N

        cardPlayer29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B21.jpg"))); // NOI18N

        cardPlayer210.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B21.jpg"))); // NOI18N

        cardPlayer211.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B21.jpg"))); // NOI18N

        cardPlayer212.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B21.jpg"))); // NOI18N

        javax.swing.GroupLayout player2Layout = new javax.swing.GroupLayout(player2);
        player2.setLayout(player2Layout);
        player2Layout.setHorizontalGroup(
            player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player2Layout.createSequentialGroup()
                .addGroup(player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(player2Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(labelBidplayer2)
                        .addGap(21, 21, 21)
                        .addComponent(bidPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(player2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cardPlayer20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardPlayer21)
                        .addGap(1, 1, 1)
                        .addComponent(cardPlayer22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardPlayer23)
                        .addGap(1, 1, 1)
                        .addComponent(cardPlayer24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardPlayer25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardPlayer26)
                        .addGap(4, 4, 4)
                        .addComponent(cardPlayer27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardPlayer28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardPlayer29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardPlayer210)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardPlayer211)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardPlayer212)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        player2Layout.setVerticalGroup(
            player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, player2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cardPlayer20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardPlayer25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardPlayer21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardPlayer22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardPlayer23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardPlayer24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardPlayer26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardPlayer27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cardPlayer28)
                    .addComponent(cardPlayer29)
                    .addComponent(cardPlayer210)
                    .addComponent(cardPlayer211)
                    .addComponent(cardPlayer212))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBidplayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bidPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        labelBidPlayer3.setText("Bid:");

        cardPlayer30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B15.jpg"))); // NOI18N

        cardPlayer31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B15.jpg"))); // NOI18N

        cardPlayer32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B15.jpg"))); // NOI18N

        cardPlayer33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B15.jpg"))); // NOI18N

        cardPlayer34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B15.jpg"))); // NOI18N

        cardPlayer35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B15.jpg"))); // NOI18N

        cardPlayer36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B15.jpg"))); // NOI18N

        cardPlayer37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B15.jpg"))); // NOI18N

        cardPlayer38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B15.jpg"))); // NOI18N

        cardPlayer39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B15.jpg"))); // NOI18N

        cardPlayer310.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B15.jpg"))); // NOI18N

        cardPlayer311.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B15.jpg"))); // NOI18N

        cardPlayer312.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/B15.jpg"))); // NOI18N

        javax.swing.GroupLayout player3Layout = new javax.swing.GroupLayout(player3);
        player3.setLayout(player3Layout);
        player3Layout.setHorizontalGroup(
            player3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player3Layout.createSequentialGroup()
                .addGroup(player3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelBidPlayer3)
                    .addComponent(bidPlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(player3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardPlayer30, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer31, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer36, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer35, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer37, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer39, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer38, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer310, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer311, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer312, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer33, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer32, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardPlayer34, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        player3Layout.setVerticalGroup(
            player3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player3Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(labelBidPlayer3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bidPlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, player3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cardPlayer30, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer32, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer33, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer34, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer35, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer36, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer37, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(cardPlayer38, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer39, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer310, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer311, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPlayer312, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(playerThis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(player2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(255, 255, 255)
                                .addComponent(bidPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 296, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(player3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(player3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerThis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bidPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(player1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addGap(12, 12, 12))
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
    
    void setCards(List<String> cards) {
        int i = 0;
        int numberOfCards = cards.size();
        System.out.println("Number of cards: " + cards.size());
        
        System.out.println("Setting images...");
        for (Component c: playerThis.getComponents()) {
            if (c instanceof JToggleButton) {
                if (i < numberOfCards)
                    ((JToggleButton) c).setIcon(new ImageIcon(getClass().getClassLoader().getResource("cards/" + cards.get(i) + ".jpg")));
                else
                    c.setVisible(false);
                
                i++;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bidPanel;
    private javax.swing.JLabel bidPlayer1;
    private javax.swing.JLabel bidPlayer2;
    private javax.swing.JLabel bidPlayer3;
    private javax.swing.JLabel bidThis;
    private javax.swing.JToggleButton cardButton0;
    private javax.swing.JToggleButton cardButton1;
    private javax.swing.JToggleButton cardButton10;
    private javax.swing.JToggleButton cardButton11;
    private javax.swing.JToggleButton cardButton12;
    private javax.swing.JToggleButton cardButton2;
    private javax.swing.JToggleButton cardButton3;
    private javax.swing.JToggleButton cardButton4;
    private javax.swing.JToggleButton cardButton5;
    private javax.swing.JToggleButton cardButton6;
    private javax.swing.JToggleButton cardButton7;
    private javax.swing.JToggleButton cardButton8;
    private javax.swing.JToggleButton cardButton9;
    private javax.swing.ButtonGroup cardGroup;
    private javax.swing.JLabel cardPlayer10;
    private javax.swing.JLabel cardPlayer11;
    private javax.swing.JLabel cardPlayer110;
    private javax.swing.JLabel cardPlayer111;
    private javax.swing.JLabel cardPlayer112;
    private javax.swing.JLabel cardPlayer12;
    private javax.swing.JLabel cardPlayer13;
    private javax.swing.JLabel cardPlayer14;
    private javax.swing.JLabel cardPlayer15;
    private javax.swing.JLabel cardPlayer16;
    private javax.swing.JLabel cardPlayer17;
    private javax.swing.JLabel cardPlayer18;
    private javax.swing.JLabel cardPlayer19;
    private javax.swing.JLabel cardPlayer20;
    private javax.swing.JLabel cardPlayer21;
    private javax.swing.JLabel cardPlayer210;
    private javax.swing.JLabel cardPlayer211;
    private javax.swing.JLabel cardPlayer212;
    private javax.swing.JLabel cardPlayer22;
    private javax.swing.JLabel cardPlayer23;
    private javax.swing.JLabel cardPlayer24;
    private javax.swing.JLabel cardPlayer25;
    private javax.swing.JLabel cardPlayer26;
    private javax.swing.JLabel cardPlayer27;
    private javax.swing.JLabel cardPlayer28;
    private javax.swing.JLabel cardPlayer29;
    private javax.swing.JLabel cardPlayer30;
    private javax.swing.JLabel cardPlayer31;
    private javax.swing.JLabel cardPlayer310;
    private javax.swing.JLabel cardPlayer311;
    private javax.swing.JLabel cardPlayer312;
    private javax.swing.JLabel cardPlayer32;
    private javax.swing.JLabel cardPlayer33;
    private javax.swing.JLabel cardPlayer34;
    private javax.swing.JLabel cardPlayer35;
    private javax.swing.JLabel cardPlayer36;
    private javax.swing.JLabel cardPlayer37;
    private javax.swing.JLabel cardPlayer38;
    private javax.swing.JLabel cardPlayer39;
    private javax.swing.JToggleButton height1;
    private javax.swing.JToggleButton height2;
    private javax.swing.JToggleButton height3;
    private javax.swing.JToggleButton height4;
    private javax.swing.JToggleButton height5;
    private javax.swing.JToggleButton height6;
    private javax.swing.JToggleButton height7;
    private javax.swing.ButtonGroup heightGroup;
    private javax.swing.JLabel heightsLabel;
    private javax.swing.JLabel labelBidPlayer1;
    private javax.swing.JLabel labelBidPlayer3;
    private javax.swing.JLabel labelBidThis;
    private javax.swing.JLabel labelBidplayer2;
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
