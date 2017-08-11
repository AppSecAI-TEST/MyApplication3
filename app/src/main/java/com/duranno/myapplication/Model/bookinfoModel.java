package com.duranno.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by duranno on 2017. 8. 4..
 */

public class bookinfoModel {

    @SerializedName("resultCode")
    private String resultCode;

    @SerializedName("arrayData")
    private List<ArrayDatum> arrayData = new ArrayList<>();

    public String getResultCode() {
        return resultCode;
    }
    public List<ArrayDatum> getArrayData(){
        return arrayData;
    }

    public class ArrayDatum {

        @SerializedName("b_nam")
        private String bNam;
        @SerializedName("b_subnam")
        private String bSubnam;
        @SerializedName("imgUrl")
        private String imgUrl;
        @SerializedName("linkUrl")
        private String linkUrl;

        public String getBNam() {
            return bNam;
        }

        public void setBNam(String bNam) {
            this.bNam = bNam;
        }

        public String getBSubnam() {
            return bSubnam;
        }

        public void setBSubnam(String bSubnam) {
            this.bSubnam = bSubnam;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getLinkUrl() {
            return linkUrl;
        }

        public void setLinkUrl(String linkUrl) {
            this.linkUrl = linkUrl;
        }
    }


    public interface Bookinterface {

        @GET("bible/api/info/bookinfo.asp")
        Call<bookinfoModel> getRetrofitData(@Query("rdid") String rdid);
    }

    public interface Bacalinfo {

        @GET("bible/api/info/bacalinfo.asp")
        Call<bookinfoModel> getRetrofitData(@Query("rdid") String rdid);
    }

}
