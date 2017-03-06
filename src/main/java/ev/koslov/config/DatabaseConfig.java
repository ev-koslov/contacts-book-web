package ev.koslov.config;

import ev.koslov.db.AccountDAO;
import ev.koslov.db.ContactDAO;
import ev.koslov.db.dao_impl.JpaAccountDAO;
import ev.koslov.db.dao_impl.JpaContactDAO;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SQL database configuration
 */

@Configuration
@EnableJpaRepositories("ev.koslov.db.repository")
@EntityScan("ev.koslov.db.entity")
@EnableTransactionManagement
public class DatabaseConfig {

//    //These 3 params we should get from external config file
//    private static final String DATABASE_URL = "db.url";
//    private static final String DATABASE_USERNAME = "db.username";
//    private static final String DATABASE_PASSWORD = "db.password";
//
//
//    //These params are hard-coded in application.properties file. Only MySQL database is allowed now
//    //Todo: add some database support
//    private static final String DATABASE_DRIVER = "db.driver";
//    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
//    private static final String ENTITY_MANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
//    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
//    private static final String HOW_TO_OPERATE_WITH_DB = "hibernate.hbm2ddl.auto";
//
//    @Resource
//    private Environment environment;
//
//    /**
//     * This bean creates entity manager factory. This bean makes spring to access sql database
//     * @return configured entity manager factory
//     */
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource());
//        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        entityManagerFactoryBean.setPackagesToScan(environment.getRequiredProperty(ENTITY_MANAGER_PACKAGES_TO_SCAN));
//        entityManagerFactoryBean.setJpaProperties(hibProperties());
//        return entityManagerFactoryBean;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(environment.getRequiredProperty(DATABASE_DRIVER));
//        dataSource.setUrl(environment.getRequiredProperty(DATABASE_URL));
//        dataSource.setUsername(environment.getRequiredProperty(DATABASE_USERNAME));
//        dataSource.setPassword(environment.getRequiredProperty(DATABASE_PASSWORD));
//        return dataSource;
//    }
//
//    private Properties hibProperties() {
//        Properties properties = new Properties();
//        properties.put(HIBERNATE_DIALECT, environment.getRequiredProperty(HIBERNATE_DIALECT));
//        properties.put(HIBERNATE_SHOW_SQL, environment.getRequiredProperty(HIBERNATE_SHOW_SQL));
//        properties.put(HOW_TO_OPERATE_WITH_DB, environment.getRequiredProperty(HOW_TO_OPERATE_WITH_DB));
//        return properties;
//    }
//
//    //This bean enable transaction managing in sql databases
//    @Bean
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return transactionManager;
//    }

    //creating condition dependent beans.

    @Bean
    public AccountDAO getAccountDAO(){
        return new JpaAccountDAO();
    }

    @Bean
    public ContactDAO getContactDAO(){
        return new JpaContactDAO();
    }

}
