/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialnetwork.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author user
 * Encrypt and decrypt strings
 */
public class MD5Hasher {
    
    /**
     * Encrypt password using secret key and MD5 algorithm
     * @param passwordToHash
     * @return passwordHashed 
     */
    public static String hash(String passwordToHash) {
        byte[] salt = PropertiesManager.getSecretKey().getBytes();
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt);
            byte[] bytes = md.digest(
                    passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((
                        bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {

        }
        return generatedPassword;
    }
    
    /**
     * Verify if password match with hash
     * @param hash
     * @param attempt
     * @return true o false if password match
     */
    public static boolean checkPassword(String hash, String attempt) {
        String generatedHash = hash(attempt);
        return hash.equals(generatedHash);
    }
}
