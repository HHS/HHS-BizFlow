package gov.hhs.usas.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import gov.hhs.usas.rest.UsasRESTController;

public class UsasRESTControllerTest {
	@Autowired
    private MockMvc mockMvc;

	 @Before
     public void setUp() {
      mockMvc = MockMvcBuilders.standaloneSetup(new UsasRESTController()).build();
     }
 

	@Test
	public void testGetUSAStaffingReportFromCognos() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/usas/report/recruitment/001234");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void testTransformRecruitmentXML() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/usas/report/recruitment?reportPath=C:/Users/pvirdi/git/HHS-BizFlow/usas_whrsc/WHRSCRecruitment2.xml");//.accept(MediaType.TEXT_PLAIN);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
      
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
		

	}

	@Test
	public void testTransformAppointmentXML() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/usas/report/appointment?reportPath=C:/Users/pvirdi/git/HHS-BizFlow/usas_whrsc/WHRSCAppointment2.xml");//.accept(MediaType.TEXT_PLAIN);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
		
	}

	@Test
	public void testGetRecruitmentData() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/usas/reportXML/recruitment/001234");//.accept(MediaType.TEXT_PLAIN);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void testGetAppointmentData() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/usas/reportXML/appointment/001234");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

}
