package com.Heather;

import java.util.*;

/**
 * Created by cryst on 3/2/2016.
 */
public class Pet {
    private String name;
    private String type;
    private HashMap<String, Integer>vperday=new HashMap<>();//holds number of visits per day to a pet
    private HashMap<String, Integer>tvperday=new HashMap<>();//holds number of pets per day
    private ArrayList<String> days=new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
    private int visits;
    private String address;


    Pet(String petName, String petType, String petAddress){
        this.name=petName;
        this.type=petType;
        this.vperday=new HashMap<>();
        this.visits=0;
        this.address=petAddress;
    }

    public void addDay(){ //track visits per day to a pet
        Scanner scanint=new Scanner(System.in);
        for(String aday:days) {
            System.out.println("How many visits are needed for " + this.name + " on " + aday);//elicit information about visits
            int visits=scanint.nextInt();
            if (visits>0) {
                if ((tvperday.containsKey(aday)) && (tvperday.get(aday) < 6)) {//if another pet is being visited on the same day
                    this.vperday.put(aday, visits); //update the information for this day
                    tvperday.put(aday, (tvperday.get(aday) + 1));//add a visit to the total for this day
                } else if ((tvperday.containsKey(aday)) && (tvperday.get(aday) >= 6)) {
                    System.out.println(aday + " is already full.");
                } else {
                    this.vperday.put(aday, visits);//update information for this pet on this day
                    tvperday.put(aday, 1);//add this day to hash if there is no entry
                }
            }
        }
    }
    public String writePetInfo(int v){
        /*System.out.println("\nPet's name: "+this.name);
        System.out.println("Address: "+this.address);*/
       // for (String d:this.vperday.keySet()){
            String entry="Visit "+this.name+" the "+this.type+" "+v+" times at "+this.address+".";

        //}
        return entry;
    }




    public HashMap<String, Integer> getvperday() {
        return this.vperday;
    }

    public String getname() {
        return this.name;
    }
}
