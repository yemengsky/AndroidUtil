

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;


public class WebViewActivity extends BaseActivity {

    private LinearLayout container;

    public static void startWebViewActivity(Context context, String title,
                                            String url) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    private String title;
    private String url;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_web_view);
        this.title = getIntent().getExtras().getString("title");
        this.url = getIntent().getExtras().getString("url");
        initView();
        initData();
    }

    private void initData() {
        webView.loadUrl(url);
    }


    private void initView() {
//        CoustomTitleBar barView = (CoustomTitleBar) findViewById(R.id.webview_title);
//        barView.setViewVisibility(View.VISIBLE, View.VISIBLE, View.GONE, View.GONE);

//        barView.setTitleContent(title);
//        barView.setBackListener(this);
        container = (LinearLayout) findViewById(R.id.webview_content);
        webView = new WebView(this);
//        ViewGroup.LayoutParams params=webView.getLayoutParams();
////        params.height= ViewGroup.LayoutParams.MATCH_PARENT;
////        params.width= ViewGroup.LayoutParams.MATCH_PARENT;
        container.addView(webView);
        // 重新设置websettings
        WebSettings s = webView.getSettings();
        s.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        s.setUseWideViewPort(true);
        s.supportMultipleWindows();
        s.setLoadWithOverviewMode(true);
        s.setSavePassword(true);
        s.setSaveFormData(true);
        s.setJavaScriptEnabled(true); // enable navigator.geolocation
        s.setGeolocationEnabled(true);
        // s.setGeolocationDatabasePath("/data/data/org.itri.html5webview/databases/");
        // // enable Web Storage: localStorage, sessionStorage
        s.setDomStorageEnabled(true);
        webView.requestFocus();
        //ebView.setScrollBarStyle(0);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
    }

    @Override

    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        webView.saveState(outState);
        ELog.e("save state...");

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack())
            webView.goBack();
        else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        webView.stopLoading();
        destroyWebView();
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public void destroyWebView() {
        container.removeAllViews();
        if (webView != null) {
            webView.clearHistory();
            webView.clearCache(true);
            webView.loadUrl("about:blank");
            webView.freeMemory();
            webView.pauseTimers();
            webView = null;
        }
    }
}
