package model;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Authentication {

    private static final int iterations = 32*1024;
    private static final int saltLen = 32;
    private static final int keyLen = 512;

    public static boolean verify(String secret, String stored) throws Exception{
        String[] saltKey = stored.split("\\$");
        byte[] bytes = Base64.getDecoder().decode(saltKey[0]);
        
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = factory.generateSecret(new PBEKeySpec(secret.toCharArray(), bytes, iterations, keyLen));
        
        String inputHash = Base64.getEncoder().encodeToString(key.getEncoded());
        
        return inputHash.equals(saltKey[1]);
    }
    
    public static String hash(String secret) throws Exception {
        byte[] bytes = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);

        SecretKeyFactory factroy = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = factroy.generateSecret(new PBEKeySpec(secret.toCharArray(), bytes, iterations, keyLen));
        
        String salt = Base64.getEncoder().encodeToString(bytes);
        String hash = Base64.getEncoder().encodeToString(key.getEncoded());
        
        return salt+"$"+hash;
    }


}