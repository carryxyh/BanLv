package fragmentpackage;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter_tab2;
import Adapter.MyAdapter_tab2_2;
import Bean.tab2_itembean;
import Bean.tab2_itembean_2;
import Bean.tab2_itembean_3;
import personal.example.xiuyuhang.banlv.R;

/**
 * Created by xiuyuhang on tab3_3/4/14.
 */
public class Fragment2 extends Fragment {

    /*----------------------------华丽的分割线-------------------------------------*/
//    private ListView listView1;
//    private ListView listView2;
//    private ListView listView3;
//
//    private List<tab2_itembean> itembeanList1;
//    private List<tab2_itembean_2> itembeanList2;
//    private List<tab2_itembean_3> itembeanList3;
//
//    private int[] imgids;
//    private int[] imgids_2;
//    private int[] imgids_3;

     /*----------------------------华丽的分割线-------------------------------------*/

//    private void initItemBean1(){
//        imgids = new int[]{R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
//
//        itembeanList1 = new ArrayList<>();
//
//        for (int i=0;i<imgids.length;i++){
//            itembeanList1.add(new tab2_itembean(
//                    imgids[i],
//                    "我是标题"+i,
//                    "我是内容"
//            ));
//        }
//    }

   //初始化itembean2
//    private void initItemBean2(){
//        imgids_2 = new int[]{R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
//
//        itembeanList2 = new ArrayList<>();
//
//        for (int i=0;i<imgids_2.length;i++){
//            itembeanList2.add(new tab2_itembean_2(
//                    imgids_2[i],
//                    "我是内容"
//            ));
//        }
//    }

    //初始化itembean3
//    private void initItemBean3(){
//        imgids = new int[]{R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
//
//        itembeanList1 = new ArrayList<>();
//
//        for (int i=0;i<imgids.length;i++){
//            itembeanList1.add(new tab2_itembean(
//                    imgids[i],
//                    "我是标题"+i,
//                    "我是内容"
//            ));
//        }
//    }

    /*----------------------------华丽的分割线-------------------------------------*/

    private View view;

    private TextView gl;
    private TextView fx;
    private TextView zx;

    private Fragment fragment1;
    private Fragment fragment2;
    private Fragment fragment3;

    //初始化views方法
    public void initViews(){

        //初始化textviews
        gl = (TextView) view.findViewById(R.id.gl);
        fx = (TextView) view.findViewById(R.id.fx);
        zx = (TextView) view.findViewById(R.id.zx);

        //初始化listviews
//        listView1 = (ListView) view.findViewById(R.id.tab2_listview1);
//        listView2 = (ListView) view.findViewById(R.id.tab2_listview2);
//        listView3 = (ListView) view.findViewById(R.id.tab2_listview3);

    }

    //初始化点击事件
    public void initEvents(){
        gl.setOnClickListener(new TextViewListener());
        fx.setOnClickListener(new TextViewListener());
        zx.setOnClickListener(new TextViewListener());
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        view = View.inflate(getActivity(),R.layout.tab2,null);

        //初始化views
        initViews();

        //初始化点击事件
        initEvents();

        //一开始选择第一个
        select(1);
        return view;
    }

    /*----------------------------华丽的分割线-------------------------------------*/

    //监听点击的三个TextView事件
    class TextViewListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            resetBackground();

            switch (v.getId()){
                case R.id.gl:
                    select(1);
                    break;
                case R.id.fx:
                    select(2);
                    break;
                case R.id.zx:
                    select(3);
                    break;

            }
        }
    }

    //重置背景
    private void resetBackground(){
        gl.setBackgroundResource(R.drawable.normalbackground_tab2);
        fx.setBackgroundResource(R.drawable.normalbackground_tab2);
        zx.setBackgroundResource(R.drawable.normalbackground_tab2);
    }

    //select方法
    private void select(int i){
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);

        switch (i){
            case 1:
                if (fragment1 == null){
                    fragment1 = new Fragment2_1();
                    transaction.add(R.id.tab2_framecontent,fragment1);
                }
                else {
                    transaction.show(fragment1);
                }
                gl.setBackgroundColor(getResources().getColor(R.color.white));
                break;
            case 2:
                if (fragment2 == null){
                    fragment2 = new Fragment2_2();
                    transaction.add(R.id.tab2_framecontent,fragment2);
                }
                else {
                    transaction.show(fragment2);
                }
                fx.setBackgroundColor(getResources().getColor(R.color.white));
                break;
            case 3:
                if (fragment3 == null){
                    fragment3 = new Fragment2_3();
                    transaction.add(R.id.tab2_framecontent,fragment3);
                }
                else {
                    transaction.show(fragment3);
                }
                zx.setBackgroundColor(getResources().getColor(R.color.white));
                break;
        }
        transaction.commit();
    }

    //隐藏fragment方法
    private void hideFragment(FragmentTransaction transaction) {

        if (fragment1 != null){
            transaction.hide(fragment1);
        }
        if (fragment2 != null){
            transaction.hide(fragment2);
        }
        if (fragment3 != null){
            transaction.hide(fragment3);
        }
    }
}
