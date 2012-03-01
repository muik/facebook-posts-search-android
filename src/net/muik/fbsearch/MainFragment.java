package net.muik.fbsearch;

import net.muik.android.loading.Loading;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.google.android.apps.analytics.GoogleAnalyticsTracker;

public class MainFragment extends Fragment {
	
	private GoogleAnalyticsTracker tracker;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tracker = GoogleAnalyticsTracker.getInstance();
		tracker.startNewSession("UA-545027-6", getActivity());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.main, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		FragmentActivity activity = getActivity();
		Loading loading = Loading.create(activity.findViewById(R.id.loading));
		loading.show();
		
		LoaderCallbacks<WebView> loaderCallbacks = new WebViewLoaderCallbacks(this, loading);
		getLoaderManager().initLoader(0, null, loaderCallbacks);
		
		tracker.trackPageView("/main");
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		tracker.stopSession();
	}

}
