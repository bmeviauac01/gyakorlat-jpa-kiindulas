package hu.bme.aut.adatvez.webshop.web;

import hu.bme.aut.adatvez.webshop.dao.ProductRepository;
import hu.bme.aut.adatvez.webshop.model.Paymentmethod;
import hu.bme.aut.adatvez.webshop.model.Product;

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

	private static final String NEW_PAYMENTMETHOD_KEY = "paymentmethod";

	@Autowired
	ProductRepository productRepository;
	
	
	@RequestMapping("/")
	public String home(Map<String, Object> model) {

		model.put("productsOver30", findProductsOver30());
		model.put("productsOrderedAtLeastTwice",
				findProductsOrderedAtLeastTwice());
		model.put("mostExpensiveProducts", findMostExpensiveProducts());		
		model.putIfAbsent(NEW_PAYMENTMETHOD_KEY, new Paymentmethod());
		model.put("buildingItems", findBuildingItems());
		model.put("expensiveToys", findExpensiveToys());
		return "testPage";
	}


	// Task 4.a
	private List<Product> findProductsOver30() {
		// TODO
		return null;
	}

	// Task 4.b
	private List<Product> findProductsOrderedAtLeastTwice() {
		// TODO
		return null;
	}

	// Task 4.c
	private List<Product> findMostExpensiveProducts() {
		// TODO
		return null;
	}

	// Task 5.a
	@RequestMapping(value = "/raisePriceOfBuildingItems", method = {RequestMethod.POST, RequestMethod.GET })
	private String raisePriceOfBuildingItems() {

		// TODO
		
		return "redirect:/";
	}

	// Task 5.b
	@RequestMapping(value = "/moveToExpensiveToys", method = {RequestMethod.POST, RequestMethod.GET })
	private String moveToExpensiveToys() {

		// TODO
		
		return "redirect:/";
	}


	//Task 6.
	@RequestMapping(value = "/newPaymentMethod", method = {RequestMethod.POST, RequestMethod.GET })
	private String newPaymentMethod(@Valid Paymentmethod paymentMethod, BindingResult errors, RedirectAttributes redirectAttributes) {

		if(!errors.hasErrors()){
			// TODO

			redirectAttributes.addFlashAttribute("success", true);
		}else{
			redirectAttributes.addFlashAttribute(NEW_PAYMENTMETHOD_KEY, paymentMethod);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + NEW_PAYMENTMETHOD_KEY, errors);
		}
		
		return "redirect:/";
	}
	
	private List<Product> findBuildingItems() {
		return productRepository.findByCategoryName("Building items");
	}

	private  List<Product> findExpensiveToys() {
		return productRepository.findByCategoryName("Expensive toys");
	}

}
