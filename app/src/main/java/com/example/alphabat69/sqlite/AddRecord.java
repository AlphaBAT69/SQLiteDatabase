package com.example.alphabat69.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecord extends AppCompatActivity {
    private Button save, reset;
    private EditText name, password, contact;
    DBHelper obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        save = findViewById(R.id.save);
        reset = findViewById(R.id.reset);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        contact = findViewById(R.id.contact);
        obj = new DBHelper(AddRecord.this);

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                obj.save(name.getText().toString(), password.getText().toString(), contact.getText().toString());
                Toast.makeText(AddRecord.this, "Record Added", Toast.LENGTH_LONG).show();
                name.setText("");
                password.setText("");
                contact.setText("");
            }
        });
        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                name.setText("");
                password.setText("");
                contact.setText("");
            }
        });
    }
}
