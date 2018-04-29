package com.sxzhwts.ticket.project.contract;

import com.sxzhwts.ticket.common.base.BaseContract;
import com.sxzhwts.ticket.project.bean.response.HomeResulst;

/**
 * 作者：fcy on 2018/4/14 14:27
 */

public interface HomeContract extends BaseContract {
    interface View extends BaseView{
        void  getReadySureOrderSucess(HomeResulst homeResulst);
    }
    interface Presenter extends BasePresenter {
        void getReadySureOrder(String access_token,String resourceId);
    }
}
