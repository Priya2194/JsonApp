package com.example.jsonapp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

 interface MyApi
{

    @GET("posts")
    Call<ArrayList<Models>> modelcall();
}
