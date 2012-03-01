package net.muik.android.loading;

import android.app.ProgressDialog;
import android.view.View;

public abstract class Loading {

	public void show() {
	}
	
	public void hide() {
	}
	
	public static Loading create(ProgressDialog dialog) {
		return new ProgressDialogLoading(dialog);
	}

	public static Loading create(View view) {
		return new ViewLoading(view);
	}

	public boolean isShowing() {
		return false;
	}
}
