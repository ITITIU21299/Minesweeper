/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minesweeper;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.*;
import java.text.SimpleDateFormat;



/**
 *
 * @author nguye
 */

public class GameScreen extends JPanel {
    private int initialLives;


    public class MineTile extends JButton {

        int rows;
        int cols;
        boolean flagCheck = false;
        boolean flagged = false;


        public MineTile(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;

        }
        public boolean isFlagged() {
            return flagged;
        }
        private boolean cleared = false;

        public boolean isCleared() {
            return cleared;
        }

        public void setCleared(boolean cleared) {
            this.cleared = cleared;
        }
    }


    int tileSize = 40;
    static int numRows = 15;
    static int numCols = 15;
    int boardWidth = numCols * tileSize;
    int boardHeight = numRows * tileSize;


    //  this = new  this("Minesweeper");
    JLabel textLabel;
    JPanel textPanel;
    JPanel boardPanel;

    static int numberOfMines;
    static MineTile[][] board = new MineTile[numRows][numCols];
    ArrayList<MineTile> mineList;
    Random random = new Random();

    static int numberOfFlags = 0;
    JLabel mineLabel = new JLabel();
    public static int maxFlags = 10;
    private static final int POINTS_DEDUCTION = 5;
    private   int TOTAL_POINTS = 100;
    private   int interval=0;
    int tilesClicked = 0;
    boolean gameOver = false;
    boolean gameNotBegin = true;

    private int difficulty;
    private Timer timer;
    private static int secondsPassed;
    private int timeLimit;
    private JButton pauseResumeButton;
    public static boolean gamePaused = false;
    private JButton advancedHintButton;


    private int elapsedTimeSeconds;
    private int MaxMine=numberOfMines;
    private int currentLives;

    private static int BASE_SCORE = 100; // Adjust the base score as needed
    private static final int DEDUCTION_AMOUNT = 5; // Points deducted for each mine not cleared in time
    private Timer deductionTimer;
    int Time=10000;
private boolean isGameTour;

    private JButton saveButton;
    public GameScreen(int diff, int row, int col) {
win=false;

        difficulty = diff;
        setDifficulty();
         Bonus();
        numRows = row;
        numCols = col;
        maxFlags=10;
        this.setSize(boardWidth, boardHeight);
        this.setLocation((int) (1217 - boardWidth) / 2, 10);
        // this.setLocationRelativeTo(null);
        // this.setResizable(false);
        // this.setDefaultCloseOperation(  this.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0,0));
        textLabel = new JLabel();
        textPanel = new JPanel();
        boardPanel = new JPanel();
        textLabel.setFont(new Font("Arial", Font.BOLD, 22));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Click a tile to start");
        textLabel.setOpaque(true);
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel, BorderLayout.WEST);
        this.add(textPanel, BorderLayout.NORTH);
        mineLabel = new JLabel("Reamining mines: " + Integer.toString(numberOfMines - numberOfFlags));
        mineLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mineLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(mineLabel, BorderLayout.SOUTH);
        boardPanel.setLayout(new GridLayout(numRows, numCols));
        this.add(boardPanel);
       currentLives=initialLives;

