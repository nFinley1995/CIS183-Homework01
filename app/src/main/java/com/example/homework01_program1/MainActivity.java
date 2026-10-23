//=====================================================================
//Author   : Nic Finley
//Date     : 10-30-2026
//Desc     : RGB Color Picker using sliders
//=====================================================================
package com.example.homework01_program1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
  TextView redTextView;
  TextView greenTextView;
  TextView blueTextView;
  TextView hexNumTextView;
  SeekBar redSeekBar;
  SeekBar greenSeekBar;
  SeekBar blueSeekBar;
  Button saveColorButton;
  ListView listView;
  private ArrayList<ColorInfo> listOfColors;

   int red = 0;
   int green = 0;
   int blue = 0;
   String hex = "00";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       redSeekBar = findViewById(R.id.sb_v_main_Red);
        greenSeekBar = findViewById(R.id.sb_v_main_Green);
        blueSeekBar = findViewById(R.id.sb_v_main_Blue);
        saveColorButton = findViewById(R.id.btn_v_main_SaveColor);
        listView = findViewById(R.id.lv_v_main_listOfColors);
        redTextView = findViewById(R.id.tv_v_main_Red);
        greenTextView = findViewById(R.id.tv_v_main_Green);
        blueTextView = findViewById(R.id.tv_v_main_Blue);
        hexNumTextView = findViewById(R.id.tv_v_main_hexNum);
        listOfColors = new ArrayList<>();
        redSeekBar.setMax(255);
        redSeekBar.setProgress(0);
        greenSeekBar.setMax(255);
        greenSeekBar.setProgress(0);
        blueSeekBar.setMax(255);
        blueSeekBar.setProgress(0);


        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                {
                    redTextView.setText("Red: " + progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                {
                    greenTextView.setText("Green: " + progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                {
                    blueTextView.setText("Blue: " + progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        saveColorButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                red = redSeekBar.getProgress();
                green = greenSeekBar.getProgress();
                blue = blueSeekBar.getProgress();
            }
        });
    }
}