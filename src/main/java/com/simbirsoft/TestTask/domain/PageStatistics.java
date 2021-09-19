package com.simbirsoft.TestTask.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@Entity
public class PageStatistics {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String url;
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String, Long> statistics;
    private String path;
    private Date dateUpload;

    public PageStatistics() {
    }

    public PageStatistics(String url, Map<String, Long> statistics, String path) {
        this.url = url;
        this.statistics = statistics;
        this.path = path;
        this.dateUpload = new Date();
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

    public Date getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(Date date) {
        this.dateUpload = date;
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
