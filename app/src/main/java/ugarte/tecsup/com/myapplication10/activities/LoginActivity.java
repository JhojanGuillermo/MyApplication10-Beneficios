package ugarte.tecsup.com.myapplication10.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText usernameInput;
    private EditText passwordInput;
    private SharedPreferences sharedPreferences;
    public static final String SHARED_PREFERENCE_NAME = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = this.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", null);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        usernameInput = (EditText) findViewById(R.id.loginusername);
        passwordInput = (EditText) findViewById(R.id.loginpassword);
        if (sharedPreferences.getBoolean("islogged", false)) {
            // Go to MainActivity
            goDashboard();
        }
        if (username != null) {
            usernameInput.setText(username);
            passwordInput.requestFocus();
        }
    }

    public void callLogin(View view) {
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username y Password son campos requeridos", Toast.LENGTH_SHORT).show();
            return;
        }
        ApiService service = ApiServiceGenerator.createService(ApiService.class);
        Call<ResponseMessage> call = null;
        RequestBody usernamePart = RequestBody.create(MultipartBody.FORM, username);
        RequestBody passwordPart = RequestBody.create(MultipartBody.FORM, password);
        call = service.login(usernamePart, passwordPart);
        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {
                        ResponseMessage responseMessage = response.body();
                        Log.d(TAG, "responseMessage: " + responseMessage);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        boolean success = editor
                                .putString("username", usernameInput.getText().toString())
                                .putBoolean("islogged", true)
                                .commit();
                        goDashboard();
                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Usuario y/o password incorrectos");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    } catch (Throwable x) {
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }

    private void goDashboard() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void callRegister(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}

