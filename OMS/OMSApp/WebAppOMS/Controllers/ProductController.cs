using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using OMSApp.BAL.Repositories;
using OMSApp.DAL.DatabaseSql;
using WebAppOMS.Models;

namespace WebAppOMS.Controllers
{
    public class ProductController : Controller
    {
        private readonly IProductsRepository _productsRepository;
        public ProductController(IProductsRepository productsRepository)
        {
            _productsRepository = productsRepository;
        }
        // GET: Product
        public ActionResult Index()
        {
            int page = 1;
            int pageSize = 20;
            var model = new List<Product>();
            var totalPages = _productsRepository.GetAllPageProducts(pageSize);
            model = _productsRepository.GetProductsList(page, pageSize).ToList();
            
            return View(model);
        }

        // GET: Product/Create
        public ActionResult Create()
        {
            var model = new ProductViewModel();
            model.ProductType = _productsRepository.PopulateDropDownProductType();

            return View(model);
        }

        public ActionResult CreateProduct(ProductViewModel collection)
        {
            var newItem = new Product
            { 
                LodgingTypeNavigation = collection.LodgingTypeNavigation,
                SpectacleTypeNavigation = collection.SpectacleTypeNavigation,
                TransportTypeNavigation = collection.TransportTypeNavigation,
                Cod = collection.Cod,
                Id = collection.Id,
                Campaign = new List<Campaign>(),
                ProductType = collection?.ProductType?.FirstOrDefault()?? "L",
                Name = collection.Name,
                SpectacleType = collection.SpectacleType,
                TransportType = collection.TransportType,
                Description = collection.Description,
                Cost = collection.Cost,
                LodgingType = collection.LodgingType,
                ImageRef = collection.ImageRef
            };

            _productsRepository.AddProduct(newItem);

            return RedirectToAction("Index");
        }
        // GET: Product/Edit/5
        public ActionResult Edit(Product collection)
        {
            return View(collection);
        }

        public ActionResult EditProduct(Product collection)
        {
            _productsRepository.UpdateProduct(collection);
            return RedirectToAction("Index");
        }

        // GET: Product/Delete/5
        public ActionResult Delete(ProductViewModel collection)
        {
            return View();
        }
    }
}