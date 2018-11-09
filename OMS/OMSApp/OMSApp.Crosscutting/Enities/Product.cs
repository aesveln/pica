using System;
using System.Collections.Generic;

namespace OMSApp.Crosscutting.Entities
{
    public class Product
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

        public virtual Lodging LodgingTypeNavigation { get; set; }
        public virtual Spectacle SpectacleTypeNavigation { get; set; }
        public virtual Transport TransportTypeNavigation { get; set; }
    }
}
