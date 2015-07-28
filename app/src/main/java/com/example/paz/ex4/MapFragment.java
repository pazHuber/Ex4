package com.example.paz.ex4;


import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements  OnMapReadyCallback {
    private GoogleMap mMap;
    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        //MapView mv = (MapView) view.findViewById(R.id.mappp);
        //mv.onCreate(savedInstanceState);
        //mv.getMapAsync(this);

        // Inflate the layout for this fragment
        return view;
    }
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.addMarker(new MarkerOptions().position(new LatLng(35, 32)).title("Eran Ozery"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36, 32)).title("Paz Huber"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(37, 32)).title("Michal Bem Simon"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(38, 32)).title("Mor vinokour"));


    }
}


