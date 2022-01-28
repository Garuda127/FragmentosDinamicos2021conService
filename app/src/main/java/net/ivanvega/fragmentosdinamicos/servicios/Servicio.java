package net.ivanvega.fragmentosdinamicos.servicios;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import net.ivanvega.fragmentosdinamicos.R;

public class Servicio extends Service {

    MediaPlayer miAudiolibro;
    public void onCreate(){

        miAudiolibro =MediaPlayer.create(this, R.raw.track);
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        miAudiolibro.start();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy(){
        super.onDestroy();
        if (miAudiolibro.isPlaying()) miAudiolibro.stop();
        miAudiolibro.release();
        miAudiolibro =null;

    }
}
