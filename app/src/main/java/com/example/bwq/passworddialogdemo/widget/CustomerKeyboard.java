package com.example.bwq.passworddialogdemo.widget;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.example.bwq.passworddialogdemo.R;


public class CustomerKeyboard extends LinearLayout implements View.OnClickListener {
    CardView key1;
    CardView key2;
    CardView key3;
    CardView key4;
    CardView key5;
    CardView key6;
    CardView key7;
    CardView key8;
    CardView key9;
    CardView key0;
    LinearLayout llDelete;
    private CustomerKeyboardClickListener mListener;

    public CustomerKeyboard(Context context) {
        this(context, null);
    }

    public CustomerKeyboard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomerKeyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = inflate(context, R.layout.pwd_keyboard_layout, this);
        key0 = view.findViewById(R.id.key0);
        key1 = view.findViewById(R.id.key1);
        key2 = view.findViewById(R.id.key2);
        key3 = view.findViewById(R.id.key3);
        key4 = view.findViewById(R.id.key4);
        key5 = view.findViewById(R.id.key5);
        key6 = view.findViewById(R.id.key6);
        key7 = view.findViewById(R.id.key7);
        key8 = view.findViewById(R.id.key8);
        key9 = view.findViewById(R.id.key9);
        llDelete = view.findViewById(R.id.ll_delete);
        setChildViewOnclick();
    }

    /**
     * 设置键盘子View的点击事件
     */
    private void setChildViewOnclick() {
        key0.setOnClickListener(this);
        key1.setOnClickListener(this);
        key2.setOnClickListener(this);
        key3.setOnClickListener(this);
        key4.setOnClickListener(this);
        key5.setOnClickListener(this);
        key6.setOnClickListener(this);
        key7.setOnClickListener(this);
        key8.setOnClickListener(this);
        key9.setOnClickListener(this);
        llDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.key0) {
            mListener.click("0");
        }
        if (v.getId() == R.id.key1) {
            mListener.click("1");
        }
        if (v.getId() == R.id.key2) {
            mListener.click("2");
        }
        if (v.getId() == R.id.key3) {
            mListener.click("3");
        }
        if (v.getId() == R.id.key4) {
            mListener.click("4");
        }
        if (v.getId() == R.id.key5) {
            mListener.click("5");
        }
        if (v.getId() == R.id.key6) {
            mListener.click("6");
        }
        if (v.getId() == R.id.key7) {
            mListener.click("7");
        }
        if (v.getId() == R.id.key8) {
            mListener.click("8");
        }
        if (v.getId() == R.id.key9) {
            mListener.click("9");
        }
        if (v.getId() == R.id.ll_delete) {
            mListener.delete();
        }
    }

    /**
     * 设置键盘的点击回调监听
     */
    public void setOnCustomerKeyboardClickListener(CustomerKeyboardClickListener listener) {
        this.mListener = listener;
    }

    /**
     * 点击键盘的回调监听
     */
    public interface CustomerKeyboardClickListener {
        public void click(String number);

        public void delete();
    }
}
