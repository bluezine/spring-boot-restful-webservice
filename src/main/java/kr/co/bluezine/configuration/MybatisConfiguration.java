package kr.co.bluezine.configuration;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration("MybatisConfiguration")
@MapperScan(basePackages={"kr.co.bluezine.mapper"})
public class MybatisConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(MybatisConfiguration.class);
	
	@Bean
	public DataSource dataSource() {
		logger.debug("---------> Set Embedded DataSource");
		return new EmbeddedDatabaseBuilder().setType(H2).build();
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		logger.debug("---------> Set SqlSessionFactory");
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}
	
	@Bean(destroyMethod="clearCache")
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		logger.debug("---------> Set SqlSessionTemplate");
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
