package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Entreprise;

@Repository
public interface IEntrepriseRepository extends JpaRepository<Entreprise, Integer> {

	List<Entreprise> findByNom(String nom);
}