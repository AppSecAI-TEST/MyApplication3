package com.duranno.myapplication.fragment;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import com.duranno.myapplication.Model.bookinfoModel;

import com.duranno.myapplication.R;
import com.duranno.myapplication.adapter.adAdapter;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by duranno on 2017. 8. 3..
 */

public class fragment2 extends Fragment {

    public static final String pratikbutani = "http://pratikbutani.x10.mx/";
    public static final String BOOKINFOURL = "http://www.duranno.com/";
    public static final String BACALINFOURL = "http://www.duranno.com/";

    private Handler handler;
    private TextView t = null;
    private BookInfoThread thread = null;
    private Context mContext;
    private RecyclerView mRecyclerList = null;
    private List<bookinfoModel> mbookinfoModelData;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        mContext = this.getContext();
        t = view.findViewById(R.id.txt);
        t.setText("page2");
        handler = new Handler();
        mRecyclerList = (RecyclerView) view.findViewById(R.id.RecycleList);
        mRecyclerList.setHasFixedSize(true);
        mRecyclerList.setItemAnimator(new DefaultItemAnimator());

        mbookinfoModelData = new ArrayList<>();
        /*Gson gson = new Gson();
        String json = Definition.TestJSONARray;
        bookinfoModel java = gson.fromJson(json, bookinfoModel.class);
        String str = String.format("%s",java.getResultCode());
        t.setText(str);*/
        //Init();


        Init2();


        return view;
    }

    private void Init2(){


/*        thread = new BookInfoThread(BOOKINFOURL,handler,"1");
        thread.run();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        try {
            new asyncTask().execute(BOOKINFOURL, "1");

            //return result;
        } catch (Exception e){

        }





    }

    private class asyncTask extends AsyncTask<String, Void, String> {

        final static String TAG = "BookinfoThread";

        bookinfoModel bookinfoRepo;

        String strbaseuUrl;


        @Override
        protected String doInBackground(String... strings) {

            String strbaseuUrl = strings[0].toString();
            String strRdid = strings[1].toString();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(strbaseuUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bookinfoModel.Bookinterface service = client.create(bookinfoModel.Bookinterface.class);
            Call<bookinfoModel> call = service.getRetrofitData(strRdid);
            call.enqueue(new Callback<bookinfoModel>() {
                @Override
                public void onResponse(Call<bookinfoModel> call, Response<bookinfoModel> response) {
                    if(response.isSuccessful()){
                        bookinfoRepo = response.body();
                        Log.d(TAG,"response.raw :"+response.raw());
                        if(bookinfoRepo.getResultCode().toString().equals("T")){
                            Log.d(TAG,"성공 :"+bookinfoRepo.getResultCode());

                            if(false){
                                String strdata = "";
                                List<bookinfoModel.ArrayDatum> arraydata = bookinfoRepo.getArrayData();
                                for (bookinfoModel.ArrayDatum t: arraydata) {

                                    strdata += String.format("%s %s %s %s\n",t.getBNam(),t.getBSubnam(), t.getImgUrl(), t.getLinkUrl());
                                }
                                String strOutput = String.format("result: %s\n %s",bookinfoRepo.getResultCode(),strdata);
                                t.setText(strOutput);
                            }

                            mbookinfoModelData.add(0,bookinfoRepo);

                            adAdapter adapter = new adAdapter(mContext,mbookinfoModelData);
                            LinearLayoutManager LinManager = new LinearLayoutManager(
                                    mContext,LinearLayoutManager.VERTICAL,false);
                            mRecyclerList.setLayoutManager(LinManager);
                            mRecyclerList.setAdapter(adapter);
                        }else{
                            Log.e(TAG,"요청 실패 :"+bookinfoRepo.getResultCode());
                        }
                    }
                }

                @Override
                public void onFailure(Call<bookinfoModel> call, Throwable t) {

                }
            });

            return null;
        }

    }

/*    private void Init() {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... voids) {

                try {
                    ApiService gitHubService = ApiService.retrofit.create(ApiService.class);
                    Call<ArrayList<pojo>> call = gitHubService.infoMel();

                    ArrayList<pojo> result = call.execute().body();

                    return "";
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                t.setText(s);
            }


        }.execute();
    }*/



    public class BookInfoThread extends Thread{
        final static String TAG = "BookinfoThread";

        bookinfoModel bookinfoRepo;
        Handler handler;
        String strbaseuUrl;

        int version =1 ;
        String strRdid;

        public BookInfoThread(String baseUrl, Handler handler, String rdid){
            this.handler = handler;
            this.strRdid = rdid;
            this.strbaseuUrl = baseUrl;

        }

        @Override
        public void run() {
            super.run();
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(strbaseuUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bookinfoModel.Bookinterface service = client.create(bookinfoModel.Bookinterface.class);
            Call<bookinfoModel> call = service.getRetrofitData(strRdid);

            call.enqueue(new Callback<bookinfoModel>() {
                @Override
                public void onResponse(Call<bookinfoModel> call, Response<bookinfoModel> response) {
                    if(response.isSuccessful()){
                        bookinfoRepo = response.body();
                        Log.d(TAG,"response.raw :"+response.raw());
                        if(bookinfoRepo.getResultCode().toString().equals("T")){
                            Log.d(TAG,"성공 :"+bookinfoRepo.getResultCode());

                            if(false){
                                String strdata = "";
                                List<bookinfoModel.ArrayDatum> arraydata = bookinfoRepo.getArrayData();
                                for (bookinfoModel.ArrayDatum t: arraydata) {

                                    strdata += String.format("%s %s %s %s\n",t.getBNam(),t.getBSubnam(), t.getImgUrl(), t.getLinkUrl());
                                }
                                String strOutput = String.format("result: %s\n %s",bookinfoRepo.getResultCode(),strdata);
                                t.setText(strOutput);
                            }

                            mbookinfoModelData.add(0,bookinfoRepo);
                        }else{
                            Log.e(TAG,"요청 실패 :"+bookinfoRepo.getResultCode());
                        }
                    }
                }

                @Override
                public void onFailure(Call<bookinfoModel> call, Throwable t) {
                    Log.e(TAG,"책정보 가져오기 실패 :" + t.getMessage() );
                    Log.e(TAG,"요청 메시지 :"+call.request());

                }
            });
        }
    }

    @Override
    public void onDestroy() {

        if(thread.isInterrupted() != true){
            thread.interrupt();
        }
        super.onDestroy();
    }
}
