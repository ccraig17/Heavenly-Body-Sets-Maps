import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetsMain {
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {

            HeavenlyBody temp = new Planet("Mercury", 88);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            temp = new Planet("Venus", 225);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            temp = new Planet("Earth", 3565);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            HeavenlyBody tempMoon = new Moon("Moon", 27);
            solarSystem.put(tempMoon.getKey(), tempMoon);
            temp.addSatellite(tempMoon);

            //Added Mars to HashMap solarSystem, then to Sets of planets
            temp = new Planet("Mars", 687);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            /**Adding Moons of Mars to the Moons Object of Type "HeavenlyBody"
             then added Mars' Moons to solarSystem HashMap
             then using the addSatellite()s() to add to the Instance (Object) of planets.
             */
            tempMoon = new Moon("Deimos", 1.3);
            solarSystem.put(tempMoon.getKey(), tempMoon);
            temp.addSatellite(tempMoon); // temp is still Mars

            tempMoon = new Moon("Phobos", 0.3);
            solarSystem.put(tempMoon.getKey(), tempMoon);
            temp.addSatellite(tempMoon); // temp is still Mars

            temp = new Planet("Jupiter", 4332);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            tempMoon = new Moon("Io", 1.8);
            solarSystem.put(tempMoon.getKey(), tempMoon);
            temp.addSatellite(tempMoon); // temp is still Jupiter

            tempMoon = new Moon("Europa", 3.5);
            solarSystem.put(tempMoon.getKey(), tempMoon);
            temp.addSatellite(tempMoon); // temp is still Jupiter

            tempMoon = new Moon("Ganymede", 7.1);
            solarSystem.put(tempMoon.getKey(), tempMoon);
            temp.addSatellite(tempMoon); // temp is still Jupiter

            tempMoon = new Moon("Callisto", 16.7);
            solarSystem.put(tempMoon.getKey(), tempMoon);
            temp.addSatellite(tempMoon); // temp is still Jupiter

            temp = new Planet("Saturn", 10759);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            temp = new Planet("Uranus", 30660);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            temp = new Planet("Neptune", 165);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            temp = new Planet("Pluto", 248);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            System.out.println("Planets");
            for(HeavenlyBody planet : planets) {
                System.out.println("\t" + planet.getKey());
            }

            HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Mars", HeavenlyBody.BodyTypes.PLANET)); //*******
            System.out.println("Moons of " + body.getKey());
            for(HeavenlyBody jupiterMoon: body.getSatellites()) {
                System.out.println("\t" + jupiterMoon.getKey());
            }

            Set<HeavenlyBody> moons = new HashSet<>();// new instance created called "moons"
            for(HeavenlyBody planet : planets) {//"Enhanced Loop of planet: planets" created to loop and grab ALL planets and attached to the variable "planet"
                moons.addAll(planet.getSatellites());// used the addALL() Method to add ALL the Moons/Satellites for ALL the planets(after Enhanced Loop) to assign to "moons"
            }

            System.out.println("All Moons");
            for(HeavenlyBody moon : moons) { // here the "Enhanced Loop" variable "moon" with "moons" (containing now ALL the Satellites) can be printed out using moon.getName().
                System.out.println("\t" + moon.getKey());
            }
            HeavenlyBody pluto = new DwarfPlanet("Pluto", 842);
            planets.add(pluto);
            System.out.println("Planets: " );
            for(HeavenlyBody planet : planets){
                System.out.println(planet);
                // System.out.println(planet.getKey() + " : " + planet.getOrbitalPeriod());
            }

            HeavenlyBody earth1 = new Planet("Earth", 365);
            HeavenlyBody earth2 = new Planet("Earth", 365);
            System.out.println(earth1.equals(earth2));
            System.out.println(earth2.equals(earth1));
            System.out.println(earth1.equals(pluto));
            System.out.println(pluto.equals(earth1));

            solarSystem.put(pluto.getKey(), pluto);
            System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.PLANET)));
            System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.DWARF_PLANET)));

            System.out.println();
            System.out.println("Solar System contains:");
            for(HeavenlyBody heavenlyBody: solarSystem.values()){
                System.out.println(heavenlyBody);
            }



        }

    }

