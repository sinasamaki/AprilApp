package com.sinasamaki.aprilapp;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LoadingGradientSpinner extends FrameLayout {

    GradientCircle firstCircle;
    GradientCircle secondCircle;
    GradientCircle thirdCircle;

    public LoadingGradientSpinner(Context context) {
        super(context);
    }

    public LoadingGradientSpinner(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray attributes = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.LoadingGradientSpinner,
                0, 0);
        try {
            init(
                    attributes.getColor(R.styleable.LoadingGradientSpinner_firstColor, 0),
                    attributes.getColor(R.styleable.LoadingGradientSpinner_secondColor, 0),
                    attributes.getColor(R.styleable.LoadingGradientSpinner_thirdColor, 0)
            );
        } finally {
            attributes.recycle();
        }
    }

    private void init(
            int firstColor,
            int secondColor,
            int thirdColor
    ) {
        firstCircle = new GradientCircle(getContext());
        secondCircle = new GradientCircle(getContext());
        thirdCircle = new GradientCircle(getContext());

        addView(firstCircle);
//        addView(secondCircle);
//        addView(thirdCircle);

        firstCircle.setColor(firstColor);
//        secondCircle.setColor(secondColor);
//        thirdCircle.setColor(thirdColor);
//
//
//        firstCircle.setCameraDistance(100000);
//        secondCircle.setCameraDistance(100000);
//        thirdCircle.setCameraDistance(100000);
//
//        ObjectAnimator firstCircleAnimation = createCircleAnimation(firstCircle, 0L);
//        firstCircleAnimation.start();
//
//        ObjectAnimator secondCircleAnimation = createCircleAnimation(secondCircle, 200L);
//        secondCircleAnimation.start();
//
//        ObjectAnimator thirdCircleAnimation = createCircleAnimation(thirdCircle, 400L);
//        thirdCircleAnimation.start();
//
//
//        ObjectAnimator viewRotate = ObjectAnimator.ofFloat(this, View.ROTATION, 0f, 360f);
//        viewRotate.setRepeatCount(ValueAnimator.INFINITE);
//        viewRotate.setRepeatMode(ValueAnimator.RESTART);
//        viewRotate.setDuration(20_000L);
//        viewRotate.start();
    }


    @NonNull
    private ObjectAnimator createCircleAnimation(View circle, long delay) {
        ObjectAnimator animation = ObjectAnimator.ofFloat(circle, View.ROTATION_X, 0f, 360f);
        animation.setRepeatCount(ValueAnimator.INFINITE);
        animation.setRepeatMode(ValueAnimator.RESTART);
        animation.setDuration(3_000L);
        animation.setStartDelay(delay);
        animation.setInterpolator(new LinearInterpolator());
        return animation;
    }

}
