package com.example.flagship
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FlagListAdapter(context: Context, dataArrayList: ArrayList<FlagListData?>?):
ArrayAdapter<FlagListData?>(context, R.layout.flag_list, dataArrayList!!){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val FlagListData = getItem(position)

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.flag_list, parent, false)
        }
        val flagListImage = view!!.findViewById<ImageView>(R.id.flagListImage)
        val flagListCountry = view.findViewById<TextView>(R.id.flagListCountry)
        val flagListCapital = view.findViewById<TextView>(R.id.flagListCapital)

        flagListImage.setImageResource(FlagListData!!.flagImage)
        flagListCountry.text = FlagListData.countryName
        flagListCapital.text = FlagListData.capital

        flagListImage.setOnClickListener {
            showImageZoomDialog(FlagListData.flagImage)
        }


        return view
    }

    private fun showImageZoomDialog(imageResId: Int) {
        val dialog = Dialog(context)
        dialog.setContentView(ImageView(context).apply {
            setImageResource(imageResId)
            adjustViewBounds = true
            scaleType = ImageView.ScaleType.FIT_CENTER
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setBackgroundColor(android.graphics.Color.BLACK)

            // Double the image size by adjusting the layout size
            val currentWidth = this.layoutParams.width
            val currentHeight = this.layoutParams.height
            layoutParams = ViewGroup.LayoutParams(
                currentWidth * 2,
                currentHeight * 2
            )

            setOnClickListener { dialog.dismiss() }
        })
        dialog.show()
    }


}