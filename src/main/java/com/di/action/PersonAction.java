package com.di.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.di.service.impl.PersonServiceImpl;

@Controller
@RequestMapping(path = "/person")
public class PersonAction {
	@Autowired
	private PersonServiceImpl personService;

	@RequestMapping(path = "/list")
	public String list(Model model) {
		model.addAttribute("persons", personService.findAll());
		return "/person/list";
	}
}
