package ugarte.tecsup.com.myapplication10.apiServices;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import ugarte.tecsup.com.myapplication10.models.Beneficio;
import ugarte.tecsup.com.myapplication10.models.Event;
import ugarte.tecsup.com.myapplication10.models.Noticia;
import ugarte.tecsup.com.myapplication10.models.ResponseMessage;
import ugarte.tecsup.com.myapplication10.models.Usuario;

/**
 * Created by JShanksX13 on 6/06/2017.
 */

public interface ApiService {

    String API_BASE_URL = "https://usuarios-api-martincs27.c9users.io";

    @GET("api/v1/usuarios")
    Call<List<Usuario>>getUsuarios();

    @Multipart
    @POST("api/v1/usuarios/login")
    Call<ResponseMessage> login(
            @Part("username") RequestBody username,
            @Part("password") RequestBody password
    );

    @Multipart
    @POST("api/v1/usuarios")
    Call<ResponseMessage> register(
            @Part("nombre") RequestBody nombre,
            @Part("apellidos") RequestBody apellidos,
            @Part("email") RequestBody email,
            @Part("password") RequestBody password,
            @Part("username") RequestBody username
    );

    @GET("api/v1/beneficios")
    Call<List<Beneficio>> listBeneficios();

    @GET("api/v1/beneficios/{id}")
    Call<Beneficio> getBeneficios(@Path("id") Integer id);

    @GET("api/v1/noticias")
    Call<List<Noticia>> listNoticias();

    @GET("api/v1/noticias/{id}")
    Call<Noticia> getNoticias(@Path("id") Integer id);

    @GET("api/v1/eventos")
    Call<List<Event>> listEvent();

    @GET("api/v1/eventos/{id}")
    Call<Event> getEvent(@Path("id") Integer id);
}

