/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racesimapp;

import java.util.ArrayList;
import java.util.List;
import racesimapp.model.Pilot;
import racesimapp.model.RaceResult;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Ricardoc
 */
public class RacesProcess {
    
    private List<Pilot> pilots;
    private Integer totalRaces;

    public RacesProcess() {
        this.pilots = null;
        this.totalRaces = null;
    }

    public RacesProcess(List<Pilot> pilots, Integer totalRaces) {
        this.pilots = pilots;
        this.totalRaces = totalRaces;
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }

    public Integer getTotalRaces() {
        return totalRaces;
    }

    public void setTotalRaces(Integer totalRaces) {
        this.totalRaces = totalRaces;
    }
    
    public Map<Integer,Map> process() throws Exception {
        Map<Integer,Map> finalResults = new HashMap<Integer,Map>();
        for (int raceId=1; raceId<=this.totalRaces; raceId++) {
            TreeMap<Float, Pilot> res = new TreeMap<Float, Pilot>(Collections.reverseOrder());
            for (Pilot p : this.pilots) {
                Float rank = this.getRandomNumber() * p.getFactor();
                while (res.containsKey(rank)) rank = this.getRandomNumber() * p.getFactor();
                res.put(rank, p);
            }            
            
            Set entries = res.entrySet();
            Iterator it = entries.iterator();
            Map<Pilot,Integer> raceResult = new HashMap<>();
            int position = 1;
            while (it.hasNext()) {
                Map.Entry mentry = (Map.Entry)it.next();
                //Float rank = (Float) mentry.getKey();               
                Pilot p = (Pilot) mentry.getValue();
                raceResult.put(p, position);                              
                position++;
            }
            finalResults.put(raceId, raceResult);
        }
        return finalResults;
    }
    
    private Integer getRandomNumber() throws Exception {
        SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
         
        // Get 128 random bytes
        byte[] randomBytes = new byte[128];
        secureRandomGenerator.nextBytes(randomBytes);
         
        //Get random integer
        //int r = secureRandomGenerator.nextInt();
         
        //Get random integer in range
        int randInRange = secureRandomGenerator.nextInt(10);
        
        return randInRange;
    }
    
    
}
