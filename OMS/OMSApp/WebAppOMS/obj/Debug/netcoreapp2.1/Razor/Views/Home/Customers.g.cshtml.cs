#pragma checksum "C:\Pica\pica\OMS\OMSApp\WebAppOMS\Views\Home\Customers.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "7ccbc2c69a52e3dae293036fb1671033b257c90d"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Home_Customers), @"mvc.1.0.view", @"/Views/Home/Customers.cshtml")]
[assembly:global::Microsoft.AspNetCore.Mvc.Razor.Compilation.RazorViewAttribute(@"/Views/Home/Customers.cshtml", typeof(AspNetCore.Views_Home_Customers))]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#line 1 "C:\Pica\pica\OMS\OMSApp\WebAppOMS\Views\_ViewImports.cshtml"
using WebAppOMS;

#line default
#line hidden
#line 2 "C:\Pica\pica\OMS\OMSApp\WebAppOMS\Views\_ViewImports.cshtml"
using WebAppOMS.Models;

#line default
#line hidden
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"7ccbc2c69a52e3dae293036fb1671033b257c90d", @"/Views/Home/Customers.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"1c5f7055368c14ce6b54896cd7c75452f651cedf", @"/Views/_ViewImports.cshtml")]
    public class Views_Home_Customers : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<dynamic>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
#line 1 "C:\Pica\pica\OMS\OMSApp\WebAppOMS\Views\Home\Customers.cshtml"
  
    ViewData["Title"] = "About";

#line default
#line hidden
            BeginContext(41, 4, true);
            WriteLiteral("<h2>");
            EndContext();
            BeginContext(46, 17, false);
#line 4 "C:\Pica\pica\OMS\OMSApp\WebAppOMS\Views\Home\Customers.cshtml"
Write(ViewData["Title"]);

#line default
#line hidden
            EndContext();
            BeginContext(63, 11, true);
            WriteLiteral("</h2>\r\n<h3>");
            EndContext();
            BeginContext(75, 19, false);
#line 5 "C:\Pica\pica\OMS\OMSApp\WebAppOMS\Views\Home\Customers.cshtml"
Write(ViewData["Message"]);

#line default
#line hidden
            EndContext();
            BeginContext(94, 1463, true);
            WriteLiteral(@"</h3>

<button class=""accordion"">Reglas de negocios Usuarios</button>
<div class=""panel"">
    <iframe width=""100%"" height=""400px"" scrolling=""yes"" seamless=""yes"" src=""http://192.168.1.102:4413/openl-tablets-webstudio-5.18.3""></iframe>
</div>
<button class=""accordion"">Usuarios</button>
<div class=""panel"">
    <table class=""table"">
        <thead>
            <tr>
                <th scope=""col"">Id Usuario</th>
                <th scope=""col"">Nombre Usuario</th>
                <th scope=""col"">Correo</th>
                <th scope=""col"">Categoria</th>
                <th scope=""col"">Dirección</th>
                <th scope=""col"">Telefono</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th scope=""row"">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>Otto</td>
                <td>mdo</td>
                <td>mdo</td>
            </tr>
            <tr>
                <th scope=""row"">2</th>
                <");
            WriteLiteral(@"td>Jacob</td>
                <td>Otto</td>
                <td>Thornton</td>
                <td>fat</td>
                <td>mdo</td>
            </tr>
            <tr>
                <th scope=""row"">3</th>
                <td>Larry</td>
                <td>Otto</td>
                <td>the Bird</td>
                <td>twitter</td>
                <td>mdo</td>
            </tr>
        </tbody>
    </table>
</div>
");
            EndContext();
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<dynamic> Html { get; private set; }
    }
}
#pragma warning restore 1591