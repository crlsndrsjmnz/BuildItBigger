package co.carlosjimenez.android.jokeactivitylib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by carlosjimenez on 1/5/16.
 */
public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "JOKE";

    TextView mTvJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_activity);

        mTvJoke = (TextView) findViewById(R.id.joke);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(JOKE_KEY)) {
            mTvJoke.setText(intent.getStringExtra(JOKE_KEY));
        }

    }
}
