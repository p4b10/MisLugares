package com.example.mislugares;

import android.app.Activity;
import android.media.SoundPool;

public class Sonidos {
	//meter sonidos en carpeta raw
	SoundPool soundPool;
	int idSonido1, idSonid2;
	Activity activity;
	
	
	public Sonidos(Activity activity){
		super();
		
		this.activity=activity;
		
		//soundpool=new SoundPool(5,AudioManager.STREAM_MUSIC,);
		//idSonido1=soundPool.load(Activity,R.raw.sonido1)
	}

}
