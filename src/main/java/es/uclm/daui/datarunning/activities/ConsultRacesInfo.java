/********************************************************/
/*  ACTIVITY: Consult Races Info                        */
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

import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

import es.uclm.daiu.datarunning.R;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;

// protected region userImports on begin
// Add your imports here. They will be preserved even if the file is generated again.
//******** USER DEFINED IMPORTS CODE BEGIN **************


//******** USER DEFINED IMPORTS END **************
// protected region userImports end

public class ConsultRacesInfo extends AppCompatActivity {
// protected region userDeclarations on begin
// Add your declarations here. They will be preserved even if the file is generated again.
//******** USER DEFINED DECLARATIONS CODE BEGIN **************


//******** USER DEFINED DECLARATIONS END **************
// protected region userDeclarations end

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_consultracesinfo);
}

// protected region userDefined on begin
// Add your code here. It will be preserved even if the file is generated again.
//******** USER DEFINED CODE BEGIN **************


//******** USER DEFINED CODE END **************
// protected region userDefined end

@Override
protected void onResume() {
super.onResume();
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.menu_consultracesinfo, menu);
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


} //  --- End of Activity ----

