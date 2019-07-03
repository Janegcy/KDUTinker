package com.example.kdutinker.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kdutinker.Adapters.RecyclerViewAdapter;
import com.example.kdutinker.Lists.LectureHall;
import com.example.kdutinker.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentLab1 extends Fragment {
    View view;
    private RecyclerView myrecyclerview;
    private List<LectureHall> name1;

    public FragmentLab1() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.lab_fragment,container,false);
        myrecyclerview = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(),name1,3);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        myrecyclerview.setAdapter(recyclerAdapter);

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        name1 = new ArrayList<>();
        name1.add(new LectureHall("LAB A",R.drawable.lab));
        name1.add(new LectureHall("LAB B",R.drawable.lab));
        name1.add(new LectureHall("LAB C",R.drawable.lab));
        name1.add(new LectureHall("LAB D",R.drawable.lab));
        name1.add(new LectureHall("LAB E",R.drawable.lab));
        name1.add(new LectureHall("LAB F",R.drawable.lab));
    }
}
