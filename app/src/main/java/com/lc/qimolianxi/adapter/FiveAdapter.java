package com.lc.qimolianxi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lc.qimolianxi.R;
import com.lc.qimolianxi.bean.FiveBean;

import java.util.List;

public class FiveAdapter extends RecyclerView.Adapter<FiveAdapter.ViewHolder> {
    private Context mContext;
    private List<FiveBean.DataBean> mList;
    private boolean visiabe = false;

    public boolean isVisiabe() {
        return visiabe;
    }

    public void setVisiabe(boolean visiabe) {
        this.visiabe = visiabe;
    }

    public FiveAdapter(Context mContext, List<FiveBean.DataBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_five, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final FiveBean.DataBean dataBean = mList.get(position);
        Glide.with(mContext).load(dataBean.getPic()).into(holder.iv);
        holder.tv_title.setText(dataBean.getTitle());
        holder.chex.setChecked(dataBean.isVisble());
        holder.chex.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                dataBean.setVisble(isChecked);
            }
        });

        if (visiabe) {
            holder.chex.setVisibility(View.VISIBLE);
        }else {
            holder.chex.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv_title;
        private final CheckBox chex;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_title = itemView.findViewById(R.id.tv_title);
            chex = itemView.findViewById(R.id.chex);
        }
    }
}
