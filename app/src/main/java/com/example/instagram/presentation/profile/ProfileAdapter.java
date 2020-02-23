package com.example.instagram.presentation.profile;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.instagram.R;
import com.example.instagram.presentation.base.BaseRecyclerViewAdapter;
import com.example.instagram.presentation.base.ItemClickListener;
import com.google.android.material.button.MaterialButton;
import com.instagram.domain.model.User;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Viet Hua on 2/15/2020
 */
public class ProfileAdapter extends BaseRecyclerViewAdapter<String, ProfileAdapter.ViewHolder> {
    private static final String TAG = ProfileAdapter.class.getSimpleName();

    public ProfileAdapter(Context context, ItemClickListener<String> listener) {
        super(context);
        setListener(listener);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_profile_picture, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String entity = mData.get(position);
        holder.renderUI(entity);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private final String TAG = ViewHolder.class.getSimpleName();
        private ImageView imgPictures;
        private ProgressBar progressBar;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            imgPictures = itemView.findViewById(R.id.img_profile);
            progressBar = itemView.findViewById(R.id.loading_img);
        }

        public void renderUI(String imgUrl) {
            Glide.with(context).load(imgUrl).listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    return false;

                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    progressBar.setVisibility(View.GONE);
                    return false;
                }
            }).into(imgPictures);
        }

        @Override
        public void onClick(View view) {
            if (mListener == null) return;
            mListener.onClickListener(getAdapterPosition(), null);
        }

        @Override
        public boolean onLongClick(View view) {
            if (mListener != null) {
                mListener.onLongClickListener(getAdapterPosition(), null);
            }
            return false;
        }
    }
}
