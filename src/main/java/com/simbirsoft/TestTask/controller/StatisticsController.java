package com.simbirsoft.TestTask.controller;

import com.simbirsoft.TestTask.domain.PageStatistics;
import com.simbirsoft.TestTask.repo.PageStatisticsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Controller
public class StatisticsController {

    @Autowired
    PageStatisticsRepo pageStatisticsRepo;

    @GetMapping("/statisticPage")
    public String getStatisticPage(Model model){
        model.addAttribute("pages", pageStatisticsRepo.findAll());
        return "statistic";
    }

    @GetMapping("statisticPage/{pageStatistics}/get")
    public String getStatisticWord(@PathVariable PageStatistics pageStatistics,
                                   Model model){

        ArrayList<String> words = pageStatistics.getStatistics()
                .entrySet()
                .stream()
                .map(o-> o.getKey() + " - " + o.getValue())
                .collect(Collectors.toCollection(ArrayList::new));

        model.addAttribute("words", words);
        return "statisticWords";
    }
}
