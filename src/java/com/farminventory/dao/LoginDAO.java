/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farminventory.dao;

import com.farminventory.entity.Login;

/**
 *
 * @author Zinwota Timothy @BrainStack
 */
public interface LoginDAO {
    String authenticate(Login login);
}
