package com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Quiz;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseshub.R;

import java.util.ArrayList;

public class CourseDetail_QuizAdapter extends RecyclerView.Adapter<CourseDetail_QuizAdapter.QuizHolder> {
    private ArrayList<Quiz> _data;
    private Context _context;
    private LayoutInflater _inflater;

    public CourseDetail_QuizAdapter(Context context, ArrayList<Quiz> data) {
        this._context = context;
        this._data = data;
        _inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public QuizHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = _inflater.inflate(R.layout.coursedetail_tab_quiz_item, parent, false);
        return new QuizHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizHolder holder, int position) {
        holder.setData(_data.get(position));
    }

    @Override
    public int getItemCount() {
        return _data.size();
    }

    class QuizHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView _number;
        private ImageView _icon1;
        private TextView _title;
        private TextView _des;
        private TextView _count;
        private ImageView _icon2;

        public QuizHolder(@NonNull View itemView) {
            super(itemView);
            _number = itemView.findViewById(R.id.coursedetail_quiz_item_number);
            _icon1 = itemView.findViewById(R.id.coursedetail_quiz_item_icon1);
            _title = itemView.findViewById(R.id.coursedetail_quiz_item_title);
            _des = itemView.findViewById(R.id.coursedetail_quiz_item_description);
            _count = itemView.findViewById(R.id.coursedetail_quiz_item_remained);
            _icon2 = itemView.findViewById(R.id.coursedetail_syllabus_item_icon2);
            itemView.setOnClickListener(this);
        }

        public void setData(Quiz quiz) {
            _number.setText(Integer.toString(quiz.get_number()));
            if(quiz.get_type() == 1) setSubmittedQuiz();
            else if (quiz.get_type() == 2) setOverduedQuiz();
            _title.setText((quiz.get_title()));
            _des.setText(quiz.get_des());
            _count.setText(quiz.get_count());
        }

        public void setSubmittedQuiz(){
            _number.setTextColor(ContextCompat.getColor(_context, R.color.Success700));
            _title.setTextColor(ContextCompat.getColor(_context, R.color.Success700));
            //_icon1.setImageBitmap(BitmapFactory.decodeResource(_context.getResources(), R.drawable.ic_icon_attach_file_green_24px));
            //_icon2.setImageBitmap(BitmapFactory.decodeResource(_context.getResources(), R.drawable.ic_icon_vertical_align_top_green_24px));

        }

        public void setOverduedQuiz(){
            _number.setTextColor(ContextCompat.getColor(_context, R.color.Danger700));
            _title.setTextColor(ContextCompat.getColor(_context, R.color.Danger700));
            //_icon1.setImageBitmap(BitmapFactory.decodeResource(_context.getResources(), R.drawable.ic_icon_attach_file_green_24px));
            //_icon2.setImageBitmap(BitmapFactory.decodeResource(_context.getResources(), R.drawable.ic_icon_vertical_align_top_green_24px));
        }



        @Override
        public void onClick(View v) {
            Navigation.findNavController(v).navigate(R.id.action_courseDetail_QuizFragment_to_courseDetial_SubmissionFragment);
        }
    }
}

