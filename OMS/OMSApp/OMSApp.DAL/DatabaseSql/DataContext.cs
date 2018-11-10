using Microsoft.EntityFrameworkCore;

namespace OMSApp.DAL.DatabaseSql
{
    public class DataContext : DbContext
    {
        public DataContext() 
        {
        }

        public DataContext(DbContextOptions<DataContext> options)
            : base(options)
        {
        }

        public DbSet<Campaign> Campaign { get; set; }
        public DbSet<City> City { get; set; }
        public DbSet<Country> Country { get; set; }
        public DbSet<Lodging> Lodging { get; set; }
        public DbSet<OpenlRepository> OpenlRepository { get; set; }
        public DbSet<Product> Product { get; set; }
        public DbSet<Spectacle> Spectacle { get; set; }
        public DbSet<Transport> Transport { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder){ }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.HasAnnotation("ProductVersion", "2.2.0-preview3-35497");

            modelBuilder.Entity<Campaign>(entity =>
            {
                entity.ToTable("CAMPAIGN", "ADMPRO");

                entity.HasIndex(e => e.Id)
                    .HasName("CAMPAIGN_Id_uindex")
                    .IsUnique();

                entity.Property(e => e.From)
                    .HasColumnName("from ")
                    .HasColumnType("date");

                entity.Property(e => e.ImageRef)
                    .IsRequired()
                    .HasColumnName("image_ref")
                    .HasMaxLength(100);

                entity.Property(e => e.Product).HasColumnName("product");

                entity.Property(e => e.To)
                    .HasColumnName("to")
                    .HasColumnType("date");

                entity.HasOne(d => d.ProductNavigation)
                    .WithMany(p => p.Campaign)
                    .HasForeignKey(d => d.Product)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("CAMPAIGN_PRODUCT_Id_fk");
            });

            modelBuilder.Entity<City>(entity =>
            {
                entity.ToTable("CITY", "ADMPRO");

                entity.Property(e => e.Id).ValueGeneratedNever();

                entity.Property(e => e.Country).HasColumnName("country");

                entity.Property(e => e.Name)
                    .HasColumnName("name")
                    .HasMaxLength(50);

                entity.HasOne(d => d.CountryNavigation)
                    .WithMany(p => p.City)
                    .HasForeignKey(d => d.Country)
                    .OnDelete(DeleteBehavior.Cascade)
                    .HasConstraintName("CITY_COUNTRY_FK");
            });

            modelBuilder.Entity<Country>(entity =>
            {
                entity.ToTable("COUNTRY", "ADMPRO");

                entity.Property(e => e.Id).ValueGeneratedNever();

                entity.Property(e => e.Name)
                    .HasColumnName("name")
                    .HasMaxLength(50);
            });

            modelBuilder.Entity<Lodging>(entity =>
            {
                entity.ToTable("LODGING", "ADMPRO");

                entity.Property(e => e.Id).ValueGeneratedNever();

                entity.Property(e => e.ArrivalDate)
                    .HasColumnName("arrival_date")
                    .HasColumnType("date");

                entity.Property(e => e.City).HasColumnName("city");

                entity.Property(e => e.DepartureDate)
                    .HasColumnName("departure_date")
                    .HasColumnType("date");

                entity.Property(e => e.NomEmp)
                    .HasColumnName("nom_emp")
                    .HasMaxLength(50);

                entity.HasOne(d => d.CityNavigation)
                    .WithMany(p => p.Lodging)
                    .HasForeignKey(d => d.City)
                    .OnDelete(DeleteBehavior.Cascade)
                    .HasConstraintName("LODGING_CITY_FK");
            });

            modelBuilder.Entity<OpenlRepository>(entity =>
            {
                entity.ToTable("openl_repository");

                entity.HasIndex(e => e.FileName)
                    .HasName("openl_repository_idx");

                entity.Property(e => e.Id).HasColumnName("id");

                entity.Property(e => e.Author)
                    .HasColumnName("author")
                    .HasMaxLength(45);

                entity.Property(e => e.FileComment)
                    .HasColumnName("file_comment")
                    .HasMaxLength(255);

                entity.Property(e => e.FileData).HasColumnName("file_data");

                entity.Property(e => e.FileName)
                    .IsRequired()
                    .HasColumnName("file_name")
                    .HasMaxLength(1000);

                entity.Property(e => e.ModifiedAt)
                    .HasColumnName("modified_at")
                    .HasColumnType("datetime")
                    .HasDefaultValueSql("(getdate())");
            });

