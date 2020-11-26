package com.example.courseshub.Main.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseshub.Main.CourseViewModel;
import com.example.courseshub.R;
import com.example.courseshub.Course.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CourseHolder> {
    private ArrayList<Course> _data;
    private LayoutInflater _inflater;
    private FragmentManager _fragmentManager;
    private Context _context;
    final private ListItemClickListener _listener;
    public int selectedItem;

    public CourseListAdapter(Context context, ArrayList<Course> data, FragmentManager fragmentManager, ListItemClickListener listener) {
        _inflater = LayoutInflater.from(context);
        _data = data;
        _context = context;
        _fragmentManager = fragmentManager;
        _listener = listener;

    }

    @Override
    public void onBindViewHolder(@NonNull CourseHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @NonNull
    @Override
    public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = _inflater.inflate(R.layout.tab_courselist_item, parent, false);
        Log.d("DBG", "Inflate 1 time");
        return new CourseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseHolder holder, int position) {
        Course course = _data.get(position);
        holder.setData(course);
    }

    @Override
    public int getItemCount() {
        return _data.size();
    }

    class CourseHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            CourseViewModel model = new CourseViewModel();
            _listener.onListItemClick(position, v);
        }

        public void setData(Course course){
            this._avt.setImageBitmap(course.get_avt());
            this._title.setText(course.get_title());
            this._teacher.setText(course.get_teacher());
            this._ta1.setText(course.get_ta1());
            this._ta2.setText(course.get_ta2());
        }
    }
    public interface ListItemClickListener{
        void onListItemClick(int position, View view);
    }
}



