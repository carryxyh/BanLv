package personal.example.xiuyuhang.banlv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import Bean.tab2_itembean;
import ImageAdapter.ImageAdapter;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by xiuyuhang on tab3_3/4/23.
 */
public class lxTZactivity extends Activity implements AdapterView.OnItemSelectedListener,ViewSwitcher.ViewFactory{

    private int[] res={R.mipmap.lxtzpic1,R.mipmap.lxtzpic2,R.mipmap.lxtzpic3,R.mipmap.lxtzpic4,R.mipmap.lxtzpic5};
    private Gallery gallery;
    private ImageSwitcher imageSwitcher;
    private ImageAdapter adapter;

    private EditText title_edit;
    private EditText content_edit;
    private Button fxbtn;

    private int ImgID_lxtz;
    private String title;
    private String content;

    private void initViews(){
        title_edit = (EditText) findViewById(R.id.titl_edit);
        content_edit = (EditText) findViewById(R.id.content_edit);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imswitcher);
        gallery = (Gallery) findViewById(R.id.gallery);
        fxbtn = (Button) findViewById(R.id.fxbtn);
    }

    private void initEvents(){
        fxbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = title_edit.getText().toString();
                content = content_edit.getText().toString();

                tab2_itembean tab2_itembeanobj = new tab2_itembean();

                tab2_itembeanobj.setImgID(ImgID_lxtz);
                tab2_itembeanobj.setContent(content);
                tab2_itembeanobj.setTitle(title);

                tab2_itembeanobj.save(lxTZactivity.this,new SaveListener() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onFailure(int i, String s) {

                    }
                });
                Intent intent = new Intent();
                intent.setClass(lxTZactivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.lxtzlayout);

        Bmob.initialize(this,"5a9f501831fac63a6825cbc7a3badfce");

        initViews();

        initEvents();

        adapter = new ImageAdapter(res,this);
        gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(this);
        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        imageSwitcher.setBackgroundResource(res[position%res.length]);
        ImgID_lxtz = res[position%res.length];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public View makeView() {
        ImageView img = new ImageView(this);
        img.setScaleType(ImageView.ScaleType.FIT_CENTER);

        return img;
    }
}
