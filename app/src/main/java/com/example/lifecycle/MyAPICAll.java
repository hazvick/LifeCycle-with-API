package com.example.lifecycle;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPICAll {

    //https://api.kanye.rest/  <- was going to be used but changed my mind
    //https://run.mocky.io/ v3/21ae3b6f-8d1f-4a11-84d6-f5ebb0461928

    @GET("v3/21ae3b6f-8d1f-4a11-84d6-f5ebb0461928")
    Call<DataModel> getData();
}
