using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebAppOMS.Models
{
    public class LoginViewModel
    {
        [RegularExpression(@"^[0-9a-zA-Z]([-\.\w]*[0-9a-zA-Z])*@(ua)\.(es)$",
            ErrorMessage = "No es un formato del correo.")]
        public string UserName { get; set; } 
        public string Password { get; set; }
    }
}
