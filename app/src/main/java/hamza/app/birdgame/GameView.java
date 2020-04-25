package hamza.app.birdgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


public class GameView extends View {

    SharedPreferences getShared = getContext().getSharedPreferences("demo", MODE_PRIVATE);
    int selectedBird = getShared.getInt("selectedBird",1);

    public static final String SCORE = "com.hamza.app";

    //Defing sound var
    private SoundEffects sound;

    //Defining canvas paramenters
    private int canWidth;
    private int canHeight;

    //Defining Bird Parameters
    private Bitmap bird[] = new Bitmap[2];
    private int birdX = 10;
    private int birdY;
    private int birdSpeed;

    //Food params
    private Bitmap food;
    private int foodX;
    private int foodY;
    private int foodSpeed = 15;

    //fire ball params
    private Bitmap fire;
    private int fireX;
    private int fireY;
    private int fireSpeed = 17;

    //Scoring Label
    private Paint scorePaint = new Paint();
    private int score;

    //Health View
    private Bitmap health[] = new Bitmap[2];
    private int healthCount;

    // Status check
    private boolean touchFlg = false;

    public GameView(Context context) {
        super(context);

        int selectedBirdID = R.drawable.bird4;
        if(selectedBird == 1)
            selectedBirdID = R.drawable.bird4;
        else if(selectedBird == 2)
            selectedBirdID = R.drawable.bird7b;
        else if(selectedBird == 3)
            selectedBirdID = R.drawable.bird8b;
        else if(selectedBird == 4)
            selectedBirdID = R.drawable.bird9b;

        bird[0] = BitmapFactory.decodeResource(context.getResources(), selectedBirdID);
        bird[1] = BitmapFactory.decodeResource(context.getResources(), selectedBirdID);

        //Sound
        sound = new SoundEffects(getContext());

        //Blue Ball
        food = BitmapFactory.decodeResource(context.getResources(), R.drawable.insect1);

        //fire ball
        fire = BitmapFactory.decodeResource(context.getResources(),R.drawable.fire);

        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(34);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        health[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.feather);
        health[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.birdlyf2);

        //Initial position
        birdY = 500;
        score = 0;
        healthCount = 3;
    }

//    creating Canvas for game with onDraw method
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canWidth = getWidth();
        canHeight = getHeight();

        //Bird
        int minBirdY = bird[0].getHeight();
        int maxBirdY = canHeight - bird[0].getHeight();

        birdY += birdSpeed;
        if (birdY < minBirdY){
            birdY = minBirdY;
        }
        if (birdY > maxBirdY){
            birdY = maxBirdY;
        }
        birdSpeed +=2;

        if (touchFlg){
            //flap wings animation
            canvas.drawBitmap(bird[1],birdX,birdY,null);
            sound.playTapSnd();
            touchFlg = false;
        }
        else {
            canvas.drawBitmap(bird[0],birdX,birdY,null);

        }

        //Blue
        foodX -= foodSpeed;
        if(hitCheck(foodX,foodY)){
            score +=10;
            sound.playHit1();

            foodX = -100;
        }
        if (foodX<0){
            foodX = canWidth + 20;
            foodY = (int) Math.floor(Math.random() * (maxBirdY-minBirdY)) + minBirdY;
        }
//        canvas.drawCircle(blueX,blueY,10,bluePaint);
        canvas.drawBitmap(food,foodX,foodY,null);
        //Black
        fireX -= fireSpeed;
        if (hitCheck(fireX,fireY)){
            fireX = -100;
            sound.playHit2();
            healthCount--;
            if (healthCount==0){
                //This is a game over condition
                Toast.makeText(getContext(), "Game Over!", Toast.LENGTH_SHORT).show();
//                score = 0;
//                healthCount = 3;
                Intent intent = new Intent(getContext(),ScoreBoard.class);
                Bundle extras = new Bundle();
                extras.putString(SCORE, score + "");
                intent.putExtras(extras);
                getContext().startActivity(intent);

            }
        }

        if(fireX < 0){
            fireX = canWidth + 200;
            fireY = (int) Math.floor(Math.random() * (maxBirdY-minBirdY))+minBirdY;
        }
//        canvas.drawCircle(blackX,blackY,20,blackPaint);
        canvas.drawBitmap(fire,fireX,fireY,null);

        canvas.drawText("Score: "+score,20,60,scorePaint);

        //Health ==> for destroy hearth when tackle to black ball
        for (int i=0;i<3;i++){
            int x = (int) (520+health[0].getWidth()*1.5*i);
            int y = 30;


            if(i<healthCount){
                canvas.drawBitmap(health[0], x, y, null);

            } else {
                canvas.drawBitmap(health[1], x, y, null);
            }

        }

    }

    public boolean hitCheck(int x, int y){
        if (birdX < x && x < (birdX+bird[0].getWidth()) && birdY < y && y < (birdY+bird[0].getHeight())){
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            touchFlg = true;
            birdSpeed = -25;

        }
        return true;
    }


}
