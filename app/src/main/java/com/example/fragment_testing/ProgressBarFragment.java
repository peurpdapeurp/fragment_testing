package com.example.fragment_testing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProgressBarFragment extends Fragment {

    private static final String ARG_DISPLAY_TEXT = "ARG_DISPLAY_TEXT";

    private String displayText_;

    private TextView textDisplay_;

    public ProgressBarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param displayText Text to display.
     * @return A new instance of fragment ProgressBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProgressBarFragment newInstance(String displayText) {
        ProgressBarFragment fragment = new ProgressBarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_DISPLAY_TEXT, displayText);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            displayText_ = getArguments().getString(ARG_DISPLAY_TEXT);
        }
        else {
            throw new IllegalStateException("getArguments() was null.");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_progress_bar, container, false);

        textDisplay_ = (TextView) view.findViewById(R.id.text_display);
        textDisplay_.setText(displayText_);

        return view;
    }
}
