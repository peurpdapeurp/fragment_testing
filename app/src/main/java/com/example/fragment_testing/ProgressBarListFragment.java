package com.example.fragment_testing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class ProgressBarListFragment extends Fragment {

    private static final int MAX_PROGRESS_BARS = 5;

    private ArrayList<ProgressBarFragment> progressBarList_;

    private ScrollView progressBarListDisplay_;
    private LinearLayout progressBarsLayout_;
    private FragmentManager fragmentManager_;

    public ProgressBarListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressBarList_ = new ArrayList<>();

        fragmentManager_ = getFragmentManager();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_progress_bar_list, container, false);

        progressBarListDisplay_ = (ScrollView) view.findViewById(R.id.progress_bar_list);
        progressBarsLayout_ = (LinearLayout) view.findViewById(R.id.progress_bars_layout);

        // Inflate the layout for this fragment
        return view;

    }

    public void addProgressBar(ProgressBarFragment progressBarFragment) {
        progressBarList_.add(progressBarFragment);

        FragmentTransaction transaction = fragmentManager_.beginTransaction();
        transaction.add(R.id.progress_bars_layout, progressBarFragment, progressBarFragment.getStreamName().toString());
        transaction.commit();
    }

}
