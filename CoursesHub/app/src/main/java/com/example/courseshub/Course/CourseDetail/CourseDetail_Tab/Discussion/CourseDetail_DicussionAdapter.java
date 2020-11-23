package com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Discussion;

import android.content.Context;
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

public class CourseDetail_DicussionAdapter extends RecyclerView.Adapter<CourseDetail_DicussionAdapter.DiscussionHolder> {
    ArrayList<Discussion> _data;
    private Context _context;
    private LayoutInflater _inflater;

    public CourseDetail_DicussionAdapter(ArrayList<Discussion> _data, Context _context) {
        this._data = _data;
        this._context = _context;
        _inflater = LayoutInflater.from(_context);
    }

    @NonNull
    @Override
    public DiscussionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = _inflater.inflate(R.layout.coursedetail_tab_discussion_item, parent, false);
        return new DiscussionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscussionHolder holder, int position) {
        holder.setData(_data.get(position));
    }

    @Override
    public int getItemCount() {
        return _data.size();
    }

    public class DiscussionHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView _avt;
        private TextView _new;
        private TextView _title;
        private TextView _des;

        public DiscussionHolder(@NonNull View itemView) {
            super(itemView);
            _avt = itemView.findViewById(R.id.coursedetail_discussion_item_avt);
            _new = itemView.findViewById(R.id.coursedetail_discussion_item_new);
            _title = itemView.findViewById(R.id.coursedetail_discussion_item_title);
            _des = itemView.findViewById(R.id.coursedetail_discussion_item_des);
        }

        public void setData(Discussion discussion){
            _avt.setImageBitmap(discussion.get_avt());
            _new.setText(Integer.toString(discussion.get_new()));
            _title.setText(discussion.get_title());
            _des.setText(discussion.get_des());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
