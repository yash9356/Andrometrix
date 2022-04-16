package com.example.andrometrixlite.Documentation;


import android.Manifest;
import android.app.DownloadManager;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.andrometrixlite.R;


public class DocActivity extends AppCompatActivity {
    private WebView web;
    public static final String USER_AGENT = "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_doc);
        web=findViewById(R.id.webView);
//        WebSettings webSettings= web.getSettings();
//        webSettings.setJavaScriptEnabled(true);



        WebSettings mywebsettings = web.getSettings();
        mywebsettings.setJavaScriptEnabled(true);
        web.setWebViewClient(new Callback());
        //web.setWebViewClient(new WebViewClient());

        //improve webview performance
        web.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        web.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        web.getSettings().setAppCacheEnabled(true);
        web.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mywebsettings.setDomStorageEnabled(true);
        mywebsettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        mywebsettings.setUseWideViewPort(true);
        mywebsettings.setSavePassword(true);
        mywebsettings.setSaveFormData(true);
        mywebsettings.setEnableSmoothTransition(true);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){

                Log.d("permission","permission denied to WRITE_EXTERNAL_STORAGE - requesting it");
                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permissions,1);
            }


        }

        //handle downloading

        web.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long contentLength) {

                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                request.setMimeType(mimeType);
                String cookies = CookieManager.getInstance().getCookie(url);
                request.addRequestHeader("cookie", cookies);
                request.addRequestHeader("User-Agent", userAgent);
                request.setDescription("Downloading file....");
                request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimeType));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimeType));
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(getApplicationContext(), "Downloading File", Toast.LENGTH_SHORT).show();
            }
        });






















        web.getSettings().setUserAgentString(USER_AGENT);
        web.setWebViewClient(new Callback());
        int webId =getIntent().getIntExtra("webId",0);
        switch (webId){
            case 0:
                web.loadUrl("https://developer.android.com/docs");
                break;
            case 1:
                web.loadUrl("https://www.geeksforgeeks.org/android-tutorial/");
                break;
            case 2:
                web.loadUrl("https://stackoverflow.com/questions/tagged/android");
                break;
            case 3:
                web.loadUrl("https://www.udemy.com/courses/development/mobile-apps/");
                break;
            case 4:
                web.loadUrl("https://github.com/");
                break;
            case 10:
                web.loadUrl("https://unsplash.com/");
                break;
            case 11:
                web.loadUrl("https://www.flaticon.com/");
                break;
            case 12:
                web.loadUrl("https://icons8.com/");
                break;
            case 13:
                web.loadUrl("https://pixabay.com/");
                break;
            case 14:
                web.loadUrl("https://www.canva.com/");
                break;
            case 15:
                web.loadUrl("https://www.pexels.com/");
                break;
            case 100:
                web.loadUrl("https://www.shutterstock.com/");
                break;
            case 101:
                web.loadUrl("https://burst.shopify.com/");
                break;
        }

    }

    private class Callback extends WebViewClient{
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
//            return super.shouldOverrideKeyEvent(view, event);
            return false;
        }
    }
}