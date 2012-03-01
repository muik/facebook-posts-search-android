package net.muik.fbsearch;

import android.content.Context;
import android.support.v4.content.Loader;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;

public class WebViewLoader extends Loader<WebView> {
	
	private WebView mWebView;

	public WebViewLoader(Context context) {
		super(context);
	}
	
	@Override
	protected void onStartLoading() {
		super.onStartLoading();
		
		if (mWebView != null) {
			deliverResult(mWebView);
		}
		
		if (takeContentChanged() || mWebView == null) {
			forceLoad();
		}
	}
	
	@Override
	public void forceLoad() {
		super.forceLoad();

		Context context = getContext();
		mWebView = new WebView(context);
		mWebView.setScrollbarFadingEnabled(true);
		WebSettings webSettings = mWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setDomStorageEnabled(true);
		webSettings.setAllowFileAccess(true);
		webSettings.setAppCacheEnabled(true);
		webSettings.setAppCacheMaxSize(1024*1024*8);
		String appCachePath = context.getCacheDir().getAbsolutePath();
		webSettings.setAppCachePath(appCachePath);
		
		mWebView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onReachedMaxAppCacheSize(long spaceNeeded,
					long totalUsedQuota,
					WebStorage.QuotaUpdater quotaUpdater) {
				quotaUpdater.updateQuota(spaceNeeded * 2);
			}
		});

		// webview에서 input 눌렀을때 키보드 나오게 하기
		mWebView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
				case MotionEvent.ACTION_UP:
					if (!v.hasFocus()) {
						v.requestFocus();
					}
					break;
				}
				return false;
			}
		});
		
		deliverResult(mWebView);
	}
	
	@Override
	public void reset() {
		super.reset();
		if (mWebView != null) {
			mWebView.stopLoading();
			mWebView = null;
		}
	}

}
