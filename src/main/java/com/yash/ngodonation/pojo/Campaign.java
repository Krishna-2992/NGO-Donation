package com.yash.ngodonation.pojo;


public class Campaign 
{
    private int campaignId;
    private String title;
    private String description;
    private String fundRaise;
    private String targetAmount;
    private String startDate;
    private String endDate;

    // getters and setters
    public int getCampaignId() 
    {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFundRaise() {
        return fundRaise;
    }

    public void setFundRaise(String fundRaise) {
        this.fundRaise = fundRaise;
    }

    public String getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(String targetAmount) {
        this.targetAmount = targetAmount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
}