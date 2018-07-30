package com.inoovalab.aaa.cex.model;

public class WITHDRAWAL {
    private String key;
    private String signature;
    private  long nonce;
    private double amount;
    private String address;
    private  String destination_tag;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public long getNonce() {
        return nonce;
    }

    public void setNonce(long nonce) {
        this.nonce = nonce;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getDestination_tag() {
        return destination_tag;
    }

    public void setDestination_tag(String destination_tag) {
        this.destination_tag = destination_tag;
    }
}
