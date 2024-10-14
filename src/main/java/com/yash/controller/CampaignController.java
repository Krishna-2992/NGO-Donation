package com.yash.controller;

import yash.com.POJO.*;
import com.yash.service.CampaignService;
import com.yash.service.impl.CampaignServiceImpl;

import java.util.List;

public class CampaignController {
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