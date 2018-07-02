package com.lopetyz.hualdodo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.lopetyz.hualdodo.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by lopetyz on 2017/8/2.
 */

public class CountDownTimerView extends View {

    @IntDef({HORIZONTAL, VERTICAL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private CharSequence mTitle;
    private CharSequence mDateFormat;
    private CharSequence mCountDownFinish;
    private int mTitleSize;
    private int mCountDownSize;
    private int mFinishSize;
    private int mTitleColor;
    private int mCountDownTimeColor;
    private int mFinishColor;
    @OrientationMode
    private int mTextOrientation;
    private float mDensity;

    private int mDefaultWidth;
    private int mDefaultHeight;

    private Paint mTitlePaint;
    private Paint mCountDownTimePaint;
    private Paint mFinishPaint;
    private Paint.FontMetricsInt mTitleFontMetricsInt;
    private Paint.FontMetricsInt mCountDownFontMetricsInt;
    private Rect mTextRect = new Rect();

    private long mMillisInFuture;
    private long mCountDownInterval;
    private OnTimeFinishedListener mOnTimeFinishedListener;
    private CountDownTimer mCountDownTimer;
    private boolean mStarted;
    private boolean mFinished;

    public CountDownTimerView(Context context) {
        this(context, null);
    }

    public CountDownTimerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountDownTimerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CountDownTimerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    public interface OnTimeFinishedListener {
        void onTimeFinished();
    }

    public void setOnTimeFinishedListener(OnTimeFinishedListener listener) {
        mOnTimeFinishedListener = listener;
    }

    public void setTextOrientation(@OrientationMode int orientation) {
        mTextOrientation = orientation;
    }

    @OrientationMode
    public int getTextOrientation() {
        return mTextOrientation;
    }

    public void start() {
        if (mMillisInFuture > 0 && mCountDownInterval > 0) {
            mCountDownTimer.start();
            mStarted = true;
        }
    }

    public void cancel() {
        mStarted = false;
        mCountDownTimer.cancel();
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        mDensity = density;
        mDefaultWidth = (int) (100 * density);
        mDefaultHeight = (int) (20 * density);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CountDownTimerView, defStyleAttr, defStyleRes);

        mTitle = ta.getString(R.styleable.CountDownTimerView_text_title);
        mTitleColor = ta.getColor(R.styleable.CountDownTimerView_text_title_color, Color.BLACK);
        @OrientationMode int index = ta.getInt(R.styleable.CountDownTimerView_text_orientation, HORIZONTAL);
        if (index > 0) {
            setTextOrientation(index);
        }
        mTitleSize = ta.getDimensionPixelSize(R.styleable.CountDownTimerView_text_title_size, (int) (14 * density));
        mCountDownTimeColor = ta.getColor(R.styleable.CountDownTimerView_text_count_down_time_color, ContextCompat.getColor(context, R.color.colorCountDown));
        mCountDownSize = ta.getDimensionPixelSize(R.styleable.CountDownTimerView_text_count_down_time_size, (int) (14 * density));
        mMillisInFuture = ta.getInt(R.styleable.CountDownTimerView_millis_in_future, 0);
        mCountDownInterval = ta.getInt(R.styleable.CountDownTimerView_count_down_interval, 0);
        mCountDownFinish = ta.getString(R.styleable.CountDownTimerView_text_count_down_finish);
        mFinishSize = ta.getDimensionPixelSize(R.styleable.CountDownTimerView_text_count_down_time_size, (int) (16 * density));
        mFinishColor = ta.getColor(R.styleable.CountDownTimerView_text_count_down_finish_color, ContextCompat.getColor(context, R.color.colorCountDown));

        mTitlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTitlePaint.setColor(mTitleColor);
        mTitlePaint.setTextSize(mTitleSize);
        mTitlePaint.setTextAlign(mTextOrientation == HORIZONTAL ? Paint.Align.LEFT : Paint.Align.CENTER);
        mTitleFontMetricsInt = mTitlePaint.getFontMetricsInt();

        mCountDownTimePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCountDownTimePaint.setColor(mCountDownTimeColor);
        mCountDownTimePaint.setTextSize(mCountDownSize);
        mCountDownTimePaint.setTextAlign(mTextOrientation == HORIZONTAL ? Paint.Align.LEFT : Paint.Align.CENTER);
        mCountDownFontMetricsInt = mCountDownTimePaint.getFontMetricsInt();
        mCountDownTimer = new CountDownTimer(mMillisInFuture, mCountDownInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                mMillisInFuture = millisUntilFinished;
                postInvalidate();
            }

            @Override
            public void onFinish() {
                mFinished = true;
                if (mOnTimeFinishedListener != null) {
                    mOnTimeFinishedListener.onTimeFinished();
                }
                cancel();
                postInvalidate();
            }
        };

        mFinishPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mFinishPaint.setColor(mFinishColor);
        mFinishPaint.setTextSize(mFinishSize);
        mFinishPaint.setTextAlign(mTextOrientation == HORIZONTAL ? Paint.Align.LEFT : Paint.Align.CENTER);

        mDefaultWidth = Math.max(mDefaultWidth, getDefaultWidth());
        mDefaultHeight = Math.max(mDefaultHeight, getDefaultHeight());

        ta.recycle();
    }

