package com.packt.leverton.service;

import com.packt.leverton.domain.UrlShortened;
import com.packt.leverton.domain.request.UrlRequest;

import java.util.List;

public interface UrlService {
    List<UrlShortened> create(UrlRequest url);

    List<UrlShortened> getAll();

    void remove(int id);
}
