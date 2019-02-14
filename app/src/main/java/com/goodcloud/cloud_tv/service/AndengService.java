package com.goodcloud.cloud_tv.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.goodcloud.cloud_tv.entity.Andeng;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static android.content.ContentValues.TAG;
import static com.goodcloud.cloud_tv.MainActivity.ANDENG_INFO;
import static com.goodcloud.cloud_tv.MainActivity.ANDENG_NULL;

/**
 * 生产信息服务类
 */
public class AndengService extends IntentService {

    //192.168.1.47:8080/houfeng  厚丰现场IP
    //private String url = "http://39.104.147.177/houfeng/core/board/search.html";
    private String url = "http://192.168.16.16:8080/houfeng/display/getTriggerInfo.html";
    private Gson gson;

    private String[] areaName = new String[100];//"区域名称
    private String[] arriveTime = new String[100];//到达时间
    private String[] arriveUserName = new String[100];//"到达人员名称
    private String[] triggerName = new String[100];//触发终端名称
    private int[] value = new int[100];//对应按钮值(1:故障,2:缺料,3:调机)
    private int[] buttonAttrInfoId = new int[100];//按钮信息id  (1:故障,2:缺料,3:调机)
    private String[] confirmCompleteUserName = new String[100];//确认完成用户id
    private Long[] lastChangeTime = new Long[100];//数据最后一次改变时间


    public AndengService(String name) {
        super(name);
    }
    public AndengService() {
        super("AndengService");
    }



    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        request();//请求借口
    }
    private void request(){
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String str;
            while ((str = reader.readLine())!=null){
                sb.append(str);
//                Log.e(TAG, "请求信息: "+sb.toString());
            }
            if("[]".equals(sb.toString())){
                Intent intent = new Intent();
                intent.setAction(ANDENG_NULL);
                sendBroadcast(intent);
//                Log.e(TAG, "请求信息 没有安灯: "+sb.toString());
            }else{
                Intent intent = new Intent();
                intent.setAction(ANDENG_INFO);
                Log.e(TAG, "请求信息 : "+sb.toString());
                gson = new Gson();
                List list = gson.fromJson(sb.toString(),List.class);
                for(int i = 0;i<list.size();i++){
                    String ss = gson.toJson(list.get(i));
                    Andeng andeng = gson.fromJson(ss,Andeng.class);
//                    Log.e(TAG, "请求信息: "+andeng.getAreaName());
                    areaName[i] = andeng.getAreaName();
                    arriveTime[i] = andeng.getLastChangeTime()+"";
                    arriveUserName[i] = andeng.getArriveUserName();
                    triggerName[i] = andeng.getTriggerName();
                    value[i] = andeng.getValue();
                }
                intent.putExtra("areaName",areaName);
                intent.putExtra("arriveTime",arriveTime);
                intent.putExtra("arriveUserName",arriveUserName);
                intent.putExtra("triggerName",triggerName);
                intent.putExtra("value",value);
                sendBroadcast(intent);
//                Log.e(TAG, "request: 广播"+value[0] );
            }

//            List list = workData.getRows();
//            Intent intent = new Intent();
//            if(list.size()>0){
//                for(int i = 0;i < list.size();i ++){
//                    String ss = gson.toJson(list.get(i));
//                    WorkData w = gson.fromJson(ss,WorkData.class);
//                    machineName[i] = w.getMachineName()+"";
//                    workShiftName[i] = w.getWorkShiftName()+"";
//                    userName[i] = w.getUserName()+"";
//                    code[i] = w.getCode()+"";
//                    productName[i] = w.getProductName()+"";
//                    //对计划数 下线数 生产状态做非空判断
//                    if(w.getPlanNum() != null){
//                        planNum[i] = w.getPlanNum();
//                    }else{
//                        planNum[i] = 0;
//                    }
//                    if(w.getReallyNum() != null){
//                        reallyNum[i] = w.getReallyNum();
//                    }else{
//                        reallyNum[i] = 0;
//                    }
//                    if(w.getStatus() != null){
//                        status[i] = w.getStatus();
//                    }else {
//                        status[i] = 0;
//                    }
//
//                }
//                //发广播
//                intent.setAction(WORKDATA);
//                intent.putExtra("machineName",machineName);
//                intent.putExtra("workShiftName",workShiftName);
//                intent.putExtra("userName",userName);
//                intent.putExtra("code",code);
//                intent.putExtra("productName",productName);
//                intent.putExtra("planNum",planNum);
//                intent.putExtra("reallyNum",reallyNum);
//                intent.putExtra("status",status);
//                sendBroadcast(intent);
//            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}
