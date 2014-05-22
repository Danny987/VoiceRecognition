package com.voice;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class VoiceRecognitionTest extends Game implements SpeechRecognitionResultHandler, VoiceRecognitionService{
	SpriteBatch batch;
	Texture img;
	BitmapFont font;
	
	String testStr;
	
	VoiceRecognitionService voiceRecognitionService;
	
	public VoiceRecognitionTest(VoiceRecognitionService voiceRecognitionService){
		this.voiceRecognitionService = voiceRecognitionService;
	}

	public void create(){
		setScreen(new GameScreen(this));
	}
	
	@Override
	public boolean isServiceAvailable() {
		// TODO Auto-generated method stub
		return this.voiceRecognitionService.isServiceAvailable();
	}

	@Override
	public void startVoiceRecognition(SpeechRecognitionResultHandler callback) {
		// TODO Auto-generated method stub
		this.voiceRecognitionService.startVoiceRecognition(callback);
	}

	@Override
	public void onError(int error, boolean fatalError) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReadyForSpeech() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotSpeechResults(ArrayList<String> results) {
		// TODO Auto-generated method stub
		
	}

}
