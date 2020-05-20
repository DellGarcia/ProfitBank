package br.com.dellgarcia.profitbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import br.com.dellgarcia.profitbank.models.User;

public class MainActivity extends AppCompatActivity {

    private User user;

    private TextInputLayout edtName;
    private TextInputLayout edtEmail;
    private TextInputLayout edtPass;
    private TextInputLayout edtConfPass;
    private RadioButton rbMasc;
    private RadioButton rbFem;
    private Spinner spnState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("name", .getText().toString());
//        editor.apply();

        instantiate();

        findViewById(R.id.btnNext).setOnClickListener(nextAction());

    }

    private void instantiate() {
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPassword);
        edtConfPass = findViewById(R.id.edtConfirmPassword);
        rbMasc = findViewById(R.id.rbMasc);
        rbFem = findViewById(R.id.rbFem);
        spnState = findViewById(R.id.spinner);
    }

    private View.OnClickListener nextAction() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = Objects.requireNonNull(edtName.getEditText()).getText().toString();
                String email = Objects.requireNonNull(edtEmail.getEditText()).getText().toString();
                String pass = Objects.requireNonNull(edtPass.getEditText()).getText().toString();
                String conf = Objects.requireNonNull(edtConfPass.getEditText()).getText().toString();

                if(pass.equals(conf)) {
                    Toast.makeText(MainActivity.this, nome, Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, email, Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, pass, Toast.LENGTH_LONG).show();

                    if(rbMasc.isChecked())
                        Toast.makeText(MainActivity.this, "Sexo: Masculino", Toast.LENGTH_LONG).show();

                    if(rbFem.isChecked())
                        Toast.makeText(MainActivity.this, "Sexo: Feminino", Toast.LENGTH_LONG).show();

                    Toast.makeText(MainActivity.this, spnState.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(MainActivity.this, "Senhas não coincidem", Toast.LENGTH_LONG).show();
                }
            }
        };
    }
}
