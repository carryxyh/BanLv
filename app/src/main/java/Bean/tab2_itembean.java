package Bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by xiuyuhang on tab3_3/4/tab3_4.
 */
public class tab2_itembean extends BmobObject{
    public int imgID;
    public String title;
    public String content;

    public tab2_itembean(){

    }

    public tab2_itembean(int imgID,String title,String content){
        this.imgID = imgID;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
