package com.example.ou.hight04;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    int i = 0;

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("服务开启，数字为：", i + "");
        i++;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("服务关闭，数字最后为：", i + "");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        Book book = intent.getParcelableExtra("book");
        Log.v("Book is",book.getId()+"*********"+book.getName());
        return new MyBind();
    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return super.bindService(service, conn, flags);
    }

    class MyBind extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }
}
