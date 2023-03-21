//package com.inti.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.inti.repository.IProduitRepository;
//
//@Controller
//public class ProduitController {
//
//	@Autowired
//	IProduitRepository ipr;
//	
////	@GetMapping("hello")
////	public String hello()
////	{
////		return "hello";
////	}
//	
//	@GetMapping("listeProduit")
//	public String listeSalarie(Model m) {
//		m.addAttribute("listeProduit", ipr.findAll());
//		return "listeProduit";
//	}
//}
