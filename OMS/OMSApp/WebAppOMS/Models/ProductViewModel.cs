using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using OMSApp.DAL.DatabaseSql;

namespace WebAppOMS.Models
{
    public class ProductViewModel
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
        public List<string> ProductType { get; set; }
        public Lodging LodgingTypeNavigation { get; set; }
        public Spectacle SpectacleTypeNavigation { get; set; }
        public Transport TransportTypeNavigation { get; set; }
        public ICollection<Campaign> Campaign { get; set; }
    }
}
