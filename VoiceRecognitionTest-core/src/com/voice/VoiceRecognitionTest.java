package com.voice;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class VoiceRecognitionTest extends ApplicationAdapter implements
SpeechRecognitionResultHandler, VoiceRecognitionService{
	SpriteBatch batch;
	Texture img;
	BitmapFont font;
	
	String testStr;
	
	VoiceRecognitionService voiceRecognitionService;
	

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.RED);
		
		testStr = "Running";
		
		this.startVoiceRecognition(this);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.draw(batch, testStr, 200, 200);
		batch.end();
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
		testStr = "got results";
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
}
