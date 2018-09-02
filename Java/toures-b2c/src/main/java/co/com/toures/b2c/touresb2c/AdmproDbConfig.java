package co.com.toures.b2c.touresb2c;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "AdmproEntityManagerFactory",
        transactionManagerRef = "AdmproTransactionManager", basePackages = {"co.com.toures.b2c.touresb2c.Admpro.repo"})
public class AdmproDbConfig {

    @Bean(name = "AdmproDataSource")
    @ConfigurationProperties(prefix = "Admpro.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "AdmproEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean AdmproEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("AdmproDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("co.com.toures.b2c.touresb2c.Admpro.domain").persistenceUnit("Admpro")
                .build();
    }

    @Bean(name = "AdmproTransactionManager")
    public PlatformTransactionManager AdmproTransactionManager(
            @Qualifier("AdmproEntityManagerFactory") EntityManagerFactory AdmproEntityManagerFactory) {
        return new JpaTransactionManager(AdmproEntityManagerFactory);
    }

}