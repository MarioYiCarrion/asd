package pe.edu.idat.appproyectokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.appproyectokotlin.databinding.ActivityImcBinding


class ImcActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btncalcularimc.setOnClickListener(this)

    }

    private fun calcularValorImc(tallacm: Double, pesokg: Double): Double
    {
        val tallam = tallacm/100
        val valorImc = pesokg / (tallam * tallam)
        return valorImc
    }

    private fun diagnosticoImc(valorImc: Double): String
    {
        if(valorImc < 16.5){
            return "Bajo de Peso"
        }else if(valorImc < 18.5){
            return "Peso Nomal"
        }else if(valorImc <25.50){
            return "Sobre Peso"
        }else{
            return "Obesidad"
        }
    }

    override fun onClick(v: View?) {
        val valorImc = calcularValorImc(
            binding.etpeso.text.toString().toDouble(),
            binding.ettalla.text.toString().toDouble()
        )
        val diagnistico = diagnosticoImc(valorImc)
        var resultado = "Su valor IMC es: $valorImc y su diagnostico es: $diagnistico"
        binding.tvdiagnostico.setText(resultado)
    }

}