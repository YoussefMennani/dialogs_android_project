package org.iao.dialogkit.custom_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.iao.dialogkit.R;

public class CustomDialog extends AppCompatActivity implements ExampleDialogListener {

    TextView username,password;
    Button openCostumDialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        username = findViewById(R.id.usernameTextView);
        password = findViewById(R.id.passwordTextView);

        openCostumDialogBtn = findViewById(R.id.openCustomDialogBtn);
        openCostumDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomDialog();
            }
        });
    }

    public void openCustomDialog(){
        ExempleCustomDialog exempleCustomDialog = new ExempleCustomDialog();
        exempleCustomDialog.show(getSupportFragmentManager()," Custom Dialog");
    }

    @Override
    public void applyTexts(String myUsername, String myPassword) {
        this.username.setText(myUsername);
        this.password.setText(myPassword);
    }
}