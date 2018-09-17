package API;

import com.example.grandatmahotelsv2.model.loginList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserAPI {
    @FormUrlEncoded
    @POST("getUserData.php")
    Call<loginList> showData(
            @Field("IdUser") Integer IdUser
    );
}



