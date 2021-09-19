package com.simbirsoft.TestTask;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        String doc=null;
//        try {
//            doc = Jsoup.connect("https://www.simbirsoft.com")
//                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
//                    .referrer("http://www.google.com")
//                    .get().text();
//        } catch (MalformedURLException e){
//            System.out.println("MalformedURLException");
//        } catch (IOException e) {
//            System.out.println("IOException");
//        }catch (IllegalArgumentException e){
//            System.out.println("iae");
//        }
//        System.out.println(doc);
//        Map<String, Integer> map = Arrays.stream(doc.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", " ").split(" "))
//                .filter(o->!o.isEmpty())
//                .filter(o->o.length()>1)
//                .map(o->o.toUpperCase())
//                .collect(Collectors.toMap(Function.identity(), count -> Integer.valueOf(1),
//                        (a,b) -> a+b, TreeMap::new));
//        map.entrySet().forEach(o->System.out.println(o.getKey() + " - " + o.getValue()));

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(".").toURI());
            System.out.println(path);
            Files.createFile(Paths.get("/uploadfile/123.txt"));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
