package com.example.administrator.view_designbyself;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/3/27.
 */

public class View01 extends View {
    public View01(Context context) {
        super(context);
    }
  public View01(Context context,AttributeSet attrs){
        super(context,attrs);
  }
    public View01(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width_result = 200;
        int height_result = 200;
        int specMode_width = MeasureSpec.getMode(widthMeasureSpec);
        int specMode_height = MeasureSpec.getMode(heightMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);
        int heightsize = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode_width == MeasureSpec.EXACTLY) {
            width_result = widthsize;
        } else {
            if (specMode_width == MeasureSpec.AT_MOST)
                width_result = Math.min(width_result, widthsize);
        }
        if (specMode_height == MeasureSpec.EXACTLY) {
            height_result = heightsize;
        } else {
           if(specMode_height ==MeasureSpec.AT_MOST)
               height_result=Math.min(height_result,heightsize);
        }
        setMeasuredDimension(width_result,height_result);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint=new Paint();
       paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setStyle(Paint.Style.FILL);
        float radius= getMeasuredWidth()/2;
        canvas.drawCircle(getMeasuredWidth()/2,getMeasuredHeight()/2,radius,paint);
      //canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);
        canvas.save();
        super.onDraw(canvas);
    }
}
