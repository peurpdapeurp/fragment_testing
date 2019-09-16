package com.example.fragment_testing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.named_data.jndn.Name;
import net.named_data.jndn.encoding.EncodingException;
import net.named_data.jndn.util.Blob;

import java.util.Objects;

public class ProgressBarFragment extends Fragment {

    private Name streamName_;
    private String displayText_;

    private TextView textDisplay_;

    public ProgressBarFragment(Name streamName, String displayText) {
        streamName_ = streamName;
        displayText_ = displayText;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
