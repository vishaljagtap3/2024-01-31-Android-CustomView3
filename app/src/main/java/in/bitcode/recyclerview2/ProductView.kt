package `in`.bitcode.recyclerview2

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class ProductView(
    context: Context,
    attributeSet: AttributeSet? = null
) : LinearLayout(context, attributeSet){

    private val imgProduct : ImageView
    private val imgDeleteIcon : ImageView
    private val txtProductTitle : TextView
    private val txtProductPrice : TextView
    private val txtProductRating : TextView

    interface OnDeleteClickListener {
        fun onDeleteClick(product: Product)
    }

    var onDeleteClickListener : OnDeleteClickListener? = null

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.product_view, null)
        addView(view)

        imgProduct = view.findViewById(R.id.imgProduct)
        imgDeleteIcon = view.findViewById(R.id.imgDeleteProduct)
        txtProductTitle = view.findViewById(R.id.txtProductTitle)
        txtProductPrice = view.findViewById(R.id.txtProductPrice)
        txtProductRating = view.findViewById(R.id.txtProductRating)

        imgDeleteIcon.setOnClickListener {
            onDeleteClickListener?.onDeleteClick(product!!)
        }
    }

    var product : Product? = null
        set(value) {
            field = value
            if(value == null) {
                return
            }
            imgProduct.setImageResource(value!!.imageId)
            imgDeleteIcon.setImageResource(android.R.drawable.ic_menu_delete)
            txtProductPrice.text = "${value.price}"
            txtProductTitle.text = value.title
            txtProductRating.text = "${value.rating}"
        }
}