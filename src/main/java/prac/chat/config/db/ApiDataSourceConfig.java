// package prac.chat.config.db;
//
// import javax.sql.DataSource;
//
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.orm.jpa.JpaTransactionManager;
// import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
// import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
// import org.springframework.transaction.PlatformTransactionManager;
//
// /**
//  * packageName    : prac.chat.config.db
//  * fileName       : ApiDataSourceConfig
//  * author         : MinKyu Park
//  * date           : 2023-09-13
//  * description    :
//  * ===========================================================
//  * DATE              AUTHOR             NOTE
//  * -----------------------------------------------------------
//  * 2023-09-13        MinKyu Park       최초 생성
//  */
// @EnableJpaRepositories(
// 	basePackages = "prac.chat.repository.api",
// 	entityManagerFactoryRef = "apiEntityManger",
// 	transactionManagerRef = "apiTransactionManger"
// )
// @Configuration
// public class ApiDataSourceConfig {
//
// 	@Primary
// 	@Bean
// 	public PlatformTransactionManager apiTransactionManger() {
// 		JpaTransactionManager transactionManager = new JpaTransactionManager();
// 		transactionManager.setEntityManagerFactory(apiEntityManger().getObject());
//
// 		return transactionManager;
// 	}
//
// 	@Primary
// 	@Bean
// 	public LocalContainerEntityManagerFactoryBean apiEntityManger() {
// 		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
// 		em.setDataSource(apiDataSource());
// 		em.setPackagesToScan("prac.chat.entity.api");
// 		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
// 		return em;
// 	}
//
// 	@Primary
// 	@Bean
// 	@ConfigurationProperties(prefix = "spring.api.hikari")
// 	public DataSource apiDataSource() {
// 		return DataSourceBuilder.create().build();
// 	}
// }
