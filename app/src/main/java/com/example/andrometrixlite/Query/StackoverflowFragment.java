package com.example.andrometrixlite.Query;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.andrometrixlite.R;


public class StackoverflowFragment extends Fragment {
    private WebView web;
    public static final String USER_AGENT = "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";


    public StackoverflowFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stackoverflow, container, false);
        web=view.findViewById(R.id.webView1);
        WebSettings webSettings= web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.getSettings().setUserAgentString(USER_AGENT);
        web.setWebViewClient(new StackoverflowFragment.Callback());
        web.loadUrl("https://stackoverflow.com/");

        return view;
    }
    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
//            return super.shouldOverrideKeyEvent(view, event);
            return false;
        }
    }
}