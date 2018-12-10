package com.example.bwq.passworddialogdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bwq.passworddialogdemo.R;
import com.example.bwq.passworddialogdemo.widget.CustomerKeyboard;
import com.example.bwq.passworddialogdemo.widget.PasswordEditText;


public class PayPwdDialog extends Dialog implements CustomerKeyboard.CustomerKeyboardClickListener, PasswordEditText.PasswordFullListener {
    ImageView ivCancel;
    PasswordEditText editPwd;
    TextView tvWithdrawDays;
    CustomerKeyboard keyBoard;

    private String days;
    private PwdFullListener listener;

    public PayPwdDialog(@NonNull Context context, String days) {
        super(context, R.style.ActionSheetDialogStyle);
        this.days = days;
    }

    public PayPwdDialog setListener(PwdFullListener listener) {
        this.listener = listener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_pwd_dialog_layout);
        ivCancel = findViewById(R.id.iv_cancel);
        editPwd = findViewById(R.id.edit_pwd);
        tvWithdrawDays = findViewById(R.id.tv_withdraw_days);
        keyBoard = findViewById(R.id.key_board);
        tvWithdrawDays.setText(days);
        editPwd.setListener(this);
        keyBoard.setOnCustomerKeyboardClickListener(this);
        ivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    public void show() {
        super.show();
        /**
         * 设置宽度全屏，要设置在show的后面
         */
        if (getWindow() != null) {
            WindowManager.LayoutParams params = getWindow().getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            getWindow().setAttributes(params);
            getWindow().setGravity(Gravity.BOTTOM);
            setCanceledOnTouchOutside(true);
        }
    }

    @Override
    public void click(String number) {
        editPwd.addPassword(number);
    }

    @Override
    public void delete() {
        editPwd.deleteLastPassword();
    }

    @Override
    public void passwordFull(String password) {
        listener.pwdFull(password);
        dismiss();
    }

    public interface PwdFullListener {
        void pwdFull(String pwd);
    }
}
