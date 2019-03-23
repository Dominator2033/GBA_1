package android_1.geekbrains.ru.lesson4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // установка прозрачного статус бара и панели навигации
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        // передача названия города
        TextView textView = (TextView) findViewById(R.id.city);
        textView.setText(getIntent().getExtras().getString("city"));

        // показать или скрыть температуру
        showTemp();
        // показать или скрыть скорость ветра
        showSpeedWind();
        // показать или скрыть влажность
        showWetness();
        // показать дождь
        showRain();
        // показать солнце
        showSun();
        // вывод текущей даты
        Date systemDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE dd MMM HH:MM", Locale.ENGLISH);
        TextView textDate = (TextView) findViewById(R.id.date_id);
        textDate.setText(simpleDateFormat.format(systemDate));
    }

    // Показать влажность
    public void showWetness() {
        TextView wetness = (TextView) findViewById(R.id.wetness);
        String wet = getIntent().getExtras().getString("wetness");

        if (wet.equals("View.VISIBLE")) {
            wetness.setVisibility(View.VISIBLE);
        } else {
            wetness.setVisibility(View.INVISIBLE);
        }
    }

    // Показать скорость ветра
    public void showSpeedWind() {
        TextView wind = (TextView) findViewById(R.id.wind_speed);
        String windSpeed = getIntent().getExtras().getString("wind");

        if (windSpeed.equals("View.VISIBLE")) {
            wind.setVisibility(View.VISIBLE);
        } else {
            wind.setVisibility(View.INVISIBLE);
        }
    }

    // Будет ли дождь?
    public void showRain() {
        TextView rain = (TextView) findViewById(R.id.rain_id);
        String str = getIntent().getExtras().getString("rain");
        ImageView imageRain = (ImageView) findViewById(R.id.rain_image);
        if (str.equals("View.VISIBLE")) {
            rain.setVisibility(View.VISIBLE);
            imageRain.setVisibility(View.VISIBLE);
        } else {
            rain.setVisibility(View.INVISIBLE);
            imageRain.setVisibility(View.INVISIBLE);
        }
    }

    // Солнце
    public void showSun() {
        TextView sun = (TextView) findViewById(R.id.sun_id);
        String str = getIntent().getExtras().getString("sun");
        ImageView imageSun = (ImageView) findViewById(R.id.sun_image);
        if (str.equals("View.VISIBLE")) {
            sun.setVisibility(View.VISIBLE);
            imageSun.setVisibility(View.VISIBLE);
        } else {
            sun.setVisibility(View.INVISIBLE);
            imageSun.setVisibility(View.INVISIBLE);
        }
    }

    // Показать температуру
    public void showTemp() {
        TextView tempVis = (TextView) findViewById(R.id.temp);
        TextView tempDay = (TextView) findViewById(R.id.day);
        View view = (View) findViewById(R.id.view);
        TextView tempNight = (TextView) findViewById(R.id.night);

        String s = getIntent().getExtras().getString("temp");

        if (s.equals("View.VISIBLE")) {
            tempVis.setVisibility(View.VISIBLE);
            tempDay.setVisibility(View.VISIBLE);
            tempNight.setVisibility(View.VISIBLE);
            view.setVisibility(View.VISIBLE);
        } else {
            tempVis.setVisibility(View.INVISIBLE);
            tempDay.setVisibility(View.INVISIBLE);
            tempNight.setVisibility(View.INVISIBLE);
            view.setVisibility(View.INVISIBLE);
        }
    }
}
