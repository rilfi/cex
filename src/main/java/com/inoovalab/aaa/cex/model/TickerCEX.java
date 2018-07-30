package com.inoovalab.aaa.cex.model;

public class TickerCEX
{
    private double timestamp;

    private double last;

    private double volume;

    private double high;

    private double ask;

    private double low;

    private double bid;

    private double volume30d;

    public double getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (double timestamp)
    {
        this.timestamp = timestamp;
    }

    public double getLast ()
    {
        return last;
    }

    public void setLast (double last)
    {
        this.last = last;
    }

    public double getVolume ()
    {
        return volume;
    }

    public void setVolume (double volume)
    {
        this.volume = volume;
    }

    public double getHigh ()
    {
        return high;
    }

    public void setHigh (double high)
    {
        this.high = high;
    }

    public double getAsk ()
    {
        return ask;
    }

    public void setAsk (double ask)
    {
        this.ask = ask;
    }

    public double getLow ()
    {
        return low;
    }

    public void setLow (double low)
    {
        this.low = low;
    }

    public double getBid ()
    {
        return bid;
    }

    public void setBid (double bid)
    {
        this.bid = bid;
    }

    public double getVolume30d ()
    {
        return volume30d;
    }

    public void setVolume30d (double volume30d)
    {
        this.volume30d = volume30d;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [timestamp = "+timestamp+", last = "+last+", volume = "+volume+", high = "+high+", ask = "+ask+", low = "+low+", bid = "+bid+", volume30d = "+volume30d+"]";
    }
}