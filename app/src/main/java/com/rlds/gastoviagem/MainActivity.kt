package com.rlds.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.rlds.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalcular.setOnClickListener( this)


}

    override fun onClick(view: View) {
       if(view.id == R.id.buttonCalcular){
           calculate()
       }
    }
    private fun isValid():Boolean{
        return (binding.editDistancia.text.toString() != ""
                && binding.editPreco.text.toString() != ""
                && binding.editAutonomia.text.toString() != ""
                && binding.editAutonomia.text.toString().toFloat() != 0f

                )

    }
    private fun calculate(){
        if(isValid()){
            val distance = binding.editDistancia.text.toString().toFloat()
            val preco  = binding.editPreco.text.toString().toFloat()
            val autonomia = binding.editAutonomia.text.toString().toFloat()


            val totalValor = (distance * preco) / autonomia

            binding.textViewTotalValor.text = "R$ ${"%.2f".format(totalValor)}"
        }else{
            Toast.makeText(
                this,
                R.string.validacao,
                Toast.LENGTH_LONG
            ).show()
        }



    }
}