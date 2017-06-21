package com.jcstudio.hearthstoneairemote;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;

/**
 * Created by jeffrey on 2017/6/21.
 */

public class RelativeSizeTextView extends android.support.v7.widget.AppCompatTextView {
    public static final int WIDTH = 0;
    public static final int HEIGHT = 1;
    private int relativeTarget;
    private float ratio;

    public RelativeSizeTextView(Context context) {
        this(context, null, 0);
    }

    public RelativeSizeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RelativeSizeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RelativeSizeTextView);
        relativeTarget = a.getInt(R.styleable.RelativeSizeTextView_relative_to, 0);
        ratio = a.getFloat(R.styleable.RelativeSizeTextView_ratio, 0.1f);
        a.recycle();
        Log.d("RSTV", "relativeTarget = " + relativeTarget + ", ratio = " + ratio);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(relativeTarget == WIDTH){
            setTextSize(TypedValue.COMPLEX_UNIT_PX, w*ratio);
        } else if(relativeTarget == HEIGHT) {
            setTextSize(TypedValue.COMPLEX_UNIT_PX, h*ratio);
        }
    }
}
