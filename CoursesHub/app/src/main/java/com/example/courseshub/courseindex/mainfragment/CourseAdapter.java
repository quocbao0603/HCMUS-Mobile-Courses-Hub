package com.example.courseshub.courseindex.mainfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseshub.R;
import com.example.courseshub.courseindex.course.CourseInfo;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseHolder>{
    private ArrayList<CourseInfo> _data;
    private LayoutInflater _inflater;
    private View.OnClickListener _listener;

    public CourseAdapter(Context context, ArrayList<CourseInfo> data){
        _inflater = LayoutInflater.from(context);
        _data = data;
    }

    @NonNull
    @Override
    public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = _inflater.inflate(R.layout.course_item, parent, false);
        return new CourseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseHolder holder, int position) {
        CourseInfo courseInfo = _data.get(position);
        holder._avt.setImageBitmap(courseInfo.get_avt());
        holder._title.setText(courseInfo.get_title());
        holder._teacher.setText(courseInfo.get_teacher());
        holder._ta1.setText(courseInfo.get_ta1());
        holder._ta2.setText(courseInfo.get_ta2());
    }

    @Override
    public int getItemCount() {
        return _data.size();
    }

    class CourseHolder extends RecyclerView.ViewHolder{

        ImageView _avt;
        TextView _title, _teacher, _ta1, _ta2;
        ImageView _bookmark, _more;

        public CourseHolder(@NonNull View itemView) {
            super(itemView);
            _avt = itemView.findViewById(R.id.course_avt);
            _title = itemView.findViewById(R.id.course_title);
            _teacher = itemView.findViewById(R.id.course_teacher);
            _ta1 = itemView.findViewById(R.id.course_ta1);
            _ta2 = itemView.findViewById(R.id.course_ta2);
            _bookmark = itemView.findViewById(R.id.course_bookmark);
            _more = itemView.findViewById(R.id.course_more);
        }
    }
}

