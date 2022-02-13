package com.nagarro.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.constant.URLType;
import com.nagarro.model.Employee;

@Service
public class EmpMangService {

	public List<Employee> getEmployee() {

		String url = URLType.GET_EMPS_URL;

		RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);

		ParameterizedTypeReference<List<Employee>> responseType = new ParameterizedTypeReference<List<Employee>>() {
		};
		ResponseEntity<List<Employee>> response = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
		List<Employee> employee = response.getBody();
		// System.out.println(employee);
		return employee;
	}

	public Employee getEmployee(long empCode) {

		String url = URLType.GET_EMP_URL + empCode;

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, Employee.class);
	}

	public void addEmployee(Employee emp) {

		String url = URLType.UPLD_EMP_URL;

		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Employee> request = new HttpEntity<Employee>(emp);
		restTemplate.postForObject(url, request, Employee.class);

	}

	public void updateEmployee(Employee emp) {

		String url = URLType.UPDT_EMP_URL;

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Employee> request = new HttpEntity<Employee>(emp);

		restTemplate.put(url, request);
	}

	public void deleteEmployee(long empCode) {

		String url = URLType.DLT_EMP_URL + empCode;

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.delete(url);

	}

}
