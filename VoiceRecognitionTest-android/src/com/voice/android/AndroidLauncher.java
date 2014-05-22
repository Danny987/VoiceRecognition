package com.voice.android;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.voice.SpeechRecognitionResultHandler;
import com.voice.VoiceRecognitionService;
import com.voice.VoiceRecognitionTest;

public class AndroidLauncher extends AndroidApplication implements VoiceRecognitionService {
	
	public SpeechRecognizer speechRecognizer;
	private SpeechRecognitionResultHandler speechRecognitionResultHandler;
	private SpeechRecognitionResultHandler resultHandler;
	
	AudioManager audioManager;
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		
		//check if there is a speech recognizer available
		if(SpeechRecognizer.isRecognitionAvailable(this)){
			//if so, create speech recognizer
			speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
			speechRecognizer.setRecognitionListener(new Listener());
		}
		
		audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		
		
		VoiceRecognitionTest game = new VoiceRecognitionTest(this);
		
		initialize(game, config);
	}

	
	private void startVoiceRecognitionActivity(){
		//create voice recognizer intent
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "en-GB");
		intent.putExtra(RecognizerIntent.EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE, true);
		
		speechRecognizer.startListening(intent);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		if(requestCode == 1234 && resultCode == RESULT_OK ){
			ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			resultHandler.gotSpeechResults(matches);
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	@Override
	public boolean isServiceAvailable() {
		// TODO Auto-generated method stub
		return speechRecognizer != null;
	}

	@Override
	public void restartVoiceService(){
		speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
		speechRecognizer.setRecognitionListener(new Listener());
	}
	
	@Override
	public void startVoiceRecognition(SpeechRecognitionResultHandler callback) {
		audioManager.setStreamSolo(AudioManager.STREAM_VOICE_CALL, true);
		// TODO Auto-generated method stub
		speechRecognitionResultHandler = callback;
		Handler mainHandler = new Handler(this.getMainLooper());
		
		Runnable myRunnable = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				startVoiceRecognitionActivity();
			}
			
		};
		mainHandler.post(myRunnable);
	}
	
	class Listener implements RecognitionListener{

		public void onBeginningOfSpeech() {
			// TODO Auto-generated method stub
			
		}

		
		public void onBufferReceived(byte[] buffer) {
			// TODO Auto-generated method stub
			
		}

		
		public void onEndOfSpeech() {
			// TODO Auto-generated method stub
			
		}

		
		public void onError(int error) {

			//determine if a fatal error occurred
			boolean fatal = false;
			if(error == SpeechRecognizer.ERROR_NO_MATCH 
					|| error == SpeechRecognizer.ERROR_SPEECH_TIMEOUT){
				fatal = false;
			}
			else{
				fatal = true;
			}
			
			speechRecognitionResultHandler.onError(error, fatal);
		}

		
		public void onEvent(int eventType, Bundle params) {
			// TODO Auto-generated method stub
			
		}

		
		public void onPartialResults(Bundle partialResults) {
			// TODO Auto-generated method stub
			
		}

		
		public void onReadyForSpeech(Bundle params) {
			// TODO Auto-generated method stub
			
			speechRecognitionResultHandler.onReadyForSpeech();
		}

		
		public void onResults(Bundle results) {
			// TODO Auto-generated method stub
			
			ArrayList<String> voiceData = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
			
			if(speechRecognitionResultHandler != null){
				speechRecognitionResultHandler.gotSpeechResults(voiceData);
			}
			audioManager.setStreamSolo(AudioManager.STREAM_VOICE_CALL, false);
		}

		
		public void onRmsChanged(float rmsdB) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
