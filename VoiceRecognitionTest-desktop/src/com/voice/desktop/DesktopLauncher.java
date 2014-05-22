package com.voice.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.voice.SpeechRecognitionResultHandler;
import com.voice.VoiceRecognitionService;
import com.voice.VoiceRecognitionTest;

public class DesktopLauncher implements VoiceRecognitionService {
	public static void main (String[] arg) {
		new DesktopLauncher();
	}
	public DesktopLauncher(){
		launch();
	}
	
	public void launch(){
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new VoiceRecognitionTest(this), config);
	}

	@Override
	public boolean isServiceAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void startVoiceRecognition(SpeechRecognitionResultHandler callback) {
		// TODO Auto-generated method stub
		
	}
}
