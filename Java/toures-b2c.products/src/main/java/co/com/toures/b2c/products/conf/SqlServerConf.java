package co.com.toures.b2c.products.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "sqlserverEntityManager",
        transactionManagerRef = "sqlserverTransactionManager",
        basePackages = "co.com.toures.b2c.products.dao.admpro"
)
public class SqlServerConf {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.admpro.datasource")
    public DataSource sqlserverDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Primary
    @Bean(name = "sqlserverEntityManager")
    public LocalContainerEntityManagerFactoryBean sqlserverEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(sqlserverDataSource())
                .properties(hibernateProperties())
                .packages("co.com.toures.b2c.products.entity.admpro")
                .persistenceUnit("sqlserverPU")
                .build();
    }

    @Primary
    @Bean(name = "sqlserverTransactionManager")
    public PlatformTransactionManager sqlserverTransactionManager(@Qualifier("sqlserverEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    private Map<String, Object> hibernateProperties() {

        Resource resource = new ClassPathResource("hibernate.properties");
        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            return properties.entrySet().stream()
                    .collect(Collectors.toMap(
                            e -> e.getKey().toString(),
                            e -> e.getValue())
                    );
        } catch (IOException e) {
            return new HashMap<String, Object>();
        }
    }
}