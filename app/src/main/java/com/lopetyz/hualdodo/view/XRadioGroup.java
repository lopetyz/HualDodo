package com.lopetyz.hualdodo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;

import com.lopetyz.hualdodo.R;

/**
 * Created by Hualei on 2017/6/5.
 * <p>
 * Automatically wrap newline when horizontal space is full.
 */

public class XRadioGroup extends RadioGroup {

    private int mHorizontalSpacing = 20;
    private int mVerticalSpacing = 10;

    public XRadioGroup(Context context) {
        super(context);
    }

    public XRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.XRadioGroup);
        for (int i = 0; i < a.length(); i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.XRadioGroup_horizontalSpacing) {
                mHorizontalSpacing = a.getInt(i, 20);
            } else if (attr == R.styleable.XRadioGroup_verticalSpacing) {
                mVerticalSpacing = a.getInt(i, 10);
            }
        }

        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int availableWidth = width - getPaddingLeft() - getPaddingRight();

        int childCount = getChildCount();
        int x = 0;
        int y = 0;
        int row = 0;

        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
                int w = child.getMeasuredWidth();
                int h = child.getMeasuredHeight();
                if (i == 0) {
                    x = w;
                } else {
                    x = x + mHorizontalSpacing + w;
                }
                if (x > availableWidth) {
                    x = w;
                    row++;
                }
                if (i == childCount - 1) {
                    y = row * h + h + row * mVerticalSpacing;
                }
            }
        }

        setMeasuredDimension(width, y + getPaddingTop() + getPaddingBottom());
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int availableWidth = r - l - paddingLeft - getPaddingRight();

        int childCount = getChildCount();
        int x = 0;
        int y = 0;
        int row = 0;
        for (int i = 0; i < childCount; i++) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                int w = child.getMeasuredWidth();
                int h = child.getMeasuredHeight();
                if (i == 0) {
                    x = w;
                } else {
                    x = x + mHorizontalSpacing + w;
                }
                if (x > availableWidth) {
                    x = w;
                    row++;
                }
                y = row * h + h + row * mVerticalSpacing;
                child.layout(paddingLeft + x - w, paddingTop + y - h, paddingLeft + x, paddingTop + y);
            }
        }
    }
}
