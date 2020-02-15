package com.example.instagram.presentation.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Viet Hua on 2/15/2020
 * @param <T>  : ITEM
 * @param <VH> : VIEW HOLDER
 */
public abstract class BaseRecyclerViewAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected List<T> mData;
    protected ItemClickListener<T> mListener;
    protected Context context;
    protected LayoutInflater mLayoutInflater;

    public BaseRecyclerViewAdapter(Context context) {
        this.context = context;
        mData = new ArrayList<>();
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setListener(ItemClickListener<T> listener) {
        this.mListener = listener;
    }

    public void setData(List<T> data) {
        if (data == null) {
            return;
        }
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public void addData(T t) {
        mData.add(t);
        notifyItemInserted(mData.size() - 1);
    }

    public void clearData() {
        mData.clear();
        notifyDataSetChanged();
    }

    public void removeData(T t) {
        int pos = mData.indexOf(t);
        removeDataByPosition(pos);
    }

    public void removeDataByPosition(int position) {
        if (position < 0) {
            return;
        }
        mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mData.size());
    }

    public T getItem(int position) {
        return mData.get(position);
    }


    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
}
