package com.paulohenrique.whattodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.paulohenrique.whattodo.adapters.ProductAdapter
import com.paulohenrique.whattodo.data.Product
import com.paulohenrique.whattodo.databinding.ActivityProductResgistrationBinding

class ProductResgistrationActivity : AppCompatActivity() {

    lateinit var binding: ActivityProductResgistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductResgistrationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.txtUnitProduct.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
        listOf("Kg", "g", "L", "ml", "unidade", "pct"))
        globalProduct.clear()
        val dados = intent.extras
        val title = dados?.getString("title")
        binding.txtTitleListProduct.text = title

        binding.btnInsertProduct.setOnClickListener {
            val product = binding.txtProduct.text.toString()
            val quantity = binding.txtQuantityProduct.text.toString().toDouble()
            val unity = binding.txtUnitProduct.selectedItem.toString()

            if (binding.txtProduct.text.isNotEmpty() && binding.txtQuantityProduct.text.isNotEmpty()) {
                val product = Product(product, quantity, unity)
                globalProduct.add(product)

                binding.txtProduct.text.clear()
                binding.txtQuantityProduct.text.clear()

                val productAdapter = ProductAdapter(this)
                productAdapter.addAll(globalProduct)
                binding.listViewProduct.adapter = productAdapter

            } else {
                if (binding.txtProduct.text.isEmpty()) {
                    binding.txtProduct.error = "Preencha o nome do produto!"
                } else {
                    binding.txtProduct.error = null
                }
                if (binding.txtQuantityProduct.text.isEmpty()) {
                    binding.txtQuantityProduct.error = "Preencha a quantidade do produto!"
                } else {
                    binding.txtQuantityProduct.error = null
                }
            }
        }
    }
}