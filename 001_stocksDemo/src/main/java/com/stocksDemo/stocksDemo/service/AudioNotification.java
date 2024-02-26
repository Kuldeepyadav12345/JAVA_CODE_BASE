package com.stocksDemo.stocksDemo.service;

import java.io.File;
import java.io.FileInputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.SourceDataLine;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class AudioNotification {

	private final int BUFFER_SIZE = 128000;
	private File soundFile;
	private AudioInputStream audioStream;
	private AudioFormat audioFormat;
	private SourceDataLine sourceLine;
	public static String buyAudioFilePath = "F://11111/Eclipse_Workspace_Youtube/STOCK_DEMO/buy.wav";
	public static String sellAudioFilePath = "F://11111/Eclipse_Workspace_Youtube/STOCK_DEMO/sell.wav";
	
	
	public static void playBuyAudio() {
        try {
            // Get an audio input stream from the audio file
        	
        	  File file = new File(buyAudioFilePath);
              FileInputStream in = new FileInputStream(file);
              AdvancedPlayer player = new AdvancedPlayer(in);
              player.play();
              
        } catch (Exception e) {
			// TODO: handle exception
		}
 }
	
	public static void playSellAudio() {
        try {
            // Get an audio input stream from the audio file
        	System.out.println("playSellAudio");
        	  File file = new File(sellAudioFilePath);
              FileInputStream in = new FileInputStream(file);
              AdvancedPlayer player = new AdvancedPlayer(in);
              player.play();
              
        } catch (Exception e) {
			// TODO: handle exception
		}
 }
}