package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Salarie;

public interface ISalarieRepository extends JpaRepository<Salarie, Integer> {

	List<Salarie> findByNom(String nom);
}