        advancedHintButton = new JButton("Advanced Hint");
        advancedHintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                provideAdvancedHint();
            }
        });
        textPanel.add(advancedHintButton, BorderLayout.SOUTH); // Move it here

        this.add(mineLabel, BorderLayout.SOUTH);
        // Add the Pause/Resume button to the GUI
        for (int rows = 0; rows < numRows; rows++) {
            for (int cols = 0; cols < numCols; cols++) {
                MineTile tile = new MineTile(rows, cols);
                board[rows][cols] = tile;

                tile.setFocusable(false);
                tile.setMargin(new Insets(0, 0, 0, 0));
                tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
                tile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (gameNotBegin) {
                            gameNotBegin = false;
                            textPanel.add(advancedHintButton, BorderLayout.EAST);
                            startTimer();
                        }                        
                        if (gameOver) {
                            stopTimer();
                            return;
                        }
                        MineTile tile = (MineTile) e.getSource();

                        if (e.getButton() == MouseEvent.BUTTON1) {
                            if(tile.flagCheck){
                                return;
                            }
                            if (tile.getIcon() == null) {
                                if (mineList.contains(tile)) {
                                    revealMine();
                                    System.out.println(currentLives);
                                } else {
                                    checkMine(tile.rows, tile.cols);
                                }
                            }
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                            if (tile.getIcon() == null && tile.isEnabled()) {
                                tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/11.png")));
                                tile.flagCheck = true;
                                flagPlaced();
                            } else if (tile.flagCheck){
                                tile.setIcon(null);
                                tile.flagCheck = false;
                                flagRemoved();
                            }
                        }
                    }
                });
                boardPanel.add(tile);
            }
        }
        this.setVisible(true);
        updateScoreLabel();
        initializeTimer();
        generateMines();
        deductionTimer = new Timer(Time, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!gamePaused){
                deductPointsForUnclearedMines();
            }}
        });

    }
    public static int NummPause=3;

    private   boolean win=true;

    private int BonusTime=3;
    public void Bonus(){
        int a=0;
        for(int i=0;i<BonusTime;i++) {
             a = random.nextInt(4);
        }
        System.out.println(a);
        switch (a){
            case 1:
                JOptionPane.showMessageDialog(null,"You won the highest bonus");
                maxFlags++;
                currentLives++;
                Time+=2000;
                timeLimit+=60;
                NummPause++;
                break;
            case 2:
                JOptionPane.showMessageDialog(null,"You won the second bonus");
                maxFlags+=2;
                currentLives+=2;
                Time+=3000;
                timeLimit+=40;
                NummPause+=2;
                break;
            case 3:
                JOptionPane.showMessageDialog(null,"You won the third bonus");
                maxFlags+=3;
                currentLives+=3;
                Time+=4000;
                timeLimit+=20;
                NummPause+=1;
                break;
            case 0:
                JOptionPane.showMessageDialog(null,"You don't have any bonus");
                break;
            default:
                break;
        }
    }

    private void provideAdvancedHint() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                MineTile tile = board[row][col];
                if (tile.isEnabled() && !tile.isFlagged()) {
                    int advancedHint = calculateAdvancedHint(row, col);
                    if (advancedHint > 0) {
                        tile.setText(String.valueOf(advancedHint));
                    }
                }
            }
        }
    }
    public int getTimeLimit(){
        return  timeLimit;
    }
    private int calculateAdvancedHint(int r, int c) {
        int advancedHint = 0;

        // Add your advanced hint calculation logic here
        // Example: Check for patterns or advanced strategies
        // This is just a placeholder example, replace with actual logic

        int minesFound = 0;

        minesFound += countMine(r - 1, c - 1);
        minesFound += countMine(r - 1, c);
        minesFound += countMine(r - 1, c + 1);
        minesFound += countMine(r, c - 1);
        minesFound += countMine(r, c + 1);
        minesFound += countMine(r + 1, c - 1);
        minesFound += countMine(r + 1, c);
        minesFound += countMine(r + 1, c + 1);

        if ((r == 0 && (c == 0 || c == numCols - 1)) || (r == numRows - 1 && (c == 0 || c == numCols - 1))) {
            advancedHint = minesFound / 2; // For corners, consider half the mines
        } else {
            advancedHint = minesFound;
        }

        return advancedHint;
    }
    
    private void setDifficulty(){
        switch (difficulty){
            case 0:
                numberOfMines = Math.round((10 * numRows * numCols) / 100.0f);
                maxFlags=10;
                initialLives = 3;
                Time=10000;
                BonusTime=3;
                NummPause=3;
                timeLimit=300;
                break;
            case 1:
                numberOfMines = Math.round((15 * numRows * numCols) / 100.0f);
                maxFlags=7;
                initialLives = 2;
                Time=8000;
                BonusTime=2;
                NummPause=2;
                timeLimit=200;
                break;
            case 2:
                numberOfMines = Math.round((25 * numRows * numCols) / 100.0f);
                maxFlags=5;
                initialLives = 1;
                Time=6000;
                BonusTime=1;
                NummPause=1;
                timeLimit=100;
                break;
        }
    }
    
    private void initializeTimer() {
        secondsPassed = 0;

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (!gamePaused) {
                    if(TOTAL_POINTS==0){
                        setGameOver();
                    }
                    secondsPassed+=1;
                    updateTimerLabel();

                    if(secondsPassed>timeLimit){

                    setGameOver();
                }
            }}
        });
    }

