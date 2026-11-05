//=====================================================================
//Author   : Nic Finley
//Date     : 11-08-2026
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
  //variable and GUI declaration.
  TextView tv_j_main_red;
  TextView tv_j_main_green;
  TextView tv_j_main_blue;
  TextView tv_j_main_hexNum;
  SeekBar sb_j_main_red;
  SeekBar sb_j_main_green;
  SeekBar sb_j_main_blue;
  Button btn_j_main_saveColor;
  ListView lv_j_main_listOfColors;
  private ArrayList<ColorInfo> listOfColors;
  ColorAdapter cAdapter;

  View mainLayout;

   int red = 0;
   int green = 0;
   int blue = 0;
   boolean yIQ;

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

       sb_j_main_red = findViewById(R.id.sb_v_main_red);
        sb_j_main_green = findViewById(R.id.sb_v_main_green);
        sb_j_main_blue = findViewById(R.id.sb_v_main_blue);
        btn_j_main_saveColor = findViewById(R.id.btn_v_main_saveColor);
        lv_j_main_listOfColors = findViewById(R.id.lv_v_main_listOfColors);
        tv_j_main_red = findViewById(R.id.tv_v_main_red);
        tv_j_main_green = findViewById(R.id.tv_v_main_green);
        tv_j_main_blue = findViewById(R.id.tv_v_main_blue);
        tv_j_main_hexNum = findViewById(R.id.tv_v_main_hexNum);
        sb_j_main_red.setMax(255);
        sb_j_main_red.setProgress(255);
        sb_j_main_green.setMax(255);
        sb_j_main_green.setProgress(255);
        sb_j_main_blue.setMax(255);
        sb_j_main_blue.setProgress(255);

        listOfColors = new ArrayList<>();
        cAdapter = new ColorAdapter(this, listOfColors);
        lv_j_main_listOfColors.setAdapter(cAdapter);

        sb_j_main_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                {
                    tv_j_main_red.setText("Red: " + progress);
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

        sb_j_main_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                {
                    tv_j_main_green.setText("Green: " + progress);
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

        sb_j_main_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                {
                    tv_j_main_blue.setText("Blue: " + progress);
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

        btn_j_main_saveColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                red = sb_j_main_red.getProgress();
                green = sb_j_main_green.getProgress();
                blue = sb_j_main_blue.getProgress();
                String hex = tv_j_main_hexNum.getText().toString();
                ColorInfo newColor = new ColorInfo(red, green, blue, hex);
                listOfColors.add(newColor);
                cAdapter.notifyDataSetChanged();
                sb_j_main_red.setProgress(255);
                sb_j_main_green.setProgress(255);
                sb_j_main_blue.setProgress(255);
                tv_j_main_red.setText("Red: " + 255);
                tv_j_main_green.setText("Green: " + 255);
                tv_j_main_blue.setText("Blue: " + 255);
                updateHex();
            }
        });

        lv_j_main_listOfColors.setOnItemClickListener((parent, view, position, id) ->
        {
            // Get the selected color
            ColorInfo selectedColor = listOfColors.get(position);

            // Restore RGB values to the SeekBars
            sb_j_main_red.setProgress(selectedColor.getRed());
            sb_j_main_green.setProgress(selectedColor.getGreen());
            sb_j_main_blue.setProgress(selectedColor.getBlue());
            tv_j_main_red.setText("Red: " + selectedColor.getRed());
            tv_j_main_green.setText("Green: " + selectedColor.getGreen());
            tv_j_main_blue.setText("Blue: " + selectedColor.getBlue());
        });

    }

    //Convert RGB to Hex.
    private void updateHex()
    {
        int red = sb_j_main_red.getProgress();
        int green = sb_j_main_green.getProgress();
        int blue = sb_j_main_blue.getProgress();
        String hex = String.format("%02X%02X%02X", red, green, blue);
        tv_j_main_hexNum.setText("Hex Representation:  #" + hex);
        mainLayout.setBackgroundColor(Color.rgb(red, green, blue));
        textColor(red, green, blue);
    }

    //Set text color.
    private void textColor(int red, int green, int blue)
    {
        int brightness = (red * 299 + green * 587 + blue * 114) / 1000;

        int textColor;

        if (brightness < 128)
        {
            yIQ = true;
        }
        else
        {
            yIQ = false;
        }

        if (yIQ == true)
        {
            textColor = Color.WHITE;
        }
        else
        {
            textColor = Color.BLACK;
        }

        tv_j_main_red.setTextColor(textColor);
        tv_j_main_green.setTextColor(textColor);
        tv_j_main_blue.setTextColor(textColor);
        tv_j_main_hexNum.setTextColor(textColor);
    }
}