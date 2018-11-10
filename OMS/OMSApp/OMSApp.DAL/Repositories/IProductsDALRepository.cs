using System;
using System.Collections.Generic;
using System.Text;
using OMSApp.DAL.DatabaseSql;

namespace OMSApp.DAL.Repositories
{
    public interface IProductsDalRepository
    {
        bool InsertProduct(Product product); 
        bool UpdateAnProduct(Product product);
        bool DeleteAnProduct(Product product);
        List<Product> GetAllProduct(int page, int pageSize);
        Product DetailProducts(int id);
        IEnumerable<string> PopulateDropDownProductType();
        Dictionary<int, string> PopulateDropDownLodging(int city);
        Dictionary<int, string> PopulateDropDownTransport(int city);
        Dictionary<int, string> PopulateDropDownSpectacle(int city);
        int PageCount(int pageSize);
    }
}
