/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racesimapp.model;

import java.util.Objects;

/**
 *
 * @author Ricardoc
 */
public class RaceResult {
    
    private Integer raceNumber;
    private Pilot pilot;
    private Integer place;

    public RaceResult() {
        this.raceNumber = null;
        this.pilot = null;
        this.place = null;
    }

    public RaceResult(Integer raceNumber, Pilot pilot, Integer place) {
        this.raceNumber = raceNumber;
        this.pilot = pilot;
        this.place = place;
    }

    public Integer getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(Integer raceNumber) {
        this.raceNumber = raceNumber;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.raceNumber);
        hash = 89 * hash + Objects.hashCode(this.pilot);
        hash = 89 * hash + Objects.hashCode(this.place);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RaceResult other = (RaceResult) obj;
        if (!Objects.equals(this.raceNumber, other.raceNumber)) {
            return false;
        }
        if (!Objects.equals(this.pilot, other.pilot)) {
            return false;
        }
        if (!Objects.equals(this.place, other.place)) {
            return false;
        }
        return true;
    }
    
    
    
}
