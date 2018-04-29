package com.sxzhwts.ticket.project.contract;

import com.sxzhwts.ticket.common.base.BaseContract;
import com.sxzhwts.ticket.project.bean.response.Result;

/**
 * 作者：fcy on 2018/4/14 14:27
 */

public interface ChangePwdContract extends BaseContract {
    interface View extends BaseView{
        void  changeSucess(Result result);
    }
    interface Presenter extends BasePresenter {
        void changePwd(String admin_access_token,String old_password ,String new_password);
    }
}
