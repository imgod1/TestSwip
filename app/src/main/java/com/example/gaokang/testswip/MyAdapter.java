package com.example.gaokang.testswip;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * 项目名称：TestSwip
 * 包名称：com.example.gaokang.testswip
 * 类描述：
 * 创建人：gaokang
 * 创建时间：2016-05-04 14:34
 * 修改人：gaokang
 * 修改时间：2016-05-04 14:34
 * 修改备注：
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> list;

    public MyAdapter(List<String> list) {
        this.list = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txt_item.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_item;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt_item = (TextView) itemView.findViewById(R.id.txt_item);
        }
    }
}
