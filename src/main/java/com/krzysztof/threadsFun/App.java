package com.krzysztof.threadsFun;


public class App 
{
    public static void main( String[] args )
    {

        WebSiteReader reader = new WebSiteReader();
        reader.readUrlsFromWebsite("https://www.wp.pl/");
//        reader.readAllLinesFromWebsite("https://www.wp.pl/");

    }
}
