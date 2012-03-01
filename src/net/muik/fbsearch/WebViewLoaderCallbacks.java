package net.muik.fbsearch;

import net.muik.android.loading.Loading;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.webkit.WebView;
import android.widget.FrameLayout;

public class WebViewLoaderCallbacks implements LoaderCallbacks<WebView> {
	
	private Fragment mFragment;
	private Loading mLoading;

	public WebViewLoaderCallbacks(Fragment fragment, Loading loading) {
		mFragment = fragment;
		mLoading = loading;
	}

	@Override
	public Loader<WebView> onCreateLoader(int id, Bundle arg) {
		WebViewLoader loader = new WebViewLoader(mFragment.getActivity());
		return loader;
	}

	@Override
	public void onLoadFinished(Loader<WebView> loader, WebView data) {
		FrameLayout parent = (FrameLayout) data.getParent();
		if (parent != null) {
			parent.removeView(data);
		}
		
		FrameLayout view = (FrameLayout) mFragment.getView();
		view.addView(data);
		
		String url = "http://fbsearch.muik.net";
		
		data.setWebViewClient(new BasicWebViewClient(mLoading));
		if (!url.equals(data.getUrl())) {
			data.loadUrl(url);
		}
	}

	@Override
	public void onLoaderReset(Loader<WebView> loader) {
		loader.reset();
	}
}
