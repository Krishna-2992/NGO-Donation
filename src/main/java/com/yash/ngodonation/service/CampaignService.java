package com.yash.ngodonation.service;

import java.util.List;

import com.yash.ngodonation.domain.Campaign;

public interface CampaignService 
{
    List<Campaign> getAllCampaigns();
    Campaign getCampaignById(int campaignId);
    void addCampaign(Campaign campaign);
    void updateCampaign(Campaign campaign);
    void deleteCampaign(int campaignId);
}