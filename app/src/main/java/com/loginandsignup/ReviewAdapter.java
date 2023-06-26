package com.loginandsignup;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loginandsignup.models.ReviewModel;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.RecyclerviewHolder> {
    private ArrayList<ReviewModel> reviewModelArrayList = new ArrayList<>();
    Context context;


    public ReviewAdapter(Context context, ArrayList<ReviewModel> recentproductArrayList) {
        this.context           = context;
        this.reviewModelArrayList = recentproductArrayList;
    }


    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.feedback_item, parent, false);
        return new RecyclerviewHolder(mRootView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {

        holder.Name.setText(reviewModelArrayList.get(position).getName());
        holder.date.setText(reviewModelArrayList.get(position).getDate());
        holder.comment.setText(reviewModelArrayList.get(position).getComment());
        holder.rating.setRating(reviewModelArrayList.get(position).getRating());
        holder.img.setImageDrawable(reviewModelArrayList.get(position).getUserimage());
        holder.name_start.setText(""+reviewModelArrayList.get(position).getName().charAt(0));

    }

    @Override
    public int getItemCount() {
        return reviewModelArrayList.size();
    }


    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {
        TextView  Name;
        ImageView img;
        TextView  comment;
        TextView  date;
        RatingBar rating;
        TextView  name_start;



        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.Comment_title);
            img = itemView.findViewById(R.id.comment_image);
            comment = itemView.findViewById(R.id.comment_by_person);
            date = itemView.findViewById(R.id.date_of_person);
            rating = itemView.findViewById(R.id.rate_comment);
            name_start= itemView.findViewById(R.id.name_start);
        }

    }

}
