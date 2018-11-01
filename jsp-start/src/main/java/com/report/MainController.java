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

    @RequestMapping("/report2")
    public String report2(Model model) {
        return "report2";
    }

    @RequestMapping("/report3")
    public String report3(Model model) {
        return "report3";
    }

    @RequestMapping("/report4")
    public String report4(Model model) {
        return "report4";
    }

    @RequestMapping("/report5")
    public String report5(Model model) {
        return "report5";
    }

    @RequestMapping("/report6")
    public String report6(Model model) {
        return "report6";
    }
}
