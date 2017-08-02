package com.lopetyz.hualdodo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lopetyz on 2017/7/21.
 */

public class SlidingSwitchButton extends View {
    private Paint mPaint;
    private Paint mPaint1;
    private Paint mPaint2;
    private RectF mRectF1;
    private RectF mRectF2;

    Path mPath = new Path();

    {
        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        mPath.addArc(new RectF(200, 200, 400, 400), -225, 225);
        mPath.arcTo(new RectF(400, 200, 600, 400), -180, 225, false);
        mPath.lineTo(400, 542);

//        mPath.lineTo(100, 100); // 由当前位置 (0, 0) 向 (100, 100) 画一条直线
//        mPath.rLineTo(100, 0); // 由当前位置 (100, 100) 向正右方 100 像素的位置画一条直线
    }

    float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};

    public SlidingSwitchButton(Context context) {
        super(context);
        init();
    }

    public SlidingSwitchButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SlidingSwitchButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SlidingSwitchButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(20);
        mPaint.setStrokeCap(Paint.Cap.BUTT);

        mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint1.setColor(Color.BLACK);
//        mPaint1.setStrokeWidth(20);
        mPaint1.setStyle(Paint.Style.STROKE);
//        mPaint1.setStrokeCap(Paint.Cap.ROUND);

        mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint2.setColor(Color.BLACK);
//        mPaint2.setStrokeWidth(20);
//        mPaint2.setStrokeCap(Paint.Cap.SQUARE);

        Shader shader = new LinearGradient(100, 100, 500, 500, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        mPaint2.setShader(shader);

        mRectF1 = new RectF(100, 400, 500, 600);
        mRectF2 = new RectF(600, 100, 1000, 300);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawCircle(300, 300, 200, mPaint);

//        canvas.drawPoints(points, 2, 10, mPaint1);

//        canvas.drawRect(100, 100, 500, 300, mPaint);
//        canvas.drawOval(100, 400, 500, 700, mPaint);

//        canvas.drawOval(rectF, mPaint);
//        canvas.drawOval(rectF1, mPaint1);

//        canvas.drawArc(mRectF1, 0, -120, false, mPaint2);
//        canvas.drawLine(270, 100, 270, 1500, mPaint2);
//        canvas.drawArc(mRectF2, -120, 10, false, mPaint1);

        canvas.drawPath(mPath, mPaint2);
    }
}
