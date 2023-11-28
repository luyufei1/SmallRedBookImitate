package com.example.smallredbookimitate.Fragment_nav;

import android.content.Context;
import android.util.AttributeSet;

import com.google.android.material.appbar.CollapsingToolbarLayout;

//该方法只针对CollapsingToolbarLayout包含内容的高度
public class NestCollapsingToolbarLayout extends CollapsingToolbarLayout {

    private boolean mIsScrimsShown = false;
    private OnScrimsShowListener mScrimsShowListener;

    public NestCollapsingToolbarLayout(Context context) {
        super(context);
    }

    public NestCollapsingToolbarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NestCollapsingToolbarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setScrimsShown(boolean shown, boolean animate) {
        super.setScrimsShown(shown, animate);
        if (mIsScrimsShown != shown) {
            mIsScrimsShown = shown;
            if (mScrimsShowListener != null) {
                //新传入的shown与原先的状态不同，更新mIsScrimsShown并触发回调
                mScrimsShowListener.onScrimsShowChange(this, mIsScrimsShown);
            }
        }
    }

    public void setOnScrimsShowListener(OnScrimsShowListener listener) {
        mScrimsShowListener = listener;
    }

    public interface OnScrimsShowListener {
        void onScrimsShowChange(NestCollapsingToolbarLayout nestCollapsingToolbarLayout, boolean isScrimesShow);
    }
}
