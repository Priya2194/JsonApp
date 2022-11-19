package com.example.jsonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{
        private MyApi myApi;
        private RecyclerView recyclerView;
        private ArrayList<Models> modelsArrayList;
        private String BaseUrl="https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rV);
        modelsArrayList=new ArrayList<>();
        viewJsonData();
    }

    private void viewJsonData()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApi=retrofit.create(MyApi.class);

        Call<ArrayList<Models>> arrayListCall= myApi.modelcall();

        arrayListCall.enqueue(new Callback<ArrayList<Models>>() {
            @Override
            public void onResponse(Call<ArrayList<Models>> call, Response<ArrayList<Models>> response)
            {
                modelsArrayList= response.body();
                int i=0;

                for (i=0;i<modelsArrayList.size();i++)
                {
                    MyAdapter myAdapter=new MyAdapter(modelsArrayList,MainActivity.this);

                    LinearLayoutManager manager=new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);

                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(myAdapter);
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Models>> call, Throwable t)
            {

            }
        });
    }
}