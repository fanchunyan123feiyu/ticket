package com.sxzhwts.ticket.project.contract;

import com.sxzhwts.ticket.common.base.BaseContract;
import com.sxzhwts.ticket.project.bean.response.Result;

/**
 * 作者：fcy on 2018/4/14 14:27
 */

public interface ReasonSubmitContract extends BaseContract {
    interface View extends BaseView{
        void  submitSucess(Result result);
    }
    interface Presenter extends BasePresenter {
        void submit(String access_token, String order_id, String remark);
    }
}
