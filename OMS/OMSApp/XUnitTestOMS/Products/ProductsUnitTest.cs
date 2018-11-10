using System;
using System.Collections.Generic;
using System.Text;
using Moq;
using OMSApp.BAL.Repositories;
using OMSApp.DAL.DatabaseSql;
using OMSApp.DAL.Repositories;
using Xunit;

namespace XUnitTestOMS.Products
{
    public class ProductsUnitTest
    {
        [Fact]
        public void WhenAUserCreateANewProductCorrect()
        {
            ////Arrange
            var valueExpected = true;
            var product = new Product
            {
                Cod = "222",
                Cost = decimal.Parse("2500000"),
                Description = "Description",
                Name = "Name",
                ImageRef = "localhost:8082/"
            };
            var chk = new Mock<IProductsDalRepository>();
            chk.Setup(x => x.InsertProduct(product)).Returns(true);
            ////Act
            var valueActual = new ProductsRepository(chk.Object)
                .AddProduct(product);
            ////Assert
            Assert.Equal(valueExpected,valueActual);
        }

        [Fact]
        public void WhenAUserCreateANewProductNullOrEmptyValues()
        {
            ////Arrange 
            var valueExpected = false;
            var product = new Product
            {
                Cod = "222",
                Cost = decimal.Parse("2500000"),
                Description = null,
                Name = string.Empty,
                ImageRef = null
            };
            var chk = new Mock<IProductsDalRepository>();
            chk.Setup(x => x.InsertProduct(product)).Returns(false);
            ////Act
            var valueActual = new ProductsRepository(chk.Object)
                .AddProduct(product);
            ////Assert
            Assert.Equal(valueExpected, valueActual);
        }

        [Fact]
        public void WhenAUserCreateANewProductFailed()
        {
            ////Arrange
            var valueExpected = false;
            var chk = new Mock<IProductsDalRepository>();
            chk.Setup(x => x.InsertProduct(null)).Returns(null);
            ////Act
            var valueActual = new ProductsRepository(chk.Object)
                .AddProduct(null);
            ////Assert
            Assert.Equal(valueExpected, valueActual);
        }

        [Fact]
        public void WhenAUserCreateANewProductPriceValid()
        {
            ////Arrange
            var valueExpected = false;
            var product = new Product
            {
                Cod = "222",
                Cost = -5000,
                Description = null,
                Name = string.Empty,
                ImageRef = null
            };
            var chk = new Mock<IProductsDalRepository>();
            chk.Setup(x => x.InsertProduct(null)).Returns(null);
            ////Act
            var valueActual = new ProductsRepository(chk.Object)
                .AddProduct(null);
            ////Assert
            Assert.Equal(valueExpected, valueActual);
        }
    }
}
