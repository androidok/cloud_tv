package com.goodcloud.cloud_tv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * APP开机自启动
 */
public class MyReceiver extends BroadcastReceiver
{
    public MyReceiver()
    { }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
        {
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
