package personal.example.xiuyuhang.banlv;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiItemDetail;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;

import java.util.List;

/**
 * Created by xiuyuhang on 15/4/21.
 */
public class SearchActivity extends Activity implements AMapLocationListener,PoiSearch.OnPoiSearchListener,View.OnClickListener{
    MapView mMapView;
    AMap mAmap;
    LocationManagerProxy mLocationManagerProxy;

    AMapLocation mLocation;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.search_layout);
        mMapView = (MapView) findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);
        mAmap = mMapView.getMap();

        mLocationManagerProxy = LocationManagerProxy.getInstance(this);

        mLocationManagerProxy.requestLocationData(LocationProviderProxy.AMapNetwork,2000,15,this);

        button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(this);
    }

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
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        mLocation = aMapLocation;
        Log.e("hello",aMapLocation.toString());
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

    @Override
    public void onPoiSearched(PoiResult poiResult, int i) {
        if (i == 0){
            List<PoiItem> list = poiResult.getPois();
            for (int k=0;k<list.size();k++){
                PoiItem item = list.get(k);
                Log.e("hello",item.toString());
            }
        }
    }

    @Override
    public void onPoiItemDetailSearched(PoiItemDetail poiItemDetail, int i) {

    }

    public void search(){
        PoiSearch.Query query = new PoiSearch.Query("kfc","餐饮","北京");

        query.setPageSize(10);

        query.setPageNum(0);
        PoiSearch poiSearch = new PoiSearch(this,query);

        LatLonPoint point = new LatLonPoint(mLocation.getLatitude(),mLocation.getLongitude());

        poiSearch.setOnPoiSearchListener(this);
        poiSearch.setBound(new PoiSearch.SearchBound(point,2000,true));
        poiSearch.searchPOIAsyn();
    }

    @Override
    public void onClick(View v) {
        search();
    }
}
