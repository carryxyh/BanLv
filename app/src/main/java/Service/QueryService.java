package Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by xiuyuhang on 15/5/25.
 */
public class QueryService extends Service {

    

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }


}
