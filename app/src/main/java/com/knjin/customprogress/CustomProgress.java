package com.knjin.customprogress;

/**
 * Created by Jing on 16/11/22.
 */

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.CancellationSignal;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 自定义progressdialog
 */
public class CustomProgress extends Dialog{

    public CustomProgress(Context context) {
        super(context);
    }

    public CustomProgress(Context context, int themeResId) {
        super(context, themeResId);
    }

    /**
     * 设置提示信息
     * @param message
     */
    public void setMessage(CharSequence message){
        if (message != null && message.length()>0) {
            findViewById(R.id.msg).setVisibility(View.VISIBLE);
            TextView tv = (TextView) findViewById(R.id.msg);
            tv.setText(message);
            tv.invalidate();
        }
    }

    /**
     *
     * @param context
     * @param message
     * @param cancelable 返回键是否取消
     * @param cancelListener
     * @return
     */
    public static CustomProgress show(Context context,CharSequence message
            ,boolean cancelable,OnCancelListener cancelListener){
        CustomProgress dialog = new CustomProgress(context,R.style.Custom_Progress);
        dialog.setTitle("");
        dialog.setContentView(R.layout.progress_custom);
        if (message == null || message.length() == 0) {
            dialog.findViewById(R.id.msg).setVisibility(View.GONE);
        }else {
            TextView tv = (TextView) dialog.findViewById(R.id.msg);
            tv.setText(message);
        }
        //按返回键是否取消
        dialog.setCancelable(cancelable);
        //监听返回处理
        dialog.setOnCancelListener(cancelListener);
        //设置居中
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
        //设置背景层透明度
        layoutParams.dimAmount = 0.2f;
        dialog.getWindow().setAttributes(layoutParams);
        dialog.show();
        return dialog;
    }

    /**
     * 当窗口焦点改变时使用
     * @param hasFocus
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        ImageView imageView = (ImageView) findViewById(R.id.loadingImageView);
        //获取ImageView上的动画背景
        AnimationDrawable loading = (AnimationDrawable) imageView.getBackground();
        //开始动画
        loading.start();
    }
}
