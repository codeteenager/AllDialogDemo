package com.codeteenager.alldialoglib;

import android.content.Context;
import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by codeteenager on 2017/11/22.
 */

class AlertController {
    private AlertDialog mDialog;
    private Window mWindow;
    private DialogViewHelper dialogViewHelper;

    public AlertController(AlertDialog dialog, Window window) {
        this.mDialog = dialog;
        this.mWindow = window;
    }

    /**
     * 设置文本
     *
     * @param viewId
     * @param text
     */
    public void setText(int viewId, CharSequence text) {
        dialogViewHelper.setText(viewId, text);
    }

    public <T extends View> T getView(int viewId) {
        return dialogViewHelper.getView(viewId);
    }

    /**
     * 设置点击事件
     *
     * @param viewId
     * @param listener
     */
    public void setOnClickListener(int viewId, View.OnClickListener listener) {
        dialogViewHelper.setOnClickListener(viewId, listener);
    }

    public void setDialogViewHelper(DialogViewHelper dialogViewHelper) {
        this.dialogViewHelper = dialogViewHelper;
    }

    public AlertDialog getDialog() {
        return mDialog;
    }

    public Window getWindow() {
        return mWindow;
    }

    public static class AlertParams {
        public Context mContext;
        public int mThemeResId;
        //点击空白是否能够取消
        public boolean mCancelable = true;
        //dialog Cancel 监听
        public DialogInterface.OnCancelListener mOnCancelListener;
        //dialog Dismiss 监听
        public DialogInterface.OnDismissListener mOnDismissListener;
        //dialog Key 监听
        public DialogInterface.OnKeyListener mOnKeyListener;
        //显示的布局
        public View mView;
        //布局id
        public int mViewLayoutResId;

        //存放字体的修改
        public SparseArray<CharSequence> mTextArray = new SparseArray<>();

        //存放点击事件
        public SparseArray<View.OnClickListener> mListenerArray = new SparseArray<>();
        //宽度
        public int mWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
        //高度
        public int mHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
        //动画
        public int mAnimations = 0;
        //位置
        public int mGravity = Gravity.CENTER;

        public AlertParams(Context context, int themeResId) {
            this.mContext = context;
            this.mThemeResId = themeResId;
        }

        /**
         * 绑定和设置参数
         *
         * @param mAlert
         */
        public void apply(AlertController mAlert) {
            DialogViewHelper dialogViewHelper = null;
            //设置布局 DialogViewHelper
            if (mViewLayoutResId != 0) {
                dialogViewHelper = new DialogViewHelper(mContext, mViewLayoutResId);
            }
            if (mView != null) {
                dialogViewHelper = new DialogViewHelper();
                dialogViewHelper.setContentView(mView);
            }

            if (dialogViewHelper == null) {
                throw new IllegalArgumentException("请设置布局setContentView()");
            }
            //给Dialog设置布局
            mAlert.getDialog().setContentView(dialogViewHelper.getContentView());
            //设置Controller辅助类
            mAlert.setDialogViewHelper(dialogViewHelper);
            //设置文本
            int textArraySize = mTextArray.size();
            for (int i = 0; i < textArraySize; i++) {
                mAlert.setText(mTextArray.keyAt(i), mTextArray.valueAt(i));
            }
            //设置点击事件
            int listenerArraySize = mListenerArray.size();
            for (int i = 0; i < listenerArraySize; i++) {
                mAlert.setOnClickListener(mListenerArray.keyAt(i), mListenerArray.valueAt(i));
            }

            //配置默认效果
            Window window = mAlert.getWindow();
            //设置位置
            window.setGravity(mGravity);
            if (mAnimations != 0) {
                //设置动画
                window.setWindowAnimations(mAnimations);
            }
            //设置宽高
            WindowManager.LayoutParams params = window.getAttributes();
            params.width = mWidth;
            params.height = mHeight;
            window.setAttributes(params);
        }
    }
}
