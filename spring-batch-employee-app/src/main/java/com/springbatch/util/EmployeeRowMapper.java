package com.springbatch.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springbatch.entity.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmpID(rs.getInt("EMP_ID"));
		employee.setEmpFirstName(rs.getString("EMP_FIRSTNAME"));
		employee.setEmpMiddleName(rs.getString("EMP_MIDDLENAME"));
		employee.setEmpLastName(rs.getString("EMP_LASTNAME"));
		employee.setEmpEmailID(rs.getString("EMP_EMAILID"));
		employee.setEmpOrganization(rs.getString("EMP_ORGANIZATION"));
		employee.setEmpCountry(rs.getString("EMP_COUNTRY"));
		employee.setEmpState(rs.getString("EMP_STATE"));
		employee.setEmpAddress(rs.getString("EMP_ADDRESS"));

		return employee;
	}

}