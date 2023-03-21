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


import com.inti.model.Salarie;
import com.inti.repository.ISalarieRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SalarieRepositoryTest {

	@Autowired
	ISalarieRepository isr;
	Salarie s;
	Salarie savedSalarie;
	
	@BeforeEach
	public  void setUtp()
	{
		System.out.println("Begin : " + LocalDateTime.now());
		s = new Salarie(1, "A", "B", "a.b@xy.fr");
		savedSalarie = isr.save(s);
		
	}
	
	@Test
	public void saveSalarie()
	{
		// Given
		
		// When
		
		// Then
		assertThat(savedSalarie).isNotNull();
		assertThat(savedSalarie.getId()).isGreaterThan(0);
	}
	
	@Test
	public void getSalarie()
	{
		// Given
		
		// When
		Salarie s2 = isr.getReferenceById(savedSalarie.getId());
		// Then
		assertThat(s2).isNotNull();
		assertThat(s2).isEqualTo(savedSalarie);
	}
	
	@Test
	public void modifySalarie()
	{
		// Given
		s.setNom("AAA");
		
		// When
		savedSalarie = isr.save(s);
		// Then
		assertThat(savedSalarie.getNom()).isEqualTo(s.getNom());

	}
	
	@Test
	public void deleteSalarie()
	{
		// Given déjà dans le setup
		// When
		isr.delete(savedSalarie);
		// Then
		Assertions.assertThrows(Exception.class, ()-> isr.getReferenceById(savedSalarie.getId()));	
	}
	
	@Test
	public void getAllSalarie()
	{
		// Given déjà dans le setup
		Salarie s3 = isr.save(new Salarie("BBB", "CCC", "bbbccc@abc.fr"));
		Salarie s4 = isr.save(new Salarie("AAA", "DDD", "aaaddd@abc.fr"));
		// When
		List<Salarie> listeS = isr.findAll();
		// Then
		assertThat(listeS).isNotEmpty();
		assertThat(listeS).hasSize(4); // Il y a déjà une ligne dans la table
		assertThat(listeS.get(0).getClass()).hasSameClassAs(Salarie.class);
		assertThat(listeS.get(2).toString()).hasToString(s3.toString());
		// Il y a déjà un objet dans la ligne 1
	}
	
	@Test
	public void getSalarieByNom()
	{
		// G
		Salarie s3 = isr.save(new Salarie("A", "CCC", "bbbccc@abc.fr"));
		// When
		List<Salarie> listeS = isr.findByNom("A");
		// Then
		assertThat(listeS).isNotEmpty();
		assertThat(listeS.get(0).getNom()).isEqualTo("A");
	}
	
	@AfterEach
	public void end()
	{
		System.out.println("End : " + LocalDateTime.now());
	}
}
