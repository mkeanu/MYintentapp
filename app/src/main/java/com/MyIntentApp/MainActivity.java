package com.MyIntentApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity =
                findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        Button btnMoveActivityData =
                findViewById(R.id.btn_move_activity_data);
        btnMoveActivityData.setOnClickListener(this);

        Button btnMoveActivityObject =
                findViewById(R.id.btn_move_activity_object);
        btnMoveActivityObject.setOnClickListener(this);

        Button btnDialNumber =
                findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);

        Button btnMoveActivityResult =
                findViewById(R.id.btn_move_with_result);
        btnMoveActivityResult.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;

            case R.id.btn_move_activity_data:
                Intent intent = new Intent(MainActivity.this, MoveActivity.class);
                intent.putExtra("data1", "somestring data");
                intent.putExtra("data2", "somestring data 2");
                startActivity(intent);
                break;

            case R.id.btn_move_activity_object:
                Person manusia = new Person("Aryo Djati", "aryodjati5@gmail.com", "Nganjuk", 17);
                Intent intent_object = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                intent_object.putExtra(MoveWithObjectActivity.EXTRA_PERSON, manusia);
                startActivity(intent_object);
                break;

            case R.id.btn_dial_number:
                String phoneNumber = "081210841382";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);
                break;

            case R.id.btn_move_with_result:
                Intent result = new Intent(MainActivity.this, MoveWithResultActivity.class);
                startActivity(result);
                break;

        }

    }
}