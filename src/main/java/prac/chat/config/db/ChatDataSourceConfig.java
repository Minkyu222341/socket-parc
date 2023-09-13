// package prac.chat.config.db;
//
// import javax.sql.DataSource;
//
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.orm.jpa.JpaTransactionManager;
// import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
// import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
// import org.springframework.transaction.PlatformTransactionManager;
//
// /**
//  * packageName    : prac.chat.config.db
//  * fileName       : ChatDataSourceConfig
//  * author         : MinKyu Park
//  * date           : 2023-09-13
//  * description    :
//  * ===========================================================
//  * DATE              AUTHOR             NOTE
//  * -----------------------------------------------------------
//  * 2023-09-13        MinKyu Park       최초 생성
//  */
// @EnableJpaRepositories(
// 	basePackages = "prac.chat.repository.chat",
// 	entityManagerFactoryRef = "chatEntityManger",
// 	transactionManagerRef = "chatTransactionManger"
// )
// @Configuration
// public class ChatDataSourceConfig {
//
// 	@Bean
// 	public PlatformTransactionManager chatTransactionManger() {
// 		JpaTransactionManager transactionManager = new JpaTransactionManager();
// 		transactionManager.setEntityManagerFactory(chatEntityManger().getObject());
//
// 		return transactionManager;
// 	}
//
// 	@Bean
// 	public LocalContainerEntityManagerFactoryBean chatEntityManger() {
// 		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
// 		em.setDataSource(chatDataSource());
// 		em.setPackagesToScan("prac.chat.entity.chat");
// 		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
// 		return em;
// 	}
//
// 	@Bean
// 	@ConfigurationProperties(prefix = "spring.chat")
// 	public DataSource chatDataSource() {
// 		return DataSourceBuilder.create().build();
// 	}
// }
