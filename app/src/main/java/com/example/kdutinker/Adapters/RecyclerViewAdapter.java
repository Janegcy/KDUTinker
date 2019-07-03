package com.example.kdutinker.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.kdutinker.Lists.LectureHall;
import com.example.kdutinker.PanoramaHallActivity;
import com.example.kdutinker.PanoramaLabActivity;
import com.example.kdutinker.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    //vars
    List<LectureHall> mData;
    Context mContext;
    int flag;

    public RecyclerViewAdapter(Context mContext,List<LectureHall> mData, int flag) {
        this.mData = mData;
        this.mContext = mContext;
        this.flag = flag;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.hall_list,parent,false);
        ViewHolder vHolder = new ViewHolder(v);

        return vHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.name.setText(mData.get(position).getName());
        holder.image.setImageResource(mData.get(position).getPhoto());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView image;
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view);
            name = itemView.findViewById(R.id.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();

                    if (flag == 1){
                        Intent intent = new Intent(context, PanoramaHallActivity.class);
                        context.startActivity(intent);
                    }else if (flag == 2){
                        //here you can choose the activity
                    }else {
                        Intent intent = new Intent(context, PanoramaLabActivity.class);
                        context.startActivity(intent);
                    }

                }
            });
        }
    }
}
