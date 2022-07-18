package code.spring.config;

import code.spring.model.Customer;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class AppConfig {
    @Bean
    public DataSource getDatasource(){
        BasicDataSource source= new BasicDataSource();
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/hibernateTest");
        source.setUsername("root");
        source.setPassword("root@123");
        return  source;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory(DataSource source) throws IOException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        Properties p = new Properties();
        p.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        p.put("hibernate.hbm2ddl.auto","update");
        sessionFactoryBean.setDataSource(source);
        sessionFactoryBean.setHibernateProperties(p);
        sessionFactoryBean.setAnnotatedClasses(Customer.class);
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransaction(SessionFactory factory){
        HibernateTransactionManager transactionManager =new HibernateTransactionManager();
        transactionManager.setSessionFactory(factory);
        return transactionManager;
    }
}
