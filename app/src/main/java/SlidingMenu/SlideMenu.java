package SlidingMenu;

import android.widget.HorizontalScrollView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;


/**
 * Created by xiuyuhang on tab3_3/4/9.
 */
public class SlideMenu extends HorizontalScrollView {

    private LinearLayout mWrapper;
    private ViewGroup mMenu;
    private ViewGroup mContent;
    private int mScreenWidth;
    //dp
    private int MenuRight = 80;

    private int mMenuWidth;

    private boolean flag = false;

    private boolean isOpen;


    public SlideMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        mScreenWidth = outMetrics.widthPixels;
        //把DP转化成px
        MenuRight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,80,context.getResources().getDisplayMetrics());
    }

    //设置子View的宽和高，设置自己的宽和高
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(!flag) {
            mWrapper = (LinearLayout) getChildAt(0);
            mMenu = (ViewGroup) mWrapper.getChildAt(0);
            mContent = (ViewGroup) mWrapper.getChildAt(1);
            mContent.getLayoutParams().width = mScreenWidth;
            mMenuWidth = mMenu.getLayoutParams().width = mScreenWidth - MenuRight;
            flag = true;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //通过设置偏移量，将MENU隐藏
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(changed) {
            this.scrollTo(mMenuWidth, 0);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        int action = ev.getAction();
        switch (action){
            case MotionEvent.ACTION_UP:
                //隐藏在左边的宽度
                int scrollX = getScrollX();

                if(scrollX >= mMenuWidth/2){
                    this.smoothScrollTo(mMenuWidth,0);
                    isOpen = false;
                }else {
                    this.smoothScrollTo(0,0);
                    isOpen = true;
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }
//    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
//
//
//        super.onScrollChanged(l, t, oldl, oldt);
//        float scale = l * 1.0f / mMenuWidth;
//        ViewHelper.setTranslationX(mMenu, mMenuWidth * scale);
//    }
//    public void openMenu(){
//        if(isOpen)
//            return;
//            this.smoothScrollTo(0,0);
//            isOpen = true;
//    }
//    public void closeMenu(){
//        if(!isOpen)
//            return;
//            this.smoothScrollTo(mMenuWidth,0);
//            isOpen = false;
//    }
//    public void toggle(){
//        if(isOpen){
//            closeMenu();
//        }
//        else{
//            openMenu();
//        }
//    }

}
