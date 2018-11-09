using System;
using System.Collections.Generic;
using System.Text;
using OMSApp.DAL.DatabaseSql;

namespace OMSApp.BAL.Repositories
{
    public interface ICampaignRepository 
    {
        bool AddCampaign(Campaign campaign);
        bool UpdateCampaign(Campaign campaign);
        bool DeleteCampaign(Campaign campaign);
        List<Campaign> GetCampaignList(int page, int pageSize);
        Campaign DetailCampaign(int id);
        int GetAllPageCampaign(int pageSize);
    }
}
