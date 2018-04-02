package ro.pub.cs.systems.eim.lab03.phonedialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends AppCompatActivity {
    EditText editText;

    private class ButtonClickListner implements Button.OnClickListener{

        @Override
        public void onClick(View view) {
            editText.setText(editText.getText().toString() + ((Button)view).getText().toString());
        }
    }

    private class ButtonDeleteClickListner implements ImageButton.OnClickListener{

        @Override
        public void onClick(View view) {
            editText.setText(editText.getText().toString().substring(0,editText.getText().length()-1));
        }
    }

    private class ButtonHungUpClickListner implements ImageButton.OnClickListener{

        @Override
        public void onClick(View view) {
            finish();
        }
    }

    private class ButtonCalllickListner implements ImageButton.OnClickListener{

        @Override
        public void onClick(View view) {
            if (ContextCompat.checkSelfPermission(PhoneDialerActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        PhoneDialerActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        1);
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + editText.getText().toString()));
                startActivity(intent);
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_phone_dialer);
        editText = (EditText) findViewById(R.id.editText);
        Button zero = (Button) findViewById(R.id.button0);
        zero.setOnClickListener(new ButtonClickListner());
        Button one = (Button) findViewById(R.id.button1);
        one.setOnClickListener(new ButtonClickListner());
        Button two = (Button) findViewById(R.id.button2);
        two.setOnClickListener(new ButtonClickListner());
        Button three = (Button) findViewById(R.id.button3);
        three.setOnClickListener(new ButtonClickListner());
        Button four = (Button) findViewById(R.id.button4);
        four.setOnClickListener(new ButtonClickListner());
        Button five = (Button) findViewById(R.id.button5);
        five.setOnClickListener(new ButtonClickListner());
        Button six = (Button) findViewById(R.id.button6);
        six.setOnClickListener(new ButtonClickListner());
        Button seven = (Button) findViewById(R.id.button7);
        seven.setOnClickListener(new ButtonClickListner());
        Button eight = (Button) findViewById(R.id.button8);
        eight.setOnClickListener(new ButtonClickListner());
        Button nine = (Button) findViewById(R.id.button9);
        nine.setOnClickListener(new ButtonClickListner());
        Button star = (Button) findViewById(R.id.button_star);
        star.setOnClickListener(new ButtonClickListner());
        Button hashtag = (Button) findViewById(R.id.button_hashtag);
        hashtag.setOnClickListener(new ButtonClickListner());
        ImageButton delete = (ImageButton) findViewById(R.id.clear_button);
        delete.setOnClickListener(new ButtonDeleteClickListner());
        ImageButton call = (ImageButton) findViewById(R.id.call_button);
        call.setOnClickListener(new ButtonCalllickListner());
        ImageButton hungUp = (ImageButton) findViewById(R.id.hangup_button);
        hungUp.setOnClickListener(new ButtonHungUpClickListner());


    }
}
