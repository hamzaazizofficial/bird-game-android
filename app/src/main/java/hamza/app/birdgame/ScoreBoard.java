package hamza.app.birdgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import static hamza.app.birdgame.GameView.SCORE;

public class ScoreBoard extends AppCompatActivity {

    TextView textView;
    int scoreRec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        textView = findViewById(R.id.score);

        Intent intent = getIntent();

        Bundle extras = getIntent().getExtras();
        String scoreRec2 = extras.getString(SCORE);
        scoreRec = Integer.parseInt(scoreRec2);

        //setting score to textView
        textView.setText("You Scored: "+scoreRec);

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Log.i("back","back button pressed");
        Intent intent = new Intent(getApplicationContext(),GameMenu.class);
        startActivity(intent);
    }
}
