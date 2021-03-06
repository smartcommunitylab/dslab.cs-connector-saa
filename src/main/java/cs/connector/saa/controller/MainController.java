package cs.connector.saa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MainController {
	
	@GetMapping("/student")
	public ResponseEntity<Map<String, Object>> getSAAStudent(
			@RequestParam String fiscalCode,
			@RequestParam String viewName) {
		ObjectMapper objectMapper = new ObjectMapper();
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = null;
		try {
			resource = resourceLoader.getResource("classpath:json/student.json");
			Map<String,Object> map = objectMapper.readValue(resource.getInputStream(), new TypeReference<Map<String, Object>>() {});
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/educationalActivity")
	public ResponseEntity<List<Map<String, Object>>> getSAAEducationalActivity(
			@RequestParam String fiscalCode,
			@RequestParam String entityType, 
			@RequestParam String viewName) {
		ObjectMapper objectMapper = new ObjectMapper();
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = null;
		try {
			resource = resourceLoader.getResource("classpath:json/educationalActivity.json");
			List<Map<String,Object>> list = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Map<String, Object>>>() {});
			return new ResponseEntity<List<Map<String, Object>>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Map<String, Object>>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/education")
	public ResponseEntity<List<Map<String, Object>>> getSAAEducation(
			@RequestParam String fiscalCode,
			@RequestParam String entityType, 
			@RequestParam String viewName) {
		ObjectMapper objectMapper = new ObjectMapper();
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = null;
		try {
			resource = resourceLoader.getResource("classpath:json/education.json");
			List<Map<String,Object>> list = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Map<String, Object>>>() {});
			return new ResponseEntity<List<Map<String, Object>>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Map<String, Object>>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/certification")
	public ResponseEntity<List<Map<String, Object>>> getSAACertification(
			@RequestParam String fiscalCode,
			@RequestParam String entityType, 
			@RequestParam String viewName) {
		ObjectMapper objectMapper = new ObjectMapper();
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = null;
		try {
			resource = resourceLoader.getResource("classpath:json/certification.json");
			List<Map<String,Object>> list = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Map<String, Object>>>() {});
			return new ResponseEntity<List<Map<String, Object>>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Map<String, Object>>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
