package com.example.purpledocs_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show start activity
            //startActivity(new Intent(MainActivity.this, Overlay.class));
            dialog = new Dialog(MainActivity.this, R.style.Theme_AppCompat_Translucent);
            dialog.setContentView(R.layout.activity_overlay);

            TextView textView1 = dialog.findViewById(R.id.textView);
            textView1.setText("Quick Tips");
            TextView textView2 = dialog.findViewById(R.id.textView3);
            textView2.setText("TAP TO DISMISS");
            ImageView imageView = dialog.findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.ic_arrow_downward_black_24dp);
            TextView textView3 = dialog.findViewById(R.id.textView2);
            textView3.setText("Forgot Password");
            dialog.setCancelable(true);
            dialog.show();

        }

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.settings_menu, menu);
        return true;
    }
}
