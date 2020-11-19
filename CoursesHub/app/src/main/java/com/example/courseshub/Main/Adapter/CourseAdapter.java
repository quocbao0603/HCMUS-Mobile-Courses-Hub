package com.example.courseshub.Main.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseshub.CourseInfo.CourseinfoFragment;
import com.example.courseshub.Main.Fragment.CourseListFragment;
import com.example.courseshub.R;
import com.example.courseshub.CourseInfo.CourseInfo;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseHolder>{
    private ArrayList<CourseInfo> _data;
    private LayoutInflater _inflater;
    private View.OnClickListener _listener = new CourseListFragment();
    private FragmentManager _fragmentManager;
    private Context _context;

    public CourseAdapter(Context context, ArrayList<CourseInfo> data, FragmentManager fragmentManager){
        _inflater = LayoutInflater.from(context);
        _data = data;
        _context = context;
        _fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = _inflater.inflate(R.layout.course_item, parent, false);

        view.setOnClickListener(_listener);
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

