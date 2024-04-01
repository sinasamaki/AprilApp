package com.sinasamaki.aprilapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GradientCircle extends View {


    int length = 0;
    int width = 0;
    int height = 0;

    Paint paint = new Paint();
    Paint outlinePaint = new Paint();
    int color = Color.BLACK;

    public GradientCircle(Context context) {
        super(context);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        length = Math.min(w, h);

        setGradient(color);
    }

    public void setColor(int color) {
        this.color = color;
        setGradient(this.color);
    }

    public void setGradient(int color) {
        if (length > 0) {
            RadialGradient gradient = new RadialGradient(
                    length * .25f,
                    length * .25f,
                    length * .75f,
                    color,
                    Color.TRANSPARENT,
                    android.graphics.Shader.TileMode.CLAMP
            );
            paint.setDither(true);
            paint.setShader(gradient);

            RadialGradient outlineGradient = new RadialGradient(
                    length * .25f,
                    length * .25f,
                    length,
                    color,
                    Color.TRANSPARENT,
                    android.graphics.Shader.TileMode.CLAMP
            );
            outlinePaint.setStyle(Paint.Style.STROKE);
            outlinePaint.setStrokeWidth(1f);
            outlinePaint.setDither(true);
            outlinePaint.setShader(outlineGradient);
        }
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(width / 2f, height / 2f, length / 2f, paint);
        canvas.drawCircle(width / 2f, height / 2f, length / 2f, outlinePaint);
    }
}
