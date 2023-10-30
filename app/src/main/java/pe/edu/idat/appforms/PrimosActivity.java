package pe.edu.idat.appforms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import pe.edu.idat.appforms.databinding.ActivityPrimosBinding;

public class PrimosActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityPrimosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrimosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnCalcularPrimo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Integer numero = Integer.parseInt(
                binding.etNumeroPrimo.getText().toString());
        String resultado =
                esPrimo(numero) ? "El número ingresado es PRIMO"
                        : "El número ingresado NO ES PRIMO";
        binding.txtPrimoRes.setText(resultado);
    }

    private Boolean esPrimo(Integer numero) {
        if (numero <= 1) {
            return false; // 0 y 1 no son primos
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // Si es divisible por algún número, no es primo
            }
        }

        return true; // Si no es divisible por ningún número, es primo
    }

}