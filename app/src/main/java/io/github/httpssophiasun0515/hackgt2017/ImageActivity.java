package io.github.httpssophiasun0515.hackgt2017;

import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONObject;

import io.github.httpssophiasun0515.hackgt2017.HttpService.CVClient;
import io.github.httpssophiasun0515.hackgt2017.RequestModel.BodyUrl;
import io.github.httpssophiasun0515.hackgt2017.ResponseModel.MSCVResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ImageActivity extends AppCompatActivity {


    private static final String MSCVAPI= "https://westcentralus.api.cognitive.microsoft.com/vision/v1.0/models/landmarks/";
    private static final String subscriptionKey = "694bdd8396634097a0e91db00327d558";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(MSCVAPI).
                addConverterFactory(GsonConverterFactory.create()).
                build();

        CVClient computerVisionClient = retrofit.create(CVClient.class);
        BodyUrl bodyUrl = new BodyUrl("https://cdntct.com/tct/pic/city/wuhan/attractions/yellow-crane-tower-5.jpg");
        //JSONObject jsonObject = new JSONObject();
        Call<MSCVResponse> mscvResponse = computerVisionClient.getLandmark(subscriptionKey, "application/json", bodyUrl);

        mscvResponse.enqueue(new Callback<MSCVResponse>() {
            @Override
            public void onResponse(Call<MSCVResponse> call, Response<MSCVResponse> response) {
                Log.d("response body", response.toString());
                Toast.makeText(getApplicationContext(), "response" + response.body().getResult().getLandmarks()[0].getName(), Toast.LENGTH_LONG).show();
                Log.d("langmark", response.body().getResult().getLandmarks()[0].getName());
            }

            @Override
            public void onFailure(Call<MSCVResponse> call, Throwable t) {
                Log.d("error", t.toString());
            }
        });
    }






}
