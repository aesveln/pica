using System;
using System.Collections.Generic;

namespace OMSApp.DAL.DatabaseSql
{
    public partial class Campaign
    {
        public int Id { get; set; } 
        public string ImageRef { get; set; }
        public int Product { get; set; }
        public DateTime From { get; set; }
        public DateTime To { get; set; }

        public virtual Product ProductNavigation { get; set; }
    }
}
