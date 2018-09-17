package API;

import com.example.grandatmahotelsv2.model.Value;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface FaqAPI {
    @FormUrlEncoded
    @GET("viewfaq.php")
    Call<Value> view();
}
