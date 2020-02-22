package com.example.instagram.presentation.search;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.instagram.R;
import com.example.instagram.presentation.base.BaseRecyclerViewAdapter;
import com.example.instagram.presentation.base.ItemClickListener;
import com.google.android.material.button.MaterialButton;
import com.instagram.domain.model.User;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Viet Hua on 2/15/2020
 */
public class SearchAdapter extends BaseRecyclerViewAdapter<User, SearchAdapter.ViewHolder>  {
    private static final String TAG = SearchAdapter.class.getSimpleName();
    private FollowButtonClickListener followButtonClickListener;
    public SearchAdapter(Context context, ItemClickListener<User> listener){
        super(context);
        setListener(listener);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_user,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User entity = mData.get(position);
        holder.renderUI(entity);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener , View.OnLongClickListener{
        private  final String TAG = ViewHolder.class.getSimpleName();
        private TextView tvUsername , tvRealName,tvStatus;
        private ImageView imgProfile;
        private MaterialButton btnFollow;
        public ViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            tvUsername = itemView.findViewById(R.id.txt_username);
            tvRealName = itemView.findViewById(R.id.txt_realName);
            tvStatus = itemView.findViewById(R.id.txt_status);
            imgProfile = itemView.findViewById(R.id.img_profile);
            btnFollow = itemView.findViewById(R.id.btn_follow);
        }
        public void renderUI(User user){
            tvUsername.setText(user.getFullName());
            tvRealName.setText("Hua Viet");
            tvStatus.setText("Pho bien");
            Glide.with(context).load(user.getProfileImage()).placeholder(R.drawable.ic_launcher_background).into(imgProfile);
            btnFollow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btnFollow.setEnabled(false);
                   followButtonClickListener.onClickListener();
                }
            });
            btnFollow.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    followButtonClickListener.onLongClickListener();
                    return false;
                }
            });
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
    public interface FollowButtonClickListener{
        void onClickListener();
        void onLongClickListener();
    }
    public void setOnFollowButtonClickListener(FollowButtonClickListener listener){
        followButtonClickListener = listener;
    }
}
