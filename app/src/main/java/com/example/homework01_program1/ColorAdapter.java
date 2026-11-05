package com.example.homework01_program1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//Set up custom adapter.
public class ColorAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorInfo> listOfColors;

    public ColorAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        context = c;
        listOfColors = ls;
    }

    @Override
    public int getCount()
    {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int position)
    {
        return listOfColors.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.colorlistcell, null);
        }

        TextView colorRed= convertView.findViewById(R.id.tv_v_cell_red);
        TextView colorGreen= convertView.findViewById(R.id.tv_v_cell_green);
        TextView colorBlue= convertView.findViewById(R.id.tv_v_cell_blue);
        TextView colorHex= convertView.findViewById(R.id.tv_v_cell_hexNum);

        ColorInfo  color = listOfColors.get(position);

        colorRed.setText("Red: " + color.getRed());
        colorGreen.setText("Green: " + color.getGreen());
        colorBlue.setText("Blue: " + color.getBlue());
        colorHex.setText(color.getHex());

        int rowColor = Color.rgb(
                color.getRed(),
                color.getGreen(),
                color.getBlue()
        );

        convertView.setBackgroundColor(rowColor);
        //Set text color of saved colors.
        int brightness = (color.getRed() * 299 + color.getGreen() * 587 + color.getBlue() * 114) / 1000;

        int textColor;

        if (brightness < 128)
        {
            textColor = Color.WHITE;
        }
        else
        {
            textColor = Color.BLACK;
        }

        colorRed.setTextColor(textColor);
        colorGreen.setTextColor(textColor);
        colorBlue.setTextColor(textColor);
        colorHex.setTextColor(textColor);

        return convertView;
    }
}