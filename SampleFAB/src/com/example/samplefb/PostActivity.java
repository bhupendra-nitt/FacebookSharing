package com.example.samplefb;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

public class PostActivity extends Activity {
	private Facebook facebook;
	Button btnPostToWall;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post);
		btnPostToWall = (Button) findViewById(R.id.button2);

		btnPostToWall.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        postToWall();
		    }
		});
	}

	@SuppressWarnings("deprecation")
	public void postToWall() {
	    // post on user's wall.
	    facebook.dialog(this, "feed", new DialogListener() {
	 
	        @Override
	        public void onFacebookError(FacebookError e) {
	        }
	 
	        @Override
	        public void onError(DialogError e) {
	        }
	 
	        @Override
	        public void onComplete(Bundle values) {
	        }
	 
	        @Override
	        public void onCancel() {
	        }
	    });
	 
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.post, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
