package com.simbirsoft.TestTask.controller;

import com.simbirsoft.TestTask.domain.PageStatistics;
import com.simbirsoft.TestTask.repo.PageStatisticsRepo;
import com.simbirsoft.TestTask.service.PageHTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Controller
public class DownloadController {

    private final PageStatisticsRepo pageStatisticsRepo;
    private final PageHTTP pageHTTP;

    public DownloadController(PageHTTP pageHTTP, PageStatisticsRepo pageStatisticsRepo) {
        this.pageHTTP = pageHTTP;
        this.pageStatisticsRepo = pageStatisticsRepo;
    }

    @GetMapping("/downloadPage")
    public String getDownloadPage() {
        return "download";
    }


    @PostMapping("/downloadPage")
    public String postDownloadPage(@RequestParam(defaultValue = "", required = false) String url,
                                   Model model) {

        ArrayList<String> words;
        if (url.isEmpty()) {
            model.addAttribute("message", "Поле не может быть пустым");
        } else {
            try {
                PageStatistics pageStatistics = pageHTTP.download(url);
                words = pageStatistics
                        .getStatistics()
                        .entrySet()
                        .stream()
                        .map(o -> o.getKey() + " - " + o.getValue())
                        .collect(Collectors.toCollection(ArrayList::new));
                pageStatisticsRepo.save(pageStatistics);

            } catch (IllegalArgumentException e) {
                model.addAttribute("message", "Адрес введен не верно");
                return "download";
            } catch (IOException e) {
                model.addAttribute("message", "Не удалось загрузить страницу");
                return "download";
            }
            model.addAttribute("message", "Загрузка завершена");
            model.addAttribute("words", words);
        }
        return "download";
    }
}
