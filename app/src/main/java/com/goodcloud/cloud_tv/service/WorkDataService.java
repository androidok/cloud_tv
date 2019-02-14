package com.goodcloud.cloud_tv.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.goodcloud.cloud_tv.entity.WorkData;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.goodcloud.cloud_tv.MainActivity.WORKDATA;


/**
 * 生产信息服务类
 */
public class WorkDataService extends IntentService {

    //192.168.1.47:8080/houfeng  厚丰现场IP
    //private String url = "http://39.104.147.177/houfeng/core/board/search.html";
    private String url = "http://192.168.1.47:8080/houfeng/core/board/search.html";
    private Gson gson;
    private String[] machineName = new String[17];//线体
    private String[] workShiftName = new String[17];//班次
    private String[] userName = new String[17];//产线负责人
    private String[] code = new String[17];//产品编号
    private String[] productName = new String[17];//产品名称
    private int[] planNum = new int[17];//计划数
    private int[] reallyNum = new int[17];//下线数
    private String difference;//差额 activity中计算
    private String completionRate;//完成率 acvitity中计算
    private int[] status = new int[17];//生产状态

    public WorkDataService(String name) {
        super(name);
    }
    public WorkDataService() {
        super("WorkDataService");
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
            gson = new Gson();
            WorkData workData = gson.fromJson(sb.toString(),WorkData.class);
            List list = workData.getRows();
            Intent intent = new Intent();
            if(list.size()>0){
                for(int i = 0;i < list.size();i ++){
                    String ss = gson.toJson(list.get(i));
                    WorkData w = gson.fromJson(ss,WorkData.class);
                    machineName[i] = w.getMachineName()+"";
                    workShiftName[i] = w.getWorkShiftName()+"";
                    userName[i] = w.getUserName()+"";
                    code[i] = w.getCode()+"";
                    productName[i] = w.getProductName()+"";
                    //对计划数 下线数 生产状态做非空判断
                    if(w.getPlanNum() != null){
                        planNum[i] = w.getPlanNum();
                    }else{
                        planNum[i] = 0;
                    }
                    if(w.getReallyNum() != null){
                        reallyNum[i] = w.getReallyNum();
                    }else{
                        reallyNum[i] = 0;
                    }
                    if(w.getStatus() != null){
                        status[i] = w.getStatus();
                    }else {
                        status[i] = 0;
                    }

                }
                //发广播
                intent.setAction(WORKDATA);
                intent.putExtra("machineName",machineName);
                intent.putExtra("workShiftName",workShiftName);
                intent.putExtra("userName",userName);
                intent.putExtra("code",code);
                intent.putExtra("productName",productName);
                intent.putExtra("planNum",planNum);
                intent.putExtra("reallyNum",reallyNum);
                intent.putExtra("status",status);
                sendBroadcast(intent);
            }
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
