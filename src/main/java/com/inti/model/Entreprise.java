//package com.inti.model;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString.Exclude;
//
//@Entity
//@Table
//@Data @AllArgsConstructor @NoArgsConstructor
//public class Entreprise {
//
//	private int id;
//	private String nom;
//	private String adresse;
//		
//	@Exclude
//	@OneToMany(mappedBy = "entreprise")
//	private List<Salarie> listeSalarie;
//	
//	public Entreprise(String nom, String adresse) {
//		super();
//		this.nom = nom;
//		this.adresse = adresse;
//	}
//
//	public Entreprise(int id, String nom, String adresse) {
//		super();
//		this.id = id;
//		this.nom = nom;
//		this.adresse = adresse;
//	}
//	
//	
//}
