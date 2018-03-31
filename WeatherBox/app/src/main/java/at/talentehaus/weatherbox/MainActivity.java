package at.talentehaus.weatherbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.json.JSONObject;

import static at.talentehaus.weatherbox.ServerRequest.queryYoungestRawValues;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBarTemperature1;
    ProgressBar progressBarTemperature2;
    TextView textViewCurrentTemperature1;
    TextView textViewCurrentTemperature2;

    ProgressBar progressBarHumidity1;
    ProgressBar progressBarHumidity2;
    TextView textViewCurrentHumidity1;
    TextView textViewCurrentHumidity2;

    ProgressBar progressBarPressure1;
    ProgressBar progressBarPressure2;
    TextView textViewCurrentPressure1;
    TextView textViewCurrentPressure2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarTemperature1 = (ProgressBar) findViewById(R.id.progressbarTemperature1);
        progressBarTemperature2 = (ProgressBar) findViewById(R.id.progressbarTemperature2);
        textViewCurrentTemperature1 = findViewById(R.id.textViewCurrentTemperature1);
        textViewCurrentTemperature2 = findViewById(R.id.textViewCurrentTemperature2);

        progressBarHumidity1 = (ProgressBar) findViewById(R.id.progressbarHumidity1);
        progressBarHumidity2 = (ProgressBar) findViewById(R.id.progressbarHumidity2);
        textViewCurrentHumidity1 = findViewById(R.id.textViewCurrentHumidity1);
        textViewCurrentHumidity2 = findViewById(R.id.textViewCurrentHumidity2);

        progressBarPressure1 = (ProgressBar) findViewById(R.id.progressbarPressure1);
        progressBarPressure2 = (ProgressBar) findViewById(R.id.progressbarPressure2);
        textViewCurrentPressure1 = findViewById(R.id.textViewCurrentPressure1);
        textViewCurrentPressure2 = findViewById(R.id.textViewCurrentPressure2);

    }

    public void updateData(View view) {
        String serverdata1 = ServerRequest.queryYoungestRawValues();
        String serverdata2 = ServerRequest.queryYoungestRawValues();

        String[] parts1 = serverdata1.split(",");
        String[] parts2 = serverdata2.split(",");

        setTemperature(true, Integer.parseInt(parts1[0]));
        setHumidity(true, Integer.parseInt(parts1[1]));
        setPressure(true, Integer.parseInt(parts1[2]));
        setTemperature(false, Integer.parseInt(parts2[0]));
        setHumidity(false, Integer.parseInt(parts2[1]));
        setPressure(false, Integer.parseInt(parts2[2]));
    }

    //Indoor == false, Outdoor == true
    private void setTemperature(boolean Outdoor, double value) {
        if (value < -30) {
            value = -30;
        } else if (value > 50) {
            value = 50;
        }
        if (Outdoor) {
            progressBarTemperature2.setProgress((int) value + 30);
            textViewCurrentTemperature2.setText(value + "°C");
        } else {
            progressBarTemperature1.setProgress((int) value + 30);
            textViewCurrentTemperature1.setText(value + "°C");
        }
    }

    private void setHumidity(boolean Outdoor, double value) {
        if (value < 0) {
            value = 0;
        } else if (value > 100) {
            value = 100;
        }
        if (Outdoor) {
            progressBarHumidity2.setProgress((int) value);
            textViewCurrentHumidity2.setText(value + "%");
        } else {
            progressBarHumidity1.setProgress((int) value);
            textViewCurrentHumidity1.setText(value + "%");
        }
    }

    private void setPressure(boolean Outdoor, double value) {
        if (value < 700) {
            value = 700;
        } else if (value > 1100) {
            value = 1100;
        }
        if (Outdoor) {
            progressBarPressure2.setProgress((int) value - 700);
            textViewCurrentPressure2.setText(value + "hPa");
        } else {
            progressBarPressure1.setProgress((int) value - 700);
            textViewCurrentPressure1.setText(value + "hPa");
        }
    }
}
