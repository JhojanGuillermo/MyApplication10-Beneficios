package ugarte.tecsup.com.myapplication10.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ugarte.tecsup.com.myapplication10.R;
import ugarte.tecsup.com.myapplication10.apiServices.ApiService;
import ugarte.tecsup.com.myapplication10.apiServices.ApiServiceGenerator;
import ugarte.tecsup.com.myapplication10.models.ResponseMessage;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = RegisterActivity.class.getSimpleName();

    private EditText nombreRegister;
    private EditText apellidosRegister;
    private EditText emailRegister;
    private EditText usernameRegister;
    private EditText passwordRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nombreRegister = (EditText) findViewById(R.id.registernombre);
        apellidosRegister = (EditText) findViewById(R.id.registerapellidos);
        emailRegister = (EditText) findViewById(R.id.registeremail);
        usernameRegister = (EditText) findViewById(R.id.registerusername);
        passwordRegister = (EditText) findViewById(R.id.registerpassword);
    }

    public void registrarUsuario(View view){
        String nombre = nombreRegister.getText().toString();
        String apellidos = apellidosRegister.getText().toString();
        String email = emailRegister.getText().toString();
        String username = usernameRegister.getText().toString();
        String password = passwordRegister.getText().toString();
        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<ResponseMessage> call = null;
        RequestBody nombrePart = RequestBody.create(MultipartBody.FORM, nombre);
        RequestBody apellidosPart = RequestBody.create(MultipartBody.FORM, apellidos);
        RequestBody emailPart = RequestBody.create(MultipartBody.FORM, email);
        RequestBody passwordPart = RequestBody.create(MultipartBody.FORM, password);
        RequestBody usernamePart = RequestBody.create(MultipartBody.FORM, username);

        call = service.register(nombrePart, apellidosPart,emailPart,passwordPart,usernamePart);
        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {
                        ResponseMessage responseMessage = response.body();
                        Log.d(TAG, "responseMessage: " + responseMessage);
                        Toast.makeText(RegisterActivity.this, "Registro Completo", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Faltan datos");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    } catch (Throwable x) {
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }
}
