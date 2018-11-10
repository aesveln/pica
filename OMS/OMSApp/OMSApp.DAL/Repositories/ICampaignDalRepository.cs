using System;
using System.Collections.Generic;
using System.Text;
using OMSApp.DAL.DatabaseSql;

namespace OMSApp.DAL.Repositories
{
    public interface ICampaignDalRepository
    {
        bool InsertCampaign(Campaign campaign); 
        bool UpdateAnCampaign(Campaign campaign);
        bool DeleteAnCampaign(Campaign campaign);
        List<Campaign> GetAllCampaign(int page, int pageSize);
        Campaign DetailCampaign(int id);
        int PageCount(int pageSize);
    }
}


