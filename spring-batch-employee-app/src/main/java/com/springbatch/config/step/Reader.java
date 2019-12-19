package com.springbatch.config.step;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springbatch.entity.Employee;
import com.springbatch.util.EmployeeRowMapper;

public class Reader implements ItemReader<List<Employee>> {
	private static final Logger logger = LoggerFactory.getLogger(Reader.class);

	@Autowired
	public JdbcTemplate jdbcTemplate;


	/*
	 * @Override public List<Employee> read() throws Exception { if (!batchJobState)
	 * { System.out.println("in item reader==========="); List<Employee> emplist =
	 * empservice.findAll(); batchJobState = true; return emplist; } return null; }
	 */
	/*
	 * @Bean ItemReader<StudentDTO> databaseCsvItemReader(DataSource dataSource) {
	 * JdbcPagingItemReader<StudentDTO> databaseReader = new
	 * JdbcPagingItemReader<>();
	 * 
	 * databaseReader.setDataSource(dataSource); databaseReader.setPageSize(1);
	 * databaseReader.setRowMapper(new BeanPropertyRowMapper<>(StudentDTO.class));
	 * 
	 * PagingQueryProvider queryProvider = createQueryProvider();
	 * databaseReader.setQueryProvider(queryProvider);
	 * 
	 * return databaseReader; }
	 */

	/*
	 * @Bean ItemReader<Employee> reader(DataSource dataSource) {
	 * logger.trace("A TRACE Message"); logger.debug("A DEBUG Message");
	 * logger.info("An INFO Message"); logger.warn("A WARN Message");
	 * logger.error("An ERROR Message"); JdbcCursorItemReader<Employee> reader = new
	 * JdbcCursorItemReader<Employee>(); reader.setDataSource(dataSource);
	 * reader.setSql("select * from TABLE_EMPLOYEES_DATA_APP");
	 * reader.setRowMapper(new EmployeeRowMapper());
	 * 
	 * return reader; }
	 */
	@Override
	public List<Employee> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		EmployeeRowMapper empRowMapper = new EmployeeRowMapper();
		List<Employee> employees=jdbcTemplate.query("select * from TABLE_EMPLOYEES_DATA_APP", empRowMapper);
		return employees;
	}

	/*
	 * @Override public List<Employee> read() throws Exception { if (!batchJobState)
	 * { DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
	 * dataSource1.setUsername("sa"); dataSource1.setPassword("");
	 * dataSource1.setUrl("jdbc:h2:file:~/test");
	 * dataSource1.setDriverClassName("org.h2.Driver");
	 * System.out.println("in item reader before query===========");
	 * List<Map<String, Object>> rows; List<Employee> employees = new ArrayList<>();
	 * rows = jdbcTemplate.
	 * queryForList("select EMP_ID,EMP_FIRSTNAME from TABLE_EMPLOYEES_DATA_APP");
	 * System.out.println("in item reader after query===========" + rows); for
	 * (Map<String, Object> row : rows) {
	 * 
	 * Employee employee = new Employee();
	 * 
	 * employee.setEmpID((int) row.get("EMP_ID"));
	 * 
	 * employee.setEmpFirstName((String) row.get("EMP_FIRSTNAME"));
	 * 
	 * employees.add(employee); } return employees; } return null;
	 * 
	 * }
	 */

}