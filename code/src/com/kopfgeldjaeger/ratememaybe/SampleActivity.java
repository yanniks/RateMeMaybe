package com.kopfgeldjaeger.ratememaybe;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import android.support.v4.app.FragmentActivity;
import com.kopfgeldjaeger.ratememaybe.RateMeMaybe.OnRMMUserChoiceListener;

public class SampleActivity extends FragmentActivity implements OnRMMUserChoiceListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample);

	    Button button1 = (Button) findViewById(R.id.androidpit);
	    button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				rate("androidpit");
			}
		});
	    Button button2 = (Button) findViewById(R.id.amazon);
	    button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				rate("amazon");
			}
		});
	    Button button3 = (Button) findViewById(R.id.playstore);
	    button3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				rate("play");
			}
		});
	}

	@Override
	public void handlePositive() {
		Toast.makeText(this, "Positive", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void handleNeutral() {
		Toast.makeText(this, "Neutral", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void handleNegative() {
		Toast.makeText(this, "Negative", Toast.LENGTH_SHORT).show();
	}
	
	public void rate (String store) {
		RateMeMaybe.resetData(this);
		RateMeMaybe rmm = new RateMeMaybe(this);
		rmm.setPromptMinimums(0, 0, 0, 0);
		rmm.setStore(store);
		rmm.setRunWithoutPlayStore(true);
		rmm.setAdditionalListener(this);
		rmm.run();
	}

}
