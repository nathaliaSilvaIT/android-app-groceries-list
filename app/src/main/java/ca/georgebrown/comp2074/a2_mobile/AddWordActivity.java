package ca.georgebrown.comp2074.a2_mobile;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AddWordActivity extends AppCompatActivity {

    public static final String NEW_REPLY = "AddWord_Reply";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        final EditText my_txt = findViewById(R.id.txtAddWord);
        Button myButton = findViewById(R.id.btnAddWord);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent();
                myIntent.putExtra(NEW_REPLY, my_txt.getText().toString());
                setResult(RESULT_OK, myIntent);
                finish();
            }
        });
    }
}
