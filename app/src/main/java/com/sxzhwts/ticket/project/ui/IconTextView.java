package com.sxzhwts.ticket.project.ui;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.sxzhwts.ticket.MyApplication;


/**
 * Created by fcy on 2017/6/12.
 * TextView使用字体库
 */

public class IconTextView extends AppCompatTextView {
    public IconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public IconTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public IconTextView(Context context) {
        super(context);
        init();
    }
    public boolean onInterceptTouchEvent(){
        return  true;
    }
    private void init() {
        setTypeface(MyApplication.getInstamce().getIconTypeFace());
    }

}

