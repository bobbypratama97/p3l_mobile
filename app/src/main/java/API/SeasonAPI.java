package API;

import com.example.grandatmahotelsv2.model.Value;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SeasonAPI {
    @FormUrlEncoded
    @GET("viewseason.php")
    Call<Value> view();
}
