using System;
using System.Collections.Generic;

namespace OMSApp.DAL.DatabaseSql
{
    public partial class City
    {
        public City()
        {
            Lodging = new HashSet<Lodging>(); 
            Spectacle = new HashSet<Spectacle>();
            TransportSourceCityNavigation = new HashSet<Transport>();
            TransportTargetCityNavigation = new HashSet<Transport>();
        }

        public int Id { get; set; }
        public string Name { get; set; }
        public int? Country { get; set; }

        public virtual Country CountryNavigation { get; set; }
        public virtual ICollection<Lodging> Lodging { get; set; }
        public virtual ICollection<Spectacle> Spectacle { get; set; }
        public virtual ICollection<Transport> TransportSourceCityNavigation { get; set; }
        public virtual ICollection<Transport> TransportTargetCityNavigation { get; set; }
    }
}
