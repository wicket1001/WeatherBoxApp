package at.talentehaus.weatherbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityBackup extends AppCompatActivity {
    NetworkRequest nr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //nr = new NetworkRequest(this);

        Button button = findViewById(R.id.button);
    }

    /*public void clicked(View view) {
        nr.dumpRequest(this);
    }*/
}