public boolean isGameOver(){
        return gameOver;
}
    public void stopTimer() {
        timer.stop();
        deductionTimer.stop();
    }
    
    public void startTimer() {
        timer.start();
        deductionTimer.start();

    }

    private void updateScoreLabel() {
        textLabel.setText("Time: " + elapsedTimeSeconds + " seconds|Score: " + BASE_SCORE+ " Flags" + maxFlags);
    }
    private void deductPointsForMine(MineTile mine) {
        mine.setCleared(true); // Mark the mine as cleared
        BASE_SCORE -= DEDUCTION_AMOUNT;
        JOptionPane.showMessageDialog(null,"Your time  out let hurry up");
        System.out.println(" Base score " + BASE_SCORE);

        if (BASE_SCORE <= 0) {
            //gameOver = true;
            textLabel.setText("Game Over! Your score is too low.");
            stopTimer();
        }
    }

    private void deductPointsForUnclearedMines() {
        ArrayList<MineTile> unclearedMines = getUnclearedMines();

        if (!unclearedMines.isEmpty()) {
            // Randomly select one uncleared mine
            MineTile randomMine = unclearedMines.get(random.nextInt(unclearedMines.size()));
            deductPointsForMine(randomMine);
        }
    }


    private void updateTimerLabel() {
        // Update a label or perform any action with the elapsed time
        textLabel.setText("Time: " + secondsPassed + " / " + timeLimit + " sceonds"+ " Base Score "+ BASE_SCORE);
    }




    public void generateMines() {
        mineList = new ArrayList<MineTile>();
        int mineLeft = numberOfMines;
        while (mineLeft > 0) {
            int r = random.nextInt(numRows);
            int c = random.nextInt(numCols);

            MineTile tile = board[r][c];
            if (!mineList.contains(tile)) {
                mineList.add(tile);
                mineLeft--;
            }
        }
    }



    public void revealMine() {
        for (int i = 0; i < mineList.size(); i++) {
            MineTile tile = mineList.get(i);
            tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/9.png")));
            mineList.remove(mineList.get(i));
            currentLives--;
            numberOfMines--;
            TOTAL_POINTS-=5;
            if (currentLives <= 0) {
               setGameOver();
               win=false;
            }
            break;
        }
        // Deduct a life based on the current number of lives

        // Check if the player has run out of lives
    }

    private ArrayList<MineTile> getUnclearedMines() {
        ArrayList<MineTile> unclearedMines = new ArrayList<>();

        for (MineTile mine : mineList) {
            if (!mine.isFlagged() && !mine.isCleared()) {
                unclearedMines.add(mine);
            }
        }

        return unclearedMines;
    }

