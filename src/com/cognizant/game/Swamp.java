package com.cognizant.game;


import java.util.Scanner;

public class Swamp {

	public static void main(String[] args) {
		Swamp swamp= new Swamp();
		
		//Set-up
		double eastWest =4;
		double northSouth =3;
		double step =1;
		String[] dangers = {"Danger!! The swamp monster spotted you \\(*o*)/. Pick a direction and RUN!!!​​"
				,"You lost your footing and fell into the swamp! Quickly, pick a direction"
				,"OMG! IS THAT CTHULHU?!? GO GO GO"
				, "The fog is getting thicker. You won't be able to see in a while. Hurry up and pick a direction"
				,"I think I can hear wolf. Run for your life !"};
		System.out.println("Grey foggy clouds float oppressively close to you,\r\n" + 
				"\r\n" + 
				"reflected in the murky grey water which reaches up your shins.\r\n" + 
				"\r\n" + 
				"Some black plants barely poke out of the shallow water.\r\n" + 
				"\r\n" + 
				"Try \"north\",\"south\",\"east\",or \"west\"\r\n" + 
				"\r\n" + 
				"You notice a small watch-like device in your left hand. \r\n" + 
				"\r\n" + 
				"\r\n" + 
				"It has hands like a watch, but the hands don't seem to tell time");
		
		System.out.println(swamp.directions(eastWest,northSouth,step));
		double distance;
		do {	
		
			String s = swamp.input();
			if(s.equals("n")||s.equals("N")||s.equals("north")||s.equals("NORTH")||s.equals("North")) {
				northSouth = northSouth - step;
				System.out.println(swamp.directions(northSouth,eastWest,step));
			}
			else if (s.equals("s")||s.equals("S")||s.equals("south")||s.equals("South")||s.equals("SOUTH")) {
				northSouth = northSouth + step;
				System.out.println(swamp.directions(northSouth,eastWest,step));
			}
			else if(s.equals("e")||s.equals("E")||s.equals("east")||s.equals("East")||s.equals("EAST")) {
				eastWest = eastWest - step;
				System.out.println(swamp.directions(northSouth,eastWest,step));
			}
			else if (s.equals("w")||s.equals("W")||s.equals("west")||s.equals("West")||s.equals("WEST")) {
				eastWest = eastWest + step;
				System.out.println(swamp.directions(northSouth,eastWest,step));
			}
			else {
				System.out.println(dangers[swamp.randomIndex(dangers.length)]);
			}
			distance = Math.sqrt((eastWest)*(eastWest)+(northSouth)*(northSouth));
		}while(distance>0);
		System.out.println();
	}
	public String input() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}
	public String directions(double eastWest, double northSouth,double step) {
		double distance;      
		String direct; 
		distance = Math.sqrt((eastWest)*(eastWest)+(northSouth)*(northSouth));                   
		direct = "The dial reads "+ distance + " m";      
		return direct;
	}
	public int randomIndex(int length) {
		double randomNumber = Math.random()*10;
		int index = (int) Math.round(randomNumber);
		if(index<length) {
			return index;
		}
		else{
			return 0;
		}
	}
}

