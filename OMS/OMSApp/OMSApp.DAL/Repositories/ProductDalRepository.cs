using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.EntityFrameworkCore;
using OMSApp.DAL.DatabaseSql;
using OMSApp.DAL.Repositories.Base;

namespace OMSApp.DAL.Repositories
{
    public class ProductDalRepository : GenericCrud<Product>, IProductsDalRepository
    {
        private readonly DataContext _dataContext; 

        public ProductDalRepository(DataContext dataContext) : base(dataContext)
        {
            _dataContext = dataContext;
        }

        public bool InsertProduct(Product product)
        {
            return Add(product);
        }

        public bool UpdateAnProduct(Product product)
        {
            return Update(product, product.Id);
        }

        public bool DeleteAnProduct(Product product)
        {
            return Delete(product);
        }

        public List<Product> GetAllProduct(int page, int pageSize)
        {
            var s = _dataContext.Product
                .Include("SpectacleTypeNavigation")
                .Include("LodgingTypeNavigation")
                .Include("TransportTypeNavigation")
                .Include("Campaign")
                .Take(pageSize * page).Skip((page - 1) * pageSize).ToList();
            return s;
        }

        public Product DetailProducts(int id)
        {
            return _dataContext.Product.FirstOrDefault(x => x.Id.Equals(id));
        }

        public IEnumerable<string> PopulateDropDownProductType()
        {
            return _dataContext.Product.GroupBy(x => x.ProductType).Select(s => s.Key).ToList();
        }

        public Dictionary<int, string> PopulateDropDownLodging(int city)
        {
            return GetLodgingType(city);
        }

        public Dictionary<int, string> PopulateDropDownTransport(int city)
        {
            return GetTransportType(city);
        }

        public Dictionary<int, string> PopulateDropDownSpectacle(int city)
        {
            return GetSpectacleType(city);
        }

        public int PageCount(int pageSize)
        {
            return GetTotalPage(pageSize);
        }
    }
}
