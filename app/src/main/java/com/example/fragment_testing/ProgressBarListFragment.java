package com.example.fragment_testing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import java.util.ArrayList;

public class ProgressBarListFragment extends Fragment {

    private static final String ARG_MAX_PROGRESS_BARS = "ARG_MAX_PROGRESS_BARS";

    private int maxProgressBars_;

    private ScrollView progressBarListDisplay_;

    private ArrayList<ProgressBarFragment> progressBarList_;

    public ProgressBarListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param maxProgressBars The maximum number of progress bars displayed by this ProgressBarListFragment.
     * @return A new instance of fragment ProgressBarListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProgressBarListFragment newInstance(int maxProgressBars) {
        ProgressBarListFragment fragment = new ProgressBarListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_MAX_PROGRESS_BARS, maxProgressBars);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            maxProgressBars_ = getArguments().getInt(ARG_MAX_PROGRESS_BARS);
        }
        else {
            throw new IllegalStateException("getArguments() was null.");
        }

        progressBarList_ = new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_progress_bar_list, container, false);

        progressBarListDisplay_ = (ScrollView) view.findViewById(R.id.progress_bar_list);

        // Inflate the layout for this fragment
        return view;

    }

    public void addProgressBar(ProgressBarFragment progressBarFragment) {
        progressBarList_.add(progressBarFragment);

    }
}
