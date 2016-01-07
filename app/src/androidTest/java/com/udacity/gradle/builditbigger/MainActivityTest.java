package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class MainActivityTest extends ApplicationTestCase<Application> {

    private MainActivity mMainActivity;

    private String mJoke;

    CountDownLatch signal;

    public MainActivityTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testJokeGetTask() throws InterruptedException {
        AsyncJokeDownloader asyncJokeDownloader = new AsyncJokeDownloader();
        asyncJokeDownloader.setListener(new AsyncJokeDownloader.Listener() {
            @Override
            public void onDownloadCompleted(String joke) {
                mJoke = joke;
                signal.countDown();
            }
        }).execute();
        signal.await(30, TimeUnit.SECONDS);

        assertFalse(TextUtils.isEmpty(mJoke));
    }

}