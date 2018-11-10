using System;
using System.Collections.Generic;

namespace OMSApp.DAL.DatabaseSql
{
    public partial class Transport
    {
        public Transport()
        {
            Product = new HashSet<Product>();
        }

        public int Id { get; set; } 
        public int? SourceCity { get; set; }
        public int? TargetCity { get; set; }
        public DateTime? DepartDate { get; set; }
        public DateTime? ReturnDate { get; set; }
        public string NomEmp { get; set; }
        public string TipoTrans { get; set; }

        public virtual City SourceCityNavigation { get; set; }
        public virtual City TargetCityNavigation { get; set; }
        public virtual ICollection<Product> Product { get; set; }
    }
}
