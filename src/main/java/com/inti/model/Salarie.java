package com.inti.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salarie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String email;
    
//    @Exclude
//    @ManyToOne
//    @JoinColumn(name="idE")
//    private Entreprise entreprise;
    
	public Salarie(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
//	public Salarie(int id, String nom, String prenom, String email) {
//		super();
//		this.id = id;
//		this.nom = nom;
//		this.prenom = prenom;
//		this.email = email;
//	}
       

}