package net.muik.android.loading;


import android.view.View;

public class CrossViewLoading extends ViewLoading {

	private View mAnotherView;

	protected CrossViewLoading(View view, View anotherView) {
		super(view);
		mAnotherView = anotherView;
	}
	
	@Override
	public void show() {
		super.show();
		mAnotherView.setVisibility(View.GONE);
	}
	
	@Override
	public void hide() {
		super.hide();
		mAnotherView.setVisibility(View.VISIBLE);
	}

	public static Loading create(View view, View anotherView) {
		return new CrossViewLoading(view, anotherView);
	}

}
