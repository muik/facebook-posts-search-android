package net.muik.android.loading;

import android.view.View;
import android.widget.Button;

public class ButtonLoading extends ViewLoading {

	private Button mButton;

	public ButtonLoading(View view, Button button) {
		super(view);
		mButton = button;
	}
	
	@Override
	public void show() {
		super.show();
		mButton.setEnabled(false);
	}
	
	@Override
	public void hide() {
		super.hide();
		mButton.setEnabled(true);
	}

}
