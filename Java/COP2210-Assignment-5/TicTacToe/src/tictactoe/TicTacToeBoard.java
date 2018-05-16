//******************************************************************************
// STUDENT NAME:  Carlos A. Rivera
// FIU EMAIL: crive161@fiu.edu
// CLASS: COP 2210 – Fall 2017
// ASSIGNMENT # 5
// DATE: 9 December 2017
//
// I hereby swear and affirm that this work is solely my own, and not the work 
// or the derivative of the work of someone else, except as outlined in the 
// assignment instructions.
//******************************************************************************


package tictactoe;

import javax.swing.JOptionPane;

/**
 * This class is the main GUI component of the program. Outside of the specific
 * calls to GUI elements on the frame, most of the methods are in the
 * accompanying TicTacToe class. This specific configuration of code forced
 * many of the GUI elements to be set as static variables to work.
 * 
 * @author Carlos A. Rivera
 */

public class TicTacToeBoard extends java.awt.Frame {

    private static TicTacToe funct = new TicTacToe();
    private static boolean isPlayer = false;
    
    public TicTacToeBoard() {
        initComponents();
        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel0 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel_0 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();

        setTitle("Tic Tac Toe");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jPanel0.setBackground(new java.awt.Color(204, 204, 204));
        jPanel0.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel0.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Playing...");
        jPanel0.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        jPanel_0.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, java.awt.BorderLayout.CENTER);

