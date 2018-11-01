package com.report;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

	@RequestMapping("/report1")
	public String report1(Model model) {
		return "report1";
	}
}
