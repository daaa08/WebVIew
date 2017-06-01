package com.example.da08.runtimepermission;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    WebView webView;
    Button button, button2, button3;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView = (WebView) findViewById(R.id.webView);


        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        editText = (EditText) findViewById(R.id.editText);

        button3.setOnClickListener(this);
        button2.setOnClickListener(this);
        button.setOnClickListener(this);

        // --------------- 기본적인 웹뷰 셋팅 ------------------
        // 페이지내의 자바스크립트가 동작하도록 해줌
        webView.getSettings().setJavaScriptEnabled(true);


        // 1 웹뷰 클라이언트를 지정.. (안하면 내장 웹브라우저가 팝업됨)
        webView.setWebViewClient(new WebViewClient());   // http만
        // 2 둘다 세팅할것 : 프로토콜에 따라 클라이언트가 선택되는것으로 파악 됨..
        webView.setWebChromeClient(new WebChromeClient());  // htttps만

        // ------------------------------------------------

        loadUrl("naver.com");

//        webView.loadUrl("http://naver.com");
    }

    private void loadUrl(String url){
        // 문지열앞에 프로토콜인 http 문자열이 없다면 붙여준다
        if(!url.startsWith("http")){
            url = "http://" + url;
        }
        // url 호출하기
        webView.loadUrl(url);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button :
                // 뒤로가기

                if(webView.canGoBack()){
                    webView.goBack();
                }
                break;
            case R.id.button2 :
                // 앞으로 가기

                if(webView.canGoForward()){
                    webView.goForward();
                }
                break;
            case R.id.button3 :
                // url 이동
                String str = editText.getText().toString();
                if(!"".equals(str)){ // 공백이 아니거나 url 패턴일 경우에만 처리
                    loadUrl(str);
                }
                break;
        }
    }
}
