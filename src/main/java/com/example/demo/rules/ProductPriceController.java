package com.example.demo.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductPriceController {

	private final ProductPriceService productPriceService;

	@Autowired
	public ProductPriceController(ProductPriceService productPriceService) {
		this.productPriceService = productPriceService;
	}

	@RequestMapping(value = "/ruleengine/getDiscount", method = RequestMethod.GET, produces = "application/json")
	public Product getQuestions(@RequestParam(required = true) String type) {

		Product product = new Product();
		product.setType(type);
		productPriceService.getProductDiscount(product);
		return product;
	}
}
