/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racesimapp;

import java.util.*;
import static java.util.stream.Collectors.toMap;
import racesimapp.model.Pilot;
import racesimapp.model.RaceResult;


/**
 *
 * @author Ricardoc
 */
public class RaceSimApp {

    private static void test1() throws Exception {
        List<Pilot> pilots = new ArrayList<Pilot>();
        Map<Pilot,Integer> finalResults = new HashMap<>();
        for (int i=1; i<=20; i++) {
            Pilot p = new Pilot();
            p.setNumber(i);
            p.setName("Pilot " + String.format("%02d", i));
            Random rd = new Random();
            p.setFactor(rd.nextFloat());
            pilots.add(p);
            finalResults.put(p, 0);
        }
        
        RacesProcess process = new RacesProcess();
        process.setPilots(pilots);
        process.setTotalRaces(10);
        /*List<RaceResult> results = process.process();
        
        System.out.println("PILOT\t\tR1\tR2\tR3\tR4\tR5\tR6\tR7\tR8\tR9\tR10\tTotal");
        System.out.println("==================================================================================================================================================");
        for (Pilot p : pilots) {
            System.out.print(p.getName() + "\t");
            for (int race=1; race<=10; race++) {
                TreeMap<Integer,Pilot> raceResult = new TreeMap<Integer,Pilot>();
                for (RaceResult singleresult : results) {
                    if ((singleresult.getRaceNumber() == race) && (singleresult.getPilot().equals(p))) {
                        raceResult.put(singleresult.getPlace(), singleresult.getPilot());
                    }
                }
            }
        }*/
        
    }
    
    private static void test() throws Exception {
        List<Pilot> pilots = new ArrayList<Pilot>();
        Map<Pilot,Integer> finalResults = new HashMap<>();
        for (int i=1; i<=20; i++) {
            Pilot p = new Pilot();
            p.setNumber(i);
            p.setName("Pilot " + String.format("%02d", i));
            Random rd = new Random();
            p.setFactor(rd.nextFloat());
            pilots.add(p);
            finalResults.put(p, 0);
        }

        for (Pilot p : pilots) {
            System.out.println(p.getNumber().toString() + " - " + p.getName() + " - " + p.getFactor().toString());
        }

        RacesProcess process = new RacesProcess();
        process.setPilots(pilots);
        process.setTotalRaces(10);
        Map<Integer,Map> results = process.process();
        for (int race =1; race<=10; race++) {
            TreeMap<Integer,Pilot> raceResult = new TreeMap<Integer,Pilot>();
            Map<Pilot,Integer> singleResult = results.get(race);
            Set setR = singleResult.entrySet();
            Iterator itR = setR.iterator();
            while (itR.hasNext()) {
                Map.Entry mentry = (Map.Entry)itR.next();
                raceResult.put((Integer) mentry.getValue(), (Pilot) mentry.getKey());
            }

            Set set = raceResult.entrySet();
            Iterator it = set.iterator();
            //System.out.println("  R A C E   R E S U L T S   F O R   R A C E   " + race);
            //System.out.println("===========================================================================");            
            while (it.hasNext()) {
                Map.Entry mentry = (Map.Entry)it.next();
                Integer pos = (Integer) mentry.getKey();
                Pilot pilot = (Pilot) mentry.getValue();
                //System.out.println(pos.toString() + " -> " + pilot.getName());
                int points = 0;
                switch (pos) {
                    case 1 : points = 10; break;
                    case 2 : points = 8; break;
                    case 3 : points = 6; break;
                    case 4 : points = 5; break;
                    case 5 : points = 4; break;
                    case 6 : points = 3; break;
                    case 7 : points = 2; break;
                    case 8 : points = 1; break;                
                }
                Integer totalP = finalResults.get(pilot);
                totalP = totalP + points;
                finalResults.put(pilot, totalP);
            }
        }
        /*
        Map<Pilot,Integer> sortedFinalResults = finalResults
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                    toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                            LinkedHashMap::new));
                
        Set set = sortedFinalResults.entrySet();
        Iterator it = set.iterator();
        //System.out.println("F I N A L    S T A N D I N G S");
        //System.out.println("==============================");
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry)it.next();
            Pilot p = (Pilot) mentry.getKey();
            Integer totalPoints = (Integer) mentry.getValue();
            //System.out.println(p.getName() + "\t" + totalPoints.toString());
        }
        */
        System.out.println("\n\nPILOT\t\tR1\tR2\tR3\tR4\tR5\tR6\tR7\tR8\tR9\tR10\tTotal");
        System.out.println("==================================================================================================================================================");
        for (Pilot p : pilots) {
            System.out.print(p.getName() + "\t");
            for (int race=1; race<=10; race++) {  
                Map<Pilot,Integer> singleResult = results.get(race);
                Integer place = singleResult.get(p);                
                System.out.print(place.toString() + "\t");
                
            }
            Integer totalPoints = finalResults.get(p);
            System.out.println(totalPoints.toString());
            //System.out.println();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            test();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
