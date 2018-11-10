using System;
using System.Collections.Generic;

namespace OMSApp.DAL.DatabaseSql
{
    public partial class OpenlRepository
    {
        public long Id { get; set; } 
        public string FileName { get; set; }
        public string Author { get; set; }
        public string FileComment { get; set; }
        public DateTime ModifiedAt { get; set; }
        public byte[] FileData { get; set; }
    }
}
