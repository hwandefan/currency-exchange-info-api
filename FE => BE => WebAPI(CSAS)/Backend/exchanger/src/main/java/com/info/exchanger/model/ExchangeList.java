package com.info.exchanger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

//Model for DB
@Entity
@Table(name="exchange_list")
public class ExchangeList {

    @Id
    @Column(name = "shortName", unique = true)
    private String shortName;

    @Column(name = "validFrom")
    private Date validFrom;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "amount")
    private double amount;

    @Column(name = "valBuy")
    private double valBuy;

    @Column(name = "valSell")
    private double valSell;

    @Column(name = "valMid")
    private double valMid;

    @Column(name = "currBuy")
    private double currBuy;

    @Column(name = "currSell")
    private double currSell;

    @Column(name = "currMid")
    private double currMid;

    @Column(name = "move")
    private double move;

    @Column(name = "cnbMid")
    private double cnbMid;

    @Column(name = "version")
    private double version;

    @Column(name = "ecbMid")
    private double ecbMid;

    public ExchangeList(String shortName, Date validFrom, String name, String country,
                        double amount, double valBuy, double valSell, double valMid,
                        double currBuy, double currSell, double currMid, double move,
                        double cnbMid, double version, double ecbMid) {
        this.shortName = shortName;
        this.validFrom = validFrom;
        this.name = name;
        this.country = country;
        this.amount = amount;
        this.valBuy = valBuy;
        this.valSell = valSell;
        this.valMid = valMid;
        this.currBuy = currBuy;
        this.currSell = currSell;
        this.currMid = currMid;
        this.move = move;
        this.cnbMid = cnbMid;
        this.version = version;
        this.ecbMid = ecbMid;
    }

    public ExchangeList() {

    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getValBuy() {
        return valBuy;
    }

    public void setValBuy(double valBuy) {
        this.valBuy = valBuy;
    }

    public double getValSell() {
        return valSell;
    }

    public void setValSell(double valSell) {
        this.valSell = valSell;
    }

    public double getValMid() {
        return valMid;
    }

    public void setValMid(double valMid) {
        this.valMid = valMid;
    }

    public double getCurrBuy() {
        return currBuy;
    }

    public void setCurrBuy(double currBuy) {
        this.currBuy = currBuy;
    }

    public double getCurrSell() {
        return currSell;
    }

    public void setCurrSell(double currSell) {
        this.currSell = currSell;
    }

    public double getCurrMid() {
        return currMid;
    }

    public void setCurrMid(double currMid) {
        this.currMid = currMid;
    }

    public double getMove() {
        return move;
    }

    public void setMove(double move) {
        this.move = move;
    }

    public double getCnbMid() {
        return cnbMid;
    }

    public void setCnbMid(double cnbMid) {
        this.cnbMid = cnbMid;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public double getEcbMid() {
        return ecbMid;
    }

    public void setEcbMid(double ecbMid) {
        this.ecbMid = ecbMid;
    }
}
