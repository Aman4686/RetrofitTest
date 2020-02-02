package com.example.retrofitwetherapp.pojo;

public class Wind
{
    private String speed;

    public String getSpeed ()
    {
        return speed;
    }

    public void setSpeed (String speed)
    {
        this.speed = speed;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [speed = "+speed+"]";
    }
}
