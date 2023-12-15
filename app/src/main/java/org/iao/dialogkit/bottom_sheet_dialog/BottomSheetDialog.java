package org.iao.dialogkit.bottom_sheet_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import org.iao.dialogkit.R;

public class BottomSheetDialog extends AppCompatActivity {

    Button buttonsheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_dialog);

        buttonsheet = findViewById(R.id.buttonSheet);
        buttonsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet();
            }
        });
    }


    private void showBottomSheet() {
        final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.layout_bottom_sheet_dialog);

        bottomSheetDialog.getWindow().setDimAmount(0.1f);

        LinearLayout edit = bottomSheetDialog.findViewById(R.id.editLinearLayout);
        bottomSheetDialog.getWindow().setDimAmount(0);
        bottomSheetDialog.show();
    }
}