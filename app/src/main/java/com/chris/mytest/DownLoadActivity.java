package com.chris.mytest;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.chris.mytest.util.DownloadManagerUtil;

/**
 * Created by Chris on 2018/6/11.
 */

public class DownLoadActivity extends AppCompatActivity {

//    private Button button;
    private String url = "https://downpack.baidu.com/appsearch_AndroidPhone_v8.0.3(1.0.65.172)_1012271b.apk";
    private String title = "测试应用.apk";
    private String desc = "下载完成后，点击安装";

    private DownloadManagerUtil downloadManagerUtil;

    long downloadId = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load);
//        button = findViewById(R.id.download);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.download:
                downloadManagerUtil = new DownloadManagerUtil(this);
                if(downloadId != 0){
                    downloadManagerUtil.clearCurrentTask(downloadId);
                }
                downloadId = downloadManagerUtil.download(url,title,desc);
                break;
            default:
                break;
        }
    }
}
