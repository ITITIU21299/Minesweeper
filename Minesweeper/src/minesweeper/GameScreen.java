/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minesweeper;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author nguye
 */

public class GameScreen extends JPanel {

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
        public void setFlagged(boolean flagged) {
            this.flagged = flagged;
        }
    }

    int tileSize = 40;
    int numRows = 15;
    int numCols = 15;
    int boardWidth = numCols * tileSize;
    int boardHeight = numRows * tileSize;


    //  this = new  this("Minesweeper");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    int numberOfMines = Math.round((10 * numRows * numCols) / 100.0f);
    MineTile[][] board = new MineTile[numRows][numCols];
    ArrayList<MineTile> mineList;
    Random random = new Random();

    int numberOfFlags = 0;
    JLabel mineLabel = new JLabel();


    int tilesClicked = 0;
    boolean gameOver = false;

    private int difficulty;
    private Timer timer;
    private int secondsPassed;
    private int timeLimit;
    private JButton pauseResumeButton;
    private boolean gamePaused = false;
    private JButton advancedHintButton;


    private JButton saveButton;
    public GameScreen(int diff, int row, int col) {
        System.out.println("1");
        difficulty = diff;
        setDifficulty();
        numRows = row;
        numCols = col;
        this.setSize(boardWidth, boardHeight);
        this.setLocation((int) (1217 - boardWidth) / 2, 10);
        // this.setLocationRelativeTo(null);
        // this.setResizable(false);
        // this.setDefaultCloseOperation(  this.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Arial", Font.BOLD, 25));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Number of mines: " + Integer.toString(numberOfMines));
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        this.add(textPanel, BorderLayout.NORTH);



        mineLabel = new JLabel("Reamining mines: " + Integer.toString(numberOfMines - numberOfFlags));
        mineLabel.setFont(new Font("Arial", Font.BOLD, 25));
        mineLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(mineLabel, BorderLayout.SOUTH);

        boardPanel.setLayout(new GridLayout(numRows, numCols));
        this.add(boardPanel);


        pauseResumeButton = new JButton("Pause");
        pauseResumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                togglePauseResume();
            }
        });

        advancedHintButton = new JButton("Advanced Hint");
        advancedHintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                provideAdvancedHint();
            }
        });
        textPanel.add(advancedHintButton, BorderLayout.WEST);

        // Add the Pause/Resume button to the GUI
        textPanel.add(pauseResumeButton, BorderLayout.EAST);
        saveButton = new JButton("Save Game");

        // ... (Existing code)
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
                        if (gameOver) {
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
        initializeTimer();
        generateMines();
        timer.start();

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

        advancedHint = minesFound;

        return advancedHint;
    }
    
    private void setDifficulty(){
        switch (difficulty){
            case 0:
                numberOfMines = Math.round((10 * numRows * numCols) / 100.0f);
                break;
            case 1:
                numberOfMines = Math.round((15 * numRows * numCols) / 100.0f);
                break;
            case 2:
                numberOfMines = Math.round((25 * numRows * numCols) / 100.0f);
                break;
        }
    }
    
    private void initializeTimer() {
        secondsPassed = 0;
        switch (difficulty) {
            case 0:
                timeLimit = 300;
                break;
            case 1:
                timeLimit = 200;
                break;
            case 2:
                timeLimit = 100;
                break;
            // Add more cases for additional difficulty levels if needed

        }
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsPassed++;
                updateTimerLabel();
                if (!gamePaused) {
                    if(secondsPassed>timeLimit){

                    revealMine();
                }
            }}
        });
    }
    private void updateTimerLabel() {
        // Update a label or perform any action with the elapsed time
        textLabel.setText("Time Limit: " + timeLimit + "   |   Time: " + secondsPassed + " seconds");
    }

    private void togglePauseResume() {
        gamePaused = !gamePaused;
        if (gamePaused) {
            timer.stop();
            pauseResumeButton.setText("Resume");
        } else {
            timer.start();
            pauseResumeButton.setText("Pause");
        }
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
        }
        gameOver = true;
        textLabel.setText("Game Over!");
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
                    break;
                case 2:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2.png")));
                    break;
                case 3:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3.png")));
                    break;
                case 4:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/4.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/4.png")));
                    break;
                case 5:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/5.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/5.png")));
                    break;
                case 6:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/6.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/6.png")));
                    break;
                case 7:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/7.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/7.png")));
                    break;
                case 8:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/8.png")));
                    tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/8.png")));
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
        mineLabel.setText("Reamining mines: " + Integer.toString(numberOfMines - numberOfFlags));
    }

    public void flagRemoved() {
        numberOfFlags--;
        mineLabel.setText("Reamining mines: " + Integer.toString(numberOfMines - numberOfFlags));
    }

    private static class GameState implements Serializable {
        private static final long serialVersionUID = 1L;

        // Add necessary fields to represent the game state
        private int numRows;
        private int numCols;
        private int numberOfMines;
        private int numberOfFlags;
        private int secondsPassed;
        private MineTile[][] board;  // Added to store the state of each MineTile
        // ... (Add more fields as needed)

        // Constructor to initialize the game state
        public GameState(int numRows, int numCols, int numberOfMines, int numberOfFlags, int secondsPassed, MineTile[][] board) {
            this.numRows = numRows;
            this.numCols = numCols;
            this.numberOfMines = numberOfMines;
            this.numberOfFlags = numberOfFlags;
            this.secondsPassed = secondsPassed;
            this.board = board;  // Store the state of each MineTile
            // ... (Initialize other fields as needed)
        }
    }






    private void saveGame() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("minesweeper.sav"))) {
            GameState gameState = new GameState(numRows, numCols, numberOfMines, numberOfFlags, secondsPassed, board);
            // ... (Add more fields to gameState as needed)
            outputStream.writeObject(gameState);
            System.out.println("Game saved successfully.");
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
            board = gameState.board;  // Restore the state of each MineTile
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








}








