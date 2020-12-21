import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Game implements ActionListener{
    private int player1Wins;
    private int totalGames;
    private int drawGames;
    private Player p1;
    private Player p2;
    private String user1Choice;
    private Board board;
    private Boolean correctInput = false;
    private Boolean gotFirstInput = false;
    private int turn = 1;

    AudioInputStream clickAudioInputStream;
    AudioInputStream startAudioInputStream;
    AudioInputStream drawAudioInputStream;
    AudioInputStream winAudioInputStream;


    Clip startClip;
    Clip winClip;
    Clip clickClip;
    Clip drawClip;




    // constructor
    public Game(){
        // initialize player1 wins as 0 and current total games as 0
        player1Wins = 0;
        totalGames = 0;

        p1 = new Player();
        p2 = new Player();
        board = new Board();

        // set Action Listener on each button
        for(int i = 1; i < 10; i++){
            board.btn_cell[i].addActionListener(this);
        }

        board.btnNew.addActionListener(this);    
        board.btnStats.addActionListener(this);
        board.btnExit.addActionListener(this);
    }


    public void actionPerformed(ActionEvent evt){


        if(evt.getSource() == board.btnExit){            
            System.exit(0);
        }

        if(evt.getSource() == board.btnStats){
            
            try {
                clickAudioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("click.wav"));
                clickClip = AudioSystem.getClip();
                clickClip.open(clickAudioInputStream);
                clickClip.start();
            }catch (Exception ex) {
                ex.printStackTrace();
            }

            printStats();
        }

        if(evt.getSource() == board.btnNew){

            try {
                startAudioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("start.wav"));
                startClip = AudioSystem.getClip();
                startClip.open(startAudioInputStream);
                startClip.start();
            }catch (Exception ex) {
                ex.printStackTrace();
            }
            

            newGame();
        }
            

        for(int i = 1; i < 10; i++){

            if(evt.getSource() == board.btn_cell[i] && user1Choice.equals("O") && turn == 1){
                board.btn_cell[i].setText("O");
                turn=2;
                board.btn_cell[i].setEnabled(false);
                board.lblTurn.setText("Turn of User 2");
                checkWin();
                
                // add click sound
                 try {
                    clickAudioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("click.wav"));
                    clickClip = AudioSystem.getClip();
                    clickClip.open(clickAudioInputStream);
                    clickClip.start();
                }catch (Exception ex) {
                    ex.printStackTrace();
                }

                return;
            }

            if (evt.getSource() == board.btn_cell[i] && user1Choice.equals("X") && turn == 1) {
                board.btn_cell[i].setText("X");
                turn=2;
                board.btn_cell[i].setEnabled(false);
                board.lblTurn.setText("Turn of User 2");
                checkWin();
                
                // add click sound
                 try {
                    clickAudioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("click.wav"));
                    clickClip = AudioSystem.getClip();
                    clickClip.open(clickAudioInputStream);
                    clickClip.start();
                }catch (Exception ex) {
                    ex.printStackTrace();
                }

                return;
            }

            if (evt.getSource() == board.btn_cell[i] && user1Choice.equals("O") && turn == 2) {
                board.btn_cell[i].setText("X");
                turn=1;
                board.btn_cell[i].setEnabled(false);
                board.lblTurn.setText("Turn of User 1");
                checkWin();
                
                // add click sound
                 try {
                    clickAudioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("click.wav"));
                    clickClip = AudioSystem.getClip();
                    clickClip.open(clickAudioInputStream);
                    clickClip.start();
                }catch (Exception ex) {
                    ex.printStackTrace();
                }

                return;
            }

            if (evt.getSource() == board.btn_cell[i] && user1Choice.equals("X") && turn == 2) {
                board.btn_cell[i].setText("O");
                turn=1;
                board.btn_cell[i].setEnabled(false);
                board.lblTurn.setText("Turn of User 1");
                checkWin();
                
                // add click sound
                 try {
                    clickAudioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("click.wav"));
                    clickClip = AudioSystem.getClip();
                    clickClip.open(clickAudioInputStream);
                    clickClip.start();
                }catch (Exception ex) {
                    ex.printStackTrace();
                }

                return;
            }
        }

    }

    public void printStats(){
        if(totalGames == 0){
            JOptionPane.showMessageDialog(null,"\nNo games played yet\n Try playing a game\n");
            return;
        }else{
            JOptionPane.showMessageDialog(null,"The results are as follows : \n\t\t" + p1.getPlayerName()
                    + " has won \t" + player1Wins + " games.\n" + p2.getPlayerName() + " has won \t" + 
                    (totalGames - player1Wins - drawGames) + " games." + "\nDraw Games = " + drawGames + "\nTotal Games Completed = " + totalGames);
        }
    }


    public void checkWin(){
        if( (user1Choice.equals("X") && board.btn_cell[1].getText()=="X" && board.btn_cell[2].getText()=="X" && board.btn_cell[3].getText()=="X") || 
            (user1Choice.equals("X") && board.btn_cell[4].getText()=="X" && board.btn_cell[5].getText()=="X" && board.btn_cell[6].getText()=="X") || 
            (user1Choice.equals("X") && board.btn_cell[7].getText()=="X" && board.btn_cell[8].getText()=="X" && board.btn_cell[9].getText()=="X") || 
            (user1Choice.equals("X") && board.btn_cell[1].getText()=="X" && board.btn_cell[5].getText()=="X" && board.btn_cell[9].getText()=="X") || 
            (user1Choice.equals("X") && board.btn_cell[7].getText()=="X" && board.btn_cell[5].getText()=="X" && board.btn_cell[3].getText()=="X") || 
            (user1Choice.equals("X") && board.btn_cell[1].getText()=="X" && board.btn_cell[4].getText()=="X" && board.btn_cell[7].getText()=="X") || 
            (user1Choice.equals("X") && board.btn_cell[2].getText()=="X" && board.btn_cell[5].getText()=="X" && board.btn_cell[8].getText()=="X") || 
            (user1Choice.equals("X") && board.btn_cell[3].getText()=="X" && board.btn_cell[6].getText()=="X" && board.btn_cell[9].getText()=="X"))
            {   
            
                try {
                    winAudioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("win.wav"));
                    winClip = AudioSystem.getClip();
                    winClip.open(winAudioInputStream);
                    winClip.start();
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                

                JOptionPane.showMessageDialog(null, p1.getPlayerName() + " won");
                for (int i = 1; i < 10; i++){
                    board.btn_cell[i].setEnabled(false);
                    board.btn_cell[i].setText("Press new Game!");
                }
                totalGames ++;
                player1Wins ++;
                
            }

        else if( (user1Choice.equals("O") && board.btn_cell[1].getText()=="O" && board.btn_cell[2].getText()=="O" && board.btn_cell[3].getText()=="O") || 
            (user1Choice.equals("O") && board.btn_cell[4].getText()=="O" && board.btn_cell[5].getText()=="O" && board.btn_cell[6].getText()=="O") || 
            (user1Choice.equals("O") && board.btn_cell[7].getText()=="O" && board.btn_cell[8].getText()=="O" && board.btn_cell[9].getText()=="O") || 
            (user1Choice.equals("O") && board.btn_cell[1].getText()=="O" && board.btn_cell[5].getText()=="O" && board.btn_cell[9].getText()=="O") || 
            (user1Choice.equals("O") && board.btn_cell[7].getText()=="O" && board.btn_cell[5].getText()=="O" && board.btn_cell[3].getText()=="O") ||
            (user1Choice.equals("O") && board.btn_cell[1].getText()=="O" && board.btn_cell[4].getText()=="O" && board.btn_cell[7].getText()=="O") || 
            (user1Choice.equals("O") && board.btn_cell[2].getText()=="O" && board.btn_cell[5].getText()=="O" && board.btn_cell[8].getText()=="O") || 
            (user1Choice.equals("O") && board.btn_cell[3].getText()=="O" && board.btn_cell[6].getText()=="O" && board.btn_cell[9].getText()=="O"))
            {

                try {
                    winAudioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("win.wav"));
                    winClip = AudioSystem.getClip();
                    winClip.open(winAudioInputStream);
                    winClip.start();
                }catch (Exception ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, p1.getPlayerName() + " won");
                for (int i = 1; i < 10; i++){
                    board.btn_cell[i].setEnabled(false);
                    board.btn_cell[i].setText("Press new Game!");
                }
                totalGames ++;
                player1Wins ++;
            }
        else if( (user1Choice.equals("X") && board.btn_cell[1].getText()=="O" && board.btn_cell[2].getText()=="O" && board.btn_cell[3].getText()=="O") || 
            (user1Choice.equals("X") && board.btn_cell[4].getText()=="O" && board.btn_cell[5].getText()=="O" && board.btn_cell[6].getText()=="O") || 
            (user1Choice.equals("X") && board.btn_cell[7].getText()=="O" && board.btn_cell[8].getText()=="O" && board.btn_cell[9].getText()=="O") || 
            (user1Choice.equals("X") && board.btn_cell[1].getText()=="O" && board.btn_cell[5].getText()=="O" && board.btn_cell[9].getText()=="O") || 
            (user1Choice.equals("X") && board.btn_cell[7].getText()=="O" && board.btn_cell[5].getText()=="O" && board.btn_cell[3].getText()=="O") ||
            (user1Choice.equals("X") && board.btn_cell[1].getText()=="O" && board.btn_cell[4].getText()=="O" && board.btn_cell[7].getText()=="O") || 
            (user1Choice.equals("X") && board.btn_cell[2].getText()=="O" && board.btn_cell[5].getText()=="O" && board.btn_cell[8].getText()=="O") || 
            (user1Choice.equals("X") && board.btn_cell[3].getText()=="O" && board.btn_cell[6].getText()=="O" && board.btn_cell[9].getText()=="O"))
            {
                try {
                    winAudioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("win.wav"));
                    winClip = AudioSystem.getClip();
                    winClip.open(winAudioInputStream);
                    winClip.start();
                }catch (Exception ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, p2.getPlayerName() + " won");
                for (int i = 1; i < 10; i++){
                    board.btn_cell[i].setEnabled(false);
                    board.btn_cell[i].setText("Press new Game!");
                }
                totalGames ++;
            }
        else if( (user1Choice.equals("O") && board.btn_cell[1].getText()=="X" && board.btn_cell[2].getText()=="X" && board.btn_cell[3].getText()=="X") || 
            (user1Choice.equals("O") && board.btn_cell[4].getText()=="X" && board.btn_cell[5].getText()=="X" && board.btn_cell[6].getText()=="X") || 
            (user1Choice.equals("O") && board.btn_cell[7].getText()=="X" && board.btn_cell[8].getText()=="X" && board.btn_cell[9].getText()=="X") || 
            (user1Choice.equals("O") && board.btn_cell[1].getText()=="X" && board.btn_cell[5].getText()=="X" && board.btn_cell[9].getText()=="X") || 
            (user1Choice.equals("O") && board.btn_cell[7].getText()=="X" && board.btn_cell[5].getText()=="X" && board.btn_cell[3].getText()=="X") ||
            (user1Choice.equals("O") && board.btn_cell[1].getText()=="X" && board.btn_cell[4].getText()=="X" && board.btn_cell[7].getText()=="X") || 
            (user1Choice.equals("O") && board.btn_cell[2].getText()=="X" && board.btn_cell[5].getText()=="X" && board.btn_cell[8].getText()=="X") || 
            (user1Choice.equals("O") && board.btn_cell[3].getText()=="X" && board.btn_cell[6].getText()=="X" && board.btn_cell[9].getText()=="X"))
            {
                try {
                    winAudioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("win.wav"));
                    winClip = AudioSystem.getClip();
                    winClip.open(winAudioInputStream);
                    winClip.start();
                }catch (Exception ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, p2.getPlayerName() + " won");
                for (int i = 1; i < 10; i++){
                    board.btn_cell[i].setEnabled(false);
                    board.btn_cell[i].setText("Press new Game!");
                }
                totalGames ++;
            }

        else if(board.btn_cell[1].isEnabled()==false && board.btn_cell[2].isEnabled()==false && board.btn_cell[3].isEnabled()==false &&
                board.btn_cell[4].isEnabled()==false && board.btn_cell[5].isEnabled()==false && board.btn_cell[6].isEnabled()==false && 
                board.btn_cell[7].isEnabled()==false && board.btn_cell[8].isEnabled()==false && board.btn_cell[9].isEnabled()==false  )
            {
                try {

                    drawAudioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("draw.wav"));
                    drawClip = AudioSystem.getClip();
                    drawClip.open(drawAudioInputStream);
                    drawClip.start();
                }catch (Exception ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null,"Game Draw");
                totalGames ++;
                drawGames++;

                for (int i = 1; i < 10; i++){
                    board.btn_cell[i].setEnabled(false);
                    board.btn_cell[i].setText("Press new Game!");
                }
            }


    }

    public void getUserChoice(){

        // Get user1 choice about X or O 
        user1Choice =JOptionPane.showInputDialog(null,p1.getPlayerName() + " Choose X or O.");

        while(true){
            switch(user1Choice){

                // if user1 chooses X then set labels appropriately
                case "X":
                correctInput = true;
                board.lblP1Choice.setText(p1.getPlayerName() + " has chosen : X");
                board.lblP2Choice.setText(p2.getPlayerName() + " has chosen : O");
                break;
    
                // if user1 chooses O then set labels appropriately
                case "O":
                correctInput = true;
                board.lblP1Choice.setText(p1.getPlayerName() + " has chosen : O");
                board.lblP2Choice.setText(p2.getPlayerName() + " has chosen : X");
                break;
    
                // if user1 chooses anything other than X or O then again ask for input
                default:
                user1Choice = JOptionPane.showInputDialog(null,p1.getPlayerName() + " Choose X or O.");
            }
            if(correctInput){
                break;
            }
        }

        board.lblTurn.setText("Turn of User 1");
    }
    
    public void newGame(){
        turn = 1;
        correctInput = false;
        board.lblP1Choice.setText("");
        board.lblP2Choice.setText("");
        board.lblTurn.setText("");


        for(int i = 1; i < 10; i++){
            board.btn_cell[i].setEnabled(true);
            board.btn_cell[i].setText("");
        }

        // Get name only once for two players so that we can build a stats for them
        if(gotFirstInput == false){
            // Set player names

            String name1;
            while(true){

                // check if player 1 name isn't empty 
                name1 = JOptionPane.showInputDialog(null,"Player1 Enter your name :");

                if(!name1.equals("")){
                    break;
                }
            }
            p1.setPlayerName(name1);

            String name2;
            while(true){

                // check if player 1 name isn't empty 
                name2 = JOptionPane.showInputDialog(null,"Player2 Enter your name :");

                if(!name2.equals("")){
                    break;
                }
            }
            p2.setPlayerName(name2);

            // names have been recorded
            gotFirstInput = true;
        }

        getUserChoice();
    } 
}