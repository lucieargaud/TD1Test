package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Entreprise;
import com.inti.repository.IEntrepriseRepository;

@Controller
@RequestMapping("entreprise")
public class EntrepriseController {

	@Autowired
	IEntrepriseRepository ier;
	
	@GetMapping("hello")
	public String hello()
	{
		return "hello";
	}
	
	// Enregistrer via un formulaire
	@GetMapping("form")
	public String formEntreprise() {
		return "formEntreprise";
	}

	@PostMapping("save")
	public String saveSalarie(@ModelAttribute("entreprise") Entreprise e) {
		ier.save(e);
		return "redirect:/entreprise/liste";
	}
	// Afficher la liste
	@GetMapping("liste")
	public String listeEntreprise(Model m) {
		m.addAttribute("listeEntreprise", ier.findAll());
		return "listeEntreprise";
	}
	
	// Supprimer
	@GetMapping("delete")
	public String deleteEntreprise(@RequestParam("id") int id) {
		ier.deleteById(id);
		return "redirect:/entreprise/liste";
	}
	
	// Modifier
	@GetMapping("modifier")
	public String modifieEntreprise(@RequestParam("id") int id, Model m)
	{
		m.addAttribute("entreprise", ier.findById(id).get());
		return "modifierEntreprise";
	}
	
	@PostMapping("update")
	public String updateEntreprise(@ModelAttribute("entreprise") Entreprise e)
	{
		ier.save(e);
		return "redirect:/entreprise/liste";
	}
	

}