package com.krzysztof.threadsFun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WebSiteReader {

    public void readUrlsFromWebsite(String webSiteUrl)   {
        try{
            URL url = new URL(webSiteUrl);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            bufferedReader.lines().filter(line-> line.contains("https"))
                    .map(line -> line.substring(line.indexOf("https")))
                    .map(this::getUrlByEndSign)
                    .forEach(System.out::println);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Please add protocol to web site url!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Please check web site url!");
        }
    }


    private String getUrlByEndSign(String line) {
        int index = line.indexOf('"');
        if (index == -1) {
            index = line.indexOf("'");
        }
        if (index != -1) {
            return line.substring(0,index);
        } else index = line.indexOf("-->");
        if (index != -1) {
            return line.substring(0,index);
        }
        return "";
    }

    public void readAllLinesFromWebsite(String websiteUrl) {
        try {
            URL url = new URL(websiteUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            reader.lines().forEach(System.out::println);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Please add protocol to web site url!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Please check web site url!");
        }
    }

}
