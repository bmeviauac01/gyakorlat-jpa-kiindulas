package hu.bme.aut.adatvez.webshop.web;

import hu.bme.aut.adatvez.webshop.dao.TermekRepository;
import hu.bme.aut.adatvez.webshop.model.Fizetesmod;
import hu.bme.aut.adatvez.webshop.model.Termek;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebshopController {

	private static final String UJ_FIZETESMOD_KEY = "fizetesmod";

	@Autowired
	TermekRepository termekRepository;
	
	
	@RequestMapping("/")
	public String home(Map<String, Object> model) {

		model.put("termekek30Folott", findTermekek30Folott());
		model.put("legalabbKetszerRendeltTermekek",
				findLegalabbKetszerRendeltTermekek());
		model.put("legdragabbTermekek", findLegdragabbTermekek());		
		model.putIfAbsent(UJ_FIZETESMOD_KEY, new Fizetesmod());
		model.put("epitoElemek", findEpitolemek());
		model.put("dragaJatekok", findDragaJatekok());
		return "testPage";
	}


	// 4.a feladat
	private List<Termek> findTermekek30Folott() {
		// TODO
		return null;
	}

	// 4.b feladat
	private List<Termek> findLegalabbKetszerRendeltTermekek() {
		// TODO
		return null;
	}

	// 4.c feladat
	private List<Termek> findLegdragabbTermekek() {
		// TODO
		return null;
	}

	// 5.a feladat
	@RequestMapping(value = "/epitoElemekDragit", method = {RequestMethod.POST, RequestMethod.GET })
	private String epitoElemekDragit() {

		// TODO
		
		return "redirect:/";
	}

	// 5.b feladat
	@RequestMapping(value = "/dragaTermekbeAtsorol", method = {RequestMethod.POST, RequestMethod.GET })
	private String dragaTermekbeAtsorol() {

		// TODO
		
		return "redirect:/";
	}


	//6. feladat
	@RequestMapping(value = "/ujFizetesiMod", method = {RequestMethod.POST, RequestMethod.GET })
	private String ujFizetesiMod(@Valid Fizetesmod fizetesmod, BindingResult errors, RedirectAttributes redirectAttributes) {

		if(!errors.hasErrors()){
			Long ujId = null;
			// TODO

			redirectAttributes.addFlashAttribute("ujId", ujId);
		}else{
			redirectAttributes.addFlashAttribute(UJ_FIZETESMOD_KEY, fizetesmod);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + UJ_FIZETESMOD_KEY, errors);
		}
		
		return "redirect:/";
	}
	
	private List<Termek> findEpitolemek() {
		return termekRepository.findByKategoriaNev("Építő elemek");
	}

	private  List<Termek> findDragaJatekok() {
		return termekRepository.findByKategoriaNev("Drága játékok");
	}

}
