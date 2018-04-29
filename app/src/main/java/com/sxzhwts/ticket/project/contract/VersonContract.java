package com.sxzhwts.ticket.project.contract;

import com.sxzhwts.ticket.common.base.BaseContract;
import com.sxzhwts.ticket.project.bean.response.VersionResult;

/**
 * 作者：fcy on 2018/4/14 14:27
 */

public interface VersonContract extends BaseContract {
    interface View extends BaseView{
        void  getVersionSucess(VersionResult sceneryResult);
    }
    interface Presenter extends BasePresenter {
        void getVersion(String clientToken);
    }
}
