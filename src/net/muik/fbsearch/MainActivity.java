package net.muik.fbsearch;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		if (getSupportFragmentManager().findFragmentById(android.R.id.content) == null) {
			Bundle extras = getIntent().getExtras();
			MainFragment fragment = new MainFragment();
			fragment.setArguments(extras);
			getSupportFragmentManager().beginTransaction()
					.add(android.R.id.content, fragment).commit();
		}
	}
}