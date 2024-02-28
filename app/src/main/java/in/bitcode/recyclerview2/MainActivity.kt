package `in`.bitcode.recyclerview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerProducts : RecyclerView
    private lateinit var edtProductTitle : EditText
    private lateinit var edtProductPrice : EditText
    private lateinit var btnAddProduct : Button

    private val products = ArrayList<Product>()
    private lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initData()
        initAdapter()
        initListener()
    }

    private fun initListener() {
        btnAddProduct.setOnClickListener {
            val newProduct = Product(
                Math.abs(Random().nextInt()),
                edtProductTitle.text.toString(),
                edtProductPrice.text.toString().toInt(),
                R.mipmap.ic_launcher
            )

            products.add(0, newProduct)
            productsAdapter.notifyItemInserted(0)
            recyclerProducts.scrollToPosition(0)
            //productsAdapter.notifyDataSetChanged()
            //productsAdapter.notifyItemInserted(products.size - 1)
        }
    }

    private fun initAdapter() {
        productsAdapter = ProductsAdapter(products)
        recyclerProducts.adapter = productsAdapter
    }

    private fun initData() {
        products.add(Product(101, "Laptop", 1000, R.mipmap.ic_launcher))
        products.add(Product(102, "Phone", 1050, R.mipmap.ic_launcher))
        products.add(Product(103, "Projector", 2000, R.mipmap.ic_launcher))
        products.add(Product(104, "Notebook", 3400, R.mipmap.ic_launcher))
        products.add(Product(105, "Desk", 5300, R.mipmap.ic_launcher))
        products.add(Product(106, "Mouse", 6800, R.mipmap.ic_launcher))
        products.add(Product(107, "KB", 100, R.mipmap.ic_launcher))
        products.add(Product(108, "Charger", 120, R.mipmap.ic_launcher))
        products.add(Product(109, "Tab", 450, R.mipmap.ic_launcher))
        products.add(Product(110, "Earphones", 8900, R.mipmap.ic_launcher))
        products.add(Product(111, "Not iPhone", 6700, R.mipmap.ic_launcher))
    }

    private fun initViews() {
        setContentView(R.layout.activity_main)
        recyclerProducts = findViewById(R.id.recyclerProducts)
        recyclerProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        edtProductTitle = findViewById(R.id.edtProductTitle)
        edtProductPrice = findViewById(R.id.edtProductPrice)
        btnAddProduct = findViewById(R.id.btnAddProduct)
    }
}