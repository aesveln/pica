using System;
using System.Collections.Generic;
using System.Text;
using Moq;
using mockEntity = OMSApp.DAL.DatabaseSql;

namespace XUnitTestOMS.Products.Mocks
{
    public class MockupProductTest
    { 
        public void mockupCorrectResponse()
        {
            var chk = new Mock<mockEntity.Product>();
            chk.Setup(x => 
                x.Cod.Equals("222") && 
                x.Cost.Equals(decimal.Parse("2500000")) &&
                x.Description.Equals("Description") &&
                x.Name.Equals("Name") &&
                x.ImageRef.Equals("localhos:8082/")).Returns(true);
        }
    }
}
