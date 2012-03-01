package net.muik.android.loading;

import android.app.Activity;
import android.app.ProgressDialog;

public class ProgressDialogLoading extends Loading {

	private Activity mActivity;
	private Integer mDialogId;
	private ProgressDialog dialog;

	protected ProgressDialogLoading(Activity activity, Integer dialogId) {
		mActivity = activity;
		mDialogId = dialogId;
	}

	public ProgressDialogLoading(Activity activity, int resId) {
		dialog = new ProgressDialog(activity);
		dialog.setMessage(activity.getResources().getText(resId));
		dialog.setIndeterminate(true);
		dialog.setCancelable(true);
	}

	public ProgressDialogLoading(ProgressDialog dialog) {
		this.dialog = dialog;
	}

	@Override
	public void show() {
		if (mDialogId != null) {
			mActivity.showDialog(mDialogId);
			return;
		}
		dialog.show();
	}

	@Override
	public void hide() {
		if (mDialogId != null) {
			mActivity.dismissDialog(mDialogId);
			return;
		}
		if (dialog.isShowing()) {
			dialog.dismiss();
		}
	}
	
	@Override
	public boolean isShowing() {
		return dialog.isShowing();
	}
	
	public static Loading create(Activity activity, int resId) {
		return new ProgressDialogLoading(activity, resId);
	}

}
