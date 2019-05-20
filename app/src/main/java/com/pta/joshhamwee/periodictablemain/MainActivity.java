package com.pta.joshhamwee.periodictablemain;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

/*
 This is the main activity of the app, i.e. the home page. It contains the periodic table.
 */
public class MainActivity extends AppCompatActivity{

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    //Array of button id's to iterate over all buttons and set on click listeners
    Integer[] listOfIds = {
            R.id.H,R.id.He,R.id.Li,R.id.Be,R.id.B,R.id.C,R.id.N,R.id.O,R.id.F,R.id.Ne,R.id.Na,R.id.Mg,R.id.Al,R.id.Si,R.id.P,R.id.S,R.id.Cl,R.id.Ar,
            R.id.K,R.id.Ca,R.id.Sc,R.id.Ti,R.id.V,R.id.Cr,R.id.Mn,R.id.Fe,R.id.Co,R.id.Ni,R.id.Cu,R.id.Zn,R.id.Ga,R.id.Ge,R.id.As,R.id.Se,R.id.Br,R.id.Kr,
            R.id.Rb,R.id.Sr,R.id.Y,R.id.Zr,R.id.Nb,R.id.Mo,R.id.Tc,R.id.Ru,R.id.Rh,R.id.Pd, R.id.Ag, R.id.Cd, R.id.In, R.id.Sn, R.id.Sb, R.id.Te, R.id.I, R.id.Xe,
            R.id.Cs, R.id.Ba, R.id.La, R.id.Ce, R.id.Pr, R.id.Nd, R.id.Pm, R.id.Sm, R.id.Eu, R.id.Gd, R.id.Tb, R.id.Dy, R.id.Ho, R.id.Er, R.id.Tm, R.id.Yb, R.id.Lu,
            R.id.Hf, R.id.Ta, R.id.W, R.id.Re, R.id.Os, R.id.Ir, R.id.Pt, R.id.Au, R.id.Hg, R.id.Tl, R.id.Pb, R.id.Bi, R.id.Po, R.id.At, R.id.Rn,
            R.id.Fr, R.id.Ra, R.id.Ac, R.id.Th, R.id.Pa, R.id.U, R.id.Np, R.id.Pu, R.id.Am, R.id.Cm, R.id.Bk, R.id.Cf, R.id.Es, R.id.Fm, R.id.Md, R.id.No, R.id.Lr
    };

