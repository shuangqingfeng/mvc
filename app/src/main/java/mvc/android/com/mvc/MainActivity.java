package mvc.android.com.mvc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener ,WeatherModel.OnWeatherListener {

    private EditText mInputName;
    private Button mQuery;
    private TextView mVisibleName;
    private WeatherModel weatherModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        weatherModel = new WeatherModeImpl();
    }

    private void initView() {
        mInputName = findView(R.id.inputName_et);
        mQuery = findView(R.id.query);
        mVisibleName = findView(R.id.visibleName_tv);
        mQuery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.query:
            weatherModel.getWeather(mInputName.getText().toString(),this);
                break;
        }
    }



    @Override
    public void onSuccess(String json) {
        mVisibleName.setText(json);
    }

    @Override
    public void onError(String error) {
        mVisibleName.setText(error);
    }

    /**
     * 通用型 findViewById  减少重复的类型转换
     */
    public <T extends View> T findView(int id) {
        try {
            return (T) findViewById(id);
        } catch (ClassCastException e) {
            throw new ClassCastException("id cast View Exception");
        }

    }
}
