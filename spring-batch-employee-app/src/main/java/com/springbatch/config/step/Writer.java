package com.springbatch.config.step;

import java.util.List;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.entity.Employee;

public class Writer implements ItemWriter<List<Employee>> {
	ExecutionContext executionContext;
	FlatFileItemWriter<Employee> writer;
	public Writer() {
		// TODO Auto-generated constructor stub
	}

	@BeforeStep
	public void beforeSteps(StepExecution stepExecution) {
		executionContext=stepExecution.getExecutionContext();
}
	@AfterStep
	public void afterSteps(StepExecution stepExecution) {
		writer.close();
}

	@Override
	public void write(List<? extends List<Employee>> employees) throws Exception {
		writer = new FlatFileItemWriter<Employee>();
		writer.setResource(new FileSystemResource("employee.csv"));
		writer.open(executionContext);
		writer.setLineAggregator(new DelimitedLineAggregator<Employee>() {
			{
				setDelimiter("|");
				setFieldExtractor(new BeanWrapperFieldExtractor<Employee>() {
					{
						setNames(new String[] { "empID", "empFirstName", "empMiddleName", "empLastName", "empEmailID",
								"empOrganization", "empCountry", "empState", "empAddress" });
					}
				});
			}
		});
		writer.write(employees.get(0));
		writer.close();

	}

}
