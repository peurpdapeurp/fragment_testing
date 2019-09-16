package com.example.fragment_testing;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.named_data.jndn.Name;

public class ProgressBarFragment extends Fragment {

    // Private constants
    private static final int PROCESSING_INTERVAL_MS = 5000;

    // Messages
    private static final int MSG_DO_SOME_WORK = 0;

    private Name streamName_;
    private String displayText_;

    private TextView textDisplay_;

    Handler handler_;



    public ProgressBarFragment(Name streamName, String displayText, Looper mainThreadLooper) {
        streamName_ = streamName;
        displayText_ = displayText;
        handler_ = new Handler(mainThreadLooper) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case MSG_DO_SOME_WORK: {
                        doSomeWork();
                        break;
                    }
                    default: {
                        throw new IllegalStateException("unexpected msg.what " + msg.what);
                    }
                }
            }
        };
    }

    private void doSomeWork() {
        String newDisplayText = textDisplay_.getText().toString() + "bloop";
        textDisplay_.setText(newDisplayText);
        scheduleNextWork(SystemClock.uptimeMillis());
    }

    private void scheduleNextWork(long thisOperationStartTimeMs) {
        handler_.removeMessages(MSG_DO_SOME_WORK);
        handler_.sendEmptyMessageAtTime(MSG_DO_SOME_WORK, thisOperationStartTimeMs + PROCESSING_INTERVAL_MS);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler_.obtainMessage(MSG_DO_SOME_WORK).sendToTarget(); // start doSomeWork cycle

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_progress_bar, container, false);

        textDisplay_ = (TextView) view.findViewById(R.id.text_display);
        String displayString = streamName_.toString() + ": " + displayText_;
        textDisplay_.setText(displayString);

        return view;
    }

    public Name getStreamName() {
        return streamName_;
    }
}