    private ArrayList<Integer> button_ids = new ArrayList<>(Arrays.asList(listOfIds));
    //private ArrayList<Integer> dropDownIDS = new ArrayList<>(Arrays.asList(listDropDown));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar(); //Function that handles the toolbar, see below
        setUpElements(); //Function that handles each button for the elements
    }

    private void setUpElements(){
        //For loop to create onClickListeners for each button
        //Override the onClick method to openActivityDisplayElementData
        for (final int id:button_ids){
            ImageButton button = (ImageButton) findViewById(id);
            button.bringToFront();
            button.setOnClickListener(null);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivityDisplayElementData(id);
                }
            });
        }

        Bundle dataFromMain = getIntent().getExtras();
        if (dataFromMain != null){
            Integer instrument = dataFromMain.getInt("instrument");                  //get passed atomic number
            Integer crystal = dataFromMain.getInt("crystal");   //gets passed atomic number
            if (instrument != 0 & crystal != 0){
                highlightElements(instrument,crystal);
            }
        }
    }

    private void setUpToolbar(){
        drawerLayout = findViewById(R.id.drawer_layout);

        toolbar = findViewById(R.id.toolbar); //Find the toolbar
        setSupportActionBar(toolbar); //Start the toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //setting up the drop down menu icon
        Drawable dropDown = ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_filter_outline);
        toolbar.setOverflowIcon(dropDown);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener( //On click listener for each item in the menu
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) { //Switch case for each item in the menu
                            case R.id.home:
                                menuItem.setChecked(true); //Do nothing
                                drawerLayout.closeDrawer(GravityCompat.START); //Close the drawer
                                break;
                            case R.id.graph:
                                menuItem.setChecked(true);
                                openEnergyActivity(); //Open energy activity on click
                                break;
                            case R.id.help:
                                menuItem.setChecked(true);
                                openHelpActivity(); //Open help activity on click
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

    //When an element is clicked on, open new activity
    private void openActivityDisplayElementData(int id){
        Intent intent = new Intent(this,DisplayElementDataActivity.class); //Create the intent that opens the new activity
        intent.putExtra("ElementID",button_ids.indexOf(id) + 1);  //Put extra data into the intent so that next activity knows what element was clicked on
        startActivity(intent); //Execute the intent
    }

    //When help page is selected from drawer, start the new activity
    private void openHelpActivity(){
        Intent intent = new Intent(this, HelpActivity.class); //Create the intent that opens the new activity
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

    //Create an option for the search button in the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dropdown_menu,menu);
        inflater.inflate(R.menu.menu_search, menu);

        return true;
    }

    //When the search button is clicked, start the search
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_m:
                super.onSearchRequested(); //Start search dialog
                return true;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START); //When drawer button is clicked, open the drawer
                return true;
            //When a specific instrument and crystal is selected refresh the activity with data coded into its Intent
            case R.id.C_LiF_200: onRefreshActivity(1,1); return true;
            case R.id.C_PET: onRefreshActivity(1,2); return true;
            case R.id.C_TAP: onRefreshActivity(1,3); return true;
            case R.id.C_LiF_220: onRefreshActivity(1,4); return true;
            case R.id.C_Qtz_1011: onRefreshActivity(1,5); return true;
            case R.id.JX_LiF_200: onRefreshActivity(2,1); return true;
            case R.id.JX_PET: onRefreshActivity(2,2); return true;
            case R.id.JX_TAP: onRefreshActivity(2,3); return true;
            case R.id.JX_LiF_220: onRefreshActivity(2,4); return true;
            case R.id.JX_Qtz_1011: onRefreshActivity(2,5); return true;
            case R.id.JF_LiF_200: onRefreshActivity(3,1); return true;
            case R.id.JF_PET: onRefreshActivity(3,2); return true;
            case R.id.JF_TAP: onRefreshActivity(3,3); return true;
            case R.id.JF_LiF_220: onRefreshActivity(3,4); return true;
            case R.id.JF_Qtz_1011: onRefreshActivity(3,5); return true;
            case R.id.JH_LiF_200: onRefreshActivity(4,1); return true;
            case R.id.JH_PET: onRefreshActivity(4,2); return true;
            case R.id.JH_TAP: onRefreshActivity(4,3); return true;
            case R.id.JH_LiF_220: onRefreshActivity(4,4); return true;
            case R.id.JH_Qtz_1011: onRefreshActivity(4,5); return true;
            case R.id.reset: onRefreshActivity(0,0);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //Overriding the default android back button to go to main page
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    //Refresh the current activity each time a colour change has been requested
    private void onRefreshActivity(Integer instrument, Integer crystal){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("instrument",instrument);
        intent.putExtra("crystal",crystal);
        this.finish();
        startActivity(intent);
    }

    //Change an elements colour dependant on whether the specific element is within the given boundaries
    private void highlightElements(Integer instrument, Integer crystal){
        elementHighlighted current = new elementHighlighted(instrument,crystal);
        for(Integer i = 1; i < listOfIds.length + 1; i++){
            ImageButton working = (ImageButton) findViewById(button_ids.get(i-1));
            if (i >= current.minRangeA & i <= current.maxRangeA){
                working.setBackground(ContextCompat.getDrawable(this,R.drawable.colour1));
            } else if (i >= current.minRangeB & i <= current.maxRangeB){
                working.setBackground(ContextCompat.getDrawable(this,R.drawable.colour7));
            } else if (i >= current.minRangeC & i <= current.maxRangeC){
                working.setBackground(ContextCompat.getDrawable(this,R.drawable.colour4));
            } else {
                working.setBackground(ContextCompat.getDrawable(this,R.drawable.colour8));
            }
        }
    }

}
