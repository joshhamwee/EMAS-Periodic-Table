package com.pta.joshhamwee.periodictablemain;
import java.util.ArrayList;
import java.util.List;

public class ElementsData {
    //List of elements for the search function
    private static List<String> elements;

    static {
        elements =  new ArrayList<String>();
        elements.add("Hydrogen - H - 1");
        elements.add("Helium - He - 2");
        elements.add("Lithium - Li - 3");
        elements.add("Beryllium - Be - 4");
        elements.add("Boron - B - 5");
        elements.add("Carbon - C - 6");
        elements.add("Nitrogen - N -7");
        elements.add("Oxygen - O - 8");
        elements.add("Fluorine - F - 9");
        elements.add("Neon - Ne - 10");
        elements.add("Sodium - Na - 11");
        elements.add("Magnesium - Mg - 12");
        elements.add("Aluminium - Al - 13");
        elements.add("Silicon - Si - 14");
        elements.add("Phosphorus - P - 15");
        elements.add("Sulphur - S - 16");
        elements.add("Chlorine - Cl - 17");
        elements.add("Argon - Ar - 18");
        elements.add("Potassium - K - 19");
        elements.add("Calcium - Ca - 20");
        elements.add("Scandium - Sc - 21");
        elements.add("Titanium - Ti - 22");
        elements.add("Vanadium - V - 23");
        elements.add("Chromium - Cr - 24");
        elements.add("Manganese - Mn - 25");
        elements.add("Iron - Fe - 26");
        elements.add("Cobalt - Co - 27");
        elements.add("Nickel - Ni - 28");
        elements.add("Copper - Cu - 29");
        elements.add("Zinc - Zn - 30");
        elements.add("Gallium - Ga - 31");
        elements.add("Germanium - Ge - 32");
        elements.add("Arsenic - As - 33");
        elements.add("Selenium - Se - 34");
        elements.add("Bromine - Br - 35");
        elements.add("Krypton - Kr - 36");
        elements.add("Rubidium - Rb - 37");
        elements.add("Strontium - Sr - 38");
        elements.add("Yttrium - Y - 39");
        elements.add("Zirconium - Zr - 40");
        elements.add("Niobium - Nb - 41");
        elements.add("Molybdenum - Mo - 42");
        elements.add("Technetium - Tc - 43");
        elements.add("Ruthenium - Ru - 44");
        elements.add("Rhodium - Rh - 45");
        elements.add("Palladium - Pd - 46");
        elements.add("Silver - Ag - 47");
        elements.add("Cadmium - Cd - 48");
        elements.add("Indium - In - 49");
        elements.add("Tin - Sn - 50");
        elements.add("Antimony - Sb - 51");
        elements.add("Tellurium - Te - 52");
        elements.add("Iodine - I - 53");
        elements.add("Xenon - Xe - 54");
        elements.add("Caesium - Cs - 55");
        elements.add("Barium - Ba - 56");
        elements.add("Lanthanum - La - 57");
        elements.add("Cerium - Ce - 58");
        elements.add("Praseodymium - Pr - 59");
        elements.add("Neodymium - Nd - 60");
        elements.add("Promethium - Pm - 61");
        elements.add("Samarium - Sm - 62");
        elements.add("Europium - Eu - 63");
        elements.add("Gadolinium - Gd - 64");
        elements.add("Terbium - Tb - 65");
        elements.add("Dysprosium - Dy - 66");
        elements.add("Holmium - Ho - 67");
        elements.add("Erbium - Er - 68");
        elements.add("Thulium - Tm - 69");
        elements.add("Ytterbium - Yb - 70");
        elements.add("Lutetium - Lu - 71");
        elements.add("Hafnium - Hf - 72");
        elements.add("Tantalum - Ta - 73");
        elements.add("Tungsten - W - 74");
        elements.add("Rhenium - Re - 75");
        elements.add("Osmium - Os - 76");
        elements.add("Iridium - Ir - 77");
        elements.add("Platinum - Pt - 78");
        elements.add("Gold - Au - 79");
        elements.add("Mercury - Hg - 80");
        elements.add("Thallium - Tl - 81");
        elements.add("Lead - Pb - 82");
        elements.add("Bismuth - Bi - 83");
        elements.add("Polonium - Po - 84");
        elements.add("Astatine - At - 85");
        elements.add("Radon - Rn - 86");
        elements.add("Francium - Fr - 87");
        elements.add("Radium - Ra - 88");
        elements.add("Actinium - Ac - 89");
        elements.add("Thorium - Th - 90");
        elements.add("Protactinium - Pa - 91");
        elements.add("Uranium - U - 92");
        elements.add("Neptunium - Np - 93");
        elements.add("Plutonium - Pu - 94");
        elements.add("Americium - Am - 95");
        elements.add("Curium - Cm - 96");
        elements.add("Berkelium - Bk - 97");
        elements.add("Californium - Cf - 98");
        elements.add("Einsteinium - Es - 99");
        elements.add("Fermium - Fm - 100");
        elements.add("Mendelevium - Md - 101");
        elements.add("Nobelium - No - 102");
        elements.add("Lawrencium - Lr - 103");
    }

    //Return function if full list is required
    public static List<String> getElements(){
        return elements;
    }

    //Filter function for the search
    public static List<String> filterData(String searchString){
        List<String> searchResults =  new ArrayList<String>();
        if(searchString != null){
            searchString = searchString.toLowerCase();

            for(String elem :  elements){
                // used trim() to remove whitespaces from start and end
                // doesnt work for two spaces though
                String cleanElem = elem.toLowerCase().trim();

                if(cleanElem.contains(searchString)){
                    searchResults.add(elem);
                }
            }
        }

        return searchResults;
    }

}
