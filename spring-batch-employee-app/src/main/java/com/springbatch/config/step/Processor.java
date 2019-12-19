package com.springbatch.config.step;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.springbatch.entity.Employee;

/*
 * public class Processor implements ItemProcessor<List<Employee>,
 * List<Employee>> {
 * 
 * 
 * @Override public List<Employee> process(List<Employee> item) throws Exception
 * { Iterator iter = item.iterator(); while (iter.hasNext()) {
 * System.out.println("item+++++++++++"+iter.next()); } return item; }
 * 
 * }
 */
public class Processor implements ItemProcessor<List<Employee>, List<Employee>> {

	@Override
	public List<Employee> process(List<Employee> item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}

}