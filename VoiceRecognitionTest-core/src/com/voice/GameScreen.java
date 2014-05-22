package com.voice;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen, SpeechRecognitionResultHandler{
	VoiceRecognitionTest game;
	SpriteBatch batch;
	BitmapFont font;
	int frame;
	
	String tester;
	
	public GameScreen(VoiceRecognitionTest game){
		this.game = game;
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.RED);
		
		game.startVoiceRecognition(this);
		tester = "no result";
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		game.startVoiceRecognition(this);
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.draw(batch, tester, 200, 200);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
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
		tester = results.get(0);
		System.out.println("here");
		
	}

}
