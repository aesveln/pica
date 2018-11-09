using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OMSApp.Models
{
    public class MarketingViewModel
    {
        public int Id { get; set; }
        public string Cod { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public decimal? Cost { get; set; }
        public string ImageRef { get; set; }
        public int? TransportType { get; set; }
        public int? SpectacleType { get; set; }
        public int? LodgingType { get; set; }
        public string ProductType { get; set; }
        //public bool IsSaleCampaign { get; set; }
    }
}