public void Reveal(){
    for (int i = 0; i < mineList.size(); i++) {
        MineTile tile = mineList.get(i);
        tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/9.png")));
    }
}
    public void checkMine(int r, int c) {
        if (r < 0 || r >= numRows || c < 0 || c >= numCols) {
            return;
        }

        MineTile tile = board[r][c];
        if (!tile.isEnabled()) {
            return;
        }
        tile.setEnabled(false);
        tilesClicked++;

        int minesFound = 0;

        minesFound += countMine(r - 1, c - 1);
        minesFound += countMine(r - 1, c);
        minesFound += countMine(r - 1, c + 1);
        minesFound += countMine(r, c - 1);
        minesFound += countMine(r, c + 1);
        minesFound += countMine(r + 1, c - 1);
        minesFound += countMine(r + 1, c);
        minesFound += countMine(r + 1, c + 1);

        if (minesFound > 0) {
            switch (minesFound) {
                case 1:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1.png")));
                    tile.setText("");
                    break;
                case 2:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2.png")));
                    tile.setText("");
                    break;
                case 3:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3.png")));
                    tile.setText("");
                    break;
                case 4:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/4.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/4.png")));
                    tile.setText("");
                    break;
                case 5:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/5.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/5.png")));
                    tile.setText("");
                    break;
                case 6:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/6.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/6.png")));
                    tile.setText("");
                    break;
                case 7:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/7.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/7.png")));
                    tile.setText("");
                    break;
                case 8:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/8.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/8.png")));
                    tile.setText("");
                    break;
            }
        } else {
            tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/10.png")));

            checkMine(r - 1, c - 1);
            checkMine(r - 1, c);
            checkMine(r - 1, c + 1);
            checkMine(r, c - 1);
            checkMine(r, c + 1);
            checkMine(r + 1, c - 1);
            checkMine(r + 1, c);
            checkMine(r + 1, c + 1);
        }

        if (tilesClicked == numRows * numCols - mineList.size()) {
            gameOver = true;
            textLabel.setText("Mines Cleared, You Win!");
            win=true;

        }
    }

    public int countMine(int r, int c) {
        if (r < 0 || r >= numRows || c < 0 || c >= numCols) {
            return 0;
        }
        if (mineList.contains(board[r][c])) {
            return 1;
        }
        return 0;
    }

    public void flagPlaced() {
        if (numberOfFlags < maxFlags) {
            numberOfFlags++;

            mineLabel.setText("Remaining mines: " + (numberOfMines - numberOfFlags));

        } else {
            JOptionPane.showMessageDialog(null, "You've reached the maximum number of flags!");
        }
    }

    public void setGameOver(){
        gameOver=true;
        stopTimer();
        textLabel.setText("Game Over!");
        Reveal();
    }


    public void flagRemoved() {
        numberOfFlags--;
        mineLabel.setText("Remaining mines: " + Integer.toString(numberOfMines - numberOfFlags));
    }

    private static class GameState implements Serializable {
        private static final long serialVersionUID = 1L;
        private Date saveDate;

        // Add necessary fields to represent the game state
        private int numRows;
        private int numCols;
        private int numberOfMines;
        private int numberOfFlags;
        private int secondsPassed;
        private   int MaxFlag;
        private MineTile[][] board;  // Added to store the state of each MineTile
        // ... (Add more fields as needed)

        // Constructor to initialize the game state
        public GameState(int numRows, int numCols, int numberOfMines, int numberOfFlags, int secondsPassed, MineTile[][] board,int MaxFlag) {
            this.numRows = numRows;
            this.numCols = numCols;
            this.numberOfMines = numberOfMines;
            this.numberOfFlags = numberOfFlags;
            this.secondsPassed = secondsPassed;
            this.board = board;
            this.MaxFlag=MaxFlag;
            // Store the state of each MineTile
            // ... (Initialize other fields as needed)
        }
        public Date getSaveDate() {
            return saveDate;
        }

        public void setSaveDate(Date saveDate) {
            this.saveDate = saveDate;
        }
    }
    public static void saveGame() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("minesweeper.sav"))) {
            GameState gameState = new GameState(numRows, numCols, numberOfMines, numberOfFlags, secondsPassed, board,maxFlags);
            // ... (Add more fields to gameState as needed)
            outputStream.writeObject(gameState);
            gameState.setSaveDate(new Date());
JOptionPane.showMessageDialog(null,"Save game successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add a new method to load the game state from a file
    private void loadGame() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("minesweeper.sav"))) {
            GameState gameState = (GameState) inputStream.readObject();
            // ... (Retrieve fields from gameState as needed)

            // Apply the loaded game state
            numRows = gameState.numRows;
            numCols = gameState.numCols;
            numberOfMines = gameState.numberOfMines;
            numberOfFlags = gameState.numberOfFlags;
            secondsPassed = gameState.secondsPassed;
            board = gameState.board;
            maxFlags= gameState.MaxFlag;
            // Restore the state of each MineTile
            // ... (Apply other fields as needed)

            // Update the GUI components based on the loaded game state
            updateGameUI();

            System.out.println("Game loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Add a new method to update the GUI components based on the loaded game state
    private void updateGameUI() {
        // Clear existing components
        textPanel.removeAll();
        boardPanel.removeAll();

        // Update the size and location of the GameScreen
        this.setSize(numCols * tileSize, numRows * tileSize);
        this.setLocation((int) (1217 - numCols * tileSize) / 2, 10);

        // Recreate components with the loaded board size
        textLabel.setText("Number of mines: " + Integer.toString(numberOfMines));
        textPanel.add(textLabel);
        this.add(textPanel, BorderLayout.NORTH);

        mineLabel.setText("Remaining mines: " + Integer.toString(numberOfMines - numberOfFlags));
        this.add(mineLabel, BorderLayout.SOUTH);

        boardPanel.setLayout(new GridLayout(numRows, numCols));
        this.add(boardPanel);

        // Recreate the board array with the loaded size
        // Note: MineTile objects are already loaded from the serialized state
        // and the references are stored in the board array
        // No need to recreate MineTile objects, just update the GUI
        for (int rows = 0; rows < numRows; rows++) {
            for (int cols = 0; cols < numCols; cols++) {
                MineTile tile = board[rows][cols];
                tile.setFocusable(false);
                tile.setMargin(new Insets(0, 0, 0, 0));
                tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
                tile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        // ... (Existing code)
                    }
                });
                boardPanel.add(tile);
            }
        }

        // Repaint the components
        revalidate();
        repaint();

        // Initialize the timer with the loaded time limit
        initializeTimer();
    }

    private static void startMinesweeperGame() {
        // You can customize the difficulty, number of rows, and columns here
        int difficulty = 1; // 0 for easy, 1 for medium, 2 for hard
        int numRows = 15;
        int numCols = 15;

        JFrame frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameScreen gameScreen = new GameScreen(difficulty, numRows, numCols);
        frame.getContentPane().add(gameScreen);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void Game_tour(){
        GameScreen gameScreen=new GameScreen(0,15,15);
        if(gameScreen.win){
            GameScreen gameScreen1=new GameScreen(0,13,13);
            if(gameScreen1.win){
                GameScreen gameScreen2=new GameScreen(0,11,11);
                if(gameScreen2.win){
                    GameScreen gameScreen3=new GameScreen(0,9,9);
                    if(gameScreen3.win){

                    }
                }
            }
        }
    }

    public void setWin(boolean win) {
        this.win = win;
    }
    public boolean isWin() {
        return win;
    }
    private void initializeAndShowGame(int rows, int cols) {
        JFrame frame = new JFrame("Minesweeper Game");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);

        GameScreen gameScreen = new GameScreen(0, rows, cols);
        frame.getContentPane().add(gameScreen);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                setWin(gameScreen.isWin());
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameScreen(0, 15, 15).Game_tour());
    }

}








