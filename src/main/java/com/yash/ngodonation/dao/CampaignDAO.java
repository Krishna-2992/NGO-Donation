package com.yash.ngodonation.dao;

import java.util.*;

import com.yash.ngodonation.pojo.Campaign;

public interface CampaignDAO 
{
	List<Campaign> getAllCampaigns();
    Campaign getCampaignById(int campaignId);
    void addCampaign(Campaign campaign);
    void updateCampaign(Campaign campaign);
    void deleteCampaign(int campaignId);
}
