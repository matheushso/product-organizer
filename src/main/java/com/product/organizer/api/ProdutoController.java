package com.product.organizer.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@PostMapping
	public String get(@RequestBody String idade) {
		if (Integer.parseInt(idade) >= 18) {
			return "É maior de idade!";
		} else {
			return "Não é maior de idade";
		}
	}

}
