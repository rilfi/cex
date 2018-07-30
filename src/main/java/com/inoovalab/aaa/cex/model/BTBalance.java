package com.inoovalab.aaa.cex.model;

public class BTBalance
{
    private double fee;

    private double eur_balance;

    private double xrp_reserved;

    private double xrp_balance;

    private double eur_available;

    private double eur_reserved;

    private double xrp_available;

    public double getFee ()
    {
        return fee;
    }

    public void setFee (double fee)
    {
        this.fee = fee;
    }

    public double getEur_balance ()
    {
        return eur_balance;
    }

    public void setEur_balance (double eur_balance)
    {
        this.eur_balance = eur_balance;
    }

    public double getXrp_reserved ()
    {
        return xrp_reserved;
    }

    public void setXrp_reserved (double xrp_reserved)
    {
        this.xrp_reserved = xrp_reserved;
    }

    public double getXrp_balance ()
    {
        return xrp_balance;
    }

    public void setXrp_balance (double xrp_balance)
    {
        this.xrp_balance = xrp_balance;
    }

    public double getEur_available ()
    {
        return eur_available;
    }

    public void setEur_available (double eur_available)
    {
        this.eur_available = eur_available;
    }

    public double getEur_reserved ()
    {
        return eur_reserved;
    }

    public void setEur_reserved (double eur_reserved)
    {
        this.eur_reserved = eur_reserved;
    }

    public double getXrp_available ()
    {
        return xrp_available;
    }

    public void setXrp_available (double xrp_available)
    {
        this.xrp_available = xrp_available;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [fee = "+fee+", eur_balance = "+eur_balance+", xrp_reserved = "+xrp_reserved+", xrp_balance = "+xrp_balance+", eur_available = "+eur_available+", eur_reserved = "+eur_reserved+", xrp_available = "+xrp_available+"]";
    }
}