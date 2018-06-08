/********************************************************/
/*  ACTIVITY: Consult HomePage Info                     */
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

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SearchView;
import android.widget.Toast;

import es.uclm.daiu.datarunning.R;


public class ConsultHomePageInfo extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulthomepageinfo);

        // Searcher Toolbar funcionality
        SearchView simpleSearchView = (SearchView) findViewById(R.id.searcher);
        simpleSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            // Do something when query submit
            @Override
            public boolean onQueryTextSubmit(String query) {
                // There is only a user call Francisco Martinez
                if(query.equals("Francisco Martinez")){
                    Intent intent = new Intent(getApplicationContext(), Searchforarunnerpage.class);
                    startActivity(intent);
                }
                // If other user is introduced as a query
                else{
                    Toast.makeText(getApplicationContext(), "Not a registered user! Try it again!", Toast.LENGTH_LONG).show();
                }

                return false;
            }

            // Do something when text changes
            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }

        });

        // TABS

        // Initializing the TabLayout
        tabLayout = (TabLayout) findViewById(R.id.simpleTabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        // Initializing ViewPager
        viewPager = (ViewPager) findViewById(R.id.simpleViewPager);

        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        // Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_consulthomepageinfo, menu);
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

