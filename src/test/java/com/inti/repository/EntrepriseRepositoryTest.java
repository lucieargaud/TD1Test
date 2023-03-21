//package com.inti.repository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.time.LocalDateTime;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.event.annotation.AfterTestClass;
//import org.springframework.test.context.event.annotation.BeforeTestClass;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.inti.model.Entreprise;
//import com.inti.model.Salarie;
//import com.inti.repository.IEntrepriseRepository;
//
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class EntrepriseRepositoryTest {
//
//	@Autowired
//	IEntrepriseRepository ier;
//	Entreprise e = new Entreprise(1, "E", "ADR");
//	
//	@BeforeTestClass
//	public  void setUtp()
//	{
//		System.out.println("Begin : " + LocalDateTime.now());
//	}
//	
//	@Test
//	public void saveSalarie()
//	{
//		// Given
//		
//		// When
//		Entreprise savedEntreprise = ier.save(e);
//		// Then
//		assertThat(savedEntreprise).isNotNull();
//		assertThat(savedEntreprise.getId()).isGreaterThan(0);
//	}
//	
//	@Test
//	public void modifySalarie()
//	{
//		// Given
//		e.setNom("AAA");
//		
//		// When
//		Entreprise e1 = ier.save(e);
//		// Then
//		assertThat(e1.getNom()).isEqualTo(e.getNom());
//	}
//	
//	@Test
//	public void deleteSalarie()
//	{
//		// Given déjà dans le setup
//		Entreprise e1 = ier.save(e);
//		// When
//		ier.deleteById(e.getId());
//		// Then
//		Assertions.assertThrows(Exception.class, ()-> ier.getReferenceById(e.getId()));	
//	}
//	
//	@AfterTestClass
//	public static void end()
//	{
//		System.out.println("End : " + LocalDateTime.now());
//	}
//}