            modelBuilder.Entity<Product>(entity =>
            {
                entity.ToTable("PRODUCT", "ADMPRO");

                entity.HasIndex(e => e.Cod)
                    .HasName("PRODUCT_cod_index");

                entity.HasIndex(e => e.Description)
                    .HasName("PRODUCT_description_index");

                entity.HasIndex(e => e.Name)
                    .HasName("PRODUCT_name_index");

                entity.Property(e => e.Id).ValueGeneratedNever();

                entity.Property(e => e.Cod)
                    .HasColumnName("cod")
                    .HasMaxLength(20);

                entity.Property(e => e.Cost)
                    .HasColumnName("cost")
                    .HasColumnType("numeric(18, 0)");

                entity.Property(e => e.Description)
                    .HasColumnName("description")
                    .HasMaxLength(300);

                entity.Property(e => e.ImageRef)
                    .HasColumnName("image_ref")
                    .HasMaxLength(200);

                entity.Property(e => e.LodgingType).HasColumnName("lodging_type");

                entity.Property(e => e.Name)
                    .HasColumnName("name")
                    .HasMaxLength(200);

                entity.Property(e => e.ProductType)
                    .HasColumnName("product_type")
                    .HasMaxLength(1);

                entity.Property(e => e.SpectacleType).HasColumnName("spectacle_type");

                entity.Property(e => e.TransportType).HasColumnName("transport_type");

                entity.HasOne(d => d.LodgingTypeNavigation)
                    .WithMany(p => p.Product)
                    .HasForeignKey(d => d.LodgingType)
                    .OnDelete(DeleteBehavior.Cascade)
                    .HasConstraintName("PRODUCT_LODGING_FK");

                entity.HasOne(d => d.SpectacleTypeNavigation)
                    .WithMany(p => p.Product)
                    .HasForeignKey(d => d.SpectacleType)
                    .OnDelete(DeleteBehavior.Cascade)
                    .HasConstraintName("PRODUCT_SPECTACLE_FK");

                entity.HasOne(d => d.TransportTypeNavigation)
                    .WithMany(p => p.Product)
                    .HasForeignKey(d => d.TransportType)
                    .OnDelete(DeleteBehavior.Cascade)
                    .HasConstraintName("PRODUCT_TRANSPORT_FK");
            });

            modelBuilder.Entity<Spectacle>(entity =>
            {
                entity.ToTable("SPECTACLE", "ADMPRO");

                entity.Property(e => e.Id).ValueGeneratedNever();

                entity.Property(e => e.City).HasColumnName("city");

                entity.Property(e => e.NomEmp)
                    .HasColumnName("nom_emp")
                    .HasMaxLength(50);

                entity.Property(e => e.SpectacleDate)
                    .HasColumnName("spectacle_date")
                    .HasColumnType("date");

                entity.Property(e => e.Type)
                    .HasColumnName("type")
                    .HasMaxLength(20);

                entity.HasOne(d => d.CityNavigation)
                    .WithMany(p => p.Spectacle)
                    .HasForeignKey(d => d.City)
                    .HasConstraintName("SPECTACLE_CITY_FK");
            });

            modelBuilder.Entity<Transport>(entity =>
            {
                entity.ToTable("TRANSPORT", "ADMPRO");

                entity.Property(e => e.Id).ValueGeneratedNever();

                entity.Property(e => e.DepartDate)
                    .HasColumnName("depart_date")
                    .HasColumnType("date");

                entity.Property(e => e.NomEmp)
                    .HasColumnName("nom_emp")
                    .HasMaxLength(50);

                entity.Property(e => e.ReturnDate)
                    .HasColumnName("return_date")
                    .HasColumnType("date");

                entity.Property(e => e.SourceCity).HasColumnName("source_city");

                entity.Property(e => e.TargetCity).HasColumnName("target_city");

                entity.Property(e => e.TipoTrans)
                    .HasColumnName("tipo_trans")
                    .HasMaxLength(2);

                entity.HasOne(d => d.SourceCityNavigation)
                    .WithMany(p => p.TransportSourceCityNavigation)
                    .HasForeignKey(d => d.SourceCity)
                    .HasConstraintName("TRANSPORT_CITY_FK");

                entity.HasOne(d => d.TargetCityNavigation)
                    .WithMany(p => p.TransportTargetCityNavigation)
                    .HasForeignKey(d => d.TargetCity)
                    .HasConstraintName("TRANSPORT_CITY_FK1");
            });
        }
    }
}
