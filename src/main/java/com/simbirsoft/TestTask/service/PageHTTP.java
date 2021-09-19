package com.simbirsoft.TestTask.service;

import com.simbirsoft.TestTask.domain.PageStatistics;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class PageHTTP {

    public PageStatistics download(String url) throws IOException, IllegalArgumentException{
            Document doc = Jsoup.connect(url)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();

        Map<String, Long> map = Arrays.stream(doc.text().replaceAll("[^a-zA-Zа-яёА-ЯЁ]", " ").split(" "))
                .filter(o->!o.isEmpty())
                .filter(o->o.length()>1)
                .map(o->o.toUpperCase())
                .collect(Collectors.toMap(Function.identity(), count -> Long.valueOf(1),
                        (a,b) -> a+b, TreeMap::new));

        return new PageStatistics(url, map, save(doc));
    }

    private String save(Document doc) {
    return "";
    }
}
