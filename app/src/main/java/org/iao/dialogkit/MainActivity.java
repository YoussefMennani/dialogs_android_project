package org.iao.dialogkit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.iao.dialogkit.date_picker_dialog.DatePickerDialog;

public class MainActivity extends AppCompatActivity {

    Button alertDialogButton;
    AlertDialog.Builder dialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AlertDialog(View view){
        dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("AlertDialog")
                .setMessage("voulez vous fermer l'application ?")
                .setCancelable(true)
                .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();


        Toast.makeText(this,"hello",Toast.LENGTH_LONG).show();


    }

    public void ProgressDialog(View view){
        MyTask myTask = new MyTask(this); // 'this' refers to the activity or fragment context
        myTask.execute();
    }


    public void DatePickerDialog(View view){
        Intent intent = new Intent(MainActivity.this, DatePickerDialog.class);
        startActivity(intent);
    }
}