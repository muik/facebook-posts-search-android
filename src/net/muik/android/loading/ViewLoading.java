package net.muik.android.loading;

import android.view.View;

public class ViewLoading extends Loading {

	private View mView;

	protected ViewLoading(View view) {
		mView = view;
	}

	@Override
	public void show() {
		mView.setVisibility(View.VISIBLE);
	}

	@Override
	public void hide() {
		mView.setVisibility(View.GONE);
	}
	
	@Override
	public boolean isShowing() {
		return mView.getVisibility() == View.VISIBLE;
	}

}
