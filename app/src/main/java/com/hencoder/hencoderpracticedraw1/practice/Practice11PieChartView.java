package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        mPaint.setColor(Color.RED);
        canvas.drawArc(140,40,690,590,
                -180,120,true,mPaint);

        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(190,90,690,590,
                -60,55,true,mPaint);

        mPaint.setColor(Color.GREEN);
        canvas.drawArc(180,92,690,592,
                -5,3,true,mPaint);

        mPaint.setColor(Color.parseColor("#8A36AD"));
        canvas.drawArc(190,94,690,594,
                -2,6,true,mPaint);

        mPaint.setColor(Color.GRAY);
        canvas.drawArc(190,96,690,596,
                6,6,true,mPaint);

        mPaint.setColor(Color.parseColor("#4E9488"));
        canvas.drawArc(190,98,690,598,
                14,66,true,mPaint);

        mPaint.setColor(Color.parseColor("#5194EB"));
        canvas.drawArc(180,100,690,600,
                82,98,true,mPaint);


        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(26);
        // 文字
        canvas.drawText("Lollipop",10,80,mPaint);
        canvas.drawText("Marshmallow",850,200,mPaint);

        canvas.drawText("Froyo",850,325,mPaint);
        canvas.drawText("Gingerbread",850,360,mPaint);
        canvas.drawText("Ice Cream Sandwich",850,410,mPaint);
        canvas.drawText("Jelly Bean",800,580,mPaint);
        canvas.drawText("KitKat",50,580,mPaint);


        mPaint.setStrokeWidth(4);
        mPaint.setColor(Color.GRAY);
        // 画线
        // Lollipop
        canvas.drawLine(110,80,200,80,mPaint);
        canvas.drawLine(200,80,220,120,mPaint);

        // Marshmallow
        canvas.drawLine(845,200,700,200,mPaint);
        canvas.drawLine(700,200,670,240,mPaint);

        // Froyo
        canvas.drawLine(845,325,690,325,mPaint);

        // Gingerbread
        canvas.drawLine(845,360,780,360,mPaint);
        canvas.drawLine(780,360,730,350,mPaint);
        canvas.drawLine(730,350,690,350,mPaint);


        // Ice Cream Sandwich
        canvas.drawLine(845,410,780,410,mPaint);
        canvas.drawLine(780,410,730,390,mPaint);
        canvas.drawLine(730,390,690,390,mPaint);

        // Jelly Bean
        canvas.drawLine(795,580,690,580,mPaint);
        canvas.drawLine(690,580,640,500,mPaint);

        // KitKat
        canvas.drawLine(150,580,250,580,mPaint);
        canvas.drawLine(250,580,290,550,mPaint);


    }
}
