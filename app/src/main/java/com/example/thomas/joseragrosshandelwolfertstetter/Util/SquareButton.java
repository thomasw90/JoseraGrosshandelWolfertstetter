package com.example.thomas.joseragrosshandelwolfertstetter.Util;

import android.content.Context;
import android.util.AttributeSet;

public class SquareButton extends android.support.v7.widget.AppCompatButton {

    public SquareButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int width = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width, width);
    }
}
