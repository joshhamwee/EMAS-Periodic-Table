package com.pta.joshhamwee.periodictablemain;

import java.util.ArrayList;
import java.util.List;

public class CurrentElement {
    String atomicNumber, name, atomicSymbol, atomicMass, crystalStructure;
    String shellOccK, shellOccL, shellOccM, shellOccN, shellOccO, shellOccP, shellOccQ;
    String valencyCommon, valencies, meltingPoint, boilingPoint, density, ionicRadius;
    String kBeta, kAlpha, lGamma23, lGamma1, lBeta4, lBeta3, lBeta2, lBeta1, lAlpha;
    String mGamma, mBeta, mAlpha, kEdge, l3Edge, l2Edge, l1Edge, m5Edge, m4Edge, m3Edge, m2Edge, m1Edge;
    List<String> data = new ArrayList<>();

    //Get the ID of what element to required data for
    public CurrentElement(Integer id, DatabaseAccess db) {
        this.atomicNumber = Integer.toString(id);
        dataGetting(db);
        dataSetting();
    }

    //Open the database and get all the data required
    private void dataGetting(DatabaseAccess db){
        db.open();
        this.data = db.getElementData(this.atomicNumber, "SELECT * FROM 'Element_Data v0' WHERE Atomic_Number = '" + this.atomicNumber + "'");
        db.close();
    }

    //Set the data specific to each value from the requested data
    private void dataSetting(){
        try {
            this.atomicNumber = data.get(0);
            this.name = data.get(1);
            this.atomicSymbol = data.get(2);
            this.atomicMass = data.get(3);
            this.crystalStructure = data.get(4);
            this.shellOccK = data.get(5);
            this.shellOccL = data.get(6);
            this.shellOccM = data.get(7);
            this.shellOccN = data.get(8);
            this.shellOccO = data.get(9);
            this.shellOccP = data.get(10);
            this.shellOccQ = data.get(11);
            this.valencyCommon = data.get(12);
            this.valencies = data.get(13);
            this.meltingPoint = data.get(14);
            this.boilingPoint = data.get(15);
            this.density = data.get(16);
            this.ionicRadius = data.get(17);
            this.kBeta = data.get(18);
            this.kAlpha = data.get(19);
            this.lGamma23 = data.get(20);
            this.lGamma1 = data.get(21);
            this.lBeta4 = data.get(22);
            this.lBeta3 = data.get(23);
            this.lBeta2 = data.get(24);
            this.lBeta1 = data.get(25);
            this.lAlpha = data.get(26);
            this.mGamma = data.get(27);
            this.mBeta = data.get(28);
            this.mAlpha = data.get(29);
            this.kEdge = data.get(30);
            this.l3Edge = data.get(31);
            this.l2Edge = data.get(32);
            this.l1Edge = data.get(33);
            this.m5Edge = data.get(34);
            this.m4Edge = data.get(35);
            this.m3Edge = data.get(36);
            this.m2Edge = data.get(37);
            this.m1Edge = data.get(38);
        }
        catch (Exception e){
        }
    }
}
