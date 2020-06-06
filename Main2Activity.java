package com.example.purpledocs_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.*;

public class Main2Activity extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE1", MODE_PRIVATE)
                .getBoolean("isFirstRun1", true);

        if (isFirstRun) {
            //show start activity
            //startActivity(new Intent(MainActivity.this, Overlay.class));
            dialog = new Dialog(Main2Activity.this, R.style.Theme_AppCompat_Translucent);
            dialog.setContentView(R.layout.activity_overlay2);

            TextView appointment = dialog.findViewById(R.id.appointment);
            appointment.setText("Tap to Book \n your Appointment");
            TextView notification = dialog.findViewById(R.id.notification);
            notification.setText("Tap to see \n new notifications");

            ImageView arrow1 = dialog.findViewById(R.id.arrow1);
            arrow1.setImageResource(R.drawable.arrow1_removebg);

            Animation animation1 =
                    AnimationUtils.loadAnimation(getApplicationContext(),
                            R.anim.blink);
            arrow1.startAnimation(animation1);

//            AnimationDrawable frameAnimation = (AnimationDrawable) arrow1.getBackground();
//            // Start the animation (looped playback by default).
//            frameAnimation.start();

            TextView add = dialog.findViewById(R.id.add);
            add.setText("Tap to add \n a patient");
            TextView queue = dialog.findViewById(R.id.queue);
            queue.setText("Patient Queue");
            ImageView arrow2 = dialog.findViewById(R.id.arrow2);
            arrow2.setImageResource(R.drawable.arrow2_removebg);

            ImageView arrow3 = dialog.findViewById(R.id.arrow3);
            arrow3.setImageResource(R.drawable.arrow3_removebg);
            Animation animation2 =
                    AnimationUtils.loadAnimation(getApplicationContext(),
                            R.anim.blink);
            arrow3.startAnimation(animation2);

            dialog.setCancelable(true);
            dialog.show();

        }

        getSharedPreferences("PREFERENCE1", MODE_PRIVATE).edit().putBoolean("isFirstRun1", false).commit();

    }
}
