using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.EntityFrameworkCore;
using OMSApp.DAL.DatabaseSql;
using OMSApp.DAL.Repositories.Base;

namespace OMSApp.DAL.Repositories
{
    public class CampaignDalRepository : GenericCrud<Campaign>, ICampaignDalRepository
    {
        private readonly DataContext _dataContext; 
        public CampaignDalRepository(DataContext dataContext) : base(dataContext)
        {
            _dataContext = dataContext;
        }

        public bool InsertCampaign(Campaign campaign)
        {
            return Add(campaign);
        }

        public bool UpdateAnCampaign(Campaign campaign)
        {
            return Update(campaign, campaign.Id);
        }

        public bool DeleteAnCampaign(Campaign campaign)
        {
            return Delete(campaign);
        }

        public List<Campaign> GetAllCampaign(int page, int pageSize)
        {
            var s = _dataContext.Campaign
                .Include("Product")
                .Take(pageSize * page).Skip((page - 1) * pageSize).ToList();
            return s;
        }

        public Campaign DetailCampaign(int id)
        {
            return _dataContext.Campaign.FirstOrDefault(x => x.Id.Equals(id));
        }

        public int PageCount(int pageSize)
        {
            return GetTotalPage(pageSize);
        }
    }
}
