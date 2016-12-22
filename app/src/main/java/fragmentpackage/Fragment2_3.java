package fragmentpackage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter_tab2_3;
import Adapter.MyAdapter_tab3;
import Bean.tab2_itembean_2;
import Bean.tab2_itembean_3;
import Bean.tab3_itembean_1;
import personal.example.xiuyuhang.banlv.R;

/**
 * Created by xiuyuhang on tab3_3/4/17.
 */
public class Fragment2_3 extends Fragment {

    private ListView listView3;

    private List<tab3_itembean_1> itembeanList3;

    private int[] imgids;

    private void initItemBeantab3(){
        imgids = new int[]{R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

        itembeanList3 = new ArrayList<>();

        for (int i=0;i<imgids.length;i++){
            itembeanList3.add(new tab3_itembean_1(
                    imgids[i],
                    "我是标题"+i,
                    "我是内容"
            ));
        }
    }

    private void initView(){
        listView3 = (ListView) view.findViewById(R.id.tab2_listview3);
    }

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.includetab2_4,null);

        initView();

        initItemBeantab3();

        listView3.setAdapter(new MyAdapter_tab3(getActivity(),itembeanList3));

        return view;
    }
}
