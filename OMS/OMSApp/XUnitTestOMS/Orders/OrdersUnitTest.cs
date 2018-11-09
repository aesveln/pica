using Moq;
using OMSApp.BAL.Repositories;
using OMSApp.DAL.DatabaseSql;
using OMSApp.DAL.Repositories;
using Xunit;

namespace XUnitTestOMS.Orders
{
    public class OrdersUnitTest
    {
        //[Fact]
        //public void WhenAUserRequestHisOrdersCorrect()
        //{
        //    ////Arrange
        //    var valueExpected = true;
        //    var product = new Product
        //    {
        //        Cod = "222",
        //        Cost = decimal.Parse("2500000"),
        //        Description = "Description",
        //        Name = "Name",
        //        ImageRef = "localhost:8082/"
        //    };
        //    var chk = new Mock<IProductsDalRepository>();
        //    chk.Setup(x => x.InsertProduct(product)).Returns(true);
        //    ////Act
        //    var valueActual = new ProductsRepository(chk.Object)
        //        .AddProduct(product);
        //    ////Assert
        //    Assert.Equal(valueExpected, valueActual);
        //}

        //[Fact]
        //public void WhenAUserRequestHisOrdersFail()
        //{
        //    ////Arrange
        //    var valueExpected = true;
        //    var product = new Product
        //    { 
        //        Cod = "222",
        //        Cost = decimal.Parse("2500000"),
        //        Description = "Description",
        //        Name = "Name",
        //        ImageRef = "localhost:8082/"
        //    };
        //    var chk = new Mock<IProductsDalRepository>();
        //    chk.Setup(x => x.InsertProduct(product)).Returns(false);
        //    ////Act
        //    var valueActual = new ProductsRepository(chk.Object)
        //        .AddProduct(product);
        //    ////Assert
        //    Assert.Equal(valueExpected, valueActual);
        //}

        //[Fact]
        //public void WhenAUserRequestHisOrdersNull()
        //{
        //    ////Arrange
        //    var valueExpected = true;
        //    var chk = new Mock<IProductsDalRepository>();
        //    chk.Setup(x => x.InsertProduct(null)).Returns(false);
        //    ////Act
        //    var valueActual = new ProductsRepository(chk.Object)
        //        .AddProduct(null);
        //    ////Assert
        //    Assert.Equal(valueExpected, valueActual);
        //}
    }
}
