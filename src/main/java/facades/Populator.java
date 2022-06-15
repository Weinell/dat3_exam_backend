/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javax.persistence.EntityManagerFactory;

import dtos.LocationDTO;
import dtos.MatchDTO;
import entities.Location;
import entities.Match;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        MatchFacade matchFacade = MatchFacade.getFacade(emf);
        //matchFacade.create(new MatchDTO(new Match("Eagles", "Jens", 1, true)));

    }
    
    public static void main(String[] args) {
        populate();
    }
}
