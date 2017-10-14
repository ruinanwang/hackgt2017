package io.github.httpssophiasun0515.hackgt2017.HttpService;

/**
 * Created by zluo on 10/14/17.
 */
import org.json.JSONObject;

import io.github.httpssophiasun0515.hackgt2017.RequestModel.BodyUrl;
import io.github.httpssophiasun0515.hackgt2017.ResponseModel.MSCVResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Header;


public interface CVClient {
    @POST("analyze/")
    Call<MSCVResponse> getLandmark(
            @Header("ocp-apim-subscription-key") String token,
            @Header("Content-Type") String contentType,
            @Body BodyUrl url
            );

}
