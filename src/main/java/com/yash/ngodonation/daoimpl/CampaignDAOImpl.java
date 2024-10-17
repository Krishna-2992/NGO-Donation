package com.yash.ngodonation.daoimpl;

import com.yash.ngodonation.dao.CampaignDAO;
import com.yash.ngodonation.pojo.Campaign;
import com.yash.ngodonation.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CampaignDAOImpl implements CampaignDAO {
    private JDBCUtil jdbcUtil;

    public CampaignDAOImpl(JDBCUtil jdbcUtil) {
        this.jdbcUtil = jdbcUtil;
    }

	@Override
    public List<Campaign> getAllCampaigns() {
        List<Campaign> campaigns = new ArrayList<>();
        String query = "SELECT * FROM campaigns";
        Connection conn = jdbcUtil.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Campaign campaign = new Campaign();
                campaign.setCampaignId(rs.getInt("campaign_id"));
                campaign.setTitle(rs.getString("title"));
                campaign.setDescription(rs.getString("description"));
                campaign.setFundRaise(rs.getString("fund_raise"));
                campaign.setTargetAmount(rs.getString("target_amount"));
                campaign.setStartDate(rs.getString("start_date"));
                campaign.setEndDate(rs.getString("end_date"));
                campaigns.add(campaign);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtil.closeConnection(conn);
        }
        return campaigns;
    }

    @Override
    public Campaign getCampaignById(int campaignId) {
        Campaign campaign = null;
        String query = "SELECT * FROM campaigns WHERE campaign_id = ?";
        Connection conn = jdbcUtil.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, campaignId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    campaign = new Campaign();
                    campaign.setCampaignId(rs.getInt("campaign_id"));
                    campaign.setTitle(rs.getString("title"));
                    campaign.setDescription(rs.getString("description"));
                    campaign.setFundRaise(rs.getString("fund_raise"));
                    campaign.setTargetAmount(rs.getString("target_amount"));
                    campaign.setStartDate(rs.getString("start_date"));
                    campaign.setEndDate(rs.getString("end_date"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtil.closeConnection(conn);
        }
        return campaign;
    }

    @Override
    public void addCampaign(Campaign campaign) {
        String query = "INSERT INTO campaigns (title, description, fund_raise, target_amount, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = jdbcUtil.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, campaign.getTitle());
            pstmt.setString(2, campaign.getDescription());
            pstmt.setString(3, campaign.getFundRaise());
            pstmt.setString(4, campaign.getTargetAmount());
            pstmt.setString(5, campaign.getStartDate());
            pstmt.setString(6, campaign.getEndDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtil.closeConnection(conn);
        }
    }

    @Override
    public void updateCampaign(Campaign campaign) {
        String query = "UPDATE campaigns SET title = ?, description = ?, fund_raise = ?, target_amount = ?, start_date = ?, end_date = ? WHERE campaign_id = ?";
        Connection conn = jdbcUtil.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, campaign.getTitle());
            pstmt.setString(2, campaign.getDescription());
            pstmt.setString(3, campaign.getFundRaise());
            pstmt.setString(4, campaign.getTargetAmount());
            pstmt.setString(5, campaign.getStartDate());
            pstmt.setString(6, campaign.getEndDate());
            pstmt.setInt(7, campaign.getCampaignId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtil.closeConnection(conn);
        }
    }

    @Override
    public void deleteCampaign(int campaignId) {
        String query = "DELETE FROM campaigns WHERE campaign_id = ?";
        Connection conn = jdbcUtil.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, campaignId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtil.closeConnection(conn);
        }
    }
}