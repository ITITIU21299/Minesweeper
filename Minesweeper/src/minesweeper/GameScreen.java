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
import java.util.Stack;

public class GameScreen extends JPanel {
    private int initialLives;
    int undoTimes;
    private Stack<Action> actionStack = new Stack<>();
    int stackIndex = 0;
    
    public class Action{
        MineTile tile;
        boolean isCheckMine;
        int index;
        
        public Action(MineTile tile, boolean isCheckmine, int index){
            this.tile = tile;
            this.isCheckMine = isCheckmine;
            this.index = index;
        }
    }
    
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
    int numRows = 15;
    int numCols = 15;
    int boardWidth = numCols * tileSize;
    int boardHeight = numRows * tileSize;
    JLabel textLabel;
    JPanel textPanel;
    JPanel boardPanel;
    int numberOfMines;
    MineTile[][] board = new MineTile[numRows][numCols];
    ArrayList<MineTile> mineList;
    Random random = new Random();
    int numberOfFlags = 0;
    JLabel mineLabel = new JLabel();
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
    private int elapsedTimeSeconds;
    private boolean isGameTour;

    private JButton saveButton;
    public GameScreen(int diff, int row, int col) {
        
        win=false;
        numRows = row;
        numCols = col;
        difficulty = diff;
        setDifficulty();
        this.setSize(boardWidth, boardHeight);
        this.setLocation((int) (1217 - boardWidth) / 2, 10);
        this.setLayout(new BorderLayout(0,0));
        textLabel = new JLabel();
        textPanel = new JPanel();
        boardPanel = new JPanel();
        textLabel.setFont(new Font("Arial", Font.BOLD, 17));
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

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undo();
            }
        });
        textPanel.add(undoButton, BorderLayout.SOUTH);
        this.add(mineLabel, BorderLayout.SOUTH);
        for (int rows = 0; rows < numRows; rows++) {
            for (int cols = 0; cols < numCols; cols++) {
                MineTile tile = new MineTile(rows, cols);
                board[rows][cols] = tile;

                tile.setFocusable(false);
                tile.setMargin(new Insets(0, 0, 0, 0));
//                tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
                tile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        
                        if (gameNotBegin) {
                            gameNotBegin = false;
                            initializeTimer();
                            startTimer();
                        }                        
                        if (gameOver){
                            return;
                        }
                        MineTile tile = (MineTile) e.getSource();
                        //System.out.println(tile.getIcon().toString().contains("/img/0.png"));
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            if(tile.flagCheck){
                                return;
                            }
                            if (tile.getIcon().toString().contains("/img/0.png")) {
                                System.out.println(".mousePressed()");
                                if (mineList.contains(tile)) {
                                    revealMine();
                                } else {
                                    checkMine(tile.rows, tile.cols, false);
                                }
                            }
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                            if (tile.getIcon().toString().contains("/img/0.png") && tile.isEnabled()) {
                                tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/11.png")));
                                tile.flagCheck = true;
                                tile.flagged =true;
                                flagPlaced();
                            } else if (tile.flagCheck){
                                tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/0.png")));
                                tile.flagCheck = false;
                                tile.flagged = false;
                                flagRemoved();
                            }
                        }
                    }
                });
                boardPanel.add(tile);
            }
        }
        this.setVisible(true);
        generateMines();
        for (int rows = 0; rows < numRows; rows++){
            for (int cols = 0; cols < numCols; cols++){
                MineTile tile = board[rows][cols];
                tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/0.png")));
                tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/0.png")));
            }
        }

    }
    
    private void undo(){
        if (undoTimes>0){
        if (!actionStack.isEmpty()){
            Action lastAction = actionStack.pop();
            undoTimes--;
            updateLabel();
            if  (lastAction.isCheckMine){
                while (!actionStack.isEmpty() && actionStack.peek().index == lastAction.index){
                lastAction.tile.setEnabled(true);
                lastAction.tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/0.png")));
                lastAction = actionStack.pop();
                }
                lastAction.tile.setEnabled(true);
                lastAction.tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/0.png")));
                tilesClicked--;
            }
            else{
                for (MineTile mineTile : mineList){
                    if (!mineTile.isFlagged()){
                        mineTile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/0.png")));
                    }
                }
                gameOver = false;
                startTimer();
            }
        }
    } else{
            JOptionPane.showMessageDialog(this,"No more undos!");
        }
    }
    
    private boolean win=true;

    public int getTimeLimit(){
        return  timeLimit;
    }
    
    private int Initial_Pause;
    
    private void setDifficulty(){
        switch (difficulty){
            case 0:
                numberOfMines = Math.round((10 * numRows * numCols) / 100.0f);
                initialLives = 3;
                timeLimit=500;
                undoTimes=1;
                Initial_Pause=3;
                break;
            case 1:
                numberOfMines = Math.round((15 * numRows * numCols) / 100.0f);
                initialLives = 2;
                timeLimit=400;
                undoTimes=2;
                Initial_Pause=2;
                break;
            case 2:
                numberOfMines = Math.round((25 * numRows * numCols) / 100.0f);
                initialLives = 1;
                timeLimit=300;
                undoTimes=3;
                Initial_Pause=1;
                break;
        }
    }
    
    private void initializeTimer() {
        secondsPassed = 0;

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (!gamePaused) {
                    secondsPassed+=1;
                    updateLabel();
                    if(secondsPassed>timeLimit){
                        revealMine();
                }
            }}
        });
    }

