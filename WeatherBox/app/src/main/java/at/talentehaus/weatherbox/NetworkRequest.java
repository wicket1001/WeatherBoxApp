package at.talentehaus.weatherbox;

import android.app.DownloadManager;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class NetworkRequest {
    RequestQueue queue;

    NetworkRequest (MainActivity mainActivity) {

        queue = Volley.newRequestQueue(mainActivity);
    }

    public void dumpRequest(final MainActivity mainActivity) {
        // String url = "http://www.google.com";
        String url = "https://3iot.drei.at/api/1/customers/th.drones%40gmail.com/sites/VaHaReIOT/histdata0/youngest?json=%7B%0A+%22select%22%3A+%5B%0A++%22temperature%22%2C%0A++%22ch3%22%2C%0A++%22ch1%22%0A+%5D%0A%7D&_=1517751189383";

        final TextView mTextView = mainActivity.findViewById(R.id.text);
/*
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        mTextView.setText("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
*/
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);
                        mTextView.setText("Response is: " + response.substring(0, 500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });

        queue.add(stringRequest);
        queue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>() {
            @Override
            public void onRequestFinished(Request<Object> request) {
                Toast.makeText(mainActivity, "FINISHED REQUEST", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
