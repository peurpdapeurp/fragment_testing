package com.example.fragment_testing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Private constants
    private static final int MAX_PROGRESS_BARS_TO_DISPLAY = 5;

    ProgressBarListFragment progressBarListFragment_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarListFragment_ = ProgressBarListFragment.newInstance(MAX_PROGRESS_BARS_TO_DISPLAY);

    }

}
