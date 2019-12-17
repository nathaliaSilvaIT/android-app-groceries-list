package ca.georgebrown.comp2074.a2_mobile;

import android.content.Intent;

import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class addItem extends AppCompatActivity {

    public static final String NEW_REPLY = "AddWord_Reply";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        final EditText t = findViewById(R.id.txtAddWord);
        Button myBtn = findViewById(R.id.btnAddWord);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent();
                myIntent.putExtra(NEW_REPLY, t.getText().toString());
                setResult(RESULT_OK, myIntent);
                finish();
            }
        });
    }
}
