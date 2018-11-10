using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace WebAppOMS.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index() 
        {
            ViewBag.showError = null;
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult ValidateUser(IFormCollection keys)
        {
            if (true)
            {
                return RedirectToAction("Index", "Home");
            }
            ViewBag.showError = "Usuario o Contraseña errada";
            return View("Index");
        }
    }
}