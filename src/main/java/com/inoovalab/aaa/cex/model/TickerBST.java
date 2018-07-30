package com.inoovalab.aaa.cex.model;

public class TickerBST
{
    private double timestamp;

    private double open;

    private double vwap;

    private double last;

    private double volume;

    private double high;

    private double ask;

    private double low;

    private double bid;

    public double getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (double timestamp)
    {
        this.timestamp = timestamp;
    }

    public double getOpen ()
    {
        return open;
    }

    public void setOpen (double open)
    {
        this.open = open;
    }

    public double getVwap ()
    {
        return vwap;
    }

    public void setVwap (double vwap)
    {
        this.vwap = vwap;
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

    @Override
    public String toString()
    {
        return "ClassPojo [timestamp = "+timestamp+", open = "+open+", vwap = "+vwap+", last = "+last+", volume = "+volume+", high = "+high+", ask = "+ask+", low = "+low+", bid = "+bid+"]";
    }
}