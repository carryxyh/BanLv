package personal.example.xiuyuhang.banlv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

/**
 * Created by xiuyuhang on 15/5/13.
 */
public class tab2_fx extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tab2_fenxiang);
        Intent i = getIntent();
        Log.e("hello",i.getExtras().get("imgId").toString());
        Log.e("hello",i.getExtras().get("title").toString());
        Log.e("hello",i.getExtras().get("content").toString());
    }
}
