package fragmentpackage;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Adapter.MyAdapter_tab1;
import Bean.tab1_itembean;
import personal.example.xiuyuhang.banlv.R;
import personal.example.xiuyuhang.banlv.lxTZactivity;

/**
 * Created by xiuyuhang on tab3_3/4/14.
 */
public class Fragment1 extends Fragment {

    /*--------------------------以下内容是listview中的各个类以及数据源---------------*/
    private ListView listView;

    private List<tab1_itembean> itembeanList;

    private int[] itembeanImgid;

    private void initItemBean(){
        String[] ti = new String[]{"安吉大竹海","仙峡山漂流","宋城千古情"};
        String[] con = new String[]{"安吉大竹海地处安吉南大门港口。位于安吉县天荒坪镇五鹤村。是以安吉县天荒坪镇五鹤村为中心的一片面积达666.7万平方米、单纯密林毛竹为主的林地。大竹海的入口处有一处冷泉名“五女泉”，五女泉的泉水是从潭池中间的泉眼里涌出来的地下水，富含矿物质。","长三角最刺激的峡谷漂流就在这里。整个峡谷落差超百米，两岸陡峭险滩，均是杳无人烟的原始森林，拥有25个滑坡、滑槽，一路体验漂流失重快感。长三角最刺激的峡谷漂流就在这里。","秉承\"建筑为形，文化为魂\"的经营理念，园区内宋河东街、土豪家族、胭脂巷、非来巷、美食街、市井街六大主题街区华丽升级，热闹非凡；大宋博文化体验馆、柳永风月阁、七十二行老作坊等崭新亮相；活着的清明上河图、聊斋惊魂鬼屋、步步惊心鬼屋、人皮客栈听音室等高科技体验项目惊喜不断；土豪家族尝现打年糕、览古法木榨油、吃手工豆腐、饮乌毡帽酒，寻找父辈们的记忆；更有新春大庙会、火把节、泼水节、为爸妈喝彩等一年四季活动不断。"};
        itembeanImgid = new int[]{R.mipmap.dazhuhai,R.mipmap.piaoliu,R.mipmap.songcheng};

        itembeanList = new ArrayList<>();
        for (int i=0;i<itembeanImgid.length;i++){
            itembeanList.add(new tab1_itembean(
                    itembeanImgid[i],
                    ti[i],
                    con[i]
            ));
        }
    }
    /*-----------------------------我是华丽的分割线--------------------------------*/
    private ImageView lxtz;
    private View view;
    private ViewPager vptop;
    private List<ImageView> list;
    private int[] imgid;
    private TextView title;
    private String[] titles;
    //图片下面的点
    private List<View> dots;
    private int currentItem = 0;
    private ScheduledExecutorService scheduledExecutorService;

    //切换当前图片的handler
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            vptop.setCurrentItem(currentItem);//切换当前显示的图片
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        view = View.inflate(getActivity(),R.layout.tab1,null);

        initViews();

        initViewPager();
        //初始化itembean
        initItemBean();

        vptop.setAdapter(new MyAdapter());

        vptop.setOnPageChangeListener(new myPageChangeListener());
        //给listview设置适配器
        listView.setAdapter(new MyAdapter_tab1(getActivity(),itembeanList));

        lxtz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),lxTZactivity.class);
                startActivity(intent);
            }
        });
        return view;
    }


    @Override
    public void onStart() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // 当Activity显示出来后，每两秒钟切换一次图片显示
        scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2, TimeUnit.SECONDS);
        super.onStart();
    }

    @Override
    public void onStop() {
        // 当Activity不可见的时候停止切换
        scheduledExecutorService.shutdown();
        super.onStop();
    }

    private void initViews() {

        listView = (ListView) view.findViewById(R.id.tab1_listview);

        lxtz = (ImageView) view.findViewById(R.id.img3);

        //图片id
        imgid = new int[]{R.mipmap.h1,R.mipmap.h2,R.mipmap.h3};
        list = new ArrayList<ImageView>();

        //标题内容数组
        titles = new String[imgid.length];
        titles[0] = "手机抢票只要一元！还不快来";
        titles[1] = "爱旅带你“趣”自驾游";
        titles[2] = "错峰周边游开始啦";

        //把图片资源加到list<ImageView>中
        for (int i=0;i<imgid.length;i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(imgid[i]);
//          imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            list.add(imageView);
        }

        //把每个dot加到dots中
        dots = new ArrayList<View>();
        dots.add(view.findViewById(R.id.dot0));
        dots.add(view.findViewById(R.id.dot1));
        dots.add(view.findViewById(R.id.dot2));

        //设置每个标题的内容
        title = (TextView) view.findViewById(R.id.title);
        title.setText(titles[0]);
    }

    //初始化viewpager
    private void initViewPager(){
        vptop = (ViewPager) view.findViewById(R.id.vp);
    }

    /**
     * 换行切换任务
     *
     * @author Administrator
     *
     */
    private class ScrollTask implements Runnable {

        public void run() {
            synchronized (vptop) {
                currentItem = (currentItem + 1) % list.size();
                handler.obtainMessage().sendToTarget(); // 通过Handler切换图片
            }
        }
    }

    /**
     * 当ViewPager中页面的状态发生改变时调用
     *
     * @author Administrator
     *
     */
    private class myPageChangeListener implements ViewPager.OnPageChangeListener{

        private int oldPosition = 0;

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            currentItem = position;
            title.setText(titles[position]);
            dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);

            dots.get(position).setBackgroundResource(R.drawable.dot_focused);
            oldPosition = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    /**
     * 填充ViewPager页面的适配器
     *
     * @author Administrator
     *
     */
    public class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imgid.length;
        }



        //过期的方法用新方法替换。
        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(list.get(arg1));
            return list.get(arg1);
        }

//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            ((ViewPager)container).addView(list.get(position));
//            return list.get(position);
//        }

        //        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
//            ((ViewPager)container).removeView((View)object);
//        }
        //过期方法，用新方法替换
        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
    }
}
