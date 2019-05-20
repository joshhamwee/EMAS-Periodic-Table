package com.pta.joshhamwee.periodictablemain;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HelpActivity extends AppCompatActivity {

    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        setUpToolbar(); //Function that handles the toolbar, see below
        setUpList(); //Function that handles the FAQ's
    }

    private void setUpList(){
        listView = (ExpandableListView)findViewById(R.id.help_view);
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Search for Elements");
        listDataHeader.add("Filter Elements");
        listDataHeader.add("Changing Units");
        listDataHeader.add("View Energy Graph");

        List<String> searchElements = new ArrayList<>();
        searchElements.add("To search for an element, click on the search icon in the top right corner of the home page. You can search for an element by name, atomic symbol, or atomic number.");

        List<String> filterElements = new ArrayList<>();
        filterElements.add("To filter elements based on different crystal and instrument pairs, click the filter icon in the top right corner top of the home page. The elements will be highlighted if they are detectable within that crystal's range given the instrument chosen.");

        List<String> changeUnits = new ArrayList<>();
        changeUnits.add("Once you have selected an element from either the periodic table or the search function then you will be presented with the element data page.");
        changeUnits.add("You can change the units of the data by selecting the instrument and crystal pair from the dropdown list found in the top right corner of element page. The default unit is keV.");

        List<String> viewGraphs = new ArrayList<>();
        viewGraphs.add("The energy graphs can be viewed by clicking the 'Energy Graph' option in the menu drawer. You can scroll down to view all the graphs.");

        listHash.put(listDataHeader.get(0),searchElements);
        listHash.put(listDataHeader.get(1),filterElements);
        listHash.put(listDataHeader.get(2),changeUnits);
        listHash.put(listDataHeader.get(3),viewGraphs);

        listAdapter = new com.pta.joshhamwee.periodictablemain.ExpandableListAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);

    }
    private void setUpToolbar(){
        drawerLayout = findViewById(R.id.drawer_layout);

        toolbar = findViewById(R.id.toolbar); //Find the toolbar
        setSupportActionBar(toolbar); //Start the toolbar
        toolbar.bringToFront();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Help: How to use the app ");
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener( //On click listener for each item in the menu
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) { //Switch case for each item in the menu
                            case R.id.home:
                                menuItem.setChecked(true);
                                openMainActivity(); //Open main activity on click
                                break;
                            case R.id.graph:
                                menuItem.setChecked(true);
                                openEnergyActivity(); //Open energy activity on click
                                break;
                            case R.id.help:
                                menuItem.setChecked(true); //Do nothing
                                drawerLayout.closeDrawer(GravityCompat.START); //Close the drawer
                                break;
                            case R.id.about_us:
                                menuItem.setChecked(true);
                                openAboutUsActivity(); //Open about us activity on click
                                break;
                        }
                        return false;
                    }
                }
        );
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    //When main page is selected from drawer, start the new activity
    private void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class); //Create the intent that opens the new activity
        startActivity(intent); //Execute the intent
    }

    //When energy page is selected from drawer, start the new activity
    private void openEnergyActivity(){
        Intent intent = new Intent(this, EnergyActivity.class); //Create the intent that opens the new activity
        startActivity(intent); //Execute the intent
    }

    //When about us page is selected from drawer, start the new activity
    private void openAboutUsActivity(){
        Intent intent = new Intent(this, AboutUsActivity.class); //Create the intent that opens the new activity
        startActivity(intent); //Execute the intent
    }

    //When the search button is clicked, start the search
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START); //When drawer button is clicked, open the drawer
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
