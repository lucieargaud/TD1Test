package com.inti.controller;

import org.springframework.test.web.servlet.MockMvc;

import com.inti.model.Salarie;
import com.inti.repository.ISalarieRepository;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(SalarieController.class)
public class SalarieControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private ISalarieRepository isr;
	
	@Test
	public void saveSalarie() throws Exception
	{
		mock.perform(get("/formSalarie"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	@DisplayName("Test enregistrement formulaire")
	public void enregistrementSalarie() throws Exception
	{
		mock.perform(post("/saveSalarie").sessionAttr("salarie", new Salarie(1, "A", "B", "a.b@xy.fr")))
		.andExpect(status().is3xxRedirection())
		.andDo(print());
	}
	
	
	@Test
	public void allSalarie() throws Exception
	{
		mock.perform(get("/listeSalarie"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void supprSalarie() throws Exception
	{
		mock.perform(get("/deleteSalarie?id=2"))
		.andExpect(status().is3xxRedirection())
		.andDo(print());
	}
}
