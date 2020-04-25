package hamza.app.birdgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import hamza.app.birdgame.Fragments.ViewPagerManager;

public class GameMenu extends AppCompatActivity {

    ImageView startBtn;
    ImageView selectBtn;
    ImageView quitBtn;
    Handler handler;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);




        

        startBtn = findViewById(R.id.startBtn);
        selectBtn = findViewById(R.id.selectBtn);
        quitBtn = findViewById(R.id.quitBtn);






        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //zoom animation
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                startBtn.startAnimation(animation);

                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
                startBtn.startAnimation(animation2);

                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                },500);

            }

        });

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //zoom animation
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                selectBtn.startAnimation(animation);

                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
                selectBtn.startAnimation(animation2);

                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(),ViewPagerManager.class);
                        startActivity(intent);
                    }
                },500);

            }
        });

        quitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //zoom animation
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                quitBtn.startAnimation(animation);

                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
                quitBtn.startAnimation(animation2);

                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        final Intent intent = new Intent(SplashScreen.this,GameMenu.class);
//                        startActivity(intent);
                        finishAffinity();
                    }
                },500);
            }
        });


    }





    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    finish();
                    finishAffinity();
                    GameMenu.super.onBackPressed();
                    }
                })
                .setNegativeButton("No",null)
                .show();
    }
}
