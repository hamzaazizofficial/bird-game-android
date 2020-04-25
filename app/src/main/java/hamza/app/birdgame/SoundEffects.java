package hamza.app.birdgame;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundEffects {

    private static SoundPool soundPool;
    private static int hitSnd;
    private static int hitSnd2;
    private static int gameOverSnd;
    private static int tapSnd;

    SoundEffects(Context context){
        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);

        hitSnd = soundPool.load(context,R.raw.point,1);
        hitSnd2 = soundPool.load(context,R.raw.hit1b,1);
        tapSnd = soundPool.load(context,R.raw.tap,1);
        gameOverSnd = soundPool.load(context,R.raw.die,1);
    }

    public void playHit1(){
        soundPool.play(hitSnd,1.0f,1.0f,1,0,1.0f);
    }

    public void playHit2(){
        soundPool.play(hitSnd2,1.0f,1.0f,1,0,1.0f);
    }

    public void playTapSnd(){
        soundPool.play(tapSnd,1.0f,1.0f,1,0,1.0f);
    }

    public void playOver() {soundPool.play(gameOverSnd,1.0f,1.0f,1,0,1.0f);}
}
