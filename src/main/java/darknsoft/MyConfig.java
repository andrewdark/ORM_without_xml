package darknsoft;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Properties;

import javax.sql.DataSource;

@Configuration
public class MyConfig {

  @Bean
  public BasicDataSource dataSource() {
    BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
    ds.setUrl("jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC&useSSL=false");
    ds.setUsername("root");
    ds.setPassword("hillel");
    ds.setInitialSize(5);
    ds.setMaxTotal(10);
    return ds;
  }
  @Bean
  public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
    LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
    sfb.setDataSource(dataSource);
    sfb.setPackagesToScan(new String[] { "darknsoft" });
    Properties props = new Properties();
    props.setProperty("dialect", "org.hibernate.dialect.MySQL5Dialect");
    sfb.setHibernateProperties(props);
    return sfb;
  }
}
