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
  TextView tv_j_main_Red;
  TextView tv_j_main_Green;
  TextView getTv_j_main_Blue;
  TextView tv_j_main_hexNum;
  SeekBar sb_j_main_Red;
  SeekBar sb_j_main_Green;
  SeekBar sb_j_main_Blue;
  Button btn_j_main_SaveColor;
  ListView lv_j_main_listOfColors;
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

       sb_j_main_Red = findViewById(R.id.sb_v_main_Red);
        sb_j_main_Green = findViewById(R.id.sb_v_main_Green);
        sb_j_main_Blue = findViewById(R.id.sb_v_main_Blue);
        btn_j_main_SaveColor = findViewById(R.id.btn_v_main_SaveColor);
        lv_j_main_listOfColors = findViewById(R.id.lv_v_main_listOfColors);
        tv_j_main_Red = findViewById(R.id.tv_v_main_Red);
        tv_j_main_Green = findViewById(R.id.tv_v_main_Green);
        getTv_j_main_Blue = findViewById(R.id.tv_v_main_Blue);
        tv_j_main_hexNum = findViewById(R.id.tv_v_main_hexNum);
        listOfColors = new ArrayList<>();
        sb_j_main_Red.setMax(255);
        sb_j_main_Red.setProgress(0);
        sb_j_main_Green.setMax(255);
        sb_j_main_Green.setProgress(0);
        sb_j_main_Blue.setMax(255);
        sb_j_main_Blue.setProgress(0);

        sb_j_main_Red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                {
                    tv_j_main_Red.setText("Red: " + progress);
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

        sb_j_main_Green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                {
                    tv_j_main_Green.setText("Green: " + progress);
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

        sb_j_main_Blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                {
                    getTv_j_main_Blue.setText("Blue: " + progress);
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

        btn_j_main_SaveColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                red = sb_j_main_Red.getProgress();
                green = sb_j_main_Green.getProgress();
                blue = sb_j_main_Blue.getProgress();
                String hex = tv_j_main_hexNum.getText().toString();
            }
        });
    }
}