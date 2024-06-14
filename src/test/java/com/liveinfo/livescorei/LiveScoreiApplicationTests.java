package com.liveinfo.livescorei;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.liveinfo.livescorei.service.APIKeyService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = LiveScoreiApplication.class)
@ExtendWith(SpringExtension.class)

class LiveScoreiApplicationTests {

	@Test
	void contextLoads() {
	}

	
	@Autowired
    private APIKeyService apiKeyService;

    @Test
    public void testThreadSafety() throws InterruptedException {
        int threadCount = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            executorService.execute(() -> {
                try {
                    // Each thread sets a unique key
                	apiKeyService.updateKey("key" + index);

                    // Read the key
                    String key = apiKeyService.getKey();
                    assertNotNull(key);
                    System.out.println("Thread " + index + " read key: " + key);

                } finally {
                    latch.countDown();
                }
            });
        }

        // Wait for all threads to finish
        latch.await(10, TimeUnit.SECONDS);
        executorService.shutdown();

        // Ensure that the key is one of the expected values
        String finalKey = apiKeyService.getKey();
        System.out.println("Final key: " + finalKey);
        assertNotNull(finalKey);
        boolean isValid = false;
        for (int i = 0; i < threadCount; i++) {
            if (finalKey.equals("key" + i)) {
                isValid = true;
                break;
            }
        }
        assertEquals(true, isValid);
    }
    
    
    
    
    @Test
    public void testThreadSafetyWithMixedOperations() throws InterruptedException {
        int writerThreadCount = 2;
        int readerThreadCount = 8;
        int totalThreadCount = writerThreadCount + readerThreadCount;

        ExecutorService executorService = Executors.newFixedThreadPool(totalThreadCount);
        CountDownLatch latch = new CountDownLatch(totalThreadCount);

        // Writer threads
        for (int i = 0; i < writerThreadCount; i++) {
            final int index = i;
            executorService.execute(() -> {
                try {
                    // Each writer thread sets a unique key
                	apiKeyService.updateKey("writerKey" + index);

                    // Sleep for a bit to simulate work
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } finally {
                    latch.countDown();
                }
            });
        }

        // Reader threads
        for (int i = 0; i < readerThreadCount; i++) {
            executorService.execute(() -> {
                try {
                    // Reader threads read the key multiple times
                    for (int j = 0; j < 10; j++) {
                        String key = apiKeyService.getKey();
                        assertNotNull(key);
                        System.out.println("Reader read key: " + key);

                        // Sleep for a bit to simulate work
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } finally {
                    latch.countDown();
                }
            });
        }

        // Wait for all threads to finish
        latch.await(30, TimeUnit.SECONDS);
        executorService.shutdown();

        // Ensure that the final key is one of the values set by writer threads
        String finalKey = apiKeyService.getKey();
        System.out.println("Final key: " + finalKey);
        assertNotNull(finalKey);

        boolean isValid = false;
        for (int i = 0; i < writerThreadCount; i++) {
            if (finalKey.equals("writerKey" + i)) {
                isValid = true;
                break;
            }
        }
        assertEquals(true, isValid);
    }

    
    
    
    
}
