package ugarte.tecsup.com.myapplication10;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by JShanksX13 on 6/06/2017.
 */

public interface ApiService {

    String API_BASE_URL = "https://usuarios-api-martincs27.c9users.io";

    @GET("api/v1/beneficios")
    Call<List<Beneficio>> listBeneficios();

    @GET("api/v1/beneficios/{id}")
    Call<Beneficio> getBeneficios(@Path("id") Integer id);

}
