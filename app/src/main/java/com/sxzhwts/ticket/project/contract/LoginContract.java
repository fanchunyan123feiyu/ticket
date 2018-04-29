package com.sxzhwts.ticket.project.contract;

import com.sxzhwts.ticket.common.base.BaseContract;
import com.sxzhwts.ticket.project.bean.response.LoginResult;

/**
 * 作者：fcy on 2018/4/14 14:27
 */

public interface LoginContract extends BaseContract {
    interface View extends BaseView{
        void  loginSucess(LoginResult loginResult);
    }
    interface Presenter extends BasePresenter {
        void login(String account, String password, String clientToken );
    }
}
