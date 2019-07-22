package com.lc.qimolianxitwo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lc.qimolianxitwo.R;
import com.lc.qimolianxitwo.bean.LadyBean;

import java.util.List;

public class LadyAdapter extends RecyclerView.Adapter<LadyAdapter.ViewHolder> {
    private Context context;
    private List<LadyBean.ResultsBean> list;

    public LadyAdapter(Context context, List<LadyBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_lady, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LadyBean.ResultsBean resultsBean = list.get(position);
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(context).load(resultsBean.getUrl()).apply(requestOptions).into(holder.iv);
        holder.tv_type.setText(resultsBean.getType());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv_type;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_type = itemView.findViewById(R.id.tv_type);

        }
    }
}