public boolean isGameOver(){
        return gameOver;
}
    public void stopTimer() {
        timer.stop();
    }
    
    public void startTimer() {
        timer.start();
    }

    private void updateLabel() {
        textLabel.setText("Time: " + secondsPassed + " / " + timeLimit + " seconds || Undo left: "+undoTimes);
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
        if (undoTimes == 0){
            for (int i = 0; i < mineList.size(); i++) {
                MineTile tile = mineList.get(i);
                tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/9.png")));
            }
        }else{
            JOptionPane.showMessageDialog(this, "You have the undo action left. Make use of it!");
        }
         gameOver=true;
         stopTimer();
         textLabel.setText("Game Over!");
         win=false;
         actionStack.push(new Action(null, false, -1));
    }

    public void checkMine(int r, int c, boolean multiple) {
        if (!multiple){
            stackIndex++;
        }
        
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
                    actionStack.push(new Action(tile, true, stackIndex));
                    if (!multiple){
                        stackIndex++;
                    }
                    break;
                case 2:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2.png")));
                    tile.setText("");
                    actionStack.push(new Action(tile, true, stackIndex));
                    if (!multiple){
                        stackIndex++;
                    }
                    break;
                case 3:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3.png")));
                    tile.setText("");
                    actionStack.push(new Action(tile, true, stackIndex));
                    if (!multiple){
                        stackIndex++;
                    }
                    break;
                case 4:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/4.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/4.png")));
                    tile.setText("");
                    actionStack.push(new Action(tile, true, stackIndex));
                    if (!multiple){
                        stackIndex++;
                    }
                    break;
                case 5:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/5.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/5.png")));
                    tile.setText("");
                    actionStack.push(new Action(tile, true, stackIndex));
                    if (!multiple){
                        stackIndex++;
                    }
                    break;
                case 6:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/6.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/6.png")));
                    tile.setText("");
                    actionStack.push(new Action(tile, true, stackIndex));
                    if (!multiple){
                        stackIndex++;
                    }
                    break;
                case 7:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/7.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/7.png")));
                    tile.setText("");
                    actionStack.push(new Action(tile, true, stackIndex));
                    if (!multiple){
                        stackIndex++;
                    }
                    break;
                case 8:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/8.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/8.png")));
                    tile.setText("");
                    actionStack.push(new Action(tile, true, stackIndex));
                    if (!multiple){
                        stackIndex++;
                    }
                    break;
            }
        } else {
            tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/10.png")));
            tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/10.png")));
            if (!multiple) {
            actionStack.push(new Action(tile, true, stackIndex));
            checkMine(r - 1, c - 1,true);
            checkMine(r - 1, c, true);
            checkMine(r - 1, c + 1, true);
            checkMine(r, c - 1, true);
            checkMine(r, c + 1, true);
            checkMine(r + 1, c - 1, true);
            checkMine(r + 1, c, true);
            checkMine(r + 1, c + 1, true);
            } else{
                actionStack.push(new Action(tile, true, stackIndex));
                checkMine(r - 1, c - 1,true);
                checkMine(r - 1, c, true);
                checkMine(r - 1, c + 1, true);
                checkMine(r, c - 1, true);
                checkMine(r, c + 1, true);
                checkMine(r + 1, c - 1, true);
                checkMine(r + 1, c, true);
                checkMine(r + 1, c + 1, true);
            }
        }

        if (tilesClicked == numRows * numCols - mineList.size()) {
            gameOver = true;
            stopTimer();
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
         numberOfFlags++;
         mineLabel.setText("Remaining mines: " + (numberOfMines - numberOfFlags));
    }

    public void flagRemoved() {
        numberOfFlags--;
        mineLabel.setText("Remaining mines: " + Integer.toString(numberOfMines - numberOfFlags));
    }
    
    public boolean isWin() {
        return win;
    }
}