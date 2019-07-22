package com.lc.qimolianxi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lc.qimolianxi.R;
import com.lc.qimolianxi.bean.MainBean;
import com.lc.qimolianxi.bean.MainGreenDaoBean;

import java.util.List;

public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.ViewHolder> {
    private Context mContext;
    private List<MainGreenDaoBean> mList;

    public GreenAdapter(Context mContext, List<MainGreenDaoBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.main_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainGreenDaoBean mainGreenDaoBean = mList.get(position);
        holder.tv_desc.setText(mainGreenDaoBean.getDesc());
        holder.tv_type.setText(mainGreenDaoBean.getType());
        Glide.with(mContext).load(mainGreenDaoBean.getUrl()).into(holder.iv);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv_desc;
        private final TextView tv_type;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            tv_type = itemView.findViewById(R.id.tv_type);
        }
    }
}
