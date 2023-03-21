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
//import com.inti.model.Produit;
//
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class ProduitRepositoryTest {
//
//	Produit p;
//	Produit p1;
//	@Autowired
//	IProduitRepository ipr;
//	
//	@BeforeTestClass
//	public void setUtp()
//	{
//		System.out.println("Begin : " + LocalDateTime.now());
//		p = new Produit("nom", "Ref", 90, 0.2);
//		Produit p1 = new Produit(1, "nom", "caisse", 13, 0.3);
//	}
//	@Test
//	public void saveTest()
//	{
//		// Given = les infos fournies
//		
//		// When = le code à vérifier
//		Produit savedProduct = ipr.save(p);
//		// Then = le test
//		assertThat(savedProduct).isNotNull(); // renvoie true si savedProduct a bien une valeur
//		assertThat(savedProduct.getNom()).isEqualTo("nom");
//		
//	}
//	
//	@Test
//	public void deleteTest()
//	{
//		// Given déjà dans le setup
//		Produit p2 = ipr.save(p);
//		// When
//		ipr.deleteById(p2.getId());
//		// Then
//		Assertions.assertThrows(Exception.class, ()-> ipr.getReferenceById(p2.getId()));
//	}
//	
//	@AfterTestClass
//	public static void end()
//	{
//		System.out.println("End : " + LocalDateTime.now());
//	}
//}
