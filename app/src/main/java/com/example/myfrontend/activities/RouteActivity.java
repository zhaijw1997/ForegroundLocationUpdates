package com.example.myfrontend.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfrontend.R;
import com.example.myfrontend.directionhelpers.FetchURL;
import com.example.myfrontend.directionhelpers.TaskLoadedCallback;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import androidx.appcompat.app.AppCompatActivity;



public class RouteActivity extends AppCompatActivity implements
        OnMapReadyCallback,
        TaskLoadedCallback {

    GoogleMap map;
    Button display_route;
    MarkerOptions place1, place2;
    Polyline currentPolyline;
    private static String API_KEY = "AIzaSyCgFkj56BPUOuk2doxqDKwlrG86OyjjjsI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        display_route = (Button)findViewById(R.id.displayroute);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_route);
        mapFragment.getMapAsync((OnMapReadyCallback) this);
        place1 = new MarkerOptions().position(new LatLng(53.8072761, -1.5545049)).title("Marker in Parkingson");
        place2 = new MarkerOptions().position(new LatLng(53.8021947, -1.5473595)).title("Marker in Morrison");

        display_route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getUrl(place1.getPosition(),place2.getPosition());
                //driving walking transit bicycling
                new FetchURL(RouteActivity.this).execute(url,"driving");
                //new FetchURL(RouteActivity.this).execute(url,"driving");
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        googleMap.addMarker(new MarkerOptions().position(new LatLng(53.8072761, -1.5545049)).title("Marker in Parkingson"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(53.8021947, -1.5473595)).title("Marker in Morrison"));
    }

    private String getUrl(LatLng origin, LatLng dest){
        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        // Travelling Mode
        //String mode = "mode=driving";

        //waypoints,Sheffied 53.383331	-1.466667
        //String waypointLatLng = "waypoints="+"53.383331"+","+"-1.466667";


        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor;

        // Output format
        String output = "json";
        //out parameters are bixude
        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"
                + output + "?" + parameters + "&key=" + API_KEY;
        System.out.println("getDerectionsURL--->: " + url);
        return url;
    }

    @Override
    public void onTaskDone(Object... values) {
        if(currentPolyline != null){
            currentPolyline.remove();
        }
        currentPolyline = map.addPolyline((PolylineOptions) values[0]);
    }
}
