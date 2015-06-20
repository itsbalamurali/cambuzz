package cambuzz.progressworks.co;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import cambuzz.progressworks.co.user.LoginActivity;


public class SplashScreen extends Activity {
 private static int SPLASHTIMER = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        /*
        ParseUser user = new ParseUser();
        user.setUsername("asha");
        user.setPassword("way2hack");
        user.setEmail("ashapondicherry12@gmail.com");
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                    Toast notificationToast =  Toast.makeText(SplashScreen.this,"Successfully signed up", Toast.LENGTH_SHORT);
                    notificationToast.show();
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    Toast notificationToast =  Toast.makeText(SplashScreen.this,"you broke the internet! :P", Toast.LENGTH_SHORT);
                    // notificationToast.setText();
                    Log.d("Login failure reason",e.toString());
                    notificationToast.show();
                }
            }
        });
        */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ParseUser currentUser = ParseUser.getCurrentUser();
                if (currentUser != null) {
                    // goto dashboard / mainactivity
                    Intent i = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    // show the signup or login screen
                    Intent login = new Intent(SplashScreen.this,LoginActivity.class);
                    startActivity(login);
                    finish();
                }

            }
        },SPLASHTIMER);
    }
}
