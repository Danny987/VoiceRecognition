package com.voice;

import java.util.ArrayList;

public interface SpeechRecognitionResultHandler {

	public void onError(int error, boolean fatalError);
	public void onReadyForSpeech();
	public void gotSpeechResults(ArrayList<String> results);	
}
