package com.example.luxiaoju.vebviewonlinefile;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    private WebView m_webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://172.16.0.175:8044/htmlTest.html";
        String fileUrl = "http://172.16.0.175:8044/testFile.docx";
        String wwUrl ="http://staff.zotn.com:9042/testFile.docx";
        String softUrl ="http://view.officeapps.live.com/op/view.aspx?src=newteach.pbworks.com%2Ff%2Fele%2Bnewsletter.docx";
        m_webView = (WebView) findViewById(R.id.webView_file);
        m_webView.setWebViewClient(new WebViewClient(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        m_webView.setWebChromeClient(new WebChromeClient());

        m_webView.getSettings().setJavaScriptEnabled(true);
        m_webView.getSettings().setUseWideViewPort(true);
//        m_webView.loadUrl("http://view.officeapps.live.com/op/view.aspx?src="+ URLEncoder.encode(wwUrl));
        m_webView.loadUrl(url);
//        m_webView.loadUrl(softUrl);
    }
}
