package com.example.abe.mymapapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MapsActivity extends FragmentActivity  {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(MapsActivity.this, "success start", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        onResume();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
                Toast.makeText(MapsActivity.this, "success if needed", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void setUpMap() {
        mMap.setMyLocationEnabled(true);


        // get location manager from the system service
       // LocationManager locationmanager = (LocationManager) getSystemService(LOCATION_SERVICE);
        // create the criteria object to retrieve provider
       // Criteria criteria = new Criteria();
        // get the name of the best provider
        //String provider = locationmanager.getBestProvider(criteria, true);
        //Location Mylocation = locationmanager.getLastKnownLocation(provider);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // get the latitude
        //Double latitude = Mylocation.getLatitude();
        //Double longitude = Mylocation.getLongitude();
        //LatLng latlng = new LatLng(latitude, longitude);
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        //mMap.animateCamera(CameraUpdateFactory.zoomTo(2));
        //Long curTime = System.currentTimeMillis();
        LatLng Haiti = new LatLng(18.5392,-72.3364);



            SimpleDateFormat date = new SimpleDateFormat("dd/Mm/yyyy");
            String currentDateTime = date.format(new Date());


     /*.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                            .title("you got a Map, It is " + currentDateTime )*/


            mMap.addMarker(new MarkerOptions()
                    .position(Haiti)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .snippet("Destination touristique pour le monde")
                    .title("Haiti La Perle des Antilles,"+"It is" + currentDateTime));
            //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latitude, longitude);

        }
    /*@Override
    public void onMapReady(GoogleMap map) {
        LatLng mapCenter = new LatLng(41.889, -87.622);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter, 13));

        // Flat markers will rotate when the map is rotated,
        // and change perspective when the map is tilted.
        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.direction_arrow))
                .position(mapCenter)
                .flat(true)
                .rotation(245));

        CameraPosition cameraPosition = CameraPosition.builder()
                .target(mapCenter)
                .zoom(13)
                .bearing(90)
                .build();

        // Animate the change in camera view over 2 seconds
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
                2000, null);
    }
}
    /*
    public void onMapReady(GoogleMap map) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(-18.142, 178.431), 2));

        // Polylines are useful for marking paths and routes on the map.
        map.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(-33.866, 151.195))  // Sydney
                .add(new LatLng(-18.142, 178.431))  // Fiji
                .add(new LatLng(21.291, -157.821))  // Hawaii
                .add(new LatLng(37.423, -122.091))  // Mountain View
        );
     */
    }



