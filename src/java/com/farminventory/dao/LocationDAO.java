/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.dao;

import com.farminventory.entity.Location;
import java.util.List;

/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public interface LocationDAO {
    
    List<Location> get();
    
    boolean update(Location Location);
    boolean save(Location Location);
    Location getLocation(int id);
    Location getLocationByState(String State);

    public boolean delete(int id);
    
}
