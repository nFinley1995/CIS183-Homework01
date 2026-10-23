package com.example.homework01_program1;

public class ColorInfo
{
    private int red;
    private int green;
    private int blue;
    private String hex;

    public ColorInfo()
    {
        red = 0;
        green = 0;
        blue = 0;
        hex = "#000000";
    }

    public ColorInfo(int R, int G, int B, String H)
    {
        red = R;
        green = G;
        blue = B;
        hex = H;
    }


    public int getRed()
    {
        return red;
    }

    public int getGreen()
    {
        return green;
    }

    public int getBlue()
    {
        return blue;
    }

    public String getHex()
    {
        return hex;
    }

    public void setRed(int red)
    {
        this.red = red;
    }

    public void setGreen(int green)
    {
        this.green = green;
    }

    public void setBlue(int blue)
    {
        this.blue = blue;
    }

    public void setHex(String hex)
    {
        this.hex = hex;
    }

    @Override
    public String toString()
    {
        return hex;
    }
}
