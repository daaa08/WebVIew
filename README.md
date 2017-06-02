# WebVIew
웹뷰 사용법


## setJavaScriptEnabled

-  페이지내의 자바스크립트가 동작하도록 해줌
```java

webView.getSettings().setJavaScriptEnabled(true);

```

## setWebViewClient
## setWebChromeClient

- 웹뷰 클라이언트를 지정.. (안하면 내장 웹브라우저가 팝업됨)
- 둘다 세팅할것 : 프로토콜에 따라 클라이언트가 선택되는것으로 파악 

```java

 webView.setWebViewClient(new WebViewClient());   // http만
 webView.setWebChromeClient(new WebChromeClient());  // htttps만

```


## startsWith

- 문자열의 시작 문자 검사
``` java
if(!url.startsWith("http")){
    url = "http://" + url;
}
```
