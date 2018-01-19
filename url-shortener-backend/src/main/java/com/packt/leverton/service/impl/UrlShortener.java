package com.packt.leverton.service.impl;

import java.util.HashMap;
import java.util.Random;

public class UrlShortener {

    private HashMap<String, String> keyMap;
    private HashMap<String, String> valueMap;

    private String domain;

    private char myChars[];
    private Random myRand;
    private int keyLength;

    UrlShortener() {
        keyMap = new HashMap<String, String>();
        valueMap = new HashMap<String, String>();
        myRand = new Random();
        keyLength = 8;
        myChars = new char[62];
        for (int i = 0; i < 62; i++) {
            int j = 0;
            if (i < 10) {
                j = i + 48;
            } else if (i > 9 && i <= 35) {
                j = i + 55;
            } else {
                j = i + 61;
            }
            myChars[i] = (char) j;
        }

        domain = "http://lur.cc";
    }

    // sanitizeURL
    // This method should take care various issues with a valid url
    // e.g. www.google.com,www.google.com/, http://www.google.com,
    // http://www.google.com/
    // all the above URL should point to same shortened URL
    // There could be several other cases like these.
    private String sanitizeURL(String url) {
        if (url.substring(0, 7).equals("http://"))
            url = url.substring(7);

        if (url.substring(0, 8).equals("https://"))
            url = url.substring(8);

        if (url.charAt(url.length() - 1) == '/')
            url = url.substring(0, url.length() - 1);
        return url;
    }

    /*
     * Get Key method
     */
    private String getKey(String longURL) {
        String key;
        key = generateKey();
        keyMap.put(key, longURL);
        valueMap.put(longURL, key);
        return key;
    }

    // generateKey
    private String generateKey() {
        String key = "";
        boolean flag = true;
        while (flag) {
            key = "";
            for (int i = 0; i <= keyLength; i++) {
                key += myChars[myRand.nextInt(62)];
            }
            if (!keyMap.containsKey(key)) {
                flag = false;
            }
        }
        return key;
    }

    // shortenURL
    // the public method which can be called to shorten a given URL
    public String shortenURL(String longURL) {
        String shortURL = "";
        longURL = sanitizeURL(longURL);
        if (valueMap.containsKey(longURL)) {
            shortURL = domain + "/" + valueMap.get(longURL);
        } else {
            shortURL = domain + "/" + getKey(longURL);
        }

        // add http part
        return shortURL;
    }
}
