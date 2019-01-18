package net.alexandroid.fragmentlearning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyFragment.MyFragmentListener {

    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyFragment myFragment = MyFragment.newInstance("Constantine");

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameLayout, myFragment, TAG)
                .commit();

        MyFragment fragment = (MyFragment) getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        MyFragment fragment2 = (MyFragment) getSupportFragmentManager().findFragmentByTag(TAG);
    }

    @Override
    public void doSomethingInActivity() {
        Log.d("ZAQ", "KUKU Moi malchik");
    }

    @Override
    public void closeApplication() {
        finish();
    }

    @Override
    public void showSecondActivity() {
        //startActivity(....);
    }

    @Override
    public void showMessageToUser() {
        Toast.makeText(this, "Kuku", Toast.LENGTH_SHORT).show();
    }
}
