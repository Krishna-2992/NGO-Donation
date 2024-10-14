package com.yash.DAO;

import java.util.*;

import yash.com.POJO.Campaign;

public interface CampaignDAO 
{
	List<Campaign> getAllCampaigns();
    Campaign getCampaignById(int campaignId);
    void addCampaign(Campaign campaign);
    void updateCampaign(Campaign campaign);
    void deleteCampaign(int campaignId);
}
