package mvc.android.com.mvc;

/**
 * Created by shuang on 2016/5/30.
 * 在最好的年华,寻找最真的自己!
 * 满天星斗.我继续前进.
 * 请求网络获取数据的接口
 */
public interface WeatherModel {
    void getWeather(String cityNumber,OnWeatherListener listener);

    interface OnWeatherListener {
        void onSuccess(String json);
        void onError(String error);
    }
}
