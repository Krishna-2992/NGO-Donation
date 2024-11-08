    package com.yash.ngodonation.controller;

    import com.yash.ngodonation.domain.Campaign;
    import com.yash.ngodonation.service.CampaignService;
    import com.yash.ngodonation.serviceimpl.CampaignServiceImpl;

    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;


    @WebServlet("/campaignController")
    public class CampaignController extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private CampaignService campaignService;

        public void init() {
            this.campaignService = new CampaignServiceImpl();
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            System.out.println("inside campaign controller");

            // getting all campaigns
            List<Campaign> campaignList = campaignService.getAllCampaigns();
            for(Campaign campaign: campaignList) {
                System.out.println(campaign);
            }
            HttpSession session = request.getSession();
            session.setAttribute("campaignList", campaignList);
            response.sendRedirect("index.jsp");
        }
    }