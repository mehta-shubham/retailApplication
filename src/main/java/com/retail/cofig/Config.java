/*
 * package com.retail.cofig;
 * 
 * import java.sql.SQLException;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.context.annotation.PropertySource; import
 * org.springframework.core.env.Environment;
 * 
 * import oracle.jdbc.pool.OracleDataSource;
 * 
 * @Configuration
 * 
 * @PropertySource("classpath:application.properties") public class Config {
 * 
 * @Autowired private Environment env;
 * 
 * @Bean("userDao") public DataSource dataSource() throws SQLException {
 * OracleDataSource dataSource = new OracleDataSource();
 * dataSource.setURL(env.getRequiredProperty("spring.datasource.url"));
 * dataSource.setUser(env.getRequiredProperty("spring.datasource.username"));
 * dataSource.setPassword(env.getRequiredProperty("spring.datasource.password"))
 * ;
 * 
 * return dataSource; } }
 */