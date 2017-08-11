package com.duranno.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duranno.myapplication.Model.bookinfoModel;
import com.duranno.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by duranno on 2017. 8. 11..
 */

public class DatalistAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final String TAG = "adAdapter";
    Context mContext;
    List<bookinfoModel.ArrayDatum> listData;
    int ViewType =0;

    public DatalistAdpater(Context context, List<bookinfoModel.ArrayDatum> listData, int ViewType){
        this.mContext = context;
        this.listData = listData;
        this.ViewType = ViewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        if(viewType == 0){
           v = LayoutInflater.from(parent.getContext()).inflate(R.layout.booklistdata, null);
            return new booklistData(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        booklistData data = (booklistData)holder;

        bookinfoModel.ArrayDatum  arrdata =  listData.get(position);

        data.tvTitle.setText(arrdata.getBNam());
        data.tvSubTitle.setText(arrdata.getBSubnam());
        data.TxtHidelink.setText(arrdata.getLinkUrl());

        Picasso.with(mContext).load(arrdata.getImgUrl()).into(data.itemImage);


    }

    @Override
    public int getItemCount() {
        return (null != listData ? listData.size() : 0);
    }

    private class booklistData extends RecyclerView.ViewHolder{

        protected TextView tvTitle;

        protected TextView tvSubTitle;

        protected ImageView itemImage;

        protected TextView TxtHidelink;


        public booklistData(View itemView){
            super(itemView);

            this.tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            this.tvSubTitle = (TextView) itemView.findViewById(R.id.tvSubTitle);
            this.itemImage = (ImageView) itemView.findViewById(R.id.itemImage);
            this.TxtHidelink = (TextView) itemView.findViewById(R.id.TxtHidelink);

        }

    }
}
