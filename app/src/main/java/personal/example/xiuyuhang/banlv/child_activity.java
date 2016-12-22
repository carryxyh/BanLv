package personal.example.xiuyuhang.banlv;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;


public class child_activity extends Activity implements AMap.OnMapClickListener,AMapLocationListener {

    MapView mMapView;

    LocationManagerProxy mLocationManagerProxy;

    String GEO = "personal.example.xiuyuhang.testmapa";

    PendingIntent mPendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.child_activity);
        mMapView = (MapView) findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMap();

        mMapView.getMap().setOnMapClickListener(this);

        mLocationManagerProxy = LocationManagerProxy.getInstance(this);

        Intent intent = new Intent(GEO);

        mPendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0,intent,0);

        IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction(GEO);

        this.registerReceiver(mGeoFenceReceiver,intentFilter);

        mLocationManagerProxy.requestLocationData(LocationManager.GPS_PROVIDER,2000,15,this);
    }


    private BroadcastReceiver mGeoFenceReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("hello","收到");
        }
    };

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        unregisterReceiver(mGeoFenceReceiver);
    }

    @Override
    public void onMapClick(LatLng latLng) {

        Log.e("hello",latLng.latitude+"");
        Log.e("hello",latLng.longitude+"");

        mMapView.getMap().addCircle(new CircleOptions().center(latLng).radius(1000));

        mLocationManagerProxy.addGeoFenceAlert(latLng.latitude,latLng.longitude,2000,1000* 60*30,mPendingIntent);
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
