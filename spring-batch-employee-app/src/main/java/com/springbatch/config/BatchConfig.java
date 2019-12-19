package com.springbatch.config;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.springbatch.config.step.Processor;
import com.springbatch.config.step.Reader;
import com.springbatch.config.step.Writer;
import com.springbatch.entity.Employee;
import com.springbatch.listener.JobCompletionListener;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
	private static final Logger logger = LoggerFactory.getLogger(BatchConfig.class);

	@Lazy
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	@Lazy
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Lazy
	@Autowired
	public DataSource dataSource;

	@Bean
	public Reader reader() {
		return new Reader();
	}

	@Bean
	public Writer writer() {
		return new Writer();
	}

	@Bean
	public Processor processor() {
		return new Processor();
	}

	@Bean
	public Job processJob(Step orderStep1) {
		return jobBuilderFactory.get("processJob").incrementer(new RunIdIncrementer()).listener(listener())
				.start(orderStep1()).build();
	}

	@Bean
	public Step orderStep1() {
		return stepBuilderFactory.get("orderStep1").<List<Employee>, List<Employee>>chunk(1).reader(reader())
				.processor(processor()).writer(writer()).startLimit(1).build();
	}

	@Bean
	public JobExecutionListener listener() {

		return new JobCompletionListener();
	}
}
