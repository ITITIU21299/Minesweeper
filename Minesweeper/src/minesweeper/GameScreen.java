/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minesweeper;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nguye
 */
public class GameScreen{
    public class MineTile extends JButton {
            int rows;
            int cols;

            public MineTile(int rows, int cols) {
                this.rows = rows;
                this.cols = cols;
            }
        }

        int tileSize = 70;
        int numRows = 8;
        int numCols = 8;
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

        int tilesClicked = 0;
        boolean gameOver = false;

        public GameScreen() {
            frame.setSize(boardWidth, boardHeight);
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
                                if (tile.getText() == "") {
                                    if (mineList.contains(tile)) {
                                        revealMine();
                                    } else {
                                        checkMine(tile.rows, tile.cols);
                                    }
                                }
                            } else if (e.getButton() == MouseEvent.BUTTON3) {
                                if (tile.getText() == "" && tile.isEnabled()) {
                                    tile.setText("🚩");
                                } else if (tile.getText() == "🚩") {
                                    tile.setText("");
                                }
                            }
                        }
                    });
                    boardPanel.add(tile);
                }
            }
            frame.setVisible(true);

            generateMines();
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
                tile.setText("💣");
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
                tile.setText(Integer.toString(minesFound));
            } else {
                tile.setText("");

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
}