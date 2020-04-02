package com.mindtree.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.productmanagement.entity.Product;
import com.mindtree.productmanagement.service.ProductService;

@Controller
public class ControllerApp {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String viewHomePage(Model model)
	{
		List<Product> productsList=productService.getProductDetails();
		model.addAttribute("productsList",productsList);
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Product product=new Product();
		model.addAttribute("product",product);
		return "new_product";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product)
	{
		productService.insertDataToProduct(product);
		return "redirect:/";
		
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name="id") Long id) {
		ModelAndView mav=new ModelAndView("edit_product");
		Product product=productService.getById(id);
		mav.addObject("product",product);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name="id") Long id)
	{
		productService.deleteById(id);
		return "redirect:/";
	}
	
}
