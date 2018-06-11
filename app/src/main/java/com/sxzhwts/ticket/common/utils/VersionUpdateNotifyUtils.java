package com.sxzhwts.ticket.common.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.sxzhwts.ticket.common.api.TokenService;
import com.sxzhwts.ticket.common.http.UrlManger;
import com.sxzhwts.ticket.common.utils.okhttp.DownloadProgressHandler;
import com.sxzhwts.ticket.common.utils.okhttp.ProgressHelper;
import com.sxzhwts.ticket.project.bean.response.VersionResult;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fcy on 2017/10/18.
 * 版本号比较
 */

public class VersionUpdateNotifyUtils {
    private Activity activity;
    private NotificationManager notificationManager;
    private NotificationCompat.Builder ntfBuilder;
    private  int DOWNLOAD_NOTIFICATION_ID=1000;
    public VersionUpdateNotifyUtils(Activity activity) {
        this.activity = activity;
    }

    //检查是否有新版本
    public void checkVersion(String token) {
        RetrofitUtils.getRetrofitInstance(UrlManger.server_api_url)
                .create(TokenService.class)
                .getVersion(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<VersionResult>() {
                    @Override
                    public void accept(VersionResult versionResult) throws Exception {
                        Log.e("TAG", "版本更新" + versionResult.toString());
                        if (versionResult.code == 1) {
                            if (VersionUtils.compareVersion(versionResult.data.version, VersionUtils.getVersionName(activity)) == 1) {//有新版本
                                Log.e("TAG", "有新版本" );
                                switch (versionResult.data.force_update) {
                                    case "1"://强制更新
                                        new AlertDialog.Builder(activity).setTitle("版本更新").setMessage("版本号：" + versionResult.data.version).setPositiveButton("立即更新", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                                updateVersion(versionResult.data.apk_url, true);
                                            }
                                        }).setCancelable(false).create().show();
                                        break;
                                    case "0"://非强制更新
                                        new AlertDialog.Builder(activity).setTitle("版本更新").setMessage("版本号：" + versionResult.data.version).setPositiveButton("立即更新", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                                updateVersion(versionResult.data.apk_url, true);
                                            }
                                        }).setNegativeButton("下次再说", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                            }
                                        }).setCancelable(false).create().show();
                                        break;
                                    default:
                                }
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        Log.e("TAG", "版本更新失败token"+token);
                    }
                });

    }

    private void updateVersion(String apkurl, final boolean isForceUpdate) {
        Log.e("TAG", "版本更新" + apkurl);
       /* final ProgressDialog dialog = new ProgressDialog(activity);
        dialog.setProgressNumberFormat("%1d KB/%2d KB");
        dialog.setTitle("下载");
        dialog.setMessage("正在下载，请稍后...");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setCancelable(false);
        dialog.show();*/

        ProgressHelper.setProgressHandler(new DownloadProgressHandler() {
            @Override
            protected void onProgress(long bytesRead, long contentLength, boolean done) {
                Log.e("是否在主线程中运行", String.valueOf(Looper.getMainLooper() == Looper.myLooper()));
                Log.e("onProgress", String.format("%d%% done\n", (100 * bytesRead) / contentLength));
                Log.e("done", "--->" + String.valueOf(done));
               /* dialog.setMax((int) (contentLength / 1024));
                dialog.setProgress((int) (bytesRead / 1024));
                if (done) {
                    dialog.dismiss();
                }*/
                int process=(int) (bytesRead / 1024)/(int) (contentLength / 1024);
                showDownloadNotificationUI((int)((100 * bytesRead) / contentLength));

            }
        });

        OkHttpClient.Builder builder = ProgressHelper.addProgress(null);
        TokenService tokenService = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(UrlManger.server_api_url)
                .client(builder.build())
                .build().create(TokenService.class);
        tokenService.downloadApk(apkurl)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
                        writeFileToDisk(response, isForceUpdate);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                    }
                });
    }
    private void showDownloadNotificationUI( int progress) {
           String s=String.format("%d%% \n", progress);
            String contentText = new StringBuffer().append(SystemUtil.getAppName(activity) + "  ")
                    .append(s).toString();

            PendingIntent contentIntent = PendingIntent.getActivity(activity,
                    0, new Intent(), PendingIntent.FLAG_CANCEL_CURRENT);
            if (notificationManager == null) {
                notificationManager = (NotificationManager) activity
                        .getSystemService(Context.NOTIFICATION_SERVICE);
            }
            if (ntfBuilder == null) {
                ntfBuilder = new NotificationCompat.Builder(activity)
                        .setSmallIcon(activity.getApplicationInfo().icon)
                        .setTicker("开始下载...").setContentIntent(contentIntent).setAutoCancel(true);
            }
            ntfBuilder.setContentText(contentText);
            ntfBuilder.setProgress(100, progress, false);
            notificationManager.notify(DOWNLOAD_NOTIFICATION_ID,
                    ntfBuilder.build());


    }
    private void writeFileToDisk(final Response<ResponseBody> response, boolean isForceUpdate) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ) {
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    try {
                        InputStream is = response.body().byteStream();
                        File file = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".apk");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileOutputStream fos = new FileOutputStream(file);
                        BufferedInputStream bis = new BufferedInputStream(is);
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = bis.read(buffer)) != -1) {
                            fos.write(buffer, 0, len);
                            fos.flush();
                        }
                        fos.close();
                        bis.close();
                        is.close();
                        installApk(activity, file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            }.execute();
        } else {
            Toast.makeText(activity, "没有发现sd卡，请安装后重试！", Toast.LENGTH_SHORT).show();
        }

    }

    public static void installApk(Activity activity, File t) {
        activity.startActivity(installIntent(activity,t));
        activity.finish();

    }

    @NonNull
    private static Intent installIntent(Activity activity, File t) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory("android.intent.category.DEFAULT");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {    //判断版本是否在7.0以上
            Uri uriForFile = FileProvider.getUriForFile(activity, "com.sxzhwts.ticket.FileProvider", t);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);  //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.setDataAndType(uriForFile, activity.getContentResolver().getType(uriForFile));
           // intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(t), getMIMEType(t));
            //intent.setDataAndType(Uri.fromFile(t), "application/vnd.android.package-archive");
        }
        return intent;
    }

    public static String getMIMEType(File file) {
        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase();//获取文件名的后缀
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
    }
}
