using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Storage;
using OMSApp.DAL.DatabaseSql;

namespace OMSApp.DAL.Repositories.Base
{
    public class GenericCrud<T> where T : class
    {
        private readonly DataContext _dataContext;
        public GenericCrud(DataContext dataContext)
        {
            _dataContext = dataContext;
        }

        public bool Add(T entity)
        {
            _dataContext.Add(entity);
            return _dataContext.SaveChanges() > 1;
        }

        public bool Delete(T entity)
        {
            _dataContext.Remove(entity);
            return _dataContext.SaveChanges() > 1;
        }

        public bool Update(T entity, int id)
        {
            _dataContext.Update(entity);
            return _dataContext.SaveChanges() > 1;
        }

        public int GetTotalPage(int pageSize)
        {
            return _dataContext.Set<T>().Count() / pageSize;
        }

        public Dictionary<int, string> GetLodgingType(int city)
        {
            var listProductType = _dataContext.Lodging
                .Where(x=> x.City.Equals(city)).OrderBy(x => x.NomEmp)
                .Select(x => new
                {
                    key = x.Id,
                    value = x.NomEmp
                });
            return listProductType as Dictionary<int, string>;
        }
        public Dictionary<int, string> GetSpectacleType(int city)
        {
            var listProductType = new Dictionary<int, string>();
            var list = _dataContext.Spectacle
                .Where(x => x.City.Equals(city)).OrderBy(x => x.Type)
                .Select(x => new
                {
                    key = x.Id,
                    value = x.Type
                }).ToDictionary(x => x.value);
            return listProductType;
        }
        public Dictionary<int, string> GetTransportType(int city)
        {
            var listTransportType = new Dictionary<int, string>();
            var list = _dataContext.Transport
                .Where(x => x.SourceCity.Equals(city)).OrderBy(x => x.TipoTrans)
                .Select(x => new
                {
                    key = x.Id,
                    value = x.TipoTrans
                }).ToDictionary(s => s.value);
            return listTransportType;
        }
    }
}
