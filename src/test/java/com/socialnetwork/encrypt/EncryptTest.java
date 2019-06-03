/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialnetwork.encrypt;

import com.socialnetwork.utils.MD5Hasher;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author user
 */
public class EncryptTest {
    
    @Test
    public void matchEncrypt(){
        String encrypt = MD5Hasher.hash("password");
        Assert.assertEquals(
                true, MD5Hasher.checkPassword(encrypt, "password"));
    }
    
}
