package API;

import com.example.grandatmahotelsv2.model.Value;
import com.example.grandatmahotelsv2.model.loginList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface  LoginAPI {
    @FormUrlEncoded
    @POST("login.php")
    Call<loginList> login(@Field("username")String username,
                          @Field("password")String password);
}
