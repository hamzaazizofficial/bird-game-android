package hamza.app.birdgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    GameView gameView;
    Handler handler = new Handler();
    private final static long TIME_INTERVAL = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        //setting Contetn View for game display
        gameView = new GameView(this);
        setContentView(gameView);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //gameView.invalidate() ==>   call onDraw() method in GameView class every 30 mili secs
                        gameView.invalidate();
                    }
                });
            }
        }, 0, TIME_INTERVAL);

    }
}
