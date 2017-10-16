package Pack1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Sample2  {

	public static HashMap<String, ArrayList<Integer>> orbitWithDistanceAndCraters = new HashMap<String, ArrayList<Integer>> ();
	public static HashMap<String, Integer> orbitWithMaxSpeed = new HashMap<String, Integer> ();
	public static HashMap<String, Float> vehicleWithExtraaTime = new HashMap<String, Float> ();
	public static HashMap<String, Integer> vehicleWithSpeed = new HashMap<String, Integer> ();
	public static LinkedHashMap<String, Float> option = new LinkedHashMap<String, Float>();
	public static String[] vehicle = new String[3];
	public static String[] orbit = new String[4];
	public static String[] weather = new String[3];

	public static void main(String[] args) {

		int maxSpeed1, maxSpeed2, maxSpeed3, maxSpeed4;
		String weatherInput = "";
		System.out.println("Please enter max speed for orbit 1, orbit 2, orbit 3 and orbit 4 respectively");
		Scanner sc1 = new Scanner(System.in);
		maxSpeed1 = sc1.nextInt();
		maxSpeed2 = sc1.nextInt();
		maxSpeed3 = sc1.nextInt();
		maxSpeed4 = sc1.nextInt();
		System.out.println("Please enter the weather name");
		Scanner sc2 = new Scanner(System.in);
		weatherInput = sc2.nextLine();


		orbitWithDistanceAndCraters.put("orbit1", new ArrayList<Integer>());
		orbitWithDistanceAndCraters.get("orbit1").add(18);		orbitWithDistanceAndCraters.get("orbit1").add(20);
		orbitWithDistanceAndCraters.put("orbit2", new ArrayList<Integer>());
		orbitWithDistanceAndCraters.get("orbit2").add(20);		orbitWithDistanceAndCraters.get("orbit2").add(10);
		orbitWithDistanceAndCraters.put("orbit3", new ArrayList<Integer>());
		orbitWithDistanceAndCraters.get("orbit3").add(30);		orbitWithDistanceAndCraters.get("orbit3").add(15);
		orbitWithDistanceAndCraters.put("orbit4", new ArrayList<Integer>());
		orbitWithDistanceAndCraters.get("orbit4").add(15);		orbitWithDistanceAndCraters.get("orbit4").add(18);


		orbitWithMaxSpeed.put("orbit1", maxSpeed1);
		orbitWithMaxSpeed.put("orbit2", maxSpeed2);
		orbitWithMaxSpeed.put("orbit3", maxSpeed3);
		orbitWithMaxSpeed.put("orbit4", maxSpeed4);

		vehicle[0] = "Bike";		vehicle[1] = "Tuktuk";		vehicle[2] = "Car";    
		orbit[0] = "orbit1";		orbit[1] = "orbit2";		orbit[2] = "orbit3";		orbit[3] = "orbit4";
		weather[0] = "Sunny";		weather[1] = "Rainy";		weather[2] = "Windy";	

		vehicleWithExtraaTime.put("Bike", 2F/60);		vehicleWithExtraaTime.put("Tuktuk", 1F/60);		vehicleWithExtraaTime.put("Car", 3F/60); 

		vehicleWithSpeed.put("Bike", 10);		vehicleWithSpeed.put("Tuktuk", 12);		vehicleWithSpeed.put("Car", 20);

		if(weatherInput.trim().equalsIgnoreCase("Sunny")) {
			for(int i = 0; i < orbit.length - 1; i++) {
				for(int j = 0; j < vehicle.length; j++) {
					System.out.println("vehicle[j]=="+vehicle[j]);
					option.put(orbit[i]+","+vehicle[j], ((float) timeTaken(orbit[i], weatherInput, vehicle[j])) + ((float) timeTaken(orbit[3], weatherInput, vehicle[j])));

				}
			}
		}
		else if (weatherInput.trim().equalsIgnoreCase("Rainy")) {
			for(int i = 0; i < orbit.length - 1; i++) {
				for(int j = 0; j < vehicle.length; j++) {
					if(vehicle[j].equalsIgnoreCase("Bike")){
						
					}
					else {
					System.out.println("vehicle[j]=="+vehicle[j]);
					option.put(orbit[i]+","+vehicle[j], (float) timeTaken(orbit[i], weatherInput, vehicle[j]) + ((float) timeTaken(orbit[3], weatherInput, vehicle[j])));
					}
				}
			}
		}
		else if (weatherInput.trim().equalsIgnoreCase("Windy")) {
			for(int i = 0; i < orbit.length - 1; i++) {
				for(int j = 0; j < vehicle.length; j++) {
					if(vehicle[j].equalsIgnoreCase("Tuktuk")){
						
					}
					else {
					System.out.println("vehicle[j]=="+vehicle[j]);
					option.put(orbit[i]+","+vehicle[j], (float) timeTaken(orbit[i], weatherInput, vehicle[j]) + ((float) timeTaken(orbit[3], weatherInput, vehicle[j])));
					}
				}
			}
		}
		
		System.out.println("option is "+ option);
		
		System.out.println("option.values())=="+option.values());
		System.out.println("Collections.min(option.values())=="+Collections.min(option.values()));
		
		float min = Collections.min(option.values());
		Iterator itr = option.keySet().iterator();
		while (itr.hasNext()) {
			String str = (String) itr.next();
			if(option.get(str).equals(min)) {
				
				System.out.println("The best route to take is ");
				System.out.println("option.get(str)=="+option.get(str));
				System.out.println("str=="+str);
				break;
		
			}
		}

	}



	public static float timeTaken(String route, String weather, String vehicleType) {
		float time = 0f;
		float craters = 0;

		float maxSpeed = 0f;
		float extraaTime = 0;

		int distance =  orbitWithDistanceAndCraters.get(route).get(0);
		System.out.println("distance=="+distance);

		if(weather.trim().equalsIgnoreCase("Sunny")) {
			craters = orbitWithDistanceAndCraters.get(route).get(1);
			craters = craters * (9f/10);
		}
		else if (weather.trim().equalsIgnoreCase("Rainy")) {
			craters = orbitWithDistanceAndCraters.get(route).get(1);
			craters = craters * (12f/10);
		}
		else if (weather.trim().equalsIgnoreCase("Windy")) 
			craters = orbitWithDistanceAndCraters.get(route).get(1);
		System.out.println("craters=="+craters);


		//System.out.println("orbitWithMaxSpeed.get(route)=="+orbitWithMaxSpeed.get(route));
		System.out.println("vehicleWithSpeed.get(vehicleType)=="+vehicleWithSpeed.get(vehicleType));
		if(orbitWithMaxSpeed.get(route) > vehicleWithSpeed.get(vehicleType))
			maxSpeed = vehicleWithSpeed.get(vehicleType);
		else
			maxSpeed = orbitWithMaxSpeed.get(route);
		System.out.println("maxSpeed=="+maxSpeed);

		if(vehicleType.equalsIgnoreCase("Bike"))
			extraaTime = vehicleWithExtraaTime.get(vehicleType);
		else if (vehicleType.equalsIgnoreCase("Tuktuk"))
			extraaTime = vehicleWithExtraaTime.get(vehicleType);
		else if (vehicleType.equalsIgnoreCase("Car"))
			extraaTime = vehicleWithExtraaTime.get(vehicleType);
		System.out.println("extraaTime=="+extraaTime);
		System.out.println("distance/maxSpeed)=="+distance/maxSpeed);
		System.out.println("craters*extraaTime=="+craters*extraaTime);
		time = (distance/maxSpeed) + craters*extraaTime;
		System.out.println("time=="+time);

		return time;

	}

}

