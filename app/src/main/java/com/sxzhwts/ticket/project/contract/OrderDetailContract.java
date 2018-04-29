package com.sxzhwts.ticket.project.contract;

import com.sxzhwts.ticket.common.base.BaseContract;
import com.sxzhwts.ticket.project.bean.response.BusOrderDetailResult;
import com.sxzhwts.ticket.project.bean.response.Result;

/**
 * 作者：fcy on 2018/4/14 14:27
 */

public interface OrderDetailContract extends BaseContract {
    interface View extends BaseView{
        void  getBusOrderDetailSucess(BusOrderDetailResult busOrderDetailResult);
        void  verication(Result result);
        void  sureTicket(Result result);
    }
    interface Presenter extends BasePresenter {
        void getOrderDetailById(String clientToken, String order_id);
        void getOrderDetailByOrderCode(String clientToken, String ordercode);
        void verication(String clientToken, String order_id);
        void sureOutTicket(String clientToken, String order_id);

    }
}
