package com.example.fragment_testing;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.named_data.jndn.Name;

public class MainActivity extends AppCompatActivity {

    // Private constants
    private static final int MAX_PROGRESS_BARS_TO_DISPLAY = 5;

    ProgressBarListFragment progressBarListFragment_;
    Button addProgressBarButton_;
    long streamId_ = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarListFragment_ = (ProgressBarListFragment) getSupportFragmentManager().findFragmentById(R.id.progress_bar_list_fragment);

        addProgressBarButton_ = (Button) findViewById(R.id.add_progress_bar_button);
        addProgressBarButton_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBarListFragment_.addProgressBar(
                        new ProgressBarFragment(
                                new Name("test_stream_name").appendSequenceNumber(++streamId_),
                                "blah blah blah",
                                getMainLooper()
                        )
                );
            }
        });

    }


}
