package com.yash.ngodonation.serviceimpl;

import com.yash.ngodonation.dao.CampaignDAO;
import com.yash.ngodonation.daoimpl.CampaignDAOImpl;
import com.yash.ngodonation.pojo.Campaign;
import com.yash.ngodonation.service.CampaignService;
import com.yash.ngodonation.util.JDBCUtil;

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
    public void addCampaign(com.yash.ngodonation.pojo.Campaign campaign) {
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