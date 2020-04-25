package hamza.app.birdgame.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.prefs.Preferences;

import hamza.app.birdgame.BirdData;
import hamza.app.birdgame.GameMenu;
import hamza.app.birdgame.GameView;
import hamza.app.birdgame.R;
import hamza.app.birdgame.ScoreBoard;

import static android.content.Context.MODE_PRIVATE;

public class SelectBird1 extends Fragment {

    private static final String BIRD1 = "com.hamza";
    ImageView imageView, imageView2, imageView3, imageView4;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.select_bird, container, false);

        imageView =  view.findViewById(R.id.imageView5);
        imageView2 = view.findViewById(R.id.imageView8);
        imageView3 = view.findViewById(R.id.imageView9);
        imageView4 = view.findViewById(R.id.imageView10);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity()!=null){
                    Toast.makeText(getActivity(), "Bird Selected!", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("demo",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("selectedBird",1);
                editor.apply();
                Intent intent = new Intent(getContext(), GameMenu.class);
                startActivity(intent);
                }

//                Intent intent1 = new Intent(getContext(), BirdData.class);
//                startActivity(intent1);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getActivity()!=null){
                    Toast.makeText(getActivity(), "Bird Selected!", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("demo",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("selectedBird",2);
                    editor.apply();
                    Intent intent = new Intent(getContext(), GameMenu.class);
                    startActivity(intent);
                }
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getActivity()!=null){
                    Toast.makeText(getActivity(), "Bird Selected!", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("demo",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("selectedBird",3);
                    editor.apply();
                    Intent intent = new Intent(getContext(), GameMenu.class);
                    startActivity(intent);
                }
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getActivity()!=null){
                    Toast.makeText(getActivity(), "Bird Selected!", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("demo",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("selectedBird",4);
                    editor.apply();
                    Intent intent = new Intent(getContext(), GameMenu.class);
                    startActivity(intent);
                }
            }
        });

//        imageView3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("demo",MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putInt("selectedBird",3);
//                editor.apply();
//            }
//        });
//
//        imageView4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("demo",MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putInt("selectedBird",4);
//                editor.apply();
//            }
//        });

        //creating shared preferences
        //creating shared preferences
//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("demo",MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        editor.putString
//                ("str",msg);
//        editor.apply();
//        textView.setText(msg);
//        Toast.makeText(getContext(), "Bird 1", Toast.LENGTH_SHORT).show();
//        imageView = view.findViewById(R.id.select1);
//        Intent intent = new Intent(getContext(), GameView.class);
//        Bundle extras = new Bundle();
//        extras.putString(BIRD1, imageView + "");
//        intent.putExtras(extras);
//        Toast.makeText(getContext(), "Bird Selected!", Toast.LENGTH_SHORT).show();

        return view;
    }
}
