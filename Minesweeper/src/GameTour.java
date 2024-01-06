import minesweeper.GameScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTour  extends JFrame{
    boolean gameEnded = false;

    public static void main(String[] args) {
        GameTour gameTour=new GameTour();
        gameTour.TourGame();

    }
    public void TourGame(){
        int initialRow = 15;
        int initialCol = 15;
        int diff = 0;
        int time = 0;


        while (true) {
            if (initialRow < 8 && initialCol < 8) {
                JOptionPane.showMessageDialog(null, "You win the tourGame");

                // Add a delay to give the player time to read the message
                try {
                    Thread.sleep(2000); // 2000 milliseconds (2 seconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Update row and column values
                initialRow -= 2;
                initialCol -= 2;
                time++;
                if (time > 0 && time % 2 == 0) {
                    diff++;
                }

                // Dispose of the previous JFrame to avoid memory leaks
            } else {
                JFrame frame = new JFrame("Minesweeper Game Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                int xLocation = (int) ((1217 - 40 * initialCol) / 2);
                int yLocation = 2;
                frame.setLocation(xLocation, yLocation);

                int frameWidth = 40 * initialCol;
                int frameHeight = 40 * initialRow + 40;
                frame.setSize(frameWidth, frameHeight);

                GameScreen gameScreen = new GameScreen(diff, initialRow, initialCol);
                frame.getContentPane().add(gameScreen);

                frame.setVisible(true);

                final boolean[] gameEnded = {false};
                Timer timer = new Timer(1000, new ActionListener() {
                    int secondsPassed = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        secondsPassed++;
                        System.out.println("Seconds passed: " + secondsPassed);
                        if(gameScreen.isGameOver()==false){
                            if (secondsPassed == gameScreen.getTimeLimit() + 1) {
                                System.out.println("Seconds win: " + secondsPassed);
                                if (gameScreen.isWin()) {
                                    gameEnded[0] = false;
                                } else {
                                    gameEnded[0] = true;
                                }
                            }
                        }else{
                            if (gameScreen.isWin()) {
                                gameEnded[0] = false;
                            } else {
                                gameEnded[0] = true;
                                JOptionPane.showMessageDialog(null,"You lose the tour_game");
                                System.exit(0);
                            }
                        }
                    }
                });

                // Start the timer
                timer.start();

                // Wait for the game to end
                while (!gameEnded[0]) {
                    try {
                        Thread.sleep(100); // Sleep for 100 milliseconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (gameEnded[0]) {
                    break;
                } else {
                    initialRow -= 2;
                    initialCol -= 2;
                    time++;
                    if (time > 0 && time % 2 == 0) {
                        diff++;
                    }
                }

                // Stop the timer
                timer.stop();
            }
        }

    }
}
