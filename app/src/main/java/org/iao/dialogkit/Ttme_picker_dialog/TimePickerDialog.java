package org.iao.dialogkit.Ttme_picker_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import org.iao.dialogkit.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import android.app.TimePickerDialog.OnTimeSetListener;
public class TimePickerDialog extends AppCompatActivity implements OnTimeSetListener {
    Button openTimePickerButton;
    TextView timeTextView1,timeTextView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_dialog);

        openTimePickerButton = findViewById(R.id.datePickerButton);
        timeTextView1 = findViewById(R.id.heureText1);
        timeTextView2 = findViewById(R.id.heureText2);
        openTimePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerFragment timePickerFragment = new TimePickerFragment();
                timePickerFragment.show(getSupportFragmentManager(),"Time Picker Dialog");
            }
        });
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Convert the 24-hour
        timeTextView1.setText("Hour : "+hourOfDay+" H "+minute+" mn");

        // Convert the 12-hour format to AM/PM format
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String formattedTime = sdf.format(calendar.getTime());

        timeTextView2.setText("Time: " + formattedTime);
    }
}