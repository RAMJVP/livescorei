package com.liveinfo.livescorei.service;

import org.springframework.stereotype.Service;

import com.liveinfo.livescorei.constant.LiveInfoConstant;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.stereotype.Service;



@Service
public class APIKeyService {

	 // AtomicReference to hold the String key
    private final AtomicReference<String> keyRef = new AtomicReference<>();

    public APIKeyService() {
        // Initialize the key with an initial value if needed
        keyRef.set(LiveInfoConstant.API_KEY);
    }

    // Thread-safe method to update the key
    public void updateKey(String newKey) {
        keyRef.set(newKey);
    }

    // Thread-safe method to read the key
    public String getKey() {
        return keyRef.get();
    }
    
 
 public String apiKey(String apiKey){
	 return LiveInfoConstant.API_KEYS_MAP.get(apiKey);
 }
    
    
    
    
}
