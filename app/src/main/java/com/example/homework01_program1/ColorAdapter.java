package com.example.homework01_program1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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

        return convertView;
    }
}