package com.example.instagram.presentation.home.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.instagram.R;
import com.example.instagram.presentation.base.BaseRecyclerViewAdapter;
import com.example.instagram.presentation.base.ItemClickListener;
import com.instagram.domain.Model.Post;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomePostAdapter extends BaseRecyclerViewAdapter<Post, HomePostAdapter.ViewHolder> {
    private static final String TAG = HomePostAdapter.class.getSimpleName();

    public HomePostAdapter(Context context, ItemClickListener<Post> listener) {
        super(context);
        setListener(listener);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post entity = mData.get(position);
        holder.renderUI(entity);

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View
            .OnClickListener, View.OnLongClickListener {
        private final String TAG = ViewHolder.class.getSimpleName();
        TextView tvUsername, tvLikeCount, tvCommentCount, tvDescription, tvPublisher;
        ImageView imgProfile, imgPost, imgLike, imgComment, imgSave;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            tvUsername = itemView.findViewById(R.id.txt_username);
            tvLikeCount = itemView.findViewById(R.id.txt_likes_count);
            tvCommentCount = itemView.findViewById(R.id.txt_comments);
            tvDescription = itemView.findViewById(R.id.txt_description);
            tvPublisher = itemView.findViewById(R.id.txt_publisher);
            imgProfile = itemView.findViewById(R.id.img_profile);
            imgPost = itemView.findViewById(R.id.img_post);
            imgLike = itemView.findViewById(R.id.item_like);
            imgComment = itemView.findViewById(R.id.item_comment);
            imgSave = itemView.findViewById(R.id.item_save);

        }

        public void renderUI(Post post) {
            int likeCount = 10;
            int commentCount = 20;
            tvUsername.setText(post.getPublisher());
            tvLikeCount.setText(String.format("%d likes", likeCount));
            tvCommentCount.setText(String.format("View all %d comments", commentCount));
            tvDescription.setText(post.getDescription());
            tvPublisher.setText(post.getPublisher());
            Glide.with(context).load(post.getPostImage()).placeholder(R.drawable.ic_launcher_background).into(imgPost);
            if (post.getDescription().equals("")) {
                tvDescription.setVisibility(View.GONE);
            } else {
                tvDescription.setVisibility(View.VISIBLE);
                tvDescription.setText(post.getDescription());
            }

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
