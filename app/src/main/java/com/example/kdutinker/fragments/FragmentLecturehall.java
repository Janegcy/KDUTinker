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

public class FragmentLecturehall extends Fragment {
    View view;
    private RecyclerView myrecyclerview,myrecyclerview2;
    private List<LectureHall> name1;

    public FragmentLecturehall() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.lecturehall_fragment,container,false);
        myrecyclerview = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getActivity(),name1,1);

        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        myrecyclerview.setAdapter(recyclerAdapter);

        myrecyclerview2 = (RecyclerView) view.findViewById(R.id.recyclerView2);
        myrecyclerview2.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        myrecyclerview2.setAdapter(recyclerAdapter);

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        name1 = new ArrayList<>();
        name1.add(new LectureHall("LT01",R.drawable.lecture_hall));
        name1.add(new LectureHall("LT02",R.drawable.lecture_hall));
        name1.add(new LectureHall("LT03",R.drawable.lecture_hall));
        name1.add(new LectureHall("LT04",R.drawable.lecture_hall));
        name1.add(new LectureHall("LT05",R.drawable.lecture_hall));
        name1.add(new LectureHall("LT06",R.drawable.lecture_hall));
        name1.add(new LectureHall("LT07",R.drawable.lecture_hall));

    }
}
