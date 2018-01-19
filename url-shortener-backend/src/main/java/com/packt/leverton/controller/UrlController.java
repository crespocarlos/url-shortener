package com.packt.leverton.controller;

import com.packt.leverton.domain.UrlShortened;
import com.packt.leverton.domain.request.UrlRequest;
import com.packt.leverton.service.UrlService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/rest")
@RestController
@Validated
@Slf4j
public class UrlController {
    @Autowired
    private UrlService urlService;

    @RequestMapping(method = RequestMethod.POST, path = "/url")
    public List<UrlShortened> createUrl(@RequestBody @Valid UrlRequest newUrl) {
        return urlService.create(newUrl);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/url")
    public List<UrlShortened> getAllUrl() {
        return urlService.getAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/url/{id}")
    public void getUrlById(@PathVariable int id) {

        urlService.remove(id);
    }
}
