package com.sxzhwts.ticket.common.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * 作者：fcy on 2018/4/13 15:16
 */

public interface BaseContract {
    interface BasePresenter {}

    interface BaseView {
        /**
         * 绑定生命周期
         *
         * @param <T>
         * @return
         */
        <T> LifecycleTransformer<T> bind2Lifecycle();

        //显示进度中
        void showLoading();

        //隐藏进度
        void hideLoading();

        //失败重试
        void showError();

        //数据为空
        void showEmpty();

        //显示当前网络不可用
        void showNoNet();

        void connectTime();

    }
}
