package fragmentpackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter_tab3;
import Bean.tab3_itembean_1;
import Utils.ReFlashListView;
import personal.example.xiuyuhang.banlv.R;


/**
 * Created by xiuyuhang on tab3_3/4/14.
 */
public class Fragment3 extends Fragment implements ReFlashListView.IReflashListener{

    private ReFlashListView listViewtab3;

    private int[] imgids;
    private String[] titles;
    private String[] contents;

    private List<tab3_itembean_1> itembeanlisttab3;

    private void initItemBeantab3(){
        titles = new String[]{"五月一号西湖","五月三号想去灵隐","五月二号杭州大厦的~","四月25号一起去XX玩","四月26号想去XX的小伙伴"};
        contents = new String[]{"     一起去西湖的，最好是女生，漂亮妹子优先哦",
                    "     五月三号想去灵隐，男生女生都可，不要大叔~年龄在20-23之间~",
                "     五月二号五一劳动节期间一起SHOPPING的小伙伴有么？女生男生不限~",
                "     一起去游XX！看天鹅的~",
                "     听说XX的帅哥很多~我家住XX有没有一起去的啊~"
        };
        imgids = new int[]{R.mipmap.tab3_1,R.mipmap.tab3_2,R.mipmap.tab3_3,R.mipmap.tab3_4,R.mipmap.tab3_5};

        itembeanlisttab3 = new ArrayList<>();

        for (int i=0;i<imgids.length;i++){
            itembeanlisttab3.add(new tab3_itembean_1(
                    imgids[i],
                    titles[i],
                    contents[i]
            ));
        }
    }

    private void initView(){
        listViewtab3 = (ReFlashListView) view.findViewById(R.id.tab3_listview1);
        listViewtab3.setInterface(this);
    }

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        view = View.inflate(getActivity(),R.layout.tab3,null);

        initView();

        initItemBeantab3();

        listViewtab3.setAdapter(new MyAdapter_tab3(getActivity(),itembeanlisttab3));

        return view;
    }

    @Override
    public void onReflash() {
        Log.e("hello","aaaaa");
        listViewtab3.reflashComplete();
    }
}
