package com.sxzhwts.ticket.project.prenster;

import com.sxzhwts.ticket.common.api.ApiService;
import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.project.contract.VersonContract;
import com.sxzhwts.ticket.project.views.SelectSceneryActivity;

import javax.inject.Inject;

/**
 * 作者：fcy on 2018/4/16 10:52
 */

public class VersionPrenster implements VersonContract.Presenter{
    private ApiService apiService;
    private SelectSceneryActivity selectSceneryActivity;

    @Inject
    public VersionPrenster(ApiService apiService, BaseMvpActivity baseMvpActivity) {
        this.apiService = apiService;
        this.selectSceneryActivity = (SelectSceneryActivity) baseMvpActivity;

    }
   /* @Override
    public void getScenery(String clientToken) {
       apiService.getScenery(clientToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(selectSceneryActivity.bind2Lifecycle())
               .subscribe(new Consumer<SceneryResult>() {
                   @Override
                   public void accept(SceneryResult sceneryResult) throws Exception {
                       selectSceneryActivity.getScenerySucess(sceneryResult);
                   }
               }, new Consumer<Throwable>() {
                   @Override
                   public void accept(Throwable throwable) throws Exception {
                       throwable.printStackTrace();
                       Log.e("TAG","登录错误");
                       if (SystemUtil.isNetworkConnected()) {
                           selectSceneryActivity.showNoNet();
                       } else {
                           selectSceneryActivity.showError();
                       }
                   }
               });
    }*/

    @Override
    public void getVersion(String clientToken) {

    }
}
