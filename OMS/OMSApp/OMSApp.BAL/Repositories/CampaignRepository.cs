using System;
using System.Collections.Generic;
using System.Text;
using OMSApp.DAL.DatabaseSql;
using OMSApp.DAL.Repositories;

namespace OMSApp.BAL.Repositories
{
    public class CampaignRepository : ICampaignRepository 
    {
        private readonly ICampaignDalRepository _campaignDalRepository;
        private readonly IProductsRepository _productsRepository;

        public CampaignRepository(
            ICampaignDalRepository campaignDalRepository,
            IProductsRepository productsRepository)
        {
            _campaignDalRepository = campaignDalRepository;
            _productsRepository = productsRepository;
        }

        public bool AddCampaign(Campaign campaign)
        {
            return campaign != null &&
                   ValidateCampaignParameters(campaign) &&
                   _campaignDalRepository.InsertCampaign(campaign);
        }

        public bool UpdateCampaign(Campaign campaign)
        {
            return campaign != null &&
                   ValidateCampaignParameters(campaign) &&
                   _campaignDalRepository.UpdateAnCampaign(campaign);
        }

        public bool DeleteCampaign(Campaign campaign)
        {
            return campaign != null &&
                   ValidateCampaignParameters(campaign) &&
                   _campaignDalRepository.DeleteAnCampaign(campaign);
        }

        public List<Campaign> GetCampaignList(int page, int pageSize)
        {
            return _campaignDalRepository.GetAllCampaign(page, pageSize);
        }

        public Campaign DetailCampaign(int id)
        {
            return _campaignDalRepository.DetailCampaign(id);
        }

        public int GetAllPageCampaign(int pageSize)
        {
            return _campaignDalRepository.PageCount(pageSize);
        }

        public bool ValidateCampaignParameters(Campaign campaign)
        {
            return !string.IsNullOrEmpty(campaign.ImageRef) &&
                   campaign.From != default(DateTime) &&
                   campaign.To != default(DateTime) &&
                   campaign.ProductNavigation != null &&
                   _productsRepository
                       .ValidateParameters(campaign.ProductNavigation);
        }
    }
}
