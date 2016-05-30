package mvc.android.com.mvc;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

/**
 * Created by shuang on 2016/5/30.
 * 在最好的年华,寻找最真的自己!
 * 满天星斗.我继续前进.
 * 从网络获取数据的接口实现
 */
public class WeatherModeImpl implements WeatherModel {
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

        }
    };
    @Override
    public void getWeather(final String cityNumber, final OnWeatherListener listener) {
      new Thread(){
          @Override
          public void run() {
              try {
                  Thread.sleep(2000);
                  mHandler.post(new Runnable() {
                      @Override
                      public void run() {
                          if(TextUtils.isEmpty(cityNumber)){
                              listener.onError("失败");
                          }else {
                              listener.onSuccess(cityNumber);
                          }

                      }
                  });
              } catch (InterruptedException e) {
                  listener.onError("失败");
                  e.printStackTrace();
              }
          }
      }.start();
    }
}
