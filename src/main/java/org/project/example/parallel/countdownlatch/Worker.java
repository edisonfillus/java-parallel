package org.project.example.parallel.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Worker implements Runnable {

    private static Logger log = LogManager.getLogger(Worker.class);

    private List<String> outputScraper;
    private CountDownLatch countDownLatch;
 
    public Worker(List<String> outputScraper, CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }
 
    @Override
    public void run() {
        log.info("Executing Job");
        outputScraper.add("Counted down");
        countDownLatch.countDown();
    }
}