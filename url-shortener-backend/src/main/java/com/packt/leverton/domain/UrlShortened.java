package com.packt.leverton.domain;

public class UrlShortened {
    private int id;
    private String url;
    private String shortened;

    public UrlShortened(int id, String url, String shortened) {
        this.id = id;
        this.url = url;
        this.shortened = shortened;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortened() {
        return shortened;
    }

    public void setShortened(String shortened) {
        this.shortened = shortened;
    }
}
