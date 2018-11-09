using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using OMSApp.DAL.DatabaseSql;
using OMSApp.DAL.Repositories;

namespace OMSApp.BAL.Repositories
{
    public class ProductsRepository : IProductsRepository 
    {
        private readonly IProductsDalRepository _productsDalRepository;

        public ProductsRepository(IProductsDalRepository productsDalRepository)
        {
            _productsDalRepository = productsDalRepository;
        }

        public bool AddProduct(Product product)
        {
            return product != null &&
                    ValidateParameters(product) &&
                   _productsDalRepository.InsertProduct(product);
        }

        public bool UpdateProduct(Product product)
        {
            return product != null && 
                   ValidateParameters(product) &&
                   _productsDalRepository.UpdateAnProduct(product);
        }

        public bool DeleteProduct(Product product)
        {
            return product != null && 
                   ValidateParameters(product) &&
                   _productsDalRepository.DeleteAnProduct(product);
        }

        public List<Product> GetProductsList(int page, int pageSize)
        {
            return _productsDalRepository.GetAllProduct(page, pageSize);
        }

        public Product DetailProducts(int id)
        {
            return _productsDalRepository.DetailProducts(id);
        }

        public int GetAllPageProducts(int pageSize)
        {
            return _productsDalRepository.PageCount(pageSize);
        }

        public List<string> PopulateDropDownProductType()
        {
            return _productsDalRepository.PopulateDropDownProductType().ToList();
        }
        public Dictionary<int, string> PopulateDropDownLodging(int city)
        {
            return _productsDalRepository.PopulateDropDownLodging(city);
        }

        public Dictionary<int, string> PopulateDropDownTransport(int city)
        {
            return _productsDalRepository.PopulateDropDownTransport(city);
        }

        public Dictionary<int, string> PopulateDropDownSpectacle(int city)
        {
            return _productsDalRepository.PopulateDropDownSpectacle(city);
        }

        public bool ValidateParameters(Product product)
        {
            return !string.IsNullOrEmpty(product.Cod) &&
                   product.Cost != null &&
                   product.Cost > 0 &&
                   !string.IsNullOrEmpty(product.Name) &&
                   !string.IsNullOrEmpty(product.Description);
        }
    }
}
