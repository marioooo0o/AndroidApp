package com.example.clientside;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

public class LectureListAdapter extends RecyclerView.Adapter<LectureListAdapter.LectureViewHolder> {
    public static final String LECTURE_KEY = "com.example.clientside.LECTURE_KEY";
    private final android.view.LayoutInflater layoutInflater;
    private List<Lecture> lectureList;

    public LectureListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.lectureList = null;
    }

    public void setLectureList(List<Lecture> lectureList) {
        this.lectureList = lectureList;
        notifyDataSetChanged();//kiedy wywołujesz set lecture to inforumje adapter że się zmieniły dane i trzeba odświeżyć recyclerView
    }
    @NonNull
    @Override
    public LectureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = layoutInflater.inflate(R.layout.lecture_row, parent, false);
        return new LectureViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull LectureViewHolder holder, int position) {
        Lecture lecture = lectureList.get(position);
        holder.lectureTitle.setText(lecture.getName());
        holder.lectureDesc.setText(lecture.getDescription());
        holder.id = lecture.getId();
    }

    @Override
    public int getItemCount() {
        if (lectureList != null)
            return lectureList.size();
        return 0;
    }

    public class LectureViewHolder extends RecyclerView.ViewHolder{
        Button lectureTitle;
        Button lecture;
        TextView lectureDesc;
        Long id;
        public LectureViewHolder(@NonNull View itemView) {
            super(itemView);
            lectureTitle = itemView.findViewById(R.id.btn_lecture);
            lectureDesc = itemView.findViewById(R.id.lecture_desc);
            lecture = itemView.findViewById(R.id.btn_show_lecture);
            lectureTitle.setOnClickListener(v -> {
                if(lectureDesc.getVisibility() == View.VISIBLE){
                    lectureDesc.setVisibility(View.GONE);
                    lecture.setVisibility(View.GONE);
                }else{
                    lectureDesc.setVisibility(View.VISIBLE);
                    lecture.setVisibility(View.VISIBLE);
                }

            });
            lecture.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), SliderViewer.class);
                intent.putExtra(LECTURE_KEY, id);
                v.getContext().startActivity(intent);
            });
        }
    }
}
