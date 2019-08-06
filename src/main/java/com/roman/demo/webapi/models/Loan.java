package com.roman.demo.webapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Loan {

    private String id;
    private String url;
    private double revenueRate;
    private int termInMonths;
    private String rating;
    private double remainingInvestment;
    private Date datePublished;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getRevenueRate() {
        return revenueRate;
    }

    public void setRevenueRate(double revenueRate) {
        this.revenueRate = revenueRate;
    }

    public int getTermInMonths() {
        return termInMonths;
    }

    public void setTermInMonths(int termInMonths) {
        this.termInMonths = termInMonths;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getRemainingInvestment() {
        return remainingInvestment;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public void setRemainingInvestment(double remainingInvestment) {
        this.remainingInvestment = remainingInvestment;
    }

    @Override
    public String toString() {
        return id +", "
                + url +", "
                + rating +", "
                + datePublished+", "
                + termInMonths+", "
                + revenueRate;
    }
}