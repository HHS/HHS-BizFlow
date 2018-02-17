package hhs.usas.dss;


import java.util.Arrays;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.ExecutionContextPromotionListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import hhs.usas.dss.model.Vacancy;
import hhs.usas.dss.model.VacancyAppCount;
import hhs.usas.dss.model.VacancyCustomer;
import hhs.usas.dss.model.VacancyDetail;
import hhs.usas.dss.model.VacancyDocuments;
import hhs.usas.dss.model.VacancyEligibility;
import hhs.usas.dss.model.VacancyPosition;
import hhs.usas.dss.model.VacancyRequest;
import hhs.usas.dss.model.VacancySpecialty;

/*
 * Batch configuration defining job(s), its step,
 * reader(JDBC), processor and writer(JDBC),
 * job scheduler using cron, etc.
 * 
 */


@Configuration
@EnableBatchProcessing //enables Spring Batch features and provides a base configuration for setting up batch jobs
public class BatchConfiguration {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private JobListener jobListener;

	@Autowired
	private StepsListener stepListener;

	@Autowired
	private ReportTasklet reportTaskletStep;

	@Autowired
	@Qualifier("targetDb")
	private DataSource targetDataSource;
	
	private static String interfaceName;

	public static String getInterfaceName() {
		return interfaceName;
	}
	
	@Bean
	public StaxEventItemReader<Vacancy> xmlFileReader() throws Exception {

		StaxEventItemReader<Vacancy> reader = new StaxEventItemReader<>();
		
		reader.setResource(new ClassPathResource("vacancyDSS.xml"));
		//reader.setFragmentRootElementName("lst_VacancyDetail");
		reader.setFragmentRootElementNames(new String[] {"lst_VacancyDetail"});

		Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
		//unmarshaller.setPackagesToScan("com.hhs.usas.dss.model");
		unmarshaller.setClassesToBeBound(Vacancy.class);
		unmarshaller.afterPropertiesSet();
		reader.setUnmarshaller(unmarshaller);
		
		return reader;
	}
	

	@Bean
	public ItemWriter<Vacancy> vacancyDetailWriter() {
		JdbcBatchItemWriter<Vacancy> dbWriter = new JdbcBatchItemWriter<Vacancy>();
		dbWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Vacancy>());;
		dbWriter.setSql(VacancyDetail.getInsertVacancyDetail());
		dbWriter.setDataSource(targetDataSource);
		return dbWriter;
	}
	
	@Bean
	public ItemWriter<Vacancy> vacancyCustomerWriter() {
		JdbcBatchItemWriter<Vacancy> dbWriter = new JdbcBatchItemWriter<Vacancy>();
		dbWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Vacancy>());
		dbWriter.setSql(VacancyCustomer.getInsertVacancyCustomer());
		dbWriter.setDataSource(targetDataSource);
		return dbWriter;
	}
	
	@Bean
	public ItemWriter<Vacancy> vacancyEligibilityWriter() {
		JdbcBatchItemWriter<Vacancy> dbWriter = new JdbcBatchItemWriter<Vacancy>();
		dbWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Vacancy>());
		dbWriter.setSql(VacancyEligibility.getInsertVacancyEligibility());
		dbWriter.setDataSource(targetDataSource);
		return dbWriter;
	}
	
	@Bean
	public ItemWriter<Vacancy> vacancyPositionWriter() {
		JdbcBatchItemWriter<Vacancy> dbWriter = new JdbcBatchItemWriter<Vacancy>();
		dbWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Vacancy>());
		dbWriter.setSql(VacancyPosition.getInsertVacancyPosition());
		dbWriter.setDataSource(targetDataSource);
		return dbWriter;
	}
	
	@Bean
	public ItemWriter<Vacancy> vacancySpecialtyWriter() {
		JdbcBatchItemWriter<Vacancy> dbWriter = new JdbcBatchItemWriter<Vacancy>();
		dbWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Vacancy>());
		dbWriter.setSql(VacancySpecialty.getInsertVacancySpecialty());
		dbWriter.setDataSource(targetDataSource);
		return dbWriter;
	}
	
	@Bean
	public ItemWriter<Vacancy> vacancyDocumentWriter() {
		JdbcBatchItemWriter<Vacancy> dbWriter = new JdbcBatchItemWriter<Vacancy>();
		dbWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Vacancy>());
		dbWriter.setSql(VacancyDocuments.getInsertVacancyDocument());
		dbWriter.setDataSource(targetDataSource);
		return dbWriter;
	}
	
	@Bean
	public ItemWriter<Vacancy> vacancyRequestWriter() {
		JdbcBatchItemWriter<Vacancy> dbWriter = new JdbcBatchItemWriter<Vacancy>();
		dbWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Vacancy>());
		dbWriter.setSql(VacancyRequest.getInsertVacancyRequest());
		dbWriter.setDataSource(targetDataSource);
		return dbWriter;
	}
	
	@Bean
	public ItemWriter<Vacancy> vacancyAppCountWriter() {
		JdbcBatchItemWriter<Vacancy> dbWriter = new JdbcBatchItemWriter<Vacancy>();
		dbWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Vacancy>());
		dbWriter.setSql(VacancyAppCount.getInsertVacancyAppCnt());
		dbWriter.setDataSource(targetDataSource);
		return dbWriter;
	}		
	
	@Bean
	public CompositeItemWriter<Vacancy> compositeVacancyWriter(){
		CompositeItemWriter<Vacancy> writer = new CompositeItemWriter<Vacancy>();
		writer.setDelegates(Arrays.asList(vacancyDetailWriter(), 
										vacancyCustomerWriter(), 
										vacancyEligibilityWriter(), 
										vacancyPositionWriter(), 
										vacancySpecialtyWriter(), 
										vacancyDocumentWriter(), 
										vacancyRequestWriter(), 
										vacancyAppCountWriter()));
		return writer;
	}


	/*
	 * Job - importVacancyDSSReport into staging table 
	 * and then, after applying business rules, move the data 
	 * from staging table to final tables
	 */
	@Bean
	public Job importDSSReports() throws Exception {
		interfaceName = " USA Staffing Interface";
		return jobBuilderFactory.get("importDSSReports")
				.incrementer(new RunIdIncrementer())
				.listener(jobListener)
				.start(retrieveCognosDataStep())
				//.next(insertDataIntoDB())
				.build();
		
	}

	//first step
	@Bean
	public Step retrieveCognosDataStep() {
		return stepBuilderFactory.get("retrieveCognosDataStep")
				.tasklet(reportTaskletStep)
				.listener(stepListener)
				.build();
	}
	
	//second step
	@Bean 
	public Step insertDataIntoDB() throws Exception {
		return stepBuilderFactory.get("insertDataIntoDBStep")
				.<Vacancy, Vacancy>chunk(1000)
				.reader(xmlFileReader())
				.writer(compositeVacancyWriter())
				.build();
	}
	
	//added new batch configurer for using multiple datasource
	@Bean
	public BatchConfigurer configurer(){
		return new DefaultBatchConfigurer(targetDataSource);
	}


	@Bean(name="targetJdbcTemplate")
	public JdbcTemplate targetJdbcTemplate() {
		return new JdbcTemplate(targetDataSource);
	}	
	

}
