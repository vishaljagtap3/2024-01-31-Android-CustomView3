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

    inner class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imgProduct : ImageView
        val txtProductTitle : TextView
        val txtProductPrice : TextView
        val imgDeleteProduct : ImageView
        init {
            imgProduct = view.findViewById(R.id.imgProduct)
            txtProductTitle = view.findViewById(R.id.txtProductTitle)
            txtProductPrice = view.findViewById(R.id.txtProductPrice)
            imgDeleteProduct = view.findViewById(R.id.imgDeleteProduct)

            itemView.setOnClickListener {
                val product = products[adapterPosition]
                Toast.makeText(it.context, "Product Selected: ${product.title}", Toast.LENGTH_LONG).show()
            }

            imgDeleteProduct.setOnClickListener {
                products.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
                //this@ProductsAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount() = products.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.product_view, null)

        //Not a good place to setup listener as we don't know what data the view would be presenting
        /*view.setOnClickListener {
            Toast.makeText(it.context, "Product Selected", Toast.LENGTH_LONG).show()
        }*/

        return ProductViewHolder(view)

        /*return ProductViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.product_view, null
                )
        )*/
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.imgProduct.setImageResource(product.imageId)
        holder.txtProductTitle.text = product.title
        holder.txtProductPrice.text = "${product.price}"

        //set up listener here
        //this way we get the product associated with the view
        //this is still not good! Because the old listener has to be garbage collected and new listener has to be attached to the view
        /*holder.view.setOnClickListener { it ->
            Toast.makeText(
                it.context,
                "Product ${product.title} selected...",
                Toast.LENGTH_LONG
            ).show()
        }*/
    }

}