        jPanel_0.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, java.awt.BorderLayout.CENTER);

        jPanel_0.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, java.awt.BorderLayout.CENTER);

        jPanel_0.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, java.awt.BorderLayout.CENTER);

        jPanel_0.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, java.awt.BorderLayout.CENTER);

        jPanel_0.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, java.awt.BorderLayout.CENTER);

        jPanel_0.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton7, java.awt.BorderLayout.CENTER);

        jPanel_0.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton8, java.awt.BorderLayout.CENTER);

        jPanel_0.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton9, java.awt.BorderLayout.CENTER);

        jPanel_0.add(jPanel9);

        jPanel0.add(jPanel_0, java.awt.BorderLayout.CENTER);

        add(jPanel0, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    /**
     * These 9 button methods will activate certain actions on the GUI when
     * pressed. This includes setting the player token, recording which button
     * was pressed, disabling the button from further pressing and determining
     * a winner.
     */
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setText(funct.getPlayerTurn());
        funct.setBoardButton(jButton1.getText(), 0);
        jButton1.setEnabled(false);
        
        if(funct.detWin(funct.getPlayerTurn())) {
            if(funct.getPlayerTurn().equalsIgnoreCase("X")) {
                jLabel1.setText("Player 1 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer1()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            else {
                jLabel1.setText("Player 2 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer2()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            System.exit(0);
        }
        
        funct.changeTurn();
        
        if(isPlayer) {
            playerTurn();
        }
        else  {
            comTurn();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jButton2.setText(funct.getPlayerTurn());
        funct.setBoardButton(funct.getPlayerTurn(), 1);
        jButton2.setEnabled(false);
        
        if(funct.detWin(funct.getPlayerTurn())) {
            if(funct.getPlayerTurn().equalsIgnoreCase("X")) {
                jLabel1.setText("Player 1 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer1()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            else {
                jLabel1.setText("Player 2 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer2()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            System.exit(0);
        }
        
        funct.changeTurn();
        
        if(isPlayer) {
            playerTurn();
        }
        else  {
            comTurn();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton3.setText(funct.getPlayerTurn());
        funct.setBoardButton(funct.getPlayerTurn(), 2);
        jButton3.setEnabled(false);
        
        if(funct.detWin(funct.getPlayerTurn())) {
            if(funct.getPlayerTurn().equalsIgnoreCase("X")) {
                jLabel1.setText("Player 1 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer1()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            else {
                jLabel1.setText("Player 2 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer2()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            System.exit(0);
        }
        
        funct.changeTurn();
        
        if(isPlayer) {
            playerTurn();
        }
        else  {
            comTurn();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton4.setText(funct.getPlayerTurn());
        funct.setBoardButton(funct.getPlayerTurn(), 3);
        jButton4.setEnabled(false);
        
        if(funct.detWin(funct.getPlayerTurn())) {
            if(funct.getPlayerTurn().equalsIgnoreCase("X")) {
                jLabel1.setText("Player 1 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer1()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            else {
                jLabel1.setText("Player 2 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer2()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            System.exit(0);
        }
        
        funct.changeTurn();
        
        if(isPlayer) {
            playerTurn();
        }
        else  {
            comTurn();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jButton5.setText(funct.getPlayerTurn());
        funct.setBoardButton(funct.getPlayerTurn(), 4);
        jButton5.setEnabled(false);
        
        if(funct.detWin(funct.getPlayerTurn())) {
            if(funct.getPlayerTurn().equalsIgnoreCase("X")) {
                jLabel1.setText("Player 1 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer1()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            else {
                jLabel1.setText("Player 2 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer2()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            System.exit(0);
        }
        
        funct.changeTurn();
        
        if(isPlayer) {
            playerTurn();
        }
        else  {
            comTurn();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jButton6.setText(funct.getPlayerTurn());
        funct.setBoardButton(funct.getPlayerTurn(), 5);
        jButton6.setEnabled(false);
        
        if(funct.detWin(funct.getPlayerTurn())) {
            if(funct.getPlayerTurn().equalsIgnoreCase("X")) {
                jLabel1.setText("Player 1 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer1()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            else {
                jLabel1.setText("Player 2 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer2()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            System.exit(0);
        }
        
        funct.changeTurn();
        
        if(isPlayer) {
            playerTurn();
        }
        else  {
            comTurn();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jButton7.setText(funct.getPlayerTurn());
        funct.setBoardButton(funct.getPlayerTurn(), 6);
        jButton7.setEnabled(false);
        
        if(funct.detWin(funct.getPlayerTurn())) {
            if(funct.getPlayerTurn().equalsIgnoreCase("X")) {
                jLabel1.setText("Player 1 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer1()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            else {
                jLabel1.setText("Player 2 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer2()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            System.exit(0);
        }
        
        funct.changeTurn();
        
        if(isPlayer) {
            playerTurn();
        }
        else  {
            comTurn();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jButton8.setText(funct.getPlayerTurn());
        funct.setBoardButton(funct.getPlayerTurn(), 7);
        jButton8.setEnabled(false);
        
        if(funct.detWin(funct.getPlayerTurn())) {
            if(funct.getPlayerTurn().equalsIgnoreCase("X")) {
                jLabel1.setText("Player 1 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer1()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            else {
                jLabel1.setText("Player 2 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer2()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            System.exit(0);
        }
        
        funct.changeTurn();
        
        if(isPlayer) {
            playerTurn();
        }
        else  {
            comTurn();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jButton9.setText(funct.getPlayerTurn());
        funct.setBoardButton(funct.getPlayerTurn(), 8);
        jButton9.setEnabled(false);
        
        if(funct.detWin(funct.getPlayerTurn())) {
            if(funct.getPlayerTurn().equalsIgnoreCase("X")) {
                jLabel1.setText("Player 1 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer1()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            else {
                jLabel1.setText("Player 2 Wins!");
                JOptionPane.showMessageDialog(null, funct.getPlayer2()
                        + " wins!", "Winner!", JOptionPane.PLAIN_MESSAGE);
            }
            System.exit(0);
        }
        
        funct.changeTurn();
        
        if(isPlayer) {
            playerTurn();
        }
        else  {
            comTurn();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        funct.detName();
        //funct.detToken();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToeBoard().setVisible(true);
                funct.detTurn();  //Rolls for who goes first, the player or COM
                isPlayer = !funct.getCom();
                
                if(isPlayer) {
                    funct.setPlayer1(funct.getName());
                    funct.setPlayer2("COM");
                    playerTurn();
                }
                else {
                    funct.setPlayer1("COM");
                    funct.setPlayer2(funct.getName());
                    comTurn();
                }
            }
        });
    }
    
    /**
     * This method will both inform the user of the computer's turn and randomly
     * select a unique button (one that has not been pressed) for the computer's
     * turn. Additionally, it uses a separate method to "click" the button. The
     * boolean isPlayer is meant to help decide who is the next player when the
     * turn changes.
     */
    
    public static void comTurn() {
        boolean key = false;
        int i = 0;
        
        JOptionPane.showMessageDialog(null, "COM, choose a spot.");
        
        do {
            i = funct.rand.nextInt(9);
            
            if(funct.getButton(i)) {
                funct.setBoardButton(funct.getPlayerTurn(), i);
                key = true;
            }
        } while(!key);
        
        isPlayer = true;
        comClick(i);
    }
    
    /**
     * This method simulates the clicking of a jButton in the GUI for when the
     * computer takes its turn. This way of going about it does not require the
     * user to move around the GUI to refresh it, unlike a ChangeListener.
     */
    
    public static void comClick(int index) {
        switch(index) {
            case 0:
                jButton1.doClick();
                break;
            
            case 1:
                jButton2.doClick();
                break;
            
            case 2:
                jButton3.doClick();
                break;
            
            case 3:
                jButton4.doClick();
                break;
            
            case 4:
                jButton5.doClick();
                break;
            
            case 5:
                jButton6.doClick();
                break;
            
            case 6:
                jButton7.doClick();
                break;
            
            case 7:
                jButton8.doClick();
                break;
            
            case 8:
                jButton9.doClick();
                break;   
        }
    }
    
    /**
     * This method tells the user that it is their turn. Unlike the computer,
     * the user has control of which button to press so any advancement of the
     * program requires a valid button to be pressed.
     */
    
    public static void playerTurn() {
        isPlayer = false;
        JOptionPane.showMessageDialog(null, funct.getName()
                                    + ", choose a spot.");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton jButton1;
    private static javax.swing.JButton jButton2;
    private static javax.swing.JButton jButton3;
    private static javax.swing.JButton jButton4;
    private static javax.swing.JButton jButton5;
    private static javax.swing.JButton jButton6;
    private static javax.swing.JButton jButton7;
    private static javax.swing.JButton jButton8;
    private static javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel0;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JPanel jPanel2;
    private static javax.swing.JPanel jPanel3;
    private static javax.swing.JPanel jPanel4;
    private static javax.swing.JPanel jPanel5;
    private static javax.swing.JPanel jPanel6;
    private static javax.swing.JPanel jPanel7;
    private static javax.swing.JPanel jPanel8;
    private static javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_0;
    // End of variables declaration//GEN-END:variables
}