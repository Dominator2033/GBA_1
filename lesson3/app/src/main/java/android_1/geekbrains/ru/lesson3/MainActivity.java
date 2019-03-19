package android_1.geekbrains.ru.lesson3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.Telephony.Mms.Part.TEXT;

public class MainActivity extends AppCompatActivity {

    private String str;
    private CheckBox checkBox;
    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // установка прозрачного статус бара и панели навигации
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // Добавление города
        Button sendButton = (Button) findViewById(R.id.send_btn);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editText);
                str = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // Скорость ветра начало
                aSwitch = (Switch) findViewById(R.id.switch3);
                if (aSwitch.isChecked()) {
                    intent.putExtra("wind", "View.VISIBLE");
                } else {
                    intent.putExtra("wind", "View.INVISIBLE");
                }
                // Скорость ветра конец

                // Влажность начало
                aSwitch = (Switch) findViewById(R.id.switch4);
                if (aSwitch.isChecked()) {
                    intent.putExtra("wetness", "View.VISIBLE");
                } else {
                    intent.putExtra("wetness", "View.INVISIBLE");
                }
                // Влажность конец

                // Показать температуру начало
                checkBox = (CheckBox) findViewById(R.id.checkBox);
                if (checkBox.isChecked()) {
                    intent.putExtra("temp", "View.VISIBLE");
                } else {
                    intent.putExtra("temp", "View.INVISIBLE");
                }
                // Показать температуру конец

                // Проверка на введенное значение, если поле пустое, то уведомление
                if (editText.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Внимание!");
                    builder.setMessage("Заполните поле город!");
                    builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else {
                    intent.putExtra("city", str);
                    startActivity(intent);
                }
            }
        });
    }
}
