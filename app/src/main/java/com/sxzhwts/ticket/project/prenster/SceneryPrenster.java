package com.sxzhwts.ticket.project.prenster;

import android.util.Log;

import com.sxzhwts.ticket.common.api.ApiService;
import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.common.utils.SystemUtil;
import com.sxzhwts.ticket.project.bean.response.SceneryResult;
import com.sxzhwts.ticket.project.contract.SceneryContract;
import com.sxzhwts.ticket.project.views.SelectSceneryActivity;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：fcy on 2018/4/16 10:52
 */

public class SceneryPrenster implements SceneryContract.Presenter{
    private ApiService apiService;
    private SelectSceneryActivity selectSceneryActivity;

    @Inject
    public SceneryPrenster(ApiService apiService, BaseMvpActivity baseMvpActivity) {
        this.apiService = apiService;
        this.selectSceneryActivity = (SelectSceneryActivity) baseMvpActivity;

    }
    @Override
    public void getScenery(String clientToken) {
        selectSceneryActivity.showLoading();
       apiService.getScenery(clientToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(selectSceneryActivity.bind2Lifecycle())
               .subscribe(new Consumer<SceneryResult>() {
                   @Override
                   public void accept(SceneryResult sceneryResult) throws Exception {
                       selectSceneryActivity.hideLoading();
                       selectSceneryActivity.getScenerySucess(sceneryResult);
                   }
               }, new Consumer<Throwable>() {
                   @Override
                   public void accept(Throwable throwable) throws Exception {
                       throwable.printStackTrace();
                       Log.e("TAG","登录错误");
                       selectSceneryActivity.hideLoading();
                       if (SystemUtil.isNetworkConnected()) {
                           selectSceneryActivity.showNoNet();
                       } else {
                           selectSceneryActivity.showError();
                       }
                   }
               });
    }
}
