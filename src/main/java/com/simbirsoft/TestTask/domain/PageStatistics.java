package com.simbirsoft.TestTask.domain;

import javax.persistence.*;
import java.util.Map;

@Entity
public class PageStatistics {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String url;
    @ElementCollection
    private Map<String, Long> statistics;
    private String path;

    public PageStatistics() {
    }

    public PageStatistics(String url, Map<String, Long> statistics, String path) {
        this.url = url;
        this.statistics = statistics;
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Long> getStatistics() {
        return statistics;
    }

    public void setStatistics(Map<String, Long> statistics) {
        this.statistics = statistics;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "StatisticsPage{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", statistics=" + statistics +
                ", path='" + path + '\'' +
                '}';
    }
}