    private int getDefaultWidth() {
        if (mTextOrientation == HORIZONTAL) {
            int countDown;
            if (TextUtils.isEmpty(mTitle)) {
                countDown = (int) mCountDownTimePaint.measureText("00:00");
            } else {
                countDown = (int) (mTitlePaint.measureText(mTitle.toString()) + mCountDownTimePaint.measureText("00:00"));
            }
            int finish = (int) mFinishPaint.measureText(mCountDownFinish.toString());
            return Math.max(countDown, finish);
        } else {
            int titleWidth = 0;
            if (!TextUtils.isEmpty(mTitle)) {
                titleWidth = (int) (mTitlePaint.measureText(mTitle.toString()));
            }
            int countDown = (int) mCountDownTimePaint.measureText("00:00");
            int finish = (int) mFinishPaint.measureText(mCountDownFinish.toString());
            return Math.max(Math.max(titleWidth, countDown), finish);
        }
    }

    private int getDefaultHeight() {
        if (mTextOrientation == HORIZONTAL) {
            return (int) Math.max(Math.ceil(mTitleFontMetricsInt.descent - mTitleFontMetricsInt.top) + 2, Math.ceil(mCountDownFontMetricsInt.descent - mCountDownFontMetricsInt.top) + 2);
        } else {
            return (int) (Math.ceil(mTitleFontMetricsInt.descent - mTitleFontMetricsInt.top) + 2 + Math.ceil(mCountDownFontMetricsInt.descent - mCountDownFontMetricsInt.top) + 2);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        int defaultWidth = mDefaultWidth;
        switch (widthMode) {
            case MeasureSpec.AT_MOST:
                width = Math.min(widthSize, defaultWidth);
                break;

            case MeasureSpec.EXACTLY:
                width = widthSize;
                break;

            case MeasureSpec.UNSPECIFIED:
                width = defaultWidth;
                break;

            default:
                width = defaultWidth;
                break;
        }

        int defaultHeight = mDefaultHeight;
        switch (heightMode) {
            case MeasureSpec.AT_MOST:
                height = Math.min(heightSize, defaultHeight);
                break;

            case MeasureSpec.EXACTLY:
                height = heightSize;
                break;

            case MeasureSpec.UNSPECIFIED:
                height = defaultHeight;
                break;

            default:
                height = defaultHeight;
                break;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (!mStarted) return;

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        int countDownBaseline = (height - (mCountDownFontMetricsInt.descent - mCountDownFontMetricsInt.ascent)) / 2 - mCountDownFontMetricsInt.ascent;
        int seconds = (int) (mMillisInFuture / 1000);
        int min = seconds / 60;
        int sec = seconds % 60;
        String time = (min < 10 ? "0" + min : min) + ":" + (sec < 10 ? "0" + sec : sec);

        if (mTextOrientation == HORIZONTAL) {
            if (!mFinished) {
                if (!TextUtils.isEmpty(mTitle)) {
                    int titleBaseline = (height - (mTitleFontMetricsInt.descent - mTitleFontMetricsInt.ascent)) / 2 - mTitleFontMetricsInt.ascent;
                    canvas.drawText(mTitle, 0, mTitle.length(), 0, titleBaseline, mTitlePaint);
                    float textWidth = mTitlePaint.measureText(mTitle.toString());
                    canvas.drawText(time, 0, time.length(), textWidth, countDownBaseline, mCountDownTimePaint);
                } else {
                    canvas.drawText(time, 0, time.length(), 0, countDownBaseline, mCountDownTimePaint);
                }
            } else {
                if (!TextUtils.isEmpty(mCountDownFinish)) {
                    canvas.drawText(mCountDownFinish, 0, mCountDownFinish.length(), width / 2, countDownBaseline, mFinishPaint);
                }
            }
        } else {
            if (!mFinished) {
                if (!TextUtils.isEmpty(mTitle)) {
                    float titleHeight = (float) (Math.ceil(mTitleFontMetricsInt.descent - mTitleFontMetricsInt.top) + 2);
                    canvas.drawText(mTitle, 0, mTitle.length(), width / 2, titleHeight, mTitlePaint);
                    float countDownHeight = (float) (Math.ceil(mCountDownFontMetricsInt.descent - mCountDownFontMetricsInt.top) + 2);
                    canvas.drawText(time, 0, time.length(), width / 2, titleHeight + countDownHeight, mCountDownTimePaint);
                } else {
                    canvas.drawText(time, 0, time.length(), width / 2, countDownBaseline, mCountDownTimePaint);
                }
            } else {
                if (!TextUtils.isEmpty(mCountDownFinish)) {
                    canvas.drawText(mCountDownFinish, 0, mCountDownFinish.length(), width / 2, countDownBaseline, mFinishPaint);
                }
            }
        }
    }
}
