using System;
using System.Collections.Generic;

namespace OMSApp.Crosscutting.Entities
{
    public partial class Lodging
    {
        public Lodging()
        {
            Product = new HashSet<Product>();
        }

        public int Id { get; set; }
        public DateTime? ArrivalDate { get; set; }
        public DateTime? DepartureDate { get; set; }
        public int? City { get; set; }
        public string NomEmp { get; set; }

        public virtual City CityNavigation { get; set; }
        public virtual ICollection<Product> Product { get; set; }
    }
}
