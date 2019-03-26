package android_1.geekbrains.ru.lesson4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private String str;
    private Switch aSwitch;
    private Switch rainSwitch;
    private Switch sunSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // установка прозрачного статус бара и панели навигации
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        setSunSwitch();
        setRainSwitch();
        addCity();
    }

    private void addCity() {
        Button sendButton = (Button) findViewById(R.id.send_btn);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editCityText);
                str = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                windSpeed(intent);
                rainSwitch(intent);
                sunSwitch(intent);
                wetnessSwitch(intent);
                showTemp(intent);
                checkBtn(editText, intent);
            }
        });
    }

    public void checkBtn(EditText editText, Intent intent) {
        // Проверка на введенное значение, если поле пустое, то уведомление
        if (editText.getText().toString().equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(getResources().getString(R.string.attention));
            builder.setMessage(getResources().getString(R.string.fill_field));
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else {
            intent.putExtra(getResources().getString(R.string.city_show), str);
            startActivity(intent);
        }
    }

    public void showTemp(Intent intent) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        if (checkBox.isChecked()) {
            intent.putExtra(getResources().getString(R.string.temp_show), "View.VISIBLE");
        } else {
            intent.putExtra(getResources().getString(R.string.temp_show), "View.INVISIBLE");
        }
    }

    public void wetnessSwitch(Intent intent) {
        aSwitch = (Switch) findViewById(R.id.switch_for_wetness);
        if (aSwitch.isChecked()) {
            intent.putExtra(getResources().getString(R.string.wetness_show), "View.VISIBLE");
        } else {
            intent.putExtra(getResources().getString(R.string.wetness_show), "View.INVISIBLE");
        }
    }

    public void rainSwitch(Intent intent) {
        if (rainSwitch.isChecked()) {
            intent.putExtra(getResources().getString(R.string.rain_show), "View.VISIBLE");
        } else {
            intent.putExtra(getResources().getString(R.string.rain_show), "View.INVISIBLE");
        }
    }

    public void sunSwitch(Intent intent) {
        if (sunSwitch.isChecked()) {
            intent.putExtra(getResources().getString(R.string.sun_show), "View.VISIBLE");
        } else {
            intent.putExtra(getResources().getString(R.string.sun_show), "View.INVISIBLE");
        }
    }

    public void setSunSwitch() {
        sunSwitch = (Switch) findViewById(R.id.switch_for_sun);
        sunSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sunSwitch.isChecked()) {
                    rainSwitch.setChecked(false);
                }
            }
        });
    }

    public void setRainSwitch() {
        rainSwitch = (Switch) findViewById(R.id.switch_for_rain);
        rainSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (rainSwitch.isChecked()) {
                    sunSwitch.setChecked(false);
                }
            }
        });
    }

    public void windSpeed(Intent intent) {
        aSwitch = (Switch) findViewById(R.id.switch_for_speed);
        if (aSwitch.isChecked()) {
            intent.putExtra(getResources().getString(R.string.wind_show), "View.VISIBLE");
        } else {
            intent.putExtra(getResources().getString(R.string.wind_show), "View.INVISIBLE");
        }
    }
}
