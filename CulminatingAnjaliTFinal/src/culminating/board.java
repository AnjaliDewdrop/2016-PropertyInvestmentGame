/*
 * Description: How does game work
 * File Name: Culminating
 * Programmer: Anjali Thatte
 * Date: August 24
 */
package culminating;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author anjal
 */
public class board extends javax.swing.JFrame implements WindowListener,ActionListener {

    
    public static House[][] available;                              //houses available in city
    public static ArrayList<Player> players = new ArrayList();       //players of the game
 
    
    
    public static JButton[][] lots;           //buttons that represent houses in city for user interaction
            
            
    public static int turn;       //rotates to determine which player's turn it is based on ID 

    private final CardLayout cardlayout;          //for switching between screens
    final Container contentPane;                   //'organiser' to switch between screens
    
    
    
    
    /**
     * Creates new form board
     */
    public board() {
        initComponents();
        
        
        int rows=(int)(Math.random()*(8-4+1)+4);     //how many rows of houses
        int cols=(int)(Math.random()*(8-4+1)+4);     //how many columns of houses
        lots=new JButton[rows][cols];
        
        //used code from TTT assignment and this link: http://stackoverflow.com/questions/3195666/how-to-place-a-jbutton-at-a-desired-location-in-a-jframe-using-java
        //will allow buttons to be set up
        pnlBack.setLayout(new FlowLayout());
        pnlBack.setLayout(new GridLayout(rows, cols, 10, 10));
        
        //set-up the organization of the frame and content pane
        //got code from example posted on class site
        cardlayout = new CardLayout();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = this.getContentPane();
        contentPane.setPreferredSize(new Dimension(800, 400));
        contentPane.setLayout(cardlayout);
        pnlGameBoard.setVisible(false);

        contentPane.add(pnlStart, "Panel 1");
        contentPane.add(pnlGameBoard, "Panel 2");
        

        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
        
        ////////////////////////////////////
        
        
        available=new House[rows][cols];
        
        //where the boundaries are for market change factors between areas of city
        int rowBlockBoundary=(int)(Math.random()*(rows-2-2+1)+2);      
        int colBlockBoundary=(int)(Math.random()*(cols-2-2+1)+2);
        
        //market change factor based on quadrant
        double q1=(Math.random()*(110-90+1)+90)/100; 
        double q2=(Math.random()*(110-90+1)+90)/100; 
        double q3=(Math.random()*(110-90+1)+90)/100; 
        double q4=(Math.random()*(110-90+1)+90)/100; 
        //above horizontal centre line of town
        for (int row=0; row<rowBlockBoundary; row++){
            //quadrant 2 houses
            for (int col=0; col<colBlockBoundary; col++){
                //creates houses and corresponding buttons in this quadrant
                available[row][col]=new House((int)(Math.random()*(5-1+1)+1), q2, Integer.toString(row)+","+Integer.toString(col));               
            
                lots[row][col]=(new JButton("("+row+","+col+")"));
                lots[row][col].setBackground(Color.RED);
                lots[row][col].addActionListener(this);//anjali
                pnlBack.add(lots[row][col]);
            }
            //quadrant 1 houses 
            for (int col=colBlockBoundary; col<cols; col++){
                //creates houses and corresponding buttons in this quadrant
                available[row][col]=new House((int)(Math.random()*(5-1+1)+1), q1, Integer.toString(row)+","+Integer.toString(col));               
            
                lots[row][col]=(new JButton("("+row+","+col+")"));
                lots[row][col].setBackground(Color.CYAN);
                lots[row][col].addActionListener(this);//anjali
                pnlBack.add(lots[row][col]);
            }
        }
        
        //below horizontal centre line of town
        for (int row=rowBlockBoundary; row<rows; row++){
            //quadrant 3 houses
            for (int col=0; col<colBlockBoundary; col++){
                //creates houses and corresponding buttons in this quadrant
                available[row][col]=new House((int)(Math.random()*(5-1+1)+1), q3, Integer.toString(row)+","+Integer.toString(col));               
            
                lots[row][col]=(new JButton("("+row+","+col+")"));
                lots[row][col].setBackground(Color.MAGENTA);
                lots[row][col].addActionListener(this);
                pnlBack.add(lots[row][col]);
            }
            //quadrant 4 houses 
            for (int col=colBlockBoundary; col<cols; col++){
                //creates houses and corresponding buttons in this quadrant
                available[row][col]=new House((int)(Math.random()*(5-1+1)+1), q4, Integer.toString(row)+","+Integer.toString(col));               
            
                lots[row][col]=(new JButton("("+row+","+col+")"));
                lots[row][col].setBackground(Color.yellow);
                lots[row][col].addActionListener(this);
                pnlBack.add(lots[row][col]);
            }
        }
        
        //resets board appropriately
        pnlBack.revalidate();   
        pnlBack.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlStart = new javax.swing.JPanel();
        btnStartGame = new javax.swing.JButton();
        txtP1 = new javax.swing.JTextField();
        txtP2 = new javax.swing.JTextField();
        txtP3 = new javax.swing.JTextField();
        txtP4 = new javax.swing.JTextField();
        radBtnPlay2 = new javax.swing.JRadioButton();
        radBtnPlay3 = new javax.swing.JRadioButton();
        radBtnPlay4 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlGameBoard = new javax.swing.JPanel();
        pnlBack = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTurn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtStats = new javax.swing.JTextArea();
        lblTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        btnStartGame.setText("Start Game");
        btnStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartGameActionPerformed(evt);
            }
        });

        txtP1.setEnabled(false);

        txtP2.setEnabled(false);

        txtP3.setEnabled(false);

        txtP4.setEnabled(false);

        radBtnPlay2.setText("2 Players");
        radBtnPlay2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBtnPlay2ActionPerformed(evt);
            }
        });

        radBtnPlay3.setText("3 Players");
        radBtnPlay3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBtnPlay3ActionPerformed(evt);
            }
        });

        radBtnPlay4.setText("4 Players");
        radBtnPlay4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBtnPlay4ActionPerformed(evt);
            }
        });

        jLabel4.setText("How many Players?");

        jLabel5.setText("Player Names:");

        jLabel6.setFont(new java.awt.Font("Verdana", 3, 48)); // NOI18N
        jLabel6.setText("Ready to Play, Buy It ALL!");

        javax.swing.GroupLayout pnlStartLayout = new javax.swing.GroupLayout(pnlStart);
        pnlStart.setLayout(pnlStartLayout);
        pnlStartLayout.setHorizontalGroup(
            pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStartLayout.createSequentialGroup()
                .addGroup(pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStartLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(radBtnPlay2)
                                .addComponent(radBtnPlay3)
                                .addComponent(radBtnPlay4))
                            .addComponent(jLabel4))
                        .addGap(226, 226, 226)
                        .addGroup(pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(pnlStartLayout.createSequentialGroup()
                                .addGroup(pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtP2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtP3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtP4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtP1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(133, 133, 133)
                                .addComponent(btnStartGame))))
                    .addGroup(pnlStartLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6)))
                .addContainerGap(322, Short.MAX_VALUE))
        );
        pnlStartLayout.setVerticalGroup(
            pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStartLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addGap(41, 41, 41)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStartLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radBtnPlay2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radBtnPlay3)))
                    .addGroup(pnlStartLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnStartGame)))
                .addGap(9, 9, 9)
                .addGroup(pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radBtnPlay4))
                .addContainerGap(212, Short.MAX_VALUE))
        );

        getContentPane().add(pnlStart, "card3");

        pnlBack.setBackground(new java.awt.Color(102, 255, 102));

        javax.swing.GroupLayout pnlBackLayout = new javax.swing.GroupLayout(pnlBack);
        pnlBack.setLayout(pnlBackLayout);
        pnlBackLayout.setHorizontalGroup(
            pnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );
        pnlBackLayout.setVerticalGroup(
            pnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        jLabel2.setText("Player Statistics:");

        jLabel1.setText("Whose Turn:");

        txtStats.setColumns(20);
        txtStats.setRows(5);
        jScrollPane1.setViewportView(txtStats);

        lblTitle.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        lblTitle.setText("Buy It ALL");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel3.setText("The City");

        javax.swing.GroupLayout pnlGameBoardLayout = new javax.swing.GroupLayout(pnlGameBoard);
        pnlGameBoard.setLayout(pnlGameBoardLayout);
        pnlGameBoardLayout.setHorizontalGroup(
            pnlGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameBoardLayout.createSequentialGroup()
                .addGroup(pnlGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGameBoardLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGameBoardLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(pnlGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addGroup(pnlGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGameBoardLayout.createSequentialGroup()
                        .addComponent(pnlBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGameBoardLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181))))
        );
        pnlGameBoardLayout.setVerticalGroup(
            pnlGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameBoardLayout.createSequentialGroup()
                .addGroup(pnlGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGameBoardLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTurn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGameBoardLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlGameBoard, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * starts game by initialising players and switching to game board panel
     * @param evt 
     */
    private void btnStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartGameActionPerformed
        //add players based on user input
        players.add(new Player(0, txtP1.getText(), 100));
        players.add(new Player(0, txtP2.getText(), 100));
        if (txtP4.isEnabled()){
            players.add(new Player(0, txtP3.getText(), 100));
            players.add(new Player(0, txtP4.getText(), 100));
        }else if (txtP3.isEnabled()){
            players.add(new Player(0, txtP3.getText(), 100));
        }
        
        //initialise first turn
        turn=(int)(Math.random()*(players.size()-1-0+1)+0);
        
        //set up user stats
        txtTurn.setText(players.get(turn).giveName());
        txtStats.setText("Your balance: "+players.get(turn).giveBalance()+"\nHouses currently owned: "+players.get(turn).ownedToString());

        cardlayout.next(contentPane); //go to game board

    }//GEN-LAST:event_btnStartGameActionPerformed

    /**
     * allows 2 users to input name
     * @param evt 
     */
    private void radBtnPlay2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBtnPlay2ActionPerformed
        txtP1.setEnabled(true);
        txtP2.setEnabled(true);
        
        radBtnPlay3.setEnabled(false);
        radBtnPlay4.setEnabled(false);
    }//GEN-LAST:event_radBtnPlay2ActionPerformed

    /**
     * allows 3 users to input name
     * @param evt 
     */
    private void radBtnPlay3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBtnPlay3ActionPerformed
        txtP1.setEnabled(true);
        txtP2.setEnabled(true);
        txtP3.setEnabled(true);
        
        radBtnPlay2.setEnabled(false);
        radBtnPlay4.setEnabled(false);
    }//GEN-LAST:event_radBtnPlay3ActionPerformed

    /**
     * allows 4 users to input name
     * @param evt 
     */
    private void radBtnPlay4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBtnPlay4ActionPerformed
        txtP1.setEnabled(true);
        txtP2.setEnabled(true);
        txtP3.setEnabled(true);
        txtP4.setEnabled(true);
        
        radBtnPlay2.setEnabled(false);
        radBtnPlay3.setEnabled(false);
    }//GEN-LAST:event_radBtnPlay4ActionPerformed

    
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
            java.util.logging.Logger.getLogger(board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new board().setVisible(true);
            }
        });
        
        //put into add players button after
       
        
        
        
        
        
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStartGame;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    public javax.swing.JPanel pnlBack;
    private javax.swing.JPanel pnlGameBoard;
    private javax.swing.JPanel pnlStart;
    private javax.swing.JRadioButton radBtnPlay2;
    private javax.swing.JRadioButton radBtnPlay3;
    private javax.swing.JRadioButton radBtnPlay4;
    private javax.swing.JTextField txtP1;
    private javax.swing.JTextField txtP2;
    private javax.swing.JTextField txtP3;
    private javax.swing.JTextField txtP4;
    private javax.swing.JTextArea txtStats;
    private javax.swing.JTextField txtTurn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowOpened(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
     *Source: https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html
     */
    
    
    /**
     * when there is a click, play turn, check for winners, apply taxes, change market values for some
     * @param ae 
     */
    @Override 
    public void actionPerformed(ActionEvent ae) {           
        
        Player whoPlays=players.get(turn);  //set turn
        
        House current;           //what is house pressed
        
        Boolean validSale=true;     //whether proper button pressed
        
        //goes through all the buttons
        for (int row=0; row<lots.length; row++){
            for (int col=0; col<lots[row].length; col++){
                
                //finds which button pressed and what house it corresponds to becomes 'current'
                if (lots[row][col].equals(ae.getSource())){
                    current=available[row][col];
                    
                    //sell house
                    if (current.giveOwner()==turn){
                        //yes=0, no=1     add in houses owned, house colour when ready
                        int sell = JOptionPane.showConfirmDialog(null, 
                                 "Player: "+whoPlays.giveName()+"\nHouse Price: "+Double.toString(current.givePrice()),"Would you like to sell?", JOptionPane.YES_NO_OPTION);
                        //sell house to bank and changes name back
                        if (sell==0){
                            whoPlays.sellHouse(current);
                            current.changeOwner(5);
                            lots[row][col].setText("("+current.giveName()+")");
                            break;
                        }
                        
                    }else if (current.giveOwner()==5){   //buy house
                        
                        //yes=0, no=1     add in houses owned, house colour when ready
                        int buy = JOptionPane.showConfirmDialog(null, 
                                 "Player: "+whoPlays.giveName()+"\nHouse Price: "+Double.toString(current.givePrice()),"Would you like to buy house "+current.giveName(), JOptionPane.YES_NO_OPTION);

                        //changes ownership and name of house to player name
                        if (buy==0){
                            whoPlays.buyHouse(current);
                            current.changeOwner(turn);
                            lots[row][col].setText(whoPlays.giveName());
                                
                        }
                        //invalid house chosen
                    } else{
                        JOptionPane.showMessageDialog(null, "You cannot buy this house. It belongs to another player.a");
                        validSale=false;    //allows another chance for player to click button
                    }
                }
            }
        }
        
        //change market value of houses after sale to not interfere with sale decisions
        
        House[][] willChange=whichChange(available);  //determines which houses will change
        
        //goes through houses and changes price if necessary
        for (int row=0; row<available.length; row++){
            for (int col=0; col<available[row].length; col++){
                
                if (available[row][col].giveChangePrice()){
                    available[row][col].changeMarketVal();
                    available[row][col].priceWillChange(false);
                }
                
                
            }
        }
        
        
        //changes turn if valid button pressed
        
        if (validSale){
            turn++;
            if (turn==players.size()){
                turn=0;
            }
        }
        
        //add taxes at end of turn so may become out unexpectedly
        if (whoPlays.giveOwned().size()>0){
            whoPlays.taxes();
        }
        
        //if players go bankrupt, they lose
        if (whoPlays.giveBalance()<=0){
            players.remove(whoPlays);
            JOptionPane.showMessageDialog(null, whoPlays.giveName()+" went bankrupt! They are out of the game.");
        }
        //if only one player left, they win
        if (players.size()==1){
            JOptionPane.showMessageDialog(null, players.get(0).giveName()+" wins! Congrats.");
            System.exit(0);
        }
        
        //finds out how many houses left to buy
        int housesBought=0;
        for (int row=0; row<available.length; row++){
            for (int col=0; col<available[row].length; col++){
                if (available[row][col].giveOwner()!=5){
                    housesBought++;
                }
            }
        }
        
        //if all houses gone and still no winner, ends in tie
        if (housesBought==available.length*available[0].length){
            JOptionPane.showMessageDialog(null, "The game is a tie! Everybody owns part of the city.");
            System.exit(0);
        }
        
        //change user stats shown
        txtTurn.setText(players.get(turn).giveName());
        txtStats.setText("Your balance: "+players.get(turn).giveBalance()+"\nHouses currently owned: "+players.get(turn).ownedToString());
    }
    
    /**
     * decides which 50% of the houses will change in market value this turn
     * @param properties
     * @return 
     */
    public static House[][] whichChange (House[][] properties){
        int halfProperties=(int)(properties.length*properties[0].length*0.5);       //number of properties divided by 2
        int counter=0;   //counter for how many houses will change
        
        //while half houses have not been assigned to change, keep picking random houses to change price
        while (counter<halfProperties){
            int rowIndice=(int)(Math.random()*((properties.length-1)-0+1)+0);
            int colIndice=(int)(Math.random()*((properties[0].length-1)-0+1)+0);

            //if this house has not been chosen yet, choose it and increase counter
            if (!(properties[rowIndice][colIndice].giveChangePrice())){
                properties[rowIndice][colIndice].priceWillChange(true);
                counter++;                
            }
            
        }

        return properties;  //return array of houses in which half have been chosen to change in price market value
    }
}
