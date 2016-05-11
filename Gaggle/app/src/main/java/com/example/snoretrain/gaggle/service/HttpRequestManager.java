package com.example.snoretrain.gaggle.service;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Snore Train on 4/28/2016.
 */
public class HttpRequestManager {
    private final String GET = "GET";
    private final String POST = "POST";

    public String getParty(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection httpClient = (HttpURLConnection) url.openConnection();
        httpClient.setRequestMethod(GET);

        InputStream stream = new BufferedInputStream(httpClient.getInputStream());
        String response = IOUtils.toString(stream);

        return response;
    }
    public void newParty(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection httpClient = (HttpURLConnection) url.openConnection();
        httpClient.setRequestMethod(GET);

        InputStream stream = new BufferedInputStream(httpClient.getInputStream());



    }
}
