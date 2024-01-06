/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minesweeper;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author nguye
 */
public class Minesweeper {
    
    private static Clip clip;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        menu.setVisible(true);
        
        
        PlayMusic();
    }
    
    public static void PlayMusic(){
        try {
            String filepath = "src\\sound\\Schubert - Serenade.wav";
            File musicPath = new File(filepath);
            if (musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
            else{
                System.out.println("Can't find file");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void StopMusic(){
         if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
    