package susanna.CochesCrudSpring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import susanna.CochesCrudSpring.model.Coches;
import susanna.CochesCrudSpring.repository.CochesRepository;




@Controller

public class CochesController { 
	@Autowired 
	private CochesRepository cocheRepository;
	@GetMapping("/coches")
	public String getAll(Model model, @Param("keyword") String keyword) {

		try {
			List<Coches> coches = new ArrayList<Coches>();
			System.out.println(keyword);
			if (keyword == null) {
				cocheRepository.findAll().forEach(coches::add);
			} else {
				cocheRepository.findByMarcaContainingIgnoreCase(keyword).forEach(coches::add);
				model.addAttribute("keyword", keyword);
				cocheRepository.findByModeloContainingIgnoreCase(keyword).forEach(coches::add);
				model.addAttribute("keyword", keyword);
			}
			model.addAttribute("coches", coches);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
		}
		return "coches";
	}
	@GetMapping("/coches/new")
	public String add(Model model) {
		Coches coches = new Coches();
		model.addAttribute("coches", coches);
		model.addAttribute("pageTitle", "Introducir Coche");

		return "coches_form";
	}

	@PostMapping("/coches/save")
	public String save(Coches coches, RedirectAttributes redirectAttributes) {
		try {
			cocheRepository.save(coches);

			redirectAttributes.addFlashAttribute("message", "Coche guardado");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/coches";
	}

	@GetMapping("/coches/{id}")
	public String editTutorial(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
		try {
			Coches coches = cocheRepository.findById(id).get();

			model.addAttribute("coches", coches);
			model.addAttribute("pageTitle", "Editar Coche (ID: " + id + ")");

			return "coches_form";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}
		return "coches_form";
	}

	
	@GetMapping("/coches/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {

		try {
			cocheRepository.deleteById(id);

			redirectAttributes.addFlashAttribute("message", "Coche con id=" + id + " eliminado");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}

		return "redirect:/coches";
	} 
	}
	
	
	
	
