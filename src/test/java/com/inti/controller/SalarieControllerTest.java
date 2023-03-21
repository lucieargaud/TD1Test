package com.inti.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.inti.repository.ISalarieRepository;

@Controller
@WebMvcTest(controllers = SalarieController.class)
public class SalarieControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private ISalarieRepository isr;
	
	@Test
	private void tousSalaries()
	{
		try {
			mock.perform(get("/salaries"))
			.andExpect(status().isOk())
			.andExpect(view().name("salaries "))
			.andExpect(forwardedUrl("/salaries.html"))
			.andExpect((ResultMatcher) content().string(containsString("Liste des salariés")))
			.andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
