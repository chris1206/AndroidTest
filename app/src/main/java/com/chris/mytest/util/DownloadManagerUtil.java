package com.chris.mytest.util;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;

/**
 * Created by Chris on 2018/6/11.
 */

public class DownloadManagerUtil {

    private Context context;

    public DownloadManagerUtil(Context context){
        this.context = context;
    }

    public long download(String url, String title, String desc) {

        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        //设置wifi下更新
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
        //下载中和下载后都显示通知栏
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        //使用系统默认的下载路径，此处为 /android/data/packages,所以兼容7.0
        request.setTitle(title);
        request.setDescription(desc);
        //设置类型为apk
        request.setMimeType("application/vnd.android.package-archive");
        //设置下载任务ID
        DownloadManager dm = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        assert dm != null;
        return dm.enqueue(request);

    }

    /**
     * 下载前先移除前一个任务，防止重复下载
     * @param downloadId
     */
    public void clearCurrentTask(long downloadId) {
        DownloadManager dm = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        try {
            dm.remove(downloadId);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }
}
