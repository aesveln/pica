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
@EnableJpaRepositories(entityManagerFactoryRef = "ADMCYOEntityManagerFactory",
        transactionManagerRef = "ADMCYOTransactionManager", basePackages = {"co.com.toures.b2c.touresb2c.ADMCYO.repo"})
public class ADMCYODbConfig {

    @Bean(name = "ADMCYODataSource")
    @ConfigurationProperties(prefix = "ADMCYO.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ADMCYOEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ADMCYOEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("ADMCYODataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("co.com.toures.b2c.touresb2c.ADMCYO.domain").persistenceUnit("ADMCYO")
                .build();
    }

    @Bean(name = "ADMCYOTransactionManager")
    public PlatformTransactionManager ADMCYOTransactionManager(
            @Qualifier("ADMCYOEntityManagerFactory") EntityManagerFactory ADMCYOEntityManagerFactory) {
        return new JpaTransactionManager(ADMCYOEntityManagerFactory);
    }

}