package com.example.courseshub.Profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseshub.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProfileCourseAdapter extends RecyclerView.Adapter<ProfileCourseAdapter.CourseHolder>{
    private ArrayList<String> _data;
    private Context _context;
    private LayoutInflater _inflater;

    public ProfileCourseAdapter(ArrayList<String> _data, Context _context) {
        this._data = _data;
        this._context = _context;
        this._inflater = LayoutInflater.from(_context);
    }

    @NonNull
    @Override
    public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = _inflater.inflate(R.layout.profile_course_item, parent, false);
        return new CourseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseHolder holder, int position) {
        holder.setData(this._data.get(position));
    }

    @Override
    public int getItemCount() {
        return _data.size();
    }

    class CourseHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public CourseHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.profile_course_item);
        }

        public void setData(String data){
            textView.setText(data);
        }
    }

}
