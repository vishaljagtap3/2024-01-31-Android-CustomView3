package `in`.bitcode.recyclerview2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.recyclerview.widget.RecyclerView
import `in`.bitcode.recyclerview2.Product

class ProductsAdapter(
    private val products: ArrayList<Product>
) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val productView: ProductView) : RecyclerView.ViewHolder(productView) {

        init {
            productView.setOnClickListener {
                val product = products[adapterPosition]
                Toast.makeText(it.context, "Product Selected: ${product.title}", Toast.LENGTH_LONG).show()
            }

            productView.onDeleteClickListener = object : ProductView.OnDeleteClickListener{
                override fun onDeleteClick(product: Product) {
                    products.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                }
            }

        }
    }

    override fun getItemCount() = products.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder( ProductView(parent.context) )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.productView.product = products[position]
    }

}