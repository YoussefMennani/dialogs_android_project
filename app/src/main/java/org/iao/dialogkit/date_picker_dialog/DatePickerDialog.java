package org.iao.dialogkit.date_picker_dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import org.iao.dialogkit.R;
import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DatePickerDialog extends AppCompatActivity implements android.app.DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_dialog);

        Button datePickerButton = (Button) findViewById(R.id.datePickerButton);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Locale.setDefault(Locale.FRENCH);
                DialogFragment  datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);

       /* String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        TextView dateTextView = (TextView) findViewById(R.id.dateText);
        dateTextView.setText(currentDateString);*/

        // Define the date format 1 pattern  23/07/2023
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        // Format the date using the specified pattern
        String formattedDate = sdf.format(c.getTime());

        TextView dateTextView1 = (TextView) findViewById(R.id.dateText1);
        dateTextView1.setText(formattedDate);


        // Define the date format pattern with French month names 14 décembre 2023
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMMM yyyy", Locale.FRENCH);

        // Format the date using the specified pattern
        formattedDate = sdf2.format(c.getTime());

        TextView dateTextView2 = (TextView) findViewById(R.id.dateText2);
        dateTextView2.setText(formattedDate);

    }
}