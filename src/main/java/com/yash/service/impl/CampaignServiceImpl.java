package com.yash.service.impl;

import com.yash.DAO.CampaignDAO;
import com.yash.DAOImpl.CampaignDAOImpl;
import yash.com.POJO.Campaign;


import com.yash.service.CampaignService;
import com.yash.util.JDBCUtil;

import java.util.List;


public class CampaignServiceImpl implements CampaignService {
    private CampaignDAO campaignDAO;

    public CampaignServiceImpl() {
        JDBCUtil jdbcUtil = new JDBCUtil();
        campaignDAO = new CampaignDAOImpl(jdbcUtil);
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignDAO.getAllCampaigns();
    }

    @Override
    public Campaign getCampaignById(int campaignId) {
        return campaignDAO.getCampaignById(campaignId);
    }

    @Override
    public void addCampaign(yash.com.POJO.Campaign campaign) {
        campaignDAO.addCampaign(campaign);
    }

    @Override
    public void updateCampaign(Campaign campaign) {
        campaignDAO.updateCampaign(campaign);
    }

    @Override
    public void deleteCampaign(int campaignId) {
        campaignDAO.deleteCampaign(campaignId);
    }

}