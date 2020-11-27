package org.fahsep.covid19.controller;

import org.fahsep.covid19.model.CovidResult;
import org.fahsep.covid19.utils.CovidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CovidController {

    @Autowired
    CovidUtils covidUtils;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/report")
    public String getReport(@RequestParam int dayNum, Model model) {
        Map<String, CovidResult> data = covidUtils.getCovidData("iran", dayNum);
        model.addAttribute("data", data);
        return "report";
    }
}
