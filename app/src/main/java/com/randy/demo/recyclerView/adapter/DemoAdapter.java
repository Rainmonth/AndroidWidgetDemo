package com.randy.demo.recyclerView.adapter;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.randy.demo.R;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    public DemoAdapter(Context context, List<String> datas) {
        mInflater = LayoutInflater.from(context);
        mData = datas;
    }

    @Override
    public DemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DemoViewHolder holder = new DemoViewHolder(mInflater.inflate(
                R.layout.item_home, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final DemoViewHolder holder, final int position) {
        holder.tv.setText(mData.get(position));

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView, pos);
                    removeData(pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addData(int position) {
        mData.add(position, "Insert One");
        notifyItemInserted(position);
    }


    public void removeData(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }

    class DemoViewHolder extends ViewHolder {

        TextView tv;

        public DemoViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);


        }
    }
}