package com.duranno.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duranno.myapplication.Model.bookinfoModel;
import com.duranno.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duranno on 2017. 8. 9..
 */

public class adAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    final String TAG = "adAdapter";
    Context mContext;
    List<bookinfoModel> listData;

    public adAdapter(Context context, List<bookinfoModel> listData){
        this.mContext = context;
        this.listData = listData;
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        if(viewType == 0){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_bookinfo, parent, false);

            return new Bookinfo(view);
        }else if(viewType == 1){

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_bookinfo, parent, false);
            return new Bacalinfo(parent);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        if(viewType == 0){

            Bookinfo bookinfo = (Bookinfo)holder;

            List<bookinfoModel.ArrayDatum> datum = listData.get(position).getArrayData();

            DatalistAdpater itemListDataAdapter = new DatalistAdpater(mContext, datum, 1);

            bookinfo.recyclerView.setHasFixedSize(true);
            bookinfo.recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            bookinfo.recyclerView.setAdapter(itemListDataAdapter);

        }else if(viewType == 1){

        }

    }

    @Override
    public int getItemCount() {
        return (null != listData ? listData.size() : 0);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
        //return super.getItemViewType(position);
    }

    private class Bookinfo extends RecyclerView.ViewHolder{

        public RecyclerView recyclerView;


        public Bookinfo(View itemView){
            super(itemView);
            this.recyclerView = (RecyclerView) itemView.findViewById(R.id.RecycleList);

        }

    }

    private class Bacalinfo extends RecyclerView.ViewHolder{

        public Bacalinfo(View itemView){
            super(itemView);

        }
    }

}
