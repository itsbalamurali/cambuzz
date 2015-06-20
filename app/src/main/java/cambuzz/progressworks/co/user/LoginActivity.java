package cambuzz.progressworks.co.user;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import cambuzz.progressworks.co.MainActivity;
import cambuzz.progressworks.co.R;
public class LoginActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginButton = (Button) findViewById(R.id.login_button);
        final EditText loginEmail = (EditText) findViewById(R.id.email_field);
        final EditText loginPass = (EditText) findViewById(R.id.password_field);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground(loginEmail.getText().toString(), loginPass.getText().toString(), new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            // Hooray! The user is logged in.
                            Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(loginIntent);
                            finish();
                        } else {
                            //Signup failed. Look at the ParseException to see what happened.
                            Toast notificationToast = Toast.makeText(LoginActivity.this, "Please check your Email/Password", Toast.LENGTH_LONG);
                            // notificationToast.setText();
                            Log.d("Credentials sent", loginEmail.getText().toString() + loginPass.getText().toString());
                            Log.d("Login failure reason", e.toString());
                            notificationToast.show();
                        }
                    }
                });
            }
        });
    }
}
