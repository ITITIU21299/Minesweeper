/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minesweeper;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class Minesweeper {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        menu.setVisible(true);
        
        String filepath = "src\\sound\\Schubert - Serenade.wav";
        PlayMusic(filepath);
        
    }
    
    public static void PlayMusic(String location){
        try {
            File musicPath = new File(location);
            if (musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
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
}
