using System;
using System.Collections.Generic;

namespace OMSApp.DAL.DatabaseSql
{
    public partial class Spectacle
    {
        public Spectacle()
        {
            Product = new HashSet<Product>();
        }

        public int Id { get; set; } 
        public string Type { get; set; }
        public DateTime? SpectacleDate { get; set; }
        public int? City { get; set; }
        public string NomEmp { get; set; }

        public virtual City CityNavigation { get; set; }
        public virtual ICollection<Product> Product { get; set; }
    }
}
