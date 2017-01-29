package com.jericopingul.wodtimer;

import android.os.CountDownTimer;

/**
 * Created by jeric on 29/01/2017.
 */

public class CountDown {

    private CountDownTimer countDownTimer;

    public CountDown() {
        countDownTimer = new CountDownTimer(10*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        };
    }

    public void start() {
        this.countDownTimer.start();
    }
}
