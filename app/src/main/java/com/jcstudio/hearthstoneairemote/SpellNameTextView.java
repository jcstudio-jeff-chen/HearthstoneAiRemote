package com.jcstudio.hearthstoneairemote;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by jeffrey on 2017/6/20.
 */

public class SpellNameTextView extends RelativeSizeTextView {
    Paint p = new Paint();
    Path path;
    float xOffset;

    public SpellNameTextView(Context context) {
        this(context, null, 0);
    }

    public SpellNameTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpellNameTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        p.setStrokeWidth(getShadowRadius());
        p.setTypeface(getTypeface());
        p.setColor(getTextColors().getDefaultColor());
        p.setShadowLayer(getShadowRadius(), getShadowDx(), getShadowDy(), getShadowColor());
        setLayerType(LAYER_TYPE_SOFTWARE, p);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        path = new Path();
        View parent = (View) getParent();
        int pw = parent.getWidth();
        float x0 = (w-pw)/2.0f;
        float y0 = h*0.9f;
        float x1 = pw*0.3f + x0;
        float y1 = h*0.3f;
        float x2 = pw*0.7f+x0;
        float y2 = h*0.3f;
        float x3 = pw+x0;
        float y3 = h*0.9f;
        path.moveTo(x0, y0);
        path.cubicTo(x1, y1, x2, y2, x3, y3);
        Log.d("CNTV", "text size = " + getTextSize());
        p.setTextSize(getTextSize());
        float tw = p.measureText(getText().toString());
        xOffset = pw/2f-tw/2f;
        Log.d("CNTV", "xOffset = " + xOffset);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        canvas.drawTextOnPath(getText().toString(), path, xOffset, 0, p);
    }
}
