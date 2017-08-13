package com.dockdesignstudio.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    int editItemPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        editItemPos = getIntent().getIntExtra("editItemPos",0);
        String editItemText = getIntent().getStringExtra("editItemText");

        EditText etEditItem = (EditText) findViewById(R.id.etEditItem);
        etEditItem.setText("");
        etEditItem.append(editItemText);
    }

    public void onSave(View v) {
        EditText etEditItem = (EditText) findViewById(R.id.etEditItem);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("editItemText", etEditItem.getText().toString());
        data.putExtra("editItemPos",editItemPos);
        //data.putExtra("code", 200); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }
}
