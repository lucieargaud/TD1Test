package com.inti.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inti.model.Entreprise;
import com.inti.model.Salarie;
import com.inti.repository.IEntrepriseRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EntrepriseRepositoryTest {

	@Autowired
	IEntrepriseRepository ier;
	Entreprise e;
	Entreprise savedEntreprise;
	
	@BeforeEach
	public void setUtp()
	{
		System.out.println("Begin : " + LocalDateTime.now());
		e = new Entreprise(1, "E", "ADR");
		savedEntreprise = ier.save(e);
		
	}
	
	@Test
	public void saveSalarie()
	{
		// Given
		
		// When
		
		// Then
		assertThat(savedEntreprise).isNotNull();
		assertThat(savedEntreprise.getId()).isGreaterThan(0);
	}
	
	@Test
	public void modifySalarie()
	{
		// Given
		e.setNom("AAA");
		
		// When
		savedEntreprise = ier.save(e);
		// Then
		assertThat(savedEntreprise.getNom()).isEqualTo(e.getNom());
	}
	
	@Test
	public void deleteSalarie()
	{
		// Given déjà dans le setup
		// When
		ier.delete(savedEntreprise);
		// Then
		Assertions.assertThrows(Exception.class, ()-> ier.getReferenceById(savedEntreprise.getId()));	
	}
	
	@Test
	public void getAllEntreprise()
	{
		// Given déjà dans le setup
		ier.save(new Entreprise("B", "ADR"));
		Entreprise e= ier.save(new Entreprise("C", "XXX"));
		// When
		List<Entreprise> listeE = ier.findAll();
		// Then
		assertThat(listeE).isNotEmpty();
		assertThat(listeE).hasSize(4); // déjà une ligne dans la base
		assertThat(listeE.get(0).getClass()).hasSameClassAs(Entreprise.class);
		assertThat(listeE.get(3).toString()).hasToString(e.toString());
	}
	
	@Test
	public void getEntrepriseByNom()
	{
		// G
		ier.save(new Entreprise("E", "ADRXXX"));
		// When
		List<Entreprise> listeE = ier.findByNom("E");
		// Then
		assertThat(listeE).isNotEmpty();
		assertThat(listeE.get(0).getNom()).isEqualTo("E");
	}
	
	@AfterEach
	public void end()
	{
		System.out.println("End : " + LocalDateTime.now());
	}
}
