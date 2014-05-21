package com.voice;

public interface VoiceRecognitionService {

	public boolean isServiceAvailable();
	public void startVoiceRecognition(SpeechRecognitionResultHandler callback);
	
	
}
