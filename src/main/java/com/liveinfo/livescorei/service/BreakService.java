package com.liveinfo.livescorei.service;

import org.springframework.stereotype.Service;

import com.liveinfo.livescorei.constant.LiveInfoConstant;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDate;


@Service
public class BreakService {

	 // AtomicReference to hold the String key
    private final AtomicReference<LocalDateTime> keyRef = new AtomicReference<>();

    public BreakService() {
        // Initialize the key with an initial value if needed
        keyRef.set(null);
    }

    // Thread-safe method to update the key
    public void updateKey(LocalDateTime newKey) {
    	
    	//LocalDateTime localDateTime = LocalDate.now().atTime(23, 59, 59);
    	
    	if(!firstWriteWinRange())
        keyRef.set(newKey);
    }

    
    private boolean firstWriteWinRange() {
    	if(!Optional.ofNullable(keyRef.get()).isPresent()) {
    		return false;
    	}
    	return keyRef.get().toLocalDate().equals(LocalDate.now());
	}

	// Thread-safe method to read the key
    public LocalDateTime getKey() {
        return keyRef.get();
    }
    
    public boolean inningsBreak(){
    	LocalDateTime breakStartTime=keyRef.get();
    	if(breakStartTime==null) {
    		return false;
    	}else if(breakRange(breakStartTime)) {
    		return true;
    	}
    	
	 return false;
    }

	private boolean breakRange(LocalDateTime breakStartTime) {
		return keyRef.get().compareTo(LocalDateTime.now())<=0 && Duration.between(breakStartTime, LocalDateTime.now()).toMinutes() <= 10;
	}
    //thread safe test case
    
    
    
}
