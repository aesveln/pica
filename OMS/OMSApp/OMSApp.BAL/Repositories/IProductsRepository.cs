using System;
using System.Collections.Generic;
using System.Text;
using OMSApp.DAL.DatabaseSql;

namespace OMSApp.BAL.Repositories
{
    public interface IProductsRepository
    {
        bool AddProduct(Product product); 
        bool UpdateProduct(Product product);
        bool DeleteProduct(Product product);
        List<Product> GetProductsList(int page, int pageSize);
        Product DetailProducts(int id);
        int GetAllPageProducts(int pageSize);
        List<string> PopulateDropDownProductType();
        Dictionary<int, string> PopulateDropDownLodging(int city);
        Dictionary<int, string> PopulateDropDownTransport(int city);
        Dictionary<int, string> PopulateDropDownSpectacle(int city);
        bool ValidateParameters(Product product);
    }
}
