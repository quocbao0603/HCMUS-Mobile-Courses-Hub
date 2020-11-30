package com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Syllabus;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseshub.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CourseDetail_SyllabusAdapter extends RecyclerView.Adapter<CourseDetail_SyllabusAdapter.SyllabusHolder> {
    private ArrayList<Syllabus> _data;
    private Context _context;
    private LayoutInflater _inflater;

    public CourseDetail_SyllabusAdapter(Context context, ArrayList<Syllabus> data) {
        this._context = context;
        this._data = data;
        _inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SyllabusHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = _inflater.inflate(R.layout.coursedetail_tab_syllabus_item, parent, false);
        return new SyllabusHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SyllabusHolder holder, int position) {
        holder.setData(_data.get(position));
    }

    @Override
    public int getItemCount() {
        return _data.size();
    }

    class SyllabusHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView _number;
        private ImageView _icon1;
        private TextView _title;
        private TextView _des;
        private ImageView _icon2;


        public SyllabusHolder(@NonNull View itemView) {
            super(itemView);
            _number = itemView.findViewById(R.id.coursedetail_syllabus_item_number);
            _icon1 = itemView.findViewById(R.id.coursedetail_syllabus_item_icon1);
            _title = itemView.findViewById(R.id.coursedetail_syllabus_item_title);
            _des = itemView.findViewById(R.id.coursedetail_syllabus_item_description);
            _icon2 = itemView.findViewById(R.id.coursedetail_syllabus_item_icon2);
            itemView.setOnClickListener(this);
        }

        public void setData(Syllabus syllabus) {
            _number.setText(Integer.toString(syllabus.get_number()));
                if(syllabus.get_type() == 0){
                    _icon1.setImageBitmap(BitmapFactory.decodeResource(_context.getResources(), R.drawable.ic_icon_attach_file_blue_24px));
                    _icon2.setImageBitmap(BitmapFactory.decodeResource(_context.getResources(), R.drawable.ic_icon_vertical_align_bottom_24px));
                }
                else{
                    _icon1.setImageBitmap(BitmapFactory.decodeResource(_context.getResources(), R.drawable.ic_icon_explore_24px));
                    _icon2.setImageBitmap(BitmapFactory.decodeResource(_context.getResources(), R.drawable.ic_icon_call_24px));
                }
            _title.setText((syllabus.get_title()));
            _des.setText(syllabus.get_des());
        }

        @Override
        public void onClick(View v){
            int position = getAdapterPosition();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(_data.get(position).get_url()));
            _context.startActivity(i);
        };
    }
}

