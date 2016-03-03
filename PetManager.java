package com.Heather;
import java.util.*;

public class PetManager {

    public static void main(String[] args) {
	// write your code here
        Scanner scan=new Scanner(System.in);
        Scanner scani=new Scanner(System.in);
        ArrayList<Pet> petlist=new ArrayList<>();
        ArrayList<String> daylist=new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
        HashMap<String, ArrayList<String>> printday=new HashMap<>();
        System.out.println("How many pets need to be added to the schedule?");
        int numpet=scani.nextInt();
        for(int i=0; i<numpet; i++) {
            System.out.println("What is the name of the pet?");
            String name = scan.nextLine();
            System.out.println("What kind of animal is it?");
            String type = scan.nextLine();
            System.out.println("What is the address where the pet lives?");
            String address = scan.nextLine();
            Pet n=new Pet(name, type, address);
            n.addDay();
            petlist.add(n);
        }
        for(Pet name:petlist){//go through once per pet object
            HashMap<String, Integer>sch=name.getvperday();//get schedule for this pet
            for (String d:daylist){ //get a day of the week
                if ((sch.containsKey(d))&&(sch.get(d)>0)){//if that day is applicable to this pet
                    ArrayList<String>val=new ArrayList<>();
                    if (printday.containsKey(d)){//if the day is in printday already
                        val=printday.get(d);//get arraylist of strings to print for this day
                        if (val.size()<6) {//if there are fewer than 6 visits planned
                            val.add(name.writePetInfo(sch.get(d)));//add string with visit schedule for this pet on this day
                            printday.put(d, val);
                        }else{//if there are already 6 visits planned
                            System.out.println("Scheduled for "+d+" is full.  No room for "+name.getname()+".");
                        }
                    }else{//if the day is not in the print schedule yet
                        val.add(name.writePetInfo(sch.get(d)));
                        printday.put(d,val);

                    }

                }
            }
        }for(String day:daylist) {//day of the week
            System.out.print("\n"+day+": \n");
            for (String i : printday.get(day)) {//item in array for that day of the week
                System.out.print("\t"+i+"\n");//print each line in array

            }
        }

    }
}
