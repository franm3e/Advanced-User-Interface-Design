/********************************************************/
/*  ACTIVITY: Init                                      */
/*                                                      */
/*  Generated with UML2Android                          */
/*  University of Castilla-La Mancha                    */
/*  Escuela Superior de Ingenieria informatica          */
/*  By: Victor Lopez-Jaquero                            */
/*                                                      */
/*  Author: Francisco Martinez Esteso                   */
/*                                                      */
/********************************************************/

package es.uclm.daui.datarunning.activities;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import es.uclm.daiu.datarunning.R;


public class Init extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_init);

		// Delete the app title toolbar
		getSupportActionBar().hide();

		// CountDownTimer Function
		waitForit();

	}

	public void waitForit(){
		new CountDownTimer(6000, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {
				// do nothing
			}

			@Override
			public void onFinish() {
				// Go to HomePageInfo screen
				Intent intent = new Intent(getApplicationContext(), ConsultHomePageInfo.class);
				startActivity(intent);

				finish();
			}

		}.start();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_init, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, as long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent intentSettings = new Intent(this, SettingsActivity.class);
			startActivity(intentSettings);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}

