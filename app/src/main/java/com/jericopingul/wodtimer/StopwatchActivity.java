package com.jericopingul.wodtimer;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Chronometer;

import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class StopwatchActivity extends AppCompatActivity {

    private long timeWhenStopped = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
    }

    public void startButton(View view) {
        Chronometer chronometer = ((Chronometer) findViewById(R.id.chronometer));
        chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        chronometer.start();

        beepOnEveryMinute();
    }

    public void stopButton(View view) {
        Chronometer chronometer = ((Chronometer) findViewById(R.id.chronometer));
        timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
        chronometer.stop();
    }

    private void beepOnEveryMinute() {
        ((Chronometer) findViewById(R.id.chronometer)).setOnChronometerTickListener(
                new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        long elapseMillis = getElapsedTime(chronometer);
                        long minutes = TimeUnit.MILLISECONDS.toMinutes(elapseMillis);
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(elapseMillis)
                                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(elapseMillis));

                        String elapsedTime = String.format(
                                Locale.getDefault(),
                                "%d min, %d sec",
                                minutes,
                                seconds
                        );
                        System.out.println("Elapsed:: " + elapsedTime);

                    }
                }
        );
    }

    private long getElapsedTime(Chronometer chronometer) {
        return SystemClock.elapsedRealtime() - chronometer.getBase();
    }

}
