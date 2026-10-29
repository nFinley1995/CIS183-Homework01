//=====================================================================
//Author   : Nic Finley
//Date     : 10-30-2026
//Desc     : RGB Color Picker using sliders
//=====================================================================
package com.example.homework01_program1;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
  TextView tv_j_red;
  TextView tv_j_green;
  TextView getTv_j_blue;
  TextView tv_j_hexNum;
  SeekBar sb_j_red;
  SeekBar sb_j_green;
  SeekBar sb_j_blue;
  Button btn_j_saveColor;
  ListView lv_j_listOfColors;
  private ArrayList<ColorInfo> listOfColors;
  ColorAdapter cAdapter;

  View mainLayout;

   int red = 0;
   int green = 0;
   int blue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       sb_j_red = findViewById(R.id.sb_v_red);
        sb_j_green = findViewById(R.id.sb_v_green);
        sb_j_blue = findViewById(R.id.sb_v_blue);
        btn_j_saveColor = findViewById(R.id.btn_v_saveColor);
        lv_j_listOfColors = findViewById(R.id.lv_v_listOfColors);
        tv_j_red = findViewById(R.id.tv_v_red);
        tv_j_green = findViewById(R.id.tv_v_green);
        getTv_j_blue = findViewById(R.id.tv_v_blue);
        tv_j_hexNum = findViewById(R.id.tv_v_hexNum);
        listOfColors = new ArrayList<>();
        sb_j_red.setMax(255);
        sb_j_red.setProgress(255);
        sb_j_green.setMax(255);
        sb_j_green.setProgress(255);
        sb_j_blue.setMax(255);
        sb_j_blue.setProgress(255);

        cAdapter = new ColorAdapter(this, listOfColors);
        lv_j_listOfColors.setAdapter(cAdapter);

        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                {
                    tv_j_red.setText("Red: " + progress);
                }

                updateHex();
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

        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                {
                    tv_j_green.setText("Green: " + progress);
                }

                updateHex();
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

        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                {
                    getTv_j_blue.setText("Blue: " + progress);
                }

                updateHex();
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

        btn_j_saveColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                red = sb_j_red.getProgress();
                green = sb_j_green.getProgress();
                blue = sb_j_blue.getProgress();
                String hex = tv_j_hexNum.getText().toString();
                Log.d("RGB", "Red: " + sb_j_red.getProgress());
                Log.d("RGB", "Green: " + sb_j_green.getProgress());
                Log.d("RGB", "Blue: " + sb_j_blue.getProgress());
                sb_j_red.setProgress(255);
                sb_j_green.setProgress(255);
                sb_j_blue.setProgress(255);
                tv_j_red.setText("Red: " + 255);
                tv_j_green.setText("Green: " + 255);
                getTv_j_blue.setText("Blue: " + 255);
                Log.d("RGB", "Red: " + sb_j_red.getProgress());
                Log.d("RGB", "Green: " + sb_j_green.getProgress());
                Log.d("RGB", "Blue: " + sb_j_blue.getProgress());
            }
        });
    }

    private void updateHex()
    {
        int red = sb_j_red.getProgress();
        int green = sb_j_green.getProgress();
        int blue = sb_j_blue.getProgress();
        String hex = String.format("%02X%02X%02X", red, green, blue);
        tv_j_hexNum.setText("Hex Representation:  #" + hex);
        mainLayout.setBackgroundColor(Color.rgb(red, green, blue));
    }
}