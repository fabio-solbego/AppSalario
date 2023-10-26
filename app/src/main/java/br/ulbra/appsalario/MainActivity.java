package br.ulbra.appsalario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText edtSal;

RadioGroup rgOpcoes;

    Button btnSal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSal = (EditText) findViewById(R.id.edtSal);
        rgOpcoes = (RadioGroup) findViewById(R.id.rgOpcoes);
        btnSal = (Button) findViewById(R.id.btnSal);
        btnSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                double salario = Double.parseDouble(edtSal.getText().toString());
                int op = rgOpcoes.getCheckedRadioButtonId();
                double novo_salario = 0;
                if (op == R.id.rb40)
                    novo_salario = salario + (salario * 0.4);

                else if (op == R.id.rb45)
                    novo_salario = salario + (salario * 0.45);
                else
                    novo_salario = salario + (salario * 0.5);
                AlertDialog. Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Novo salário");
                dialog.setMessage("Seu novo salário é : R$"
                +String.valueOf(novo_salario));
                dialog.setNeutralButton("OK", null);
                dialog.show();
            }
        });
    }
}