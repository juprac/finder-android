package com.helloworld.finder;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationsMapsActivity extends BaseActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    public static final CameraPosition ARGENTINA =
            new CameraPosition.Builder().target(new LatLng(-36.6193822,-64.3362552))
            .zoom(15)
            .tilt(10)
            .build();
    public static final CameraPosition ESPAÑA =
            new CameraPosition.Builder().target(new LatLng(40.4378698,-3.8196211))
                    .zoom(15)
                    .tilt(20)
                    .build();
    public static final CameraPosition CHINA =
            new CameraPosition.Builder().target(new LatLng(31.2231338,120.9162892))
                    .zoom(15)
                    .tilt(50)
                    .build();
    public static final CameraPosition IRLANDA =
            new CameraPosition.Builder().target(new LatLng(53.283891,-9.1187861))
                    .zoom(15)
                    .tilt(60)
                    .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button btArg = findViewById(R.id.btArg);
        btArg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(ARGENTINA));

            }
        });

        Button btEsp = findViewById(R.id.btEsp);
        btEsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(ESPAÑA));


            }
        });

        Button btChi = findViewById(R.id.btChi);
        btChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(CHINA));

            }
        });

        Button btIrl = findViewById(R.id.btIrl);
        btIrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(IRLANDA));

            }
        });



    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }


}