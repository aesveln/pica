using System;
using Xunit;
using Moq;
using OMSApp.BAL.Repositories;
using OMSApp.DAL.DatabaseSql;
using OMSApp.DAL.Repositories;

namespace XUnitTestOMS.Campaigns
{
    public class CampaignUnitTest
    {
        [Fact]
        public void WhenAUserCreateANewCampaignCorrect()
        {
            ////Arrange 
            var valueExpected = true;
            var Campaign = new Campaign
            {
                Id = 10,
                Product = 1,
                ImageRef = "localhost:8082/",
                From = DateTime.Today,
                To = DateTime.Today.AddDays(5),
                ProductNavigation = new Product
                {
                    Cod = "222",
                    Cost = decimal.Parse("2500000"),
                    Description = "Description",
                    Name = "Name",
                    ImageRef = "localhost:8082/"
                }
            };
            var chk = new Mock<ICampaignDalRepository>();
            chk.Setup(x => x.InsertCampaign(Campaign)).Returns(true);
            var chkp = new Mock<IProductsRepository>();
            chkp.Setup(x => x.ValidateParameters(Campaign.ProductNavigation))
                .Returns(true);
            ////Act
            var valueActual = new CampaignRepository(chk.Object,chkp.Object)
                .AddCampaign(Campaign);
            ////Assert
            Assert.Equal(valueExpected, valueActual);
        }

        [Fact]
        public void WhenAUserCreateANewCampaignFail()
        {
            ////Arrange
            var valueExpected = false;
            var campaign = new Campaign
            {
                Id = 10,
                Product = 1,
                ImageRef = "localhost:8082/",
                From = DateTime.Today,
                To = DateTime.Today.AddDays(5),
                ProductNavigation = new Product
                {
                    Cod = "222",
                    Cost = -0005,
                    Description = string.Empty,
                    Name = null,
                    ImageRef = "localhost:8082/"
                }
            };
            var chk = new Mock<ICampaignDalRepository>();
            chk.Setup(x => x.InsertCampaign(campaign)).Returns(true);
            var chkp = new Mock<IProductsRepository>();
            chkp.Setup(x => x.ValidateParameters(campaign.ProductNavigation))
                .Returns(false);
            ////Act
            var valueActual = new CampaignRepository(chk.Object, chkp.Object)
                .AddCampaign(campaign);
            ////Assert
            Assert.Equal(valueExpected, valueActual);
        }

        [Fact]
        public void WhenAUserCreateANewCampaignFailProductIsNull()
        {
            ////Arrange
            var valueExpected = false;
            var campaign = new Campaign
            {
                Id = 10,
                Product = 1,
                ImageRef = "localhost:8082/",
                From = DateTime.Today,
                To = DateTime.Today.AddDays(5),
                ProductNavigation = null
            };
            var chk = new Mock<ICampaignDalRepository>();
            chk.Setup(x => x.InsertCampaign(campaign)).Returns(true);
            var chkp = new Mock<IProductsRepository>();
            chkp.Setup(x => x.ValidateParameters(campaign.ProductNavigation))
                .Returns(true);
            ////Act
            var valueActual = new CampaignRepository(chk.Object, chkp.Object)
                .AddCampaign(campaign);
            ////Assert
            Assert.Equal(valueExpected, valueActual);
        }

        [Fact]
        public void WhenAUserCreateANewCampaignWithNullOrEmptyValues()
        {
            ////Arrange
            var valueExpected = false;
            var chk = new Mock<ICampaignDalRepository>();
            chk.Setup(x => x.InsertCampaign(null)).Returns(null);
            var chkp = new Mock<IProductsRepository>();
            chkp.Setup(x => x.ValidateParameters(null))
                .Returns(true);
            ////Act
            var valueActual = new CampaignRepository(chk.Object, chkp.Object)
                .AddCampaign(null);
            ////Assert
            Assert.Equal(valueExpected, valueActual);
        }
    }
}
