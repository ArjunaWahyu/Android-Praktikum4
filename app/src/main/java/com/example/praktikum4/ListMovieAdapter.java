package com.example.praktikum4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

//RecyclerView Adapter
public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ListViewHolder> {
    private ArrayList<Movie> listMovie;
    private OnItemClickCallback onItemClickCallback;

    public ListMovieAdapter(ArrayList<Movie> list, OnItemClickCallback onItemClickCallback) {
        this.listMovie = list;
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Movie movie = listMovie.get(position);
        Glide.with(holder.itemView.getContext())
                .load(movie.getPosterImage())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(movie.getTitle());
        holder.tvDescription.setText(movie.getDescription());
        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listMovie.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.iv_movie_poster);
            tvName = itemView.findViewById(R.id.tv_movie_title);
            tvDescription = itemView.findViewById(R.id.tv_movie_description);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Movie data);
    }

}
