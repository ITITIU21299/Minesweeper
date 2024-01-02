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
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author nguye
 */

public class GameScreen {

    public class MineTile extends JButton {

        int rows;
        int cols;
        boolean flagCheck = false;

        public MineTile(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
        }
    }

    int tileSize = 40;
    int numRows = 15;
    int numCols = 15;
    int boardWidth = numCols * tileSize;
    int boardHeight = numRows * tileSize;


    JFrame frame = new JFrame("Minesweeper");
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

    public GameScreen() {
        System.out.println("1");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocation((int) (1217 - boardWidth) / 2, 10);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Arial", Font.BOLD, 25));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Number of mines: " + Integer.toString(numberOfMines));
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);


        mineLabel = new JLabel("Reamining mines: " + Integer.toString(numberOfMines - numberOfFlags));
        mineLabel.setFont(new Font("Arial", Font.BOLD, 25));
        mineLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(mineLabel, BorderLayout.SOUTH);

        boardPanel.setLayout(new GridLayout(numRows, numCols));
        frame.add(boardPanel);

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
        frame.setVisible(true);
        initializeTimer();
        generateMines();
        timer.start();

    }
    private void initializeTimer() {
        secondsPassed = 0;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsPassed++;
                updateTimerLabel();
                if (secondsPassed >= timeLimit) {
                    // Time limit reached, implement game over logic or end the game
                    timer.stop();
                    gameOver = true;
                    textLabel.setText("Time's up! Game Over!");
                }
            }
        });
    }    private void updateTimerLabel() {
        // Update a label or perform any action with the elapsed time
        textLabel.setText("Number of mines: " + numberOfMines + "   |   Time: " + secondsPassed + " seconds");
    }

    private void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
        // Adjust the number of mines or any other parameters based on the difficulty level
        switch (difficulty) {
            case 1:
                numberOfMines = Math.round((5 * numRows * numCols) / 100.0f);
                timeLimit = 300;
                break;
            case 2:
                numberOfMines = Math.round((10 * numRows * numCols) / 100.0f);
                timeLimit = 600;
                break;
            case 3:
                numberOfMines = Math.round((15 * numRows * numCols) / 100.0f);
                timeLimit = 900;
                break;
            // Add more cases for additional difficulty levels if needed
        }
        initializeTimer();
        // Update the display or restart the game with new parameters
        // For example, you may want to call a method like resetGame() here
        // resetGame();
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
        tile.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1.png")));
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
                    break;
                case 2:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2.png")));
                    break;
                case 3:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3.png")));
                    break;
                case 4:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/4.png")));
                    break;
                case 5:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/5.png")));
                    break;
                case 6:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/6.png")));
                    break;
                case 7:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/7.png")));
                    break;
                case 8:
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/8.png")));
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
}
