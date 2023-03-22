package com.inti.controller;

import org.springframework.test.web.servlet.MockMvc;

import com.inti.model.Entreprise;
import com.inti.repository.IEntrepriseRepository;

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

@WebMvcTest(EntrepriseController.class)
public class EntrepriseControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private IEntrepriseRepository isr;
	
	@Test
	public void saveEntreprise() throws Exception
	{
		mock.perform(get("/entreprise/form"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	@DisplayName("Test enregistrement formulaire")
	public void enregistrementEntreprise() throws Exception
	{
		mock.perform(post("/entreprise/save").sessionAttr("entreprise", new Entreprise(1, "A", "ADR")))
		.andExpect(status().is3xxRedirection())
		.andDo(print());
	}
	
	
	@Test
	public void allEntreprise() throws Exception
	{
		mock.perform(get("/entreprise/liste"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void supprEntreprise() throws Exception
	{
		mock.perform(get("/entreprise/delete?id=2"))
		.andExpect(status().is3xxRedirection())
		.andDo(print());
	}
}
