package com.sxzhwts.ticket.project.contract;

import com.sxzhwts.ticket.common.base.BaseContract;
import com.sxzhwts.ticket.project.bean.response.OrderResult;
import com.sxzhwts.ticket.project.bean.response.Result;

/**
 * 作者：fcy on 2018/4/14 14:27
 */

public interface OrderListContract extends BaseContract {
    interface AllOrderView extends BaseView{
        void  getOrderListSucess(OrderResult orderResult);
        void  verication(Result result);
        void  sure(Result result);
    }
    interface SureOrderView extends BaseView{
        void  getOrderListSucess(OrderResult orderResult);
        void  sure(Result result);
    }
    interface Presenter extends BasePresenter {
        void getOrderList(String clientToken,String resourceId,String state,String page);
        void verication(String clientToken,String orderid);
        void orderfirmyes(String clientToken,String orderid);
    }
}
