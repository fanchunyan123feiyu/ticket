package com.sxzhwts.ticket.project.contract;

import com.sxzhwts.ticket.common.base.BaseContract;
import com.sxzhwts.ticket.project.bean.response.SceneryResult;

/**
 * 作者：fcy on 2018/4/14 14:27
 */

public interface SceneryContract extends BaseContract {
    interface View extends BaseView{
        void  getScenerySucess(SceneryResult sceneryResult);
    }
    interface Presenter extends BasePresenter {
        void getScenery(String clientToken);
    }
}
