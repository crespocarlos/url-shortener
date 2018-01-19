package com.packt.leverton.service.impl;

import com.packt.leverton.domain.UrlShortened;
import com.packt.leverton.domain.request.UrlRequest;
import com.packt.leverton.service.UrlService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UrlServiceImpl implements UrlService {

    private static List<UrlShortened> urls = new ArrayList<>();

    @Override public List<UrlShortened> create(UrlRequest url) {
        int size = urls.size();
        if (!isValidUrl(url.getUrl())) {
            throw new IllegalArgumentException("Invalid url");
        }

        UrlShortener urlShortener = new UrlShortener();

        UrlShortened newUrl = new UrlShortened(size, url.getUrl(), urlShortener.shortenURL(url.getUrl()));
        urls.add(newUrl);
        return urls;
    }

    @Override public List<UrlShortened> getAll() {
        return urls;
    }

    @Override public void remove(int id) {
        urls.removeIf(p -> p.getId() == id);
    }

    private boolean isValidUrl(String url) {
        String regex = "^https?://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        return url.matches(regex);
    }
}
