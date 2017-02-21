package com.jericopingul.wodtimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.codetroopers.betterpickers.numberpicker.NumberPickerBuilder;


public class TimerSelectorActivity extends AppCompatActivity {

    private Button minutesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_selector);
        minutesButton = (Button) findViewById(R.id.minutes_button);

        minutesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberPickerBuilder npb = new NumberPickerBuilder()
                        .setFragmentManager(getSupportFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment);
                npb.show();
            }
        });
    }


}
