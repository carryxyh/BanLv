package personal.example.xiuyuhang.banlv;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import fragmentpackage.Fragment1;
import fragmentpackage.Fragment2;
import fragmentpackage.Fragment3;
import fragmentpackage.Fragment4;


public class MainActivity extends FragmentActivity {

    //bottomactivity中的四个LinearLayout
    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear4;

    //bottomactivity中的四个ImageButton
    private ImageButton img1;
    private ImageButton img2;
    private ImageButton img3;
    private ImageButton img4;

    //生命四个fragment
    private Fragment fragment1;
    private Fragment fragment2;
    private Fragment fragment3;
    private Fragment fragment4;


    //初始化view方法
    private void initViews(){
        //初始化bottomactivity中的四个LinearLayout
        linear1 = (LinearLayout) findViewById(R.id.linear1);
        linear2 = (LinearLayout) findViewById(R.id.linear2);
        linear3 = (LinearLayout) findViewById(R.id.linear3);
        linear4 = (LinearLayout) findViewById(R.id.linear4);

        //初始化四个Linearlayout中的ImageButton
        img1 = (ImageButton) findViewById(R.id.imb1);
        img2 = (ImageButton) findViewById(R.id.imb2);
        img3 = (ImageButton) findViewById(R.id.imb3);
        img4 = (ImageButton) findViewById(R.id.imb4);

    }

    //初始化设置监听事件
    private void initEvents(){
        linear1.setOnClickListener(new ImageButtonListener());
        linear2.setOnClickListener(new ImageButtonListener());
        linear3.setOnClickListener(new ImageButtonListener());
        linear4.setOnClickListener(new ImageButtonListener());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //调用初始化views方法
        initViews();

        //调用初始化设置监听事件方法
        initEvents();

        //一开始选择第一个界面
        setSelect(0);
    }

    //监听类ImageButtonListener
    class ImageButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            resetImgs();
            switch (v.getId()){
                case R.id.linear1:
                    setSelect(0);
                    break;
                case R.id.linear2:
                    setSelect(1);
                    break;
                case R.id.linear3:
                    setSelect(2);
                    break;
                case R.id.linear4:
                    setSelect(3);
                    break;
                default:
                    break;
            }
        }
    }

    //切换图片至初始状态
    private void resetImgs() {
        img1.setImageResource(R.mipmap.home1);
        img2.setImageResource(R.mipmap.zixun1);
        img3.setImageResource(R.mipmap.sousuo1);
        img4.setImageResource(R.mipmap.gengduo1);
    }

    //吧图片设置为点击后的图片,并且设置内容区域
    private void setSelect(int i){

        //初始化fragment事务管理者
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);

        switch (i){
            case 0:
                if(fragment1 == null){
                    fragment1 = new Fragment1();
                    transaction.add(R.id.content,fragment1);
                }
                else {
                    transaction.show(fragment1);
                }
                img1.setImageResource(R.mipmap.home2);
                break;
            case 1:
                if(fragment2 == null){
                    fragment2 = new Fragment2();
                    transaction.add(R.id.content,fragment2);
                }
                else {
                    transaction.show(fragment2);
                }
                img2.setImageResource(R.mipmap.zixun2);
                break;
            case 2:
                if(fragment3 == null){
                    fragment3 = new Fragment3();
                    transaction.add(R.id.content,fragment3);
                }
                else {
                    transaction.show(fragment3);
                }
                img3.setImageResource(R.mipmap.sousuo2);
                break;
            case 3:
                if(fragment4 == null){
                    fragment4 = new Fragment4();
                    transaction.add(R.id.content,fragment4);
                }
                else {
                    transaction.show(fragment4);
                }
                img4.setImageResource(R.mipmap.gengduo2);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if(fragment1 != null){
            transaction.hide(fragment1);
        }
        if(fragment2 != null){
            transaction.hide(fragment2);
        }
        if(fragment3 != null){
            transaction.hide(fragment3);
        }
        if(fragment4 != null){
            transaction.hide(fragment4);
        }
    }
}
