package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class Practice10HistogramView extends View {

    // X 轴起点坐标
    public static final int START_X = 150;
    // Y 轴起点坐标
    public static final int START_Y = 50;
    // Y 轴的高度
    public static final int END_Y = 450;
    // X 轴的宽度
    public static final int END_X = 950;
    // 间距的宽度
    public static final int SPACE_WIDTH = 20;
    // 矩形的宽度
    public static final int RECT_WIDTH = 80;
    // text的数组
    public static final String[] textArr = {"Froyo","GB","ICS","JB","KitKat","L","M"};

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        // 画坐标轴
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.WHITE);
        canvas.drawLine(START_X, START_Y, START_X, END_Y,mPaint);
        canvas.drawLine(START_X, END_Y,END_X, END_Y,mPaint);

        // 画标题
        mPaint.setTextSize(45);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText("直方图",450,600,mPaint);


        // 画矩形
        // 第一个高度最低的白色矩形
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(START_X + SPACE_WIDTH,END_Y - 2,
                START_X + SPACE_WIDTH + RECT_WIDTH ,
                END_Y, mPaint);

        // 循环画出其余矩形，
        mPaint.setColor(Color.parseColor("#72B916"));
        for (int i = 2; i < 8; i++) {


            // 左坐标距离原点的距离 = X 轴开始坐标 + 间距 * i + 矩形宽度 * (i-1) i 从1开始
            int betweenSpace = START_X + SPACE_WIDTH * i  + RECT_WIDTH * (i-1) ;
            // 随机数设定高度
            int height = END_Y - 10 * new Random().nextInt(20);
            // 右坐标始终 = 左坐标 + 矩形宽度
            int width = betweenSpace + RECT_WIDTH;

            mPath.addRect(betweenSpace,height,width ,
                    END_Y, Path.Direction.CW);

        }
        canvas.drawPath(mPath, mPaint);


        // 画出 text
        mPaint.setTextSize(24);
        mPaint.setColor(Color.WHITE);
        for (int i = 0; i < textArr.length; i++) {
            // 距离矩形左下角的距离 为了使 textView 居中一些
            int leftDistance = i == 0 || i == 4 ? 10 :
                    i > 4 ? 30 : 20;

            // 左坐标距离原点的距离 = X 轴开始坐标 + 间距 * )i+ 1) + 矩形宽度 * i +   i 从0开始
            int startX = START_X + SPACE_WIDTH * (i + 1) + leftDistance + RECT_WIDTH * i;
            canvas.drawText(textArr[i],
                     startX,
                    END_Y + 20,
                    mPaint);
        }

    }
}
