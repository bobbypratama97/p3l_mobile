package API;

import com.example.grandatmahotelsv2.model.Value;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface signupAPI {
    @FormUrlEncoded
    @POST("insert.php")
    Call<Value> daftar(
            @Field("IdUser") Integer IdUser,
            @Field("IdType") Integer IdType,
            @Field("IdRole") Integer IdRole,
            @Field("FirstName") String FirstName,
            @Field("LastName") String LastName,
            @Field("Institutionname") String InstitutionName,
            @Field("IdentityNumber") String IdentityNumber,
            @Field("PhoneNumber") String PhoneNumber,
            @Field("EmailAddress") String EmailAddress,
            @Field("Address") String Address,
            @Field("Username") String Username,
            @Field("Password") String Password,
            @Field("RegistrationDate") Date RegistrationDate);
}
