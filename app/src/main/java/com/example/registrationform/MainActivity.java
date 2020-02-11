package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    //variabelen voor wat er in ons scherm staat
    private MaterialButton btnConfirm;
    private RadioGroup rgGender;
    private Switch swiAgree;
    private EditText etUsername;
    private EditText etPass;
    private TextInputLayout ilUsername, ilPass;


    private View.OnClickListener submitListener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Log.d("test","ge klikt op knop");

        }
    };

    private TextWatcher passwordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            int input = etPass.getText().length();
            if (input >= 4 && input <= 20) {
                ilPass.setError(null);
            }else {
                ilPass.setError("password moet tussen de 4 en 20 karakters zijn");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //verwijzing naar Layout van het scherm
        setContentView(R.layout.activity_main);

        //verwijzing naar de componenten in het scherm (UI)

        btnConfirm = findViewById(R.id.btn_submit);
        rgGender = findViewById(R.id.rg_gender);
        swiAgree = findViewById(R.id.swi_agree);
        etUsername = findViewById(R.id.et_username);
        etPass = findViewById(R.id.et_pass);
        ilUsername = findViewById(R.id.il_username);
        ilPass = findViewById(R.id.il_pass);

        //listener toevoegen aan component
        btnConfirm.setOnClickListener(submitListener);
        etPass.addTextChangedListener(passwordWatcher);
  


    }
}
