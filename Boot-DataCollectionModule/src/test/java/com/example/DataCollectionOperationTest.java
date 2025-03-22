package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.bindingd.ChildInputs;
import com.example.ms.DcOperationController;
import com.example.service.DcServicemgmt;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@WebMvcTest(value=DcOperationController.class)
class DataCollectionOperationTest {
	
	@SuppressWarnings("removal")
	@MockBean
	private DcServicemgmt mgmt;
	@Autowired
	private MockMvc mockmv;
	
	@Test
	public void displayplanNames() throws Exception {
		
		List<String> planList = new ArrayList<String>();
		planList.add("SNAP"); planList.add("QHP");
		planList.add("QHP");
		Mockito.when(mgmt.showAllPlanNames()).thenReturn(planList);
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/Dc-api/planNames");
	    MvcResult result =	mockmv.perform(builder).andReturn();
	    int status = result.getResponse().getStatus();
	    assertEquals(200, status);
	    
		
		
	}
	
	@Test
	public void generateCaseNOTest1() throws Exception {
		Mockito.when(mgmt.generateCaseNo(1)).thenReturn(1001);
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/Dc-api/generatedCaseNo/1");
	    MvcResult result =	mockmv.perform(builder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(201, status);
		
	}
	@Test
	public void generateCaseNOTest2() throws Exception {
		Mockito.when(mgmt.generateCaseNo(121)).thenReturn(0);
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/Dc-api/generatedCaseNo/121");
	    MvcResult result =	mockmv.perform(builder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(201, status);
		
	}
	@Test
	public void saveChildrenTest() throws Exception {
		ChildInputs inputs = new ChildInputs();
		inputs.setCaseNo(1001); inputs.setSsn(999456123); inputs.setDob(LocalDate.of(2000, 10, 21));
		ChildInputs inputs1 = new ChildInputs();
		inputs1.setCaseNo(1001); inputs.setSsn(999456126); inputs.setDob(LocalDate.of(2001, 10, 21));
		List<ChildInputs> list = new ArrayList<ChildInputs>();
		list.add(inputs1);
		list.add(inputs);
		
		Mockito.when(mgmt.saveChildrenDetails(list)).thenReturn(1001);
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.registerModule(new JavaTimeModule());
		String jsoncontent = mapper.writeValueAsString(list);
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/Dc-api/saveChildren").contentType("application/json").content(jsoncontent);
	    MvcResult result =	mockmv.perform(builder).andReturn();
		int status = result.getResponse().getStatus();
		//String responseJson = result.getResponse().getContentAsString();
		//assertEquals(1001, Integer.parseInt(responseJson));
		assertEquals(201, status);
	}


	

}
