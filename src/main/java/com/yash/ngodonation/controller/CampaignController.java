package com.yash.ngodonation.controller;

import java.util.List;

import com.yash.ngodonation.pojo.*;
import com.yash.ngodonation.service.CampaignService;
import com.yash.ngodonation.serviceimpl.CampaignServiceImpl;

public class CampaignController 
{
    private CampaignService campaignService;

    public CampaignController() {
        campaignService = new CampaignServiceImpl();
    }

    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    public Campaign getCampaignById(int campaignId) {
        return campaignService.getCampaignById(campaignId);
    }

    public void addCampaign(Campaign campaign) {
        campaignService.addCampaign(campaign);
    }

    public void updateCampaign(Campaign campaign) {
        campaignService.updateCampaign(campaign);
    }

    public void deleteCampaign(int campaignId) {
        campaignService.deleteCampaign(campaignId);
    }
}