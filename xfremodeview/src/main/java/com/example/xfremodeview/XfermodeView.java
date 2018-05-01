package com.example.xfremodeview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;


public class XfermodeView extends View {
    private Bitmap mBgBitmap, mFgBitmap;
    private Paint mPaint;
    private Canvas mCanvas;
    private Path mPath;
    private int height = 200;
    private int width = 200;
    private int drawable_id;
    private int color;
    private int paddingLeft;
    private int paddingRight;
    private int paddintTop;
    private int paddingBottom;
    public XfermodeView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.XfermodeView);
        drawable_id = attrs.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "src", 0);
        color=a.getColor(R.styleable.XfermodeView_color,Color.GRAY);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int specMode_width = MeasureSpec.getMode(widthMeasureSpec);
        int specMode_height = MeasureSpec.getMode(heightMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);
        int heightsize = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode_width == MeasureSpec.EXACTLY) {
            width = widthsize;
        } else {
            if (specMode_width == MeasureSpec.AT_MOST)
                width = Math.min(width, widthsize);
        }
        if (specMode_height == MeasureSpec.EXACTLY) {
            height = heightsize;
        } else {
            if (specMode_height == MeasureSpec.AT_MOST)
                height = Math.min(height, heightsize);
        }
        paddingLeft=getPaddingLeft();
        paddingRight=getPaddingRight();
        paddintTop=getPaddingTop();
        paddingBottom=getPaddingBottom();
        init();
        setMeasuredDimension(width, height);
    }
    private void init() {
        mPaint = new Paint();
        mPaint.setAlpha(0);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(50);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPath = new Path();
        mBgBitmap = BitmapFactory.decodeResource(getResources(), drawable_id);
        int rationheight = mBgBitmap.getHeight() / (height-paddintTop-paddingBottom);
        int rationwidth = mBgBitmap.getWidth() / (width-paddingLeft-paddingRight);
        BitmapFactory.Options da = new BitmapFactory.Options();
        da.inSampleSize = rationheight > rationwidth ? rationwidth : rationheight;
        mBgBitmap = BitmapFactory.decodeResource(getResources(), drawable_id, da);
        mFgBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mFgBitmap);
        mCanvas.drawColor(color);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                mPath.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(event.getX(), event.getY());
                break;
        }
        mCanvas.drawPath(mPath, mPaint);
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBgBitmap, paddingLeft, paddintTop, null);
        canvas.drawBitmap(mFgBitmap, paddingLeft, paddintTop, null);
    }
}
