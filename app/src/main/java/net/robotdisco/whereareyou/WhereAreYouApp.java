package net.robotdisco.whereareyou;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by gaelan on 2014-09-22.
 */
public class WhereAreYouApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "<YOUR_API_KEY", "<YOUR_CLIENT_KEY>");
    }
}
