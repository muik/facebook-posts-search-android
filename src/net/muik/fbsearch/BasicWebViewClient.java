package net.muik.fbsearch;

import net.muik.android.loading.Loading;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BasicWebViewClient extends WebViewClient {
	
	private Loading mLoading;
	
	public BasicWebViewClient(Loading loading) {
		mLoading = loading;
	}
	
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		if (url.startsWith("http://fbsearch.muik.net")) {
			return super.shouldOverrideUrlLoading(view, url);
		} else {
			Uri uri = Uri.parse(url);
			Intent intent  = new Intent(Intent.ACTION_VIEW, uri);
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			view.getContext().startActivity(intent);
			return true;
		}
	}
	
	@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon) {
		super.onPageStarted(view, url, favicon);
		view.setVisibility(View.INVISIBLE);
		mLoading.show();
	}
	
	@Override
	public void onPageFinished(WebView view, String url) {
		super.onPageFinished(view, url);
		view.setVisibility(View.VISIBLE);
		mLoading.hide();
	}

}
