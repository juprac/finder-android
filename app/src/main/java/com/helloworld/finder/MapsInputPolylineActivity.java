package com.helloworld.finder;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import java.util.List;

import models.Direction;
import models.Leg;
import models.Polyline;
import models.Step;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsInputPolylineActivity extends BaseActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String sFromLocation, sToLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        sFromLocation = getIntent().getStringExtra("from_location");
        sToLocation = getIntent().getStringExtra("to_location");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

     //   LatLng fromLocation = new LatLng(20.5368442,-100.8286578);
     //   LatLng toLocation = new LatLng(20.538187,-100.8211236);

      //  mMap.addMarker(new MarkerOptions().position(fromLocation));
     //   mMap.addMarker(new MarkerOptions().position(toLocation));

        mMap.setMaxZoomPreference(20f);
        mMap.getUiSettings().setZoomControlsEnabled(true);

       //mMap.addMarker(new MarkerOptions().position(fromLocation));

      //  mMap.moveCamera(CameraUpdateFactory.newLatLng(fromLocation));

        CallDirectionsAPI();

       // mMap.addPolyline(new PolylineOptions()
       //     .add(fromLocation, toLocation). width(5).color(Color.BLUE));

    }
    private void CallDirectionsAPI (){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GMapsDirectionsAPI api = retrofit.create(GMapsDirectionsAPI.class);



        Call<Direction> call = api.getDirection(sFromLocation, sToLocation, "AIzaSyDdmkNrCIOU0B8NvysDjThMC8Eh4WNzC9E");



        call.enqueue(new Callback<Direction>() {
           @Override
            public void onResponse(Call<Direction> call, Response<Direction> response) {
               List<Leg> leg = response.body().getRoutes().get(0).getLegs();

               LatLng startLocation = new LatLng(leg.get(0).getStartLocation().getLat(), leg.get(0).getStartLocation().getLng());
               LatLng endLocation = new LatLng(leg.get(0).getEndLocation().getLat(), leg.get(0).getEndLocation().getLng());

               mMap.addMarker(new MarkerOptions().position(startLocation).title(leg.get(0).getStartAddress()));
               mMap.moveCamera(CameraUpdateFactory.newLatLng(startLocation));
               mMap.addMarker(new MarkerOptions().position(endLocation).title(leg.get(0).getEndAddress()));

                for(Step step : leg.get(0).getSteps()){
                   Polyline polyline = step.getPolyline();

                    List<LatLng> points = PolyUtil.decode(polyline.getPoints());

                    mMap.addPolyline(new PolylineOptions().addAll(points).width(5).color(Color.BLUE));
               }

            }

            @Override
              public void onFailure(Call<Direction> call, Throwable t) {
                Log.e("error", t.getMessage());

            }
        });

    }
}