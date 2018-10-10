package gov.hhs.batch;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfiguration {

	@Bean(name="hhsDb")
	@Primary
	@ConfigurationProperties(prefix = "target.datasource")
	public DataSource targetDataSource() {
		return DataSourceBuilder.create().build();
	}	
	
}
