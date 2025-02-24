package com.example.aula05

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.aula05.dao.PessoaDAO
import com.example.aula05.model.Pessoa
import java.math.BigDecimal

class FormularioPessoaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.formulario_pessoa_activity)


        val salvarPessoa = findViewById<Button>(R.id.botao_salvar)

        val dao = PessoaDAO(this)

        salvarPessoa.setOnClickListener  {
        val inputNome = findViewById<EditText>(R.id.nome_pessoa)
            val nome = inputNome.text.toString()

        val inputIdade = findViewById<EditText>(R.id.idade_pessoa)
            val idade = inputIdade.text.toString()

        val inputProfissao = findViewById<EditText>(R.id.profissao_pessoa)
            val profissao = inputProfissao.text.toString()

        val inputAltura = findViewById<EditText>(R.id.altura_pessoa)
            val altura = inputAltura.text.toString()
            val alturaValidada = if(altura.isBlank()){
                BigDecimal.ZERO
            }else{
                BigDecimal(altura)
            }

        val novaPessoa = Pessoa(
            nome = nome,
            idade = idade.toInt(),
            profissao = profissao,
            altura = alturaValidada
        )
            dao.adicionar(novaPessoa)
         Log.i("Formulario"," O que veio: $novaPessoa")
         Log.i("FormularioDAO","Veio do DAO: ${dao.buscarPessoas()}")
        }


    }
}