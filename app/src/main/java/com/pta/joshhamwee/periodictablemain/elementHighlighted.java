package com.pta.joshhamwee.periodictablemain;

public class elementHighlighted {
    Integer instrument, crystal, minRangeA, maxRangeA, minRangeB, maxRangeB, minRangeC, maxRangeC;
    //Check if a specific element is within a boundary so that it knows whether it needs to be highlighted or not
    public elementHighlighted(Integer instrument, Integer crystal){
        this.crystal = crystal;
        this.instrument = instrument;

        if(instrument == 1){ //Cameca
            setBoundariesCameca(crystal);
        }
        else if(instrument == 2){ // Jeol-X
            setBoundariesJX(crystal);
        }
        else if(instrument == 3){ //Jeol-F
            setBoundariesJF(crystal);
        }
        else if(instrument == 4){ //Jeol-H
            setBoundariesJH(crystal);
        }
    }

    //Hard coded in the boundaries as it is not possible to do this through the database
    private void setBoundariesCameca(Integer crystal){
        if (crystal == 1){ //LiF(200)
            this.minRangeA = 21;
            this.maxRangeA = 37;
            this.minRangeB = 52;
            this.maxRangeB = 93;
            this.minRangeC = 96;
            this.maxRangeC = 98;
        }
        else if (crystal == 2){ //PET
            this.minRangeA = 14;
            this.maxRangeA = 26;
            this.minRangeB = 38;
            this.maxRangeB = 65;
            this.minRangeC = 74;
            this.maxRangeC = 98;
        }
        else if (crystal == 3){ //TAP
            this.minRangeA = 9;
            this.maxRangeA = 15;
            this.minRangeB = 25;
            this.maxRangeB = 41;
            this.minRangeC = 57;
            this.maxRangeC = 79;
        }
        else if (crystal == 4){ //LiF(220)
            this.minRangeA = 24;
            this.maxRangeA = 41;
            this.minRangeB = 0;
            this.maxRangeB = 0;
            this.minRangeC = 0;
            this.maxRangeC = 0;
        }
        else if (crystal == 5){ //Qtz(1011)
            this.minRangeA = 16;
            this.maxRangeA = 29;
            this.minRangeB = 0;
            this.maxRangeB = 0;
            this.minRangeC = 0;
            this.maxRangeC = 0;
        }
    }

    private void setBoundariesJX(Integer crystal){
        if (crystal == 1){ //LiF(200)
            this.minRangeA = 20;
            this.maxRangeA = 37;
            this.minRangeB = 50;
            this.maxRangeB = 92;
            this.minRangeC = 94;
            this.maxRangeC = 98;
        }
        else if (crystal == 2){ //PET
            this.minRangeA = 14;
            this.maxRangeA = 25;
            this.minRangeB = 36;
            this.maxRangeB = 65;
            this.minRangeC = 71;
            this.maxRangeC = 98;
        }
        else if (crystal == 3){ //TAP
            this.minRangeA = 8;
            this.maxRangeA = 15;
            this.minRangeB = 24;
            this.maxRangeB = 40;
            this.minRangeC = 57;
            this.maxRangeC = 79;
        }
        else if (crystal == 4){ //LiF(220)
            this.minRangeA = 23;
            this.maxRangeA = 41;
            this.minRangeB = 0;
            this.maxRangeB = 0;
            this.minRangeC = 0;
            this.maxRangeC = 0;
        }
        else if (crystal == 5){ //Qtz(1011)
            this.minRangeA = 15;
            this.maxRangeA = 29;
            this.minRangeB = 0;
            this.maxRangeB = 0;
            this.minRangeC = 0;
            this.maxRangeC = 0;
        }
    }

    private void setBoundariesJF(Integer crystal){
        if (crystal == 1){ //LiF(200)
            this.minRangeA = 20;
            this.maxRangeA = 35;
            this.minRangeB = 50;
            this.maxRangeB = 87;
            this.minRangeC = 94;
            this.maxRangeC = 98;
        }
        else if (crystal == 2){ //PET
            this.minRangeA = 14;
            this.maxRangeA = 24;
            this.minRangeB = 36;
            this.maxRangeB = 61;
            this.minRangeC = 71;
            this.maxRangeC = 98;
        }
        else if (crystal == 3){ //TAP
            this.minRangeA = 8;
            this.maxRangeA = 14;
            this.minRangeB = 24;
            this.maxRangeB = 38;
            this.minRangeC = 57;
            this.maxRangeC = 75;
        }
        else if (crystal == 4){ //LiF(220)
            this.minRangeA = 24;
            this.maxRangeA = 37;
            this.minRangeB = 0;
            this.maxRangeB = 0;
            this.minRangeC = 0;
            this.maxRangeC = 0;
        }
        else if (crystal == 5){ //Qtz(1011)
            this.minRangeA = 15;
            this.maxRangeA = 27;
            this.minRangeB = 0;
            this.maxRangeB = 0;
            this.minRangeC = 0;
            this.maxRangeC = 0;
        }
    }

    private void setBoundariesJH(Integer crystal){
        if (crystal == 1){ //LiF(200)
            this.minRangeA = 20;
            this.maxRangeA = 31;
            this.minRangeB = 50;
            this.maxRangeB = 80;
            this.minRangeC = 95;
            this.maxRangeC = 98;
        }
        else if (crystal == 2){ //PET
            this.minRangeA = 14;
            this.maxRangeA = 22;
            this.minRangeB = 37;
            this.maxRangeB = 56;
            this.minRangeC = 72;
            this.maxRangeC = 98;
        }
        else if (crystal == 3){ //TAP
            this.minRangeA = 9;
            this.maxRangeA = 13;
            this.minRangeB = 24;
            this.maxRangeB = 35;
            this.minRangeC = 57;
            this.maxRangeC = 69;
        }
        else if (crystal == 4){ //LiF(220)
            this.minRangeA = 24;
            this.maxRangeA = 37;
            this.minRangeB = 0;
            this.maxRangeB = 0;
            this.minRangeC = 0;
            this.maxRangeC = 0;
        }
        else if (crystal == 5){ //Qtz(1011)
            this.minRangeA = 16;
            this.maxRangeA = 25;
            this.minRangeB = 0;
            this.maxRangeB = 0;
            this.minRangeC = 0;
            this.maxRangeC = 0;
        }
    }

}
