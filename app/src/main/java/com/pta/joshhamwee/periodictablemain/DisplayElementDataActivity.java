package com.pta.joshhamwee.periodictablemain;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DisplayElementDataActivity extends AppCompatActivity {

    Toolbar toolbar;

    //Lists of different elements to determine colours
    private static final Set<Integer> AlkMetals = new HashSet<>(Arrays.asList(new Integer[]{1,3,11,19,37,55,87}));
    private static final Set<Integer> AlkEMetals = new HashSet<>(Arrays.asList(new Integer []{4,12,20,38,56,88}));
    private static final Set<Integer> TranMetals = new HashSet<>(Arrays.asList(new Integer []{21,22,23,24,25,26,27,28,29,30,
                            39,40,41,42,43,44,45,46,47,48,57,72,73,74,75,76,77,78,79,80,89}));
    private static final Set<Integer> Metaloids = new HashSet<>(Arrays.asList(new Integer []{13,31,32,49,50,51,81,82,83,84}));
    private static final Set<Integer> NonMetals = new HashSet<>(Arrays.asList(new Integer []{5,6,7,8,9,14,15,16,17,33,34,35,52,53,85}));
    private static final Set<Integer> NobleGases = new HashSet<>(Arrays.asList(new Integer []{2,10,18,36,54,86}));
    private CurrentElement currentElement;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_element_data);

        //Sets up the toolbar on this activity
        setUpToolbar();

        //Get the ID Data that was passed from main activity or search activity
        Bundle dataFromMain = getIntent().getExtras();
        Integer atomicNumber = dataFromMain.getInt("ElementID");                  //get passed atomic number
        Integer elementSize = dataFromMain.getInt("ElementIDSearch");   //gets passed atomic number
        if(elementSize != 0){
            atomicNumber = elementSize;
        }
        setUpButtons(atomicNumber);
        //create a new database instance
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);

        //Create an element object that relates to the specific ID
        currentElement = new CurrentElement(atomicNumber, databaseAccess);

        TextView ElementName = findViewById(R.id.ElementName);
        ElementName.setText(currentElement.name);
        displayKeVValues(currentElement);

        //Underlining the headers
        TextView KLMHeader = findViewById(R.id.KLM_Energies_Header);
        SpannableString KLM = new SpannableString("KLM Energies:");
        KLM.setSpan(new UnderlineSpan(),0,KLM.length(),0);
        KLMHeader.setText(KLM);

        TextView AbsorptionHeader = findViewById(R.id.Absorbsion_Edges_Header);
        SpannableString Absorption = new SpannableString("Absorption Edges:");
        Absorption.setSpan(new UnderlineSpan(),0,Absorption.length(),0);
        AbsorptionHeader.setText(Absorption);

        //changing colours of element name and buttons according to position in table
        Button nextElement = (Button) findViewById(R.id.next_element);
        Button prevElement = (Button) findViewById(R.id.previous_element);


        //This is the colour change to the specific atomic number
        if(AlkMetals.contains(atomicNumber)) {
            ElementName.setTextColor(ContextCompat.getColor(this, R.color.pastelPink));
            nextElement.setBackground(ContextCompat.getDrawable(this,R.drawable.button_colour1));
            prevElement.setBackground(ContextCompat.getDrawable(this,R.drawable.button_colour1));
            if(atomicNumber == 1) prevElement.setVisibility(View.INVISIBLE);
        }
        else if(AlkEMetals.contains(atomicNumber)){
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelOrange));
            nextElement.setBackground(ContextCompat.getDrawable(this,R.drawable.button_colour2));
            prevElement.setBackground(ContextCompat.getDrawable(this,R.drawable.button_colour2));
        }
        else if(TranMetals.contains(atomicNumber)){
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelYellow));
            nextElement.setBackground(ContextCompat.getDrawable(this,R.drawable.button_colour3));
            prevElement.setBackground(ContextCompat.getDrawable(this,R.drawable.button_colour3));
        }
        else if(Metaloids.contains(atomicNumber)){
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelBlue));
            nextElement.setBackground(ContextCompat.getDrawable(this,R.drawable.button_colour4));
            prevElement.setBackground(ContextCompat.getDrawable(this,R.drawable.button_colour4));
        }
        else if(NonMetals.contains(atomicNumber)){
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelPurple));
            nextElement.setBackground(ContextCompat.getDrawable(this,R.drawable.button_colour5));
            prevElement.setBackground(ContextCompat.getDrawable(this,R.drawable.button_colour5));
        }
        else if(NobleGases.contains(atomicNumber)){
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelGrey));
            nextElement.setBackground(ContextCompat.getDrawable(this,R.drawable.button_colour6));
            prevElement.setBackground(ContextCompat.getDrawable(this,R.drawable.button_colour6));
        }
        else{
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelGreen));
            nextElement.setBackground(ContextCompat.getDrawable(this,R.drawable.button_colour7));
            prevElement.setBackground(ContextCompat.getDrawable(this,R.drawable.button_colour7));
            if(atomicNumber == 103) nextElement.setVisibility(View.INVISIBLE);
        }

    }


    private void displayKeVValues(CurrentElement currentElement){
        //Create textViews to display the chosen element's information
        TextView AtomicNumber = findViewById(R.id.AtomicNumber);
        AtomicNumber.setText(currentElement.atomicNumber);
        TextView AtomicSymbol = findViewById(R.id.AtomicSymbol);
        AtomicSymbol.setText(currentElement.atomicSymbol);
        TextView AtomicMass = findViewById(R.id.AtomicMass);
        AtomicMass.setText(currentElement.atomicMass);
        TextView CrystalStruct = findViewById(R.id.CrystalStruct);
        CrystalStruct.setText(currentElement.crystalStructure);
        TextView ShellK = findViewById(R.id.ShellOccK);
        ShellK.setText(currentElement.shellOccK);
        TextView ShellL = findViewById(R.id.ShellOccL);
        ShellL.setText(currentElement.shellOccL);
        TextView ShellM = findViewById(R.id.ShellOccM);
        ShellM.setText(currentElement.shellOccM);
        TextView ShellN = findViewById(R.id.ShellOccN);
        ShellN.setText(currentElement.shellOccN);
        TextView ShellO = findViewById(R.id.ShellOccO);
        ShellO.setText(currentElement.shellOccO);
        TextView ShellP = findViewById(R.id.ShellOccP);
        ShellP.setText(currentElement.shellOccP);
        TextView ShellQ = findViewById(R.id.ShellOccQ);
        ShellQ.setText(currentElement.shellOccQ);
        TextView ValencyCommon = findViewById(R.id.ValencyCommon);
        ValencyCommon.setText(currentElement.valencyCommon);
        TextView Valencies = findViewById(R.id.Valencies);
        Valencies.setText(currentElement.valencies);
        TextView MeltingPoint = findViewById(R.id.MeltingPoint);
        MeltingPoint.setText(currentElement.meltingPoint + "°C");
        TextView BoilingPoint = findViewById(R.id.BoilingPoint);
        BoilingPoint.setText(currentElement.boilingPoint + "°C");
        TextView Density = findViewById(R.id.Density);
        Density.setText(currentElement.density + "g.cm-3");
        TextView IonicRadius = findViewById(R.id.IonicRadius);
        IonicRadius.setText(currentElement.ionicRadius + "nm");
        TextView KBeta = findViewById(R.id.KBeta);

        //Set up units
        String units = " keV";
        KBeta.setText(setUpEnergyUnits(currentElement.kBeta,units));
        TextView KAlpha = findViewById(R.id.KAlpha);
        KAlpha.setText(setUpEnergyUnits(currentElement.kAlpha,units));
        TextView LGamma23 = findViewById(R.id.LGamma23);
        LGamma23.setText(setUpEnergyUnits(currentElement.lGamma23,units));
        TextView LGamma1 = findViewById(R.id.LGamma1);
        LGamma1.setText(setUpEnergyUnits(currentElement.lGamma1,units));
        TextView LBeta4 = findViewById(R.id.LBeta4);
        LBeta4.setText(setUpEnergyUnits(currentElement.lBeta4,units));
        TextView LBeta3 = findViewById(R.id.LBeta3);
        LBeta3.setText(setUpEnergyUnits(currentElement.lBeta3,units));
        TextView LBeta2 = findViewById(R.id.LBeta2);
        LBeta2.setText(setUpEnergyUnits(currentElement.lBeta2,units));
        TextView LBeta1 = findViewById(R.id.LBeta1);
        LBeta1.setText(setUpEnergyUnits(currentElement.lBeta1,units));
        TextView LAlpha = findViewById(R.id.LAlpha);
        LAlpha.setText(setUpEnergyUnits(currentElement.lAlpha,units));
        TextView MGamma = findViewById(R.id.MGamma);
        MGamma.setText(setUpEnergyUnits(currentElement.mGamma,units));
        TextView MBeta = findViewById(R.id.MBeta);
        MBeta.setText(setUpEnergyUnits(currentElement.mBeta,units));
        TextView MAlpha = findViewById(R.id.MAlpha);
        MAlpha.setText(setUpEnergyUnits(currentElement.mAlpha,units));
        TextView KEdge = findViewById(R.id.KEdge);
        KEdge.setText(setUpEnergyUnits(currentElement.kEdge,units));
        TextView L3Edge = findViewById(R.id.L3Edge);
        L3Edge.setText(setUpEnergyUnits(currentElement.l3Edge,units));
        TextView L2Edge = findViewById(R.id.L2Edge);
        L2Edge.setText(setUpEnergyUnits(currentElement.l2Edge,units));
        TextView L1Edge = findViewById(R.id.L1Edge);
        L1Edge.setText(setUpEnergyUnits(currentElement.l1Edge,units));
        TextView M5Edge = findViewById(R.id.M5Edge);
        M5Edge.setText(setUpEnergyUnits(currentElement.m5Edge,units));
        TextView M4Edge = findViewById(R.id.M4Edge);
        M4Edge.setText(setUpEnergyUnits(currentElement.m4Edge,units));
        TextView M3Edge = findViewById(R.id.M3Edge);
        M3Edge.setText(setUpEnergyUnits(currentElement.m3Edge,units));
        TextView M2Edge = findViewById(R.id.M2Edge);
        M2Edge.setText(setUpEnergyUnits(currentElement.m2Edge,units));
        TextView M1Edge = findViewById(R.id.M1Edge);
        M1Edge.setText(setUpEnergyUnits(currentElement.m1Edge,units));
    }

    //Helper function to set up energy units
    private String setUpEnergyUnits(String string, String units){
        if((string.equals("-") || string.equals(""))){
            units = "";
        }
        return (string + units);
    }

    private void setUpToolbar() {
        //Find the toolbar by the specific id
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Drawable dropDown = ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_filter_outline);
        toolbar.setOverflowIcon(dropDown);

            if (getSupportActionBar()!=null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
        //Set on click listener on the navigation bar
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Change the units dependant on what instrument and crystal are selected
        switch(item.getItemId()) {
            case android.R.id.home : this.finish(); return super.onOptionsItemSelected(item);
            case R.id.C_LiF_200: onRefreshActivity("Cameca","LIF200", ""); return true;
            case R.id.C_PET: onRefreshActivity("Cameca","PET", ""); return true;
            case R.id.C_TAP: onRefreshActivity("Cameca","TAP", ""); return true;
            case R.id.C_LiF_220: onRefreshActivity("Cameca","LIF220", ""); return true;
            case R.id.C_Qtz_1011: onRefreshActivity("Cameca","QTZ1011", ""); return true;
            case R.id.JX_LiF_200: onRefreshActivity("Joel","LIF200", "XCE"); return true;
            case R.id.JX_PET: onRefreshActivity("Joel","PET", "XCE"); return true;
            case R.id.JX_TAP: onRefreshActivity("Joel","TAP", "XCE"); return true;
            case R.id.JX_LiF_220: onRefreshActivity("Joel","LIF220", "XCE"); return true;
            case R.id.JX_Qtz_1011: onRefreshActivity("Joel","QTZ1011", "XCE"); return true;
            case R.id.JF_LiF_200: onRefreshActivity("Joel","LIF200", "FCE"); return true;
            case R.id.JF_PET: onRefreshActivity("Joel","PET", "FCE"); return true;
            case R.id.JF_TAP: onRefreshActivity("Joel","TAP", "FCE"); return true;
            case R.id.JF_LiF_220: onRefreshActivity("Joel","LIF220", "FCE"); return true;
            case R.id.JF_Qtz_1011: onRefreshActivity("Joel","QTZ1011", "FCE"); return true;
            case R.id.JH_LiF_200: onRefreshActivity("Joel","LIF200", "H-type"); return true;
            case R.id.JH_PET: onRefreshActivity("Joel","PET", "H-type"); return true;
            case R.id.JH_TAP: onRefreshActivity("Joel","TAP", "H-type"); return true;
            case R.id.JH_LiF_220: onRefreshActivity("Joel","LIF220", "H-type"); return true;
            case R.id.JH_Qtz_1011: onRefreshActivity("Joel","QTZ1011", "H-type"); return true;
            case R.id.reset: onRefreshActivity("Reset","Reset", "Reset");
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void onRefreshActivity(String instrument, String crystal, String spectrometer){
        if (instrument.equals("Reset")){
            displayKeVValues(currentElement);
        }
        else if (instrument.equals("Cameca")){
            setCamecaValues(crystal, currentElement);
        }
        else if (instrument.equals("Joel")) {
            setLValue(currentElement, spectrometer, crystal);
        }

    }

    //Make sure that the activity is closed. it returns to the home page
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    //Change the values specific to the Cameca machine
    private void setCamecaValues(String crystal, CurrentElement element){
        List<String> newData = new ArrayList<>();
        for (int i = 18; i < 30; i++){
            try {
                float n = Float.parseFloat(element.data.get(i));
                newData.add(String.format("%.3f", (500*changeUnitsJOEL("H-type", crystal, n))));
            }
            catch(Exception e){
                newData.add("-");
            }
        }
        updateEnergyValues(newData, "Cameca");
    }

    //Change the values specific to the Jeol machine
    private double changeUnitsJOEL(String spectrometer, String crystal, double energy){
        double R = 0, two_d = 0, E = 0;
        if (spectrometer.equals("XCE") || spectrometer.equals("FCE")) R = 140;
        else if (spectrometer.equals("H-type")) R = 100;

        if (crystal.equals("PET")) two_d = 8.74;
        else if (crystal.equals("TAP")) two_d = 25.75;
        else if (crystal.equals("QTZ1011")) two_d = 6.686;
        else if (crystal.equals("LIF200")) two_d = 4.0267;
        else if (crystal.equals("LIF220")) two_d = 2.848;

        //n is fixed at 1 so not needed in conversion equation
        double l_value = (24.792 * R) / (two_d * energy);
        return l_value;
    }

    private void setLValue(CurrentElement element, String spectrometer, String crystal){
        List<String> newData = new ArrayList<>();
        for (int i = 18; i < 30; i++){
            try{
                float n = Float.parseFloat(element.data.get(i));
                newData.add(String.format("%.3f",(changeUnitsJOEL(spectrometer, crystal, n))));
            }
            catch(Exception e){
                newData.add("-");
            }
        }
        updateEnergyValues(newData, "Joel");
    }

    //Function to reset data to KeV on display done by calling function that initially displays the data onscreen
    private void updateEnergyValues(List<String> newData, String instrument){
        String unit = new String();
        if (instrument == "Cameca") unit = " Sine(Θ)";
        if (instrument == "Joel") unit = " L-Value";
        TextView KBeta = findViewById(R.id.KBeta);
        KBeta.setText(setUpEnergyUnits(newData.get(0),unit));
        TextView KAlpha = findViewById(R.id.KAlpha);
        KAlpha.setText(setUpEnergyUnits(newData.get(1),unit));
        TextView LGamma23 = findViewById(R.id.LGamma23);
        LGamma23.setText(setUpEnergyUnits(newData.get(2),unit));
        TextView LGamma1 = findViewById(R.id.LGamma1);
        LGamma1.setText(setUpEnergyUnits(newData.get(3),unit));
        TextView LBeta4 = findViewById(R.id.LBeta4);
        LBeta4.setText(setUpEnergyUnits(newData.get(4),unit));
        TextView LBeta3 = findViewById(R.id.LBeta3);
        LBeta3.setText(setUpEnergyUnits(newData.get(5),unit));
        TextView LBeta2 = findViewById(R.id.LBeta2);
        LBeta2.setText(setUpEnergyUnits(newData.get(6), unit));
        TextView LBeta1 = findViewById(R.id.LBeta1);
        LBeta1.setText(setUpEnergyUnits(newData.get(7),unit));
        TextView LAlpha = findViewById(R.id.LAlpha);
        LAlpha.setText(setUpEnergyUnits(newData.get(8), unit));
        TextView MGamma = findViewById(R.id.MGamma);
        MGamma.setText(setUpEnergyUnits(newData.get(9),unit));
        TextView MBeta = findViewById(R.id.MBeta);
        MBeta.setText(setUpEnergyUnits(newData.get(10),unit));
        TextView MAlpha = findViewById(R.id.MAlpha);
        MAlpha.setText(setUpEnergyUnits(newData.get(11),unit));
    }

    //Function to move between previous and next element
    private void setUpButtons(final Integer currentElement){
        Button nextElement = (Button) findViewById(R.id.next_element);
        nextElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DisplayElementDataActivity.class); //Create the intent that opens the new activity
                intent.putExtra("ElementID",currentElement + 1);  //Put extra data into the intent so that next activity knows what element was clicked on
                startActivity(intent); //Execute the intent
            }
        });
        Button prevElement = (Button) findViewById(R.id.previous_element);
        prevElement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DisplayElementDataActivity.class); //Create the intent that opens the new activity
                intent.putExtra("ElementID",currentElement - 1);  //Put extra data into the intent so that next activity knows what element was clicked on
                startActivity(intent); //Execute the intent
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dropdown_menu,menu);
        return true;
    }

}
