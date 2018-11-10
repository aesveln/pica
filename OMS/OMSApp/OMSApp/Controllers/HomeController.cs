using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using OMSApp.Models;
using OMSApp.BAL;
namespace OMSApp.Controllers
{
    public class HomeController : Controller
    {
        private const int _pageSize = 10;
        private readonly IProductsRepository _productsRepository;
        public HomeController(
            DataContext context,
            IProductsRepository productsRepository
            )
        {
            _productsRepository = productsRepository;
        }

        public IActionResult Index()
        {
            return View();
        }

        public IActionResult Marketing(int searchString, int? page)
        {

            if (searchString == null || page == null)
            {
                page = 1;
            }

            var model = new List<MarketingViewModel>();
            var pageNumber = (page ?? 1);
            var idss = _productsRepository.GetProductById(searchString);
            foreach (var x in _productsRepository.GetAllProducts())//.ToPagedList(pageNumber, _pageSize))
            {
                model.Add(new MarketingViewModel
                {
                    Id = x.Id,
                    Description = x.Description,
                    Cost = x.Cost,
                    Cod = x.Cod,
                    ImageRef = x.ImageRef,
                    LodgingType = x.LodgingType,
                    Name = x.Name,
                    ProductType = x.ProductType,
                    SpectacleType = x.SpectacleType,
                    TransportType = x.TransportType
                });
            }

            return View(model); //.ToPagedList(pageNumber, _pageSize));

        }

        public IActionResult Orders()
        {
            return View();
        }

        public IActionResult Customers()
        {
            return View();
        }
        

        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
