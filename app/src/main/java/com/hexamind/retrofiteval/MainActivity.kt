package com.hexamind.retrofiteval

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var apiService: ApiService
    private lateinit var jsonClass: JsonClass
    private lateinit var text: TextView
    private lateinit var title: TextView
    private lateinit var image: ImageView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.text)
        title = findViewById(R.id.title)
        image = findViewById(R.id.image)
        progressBar = findViewById(R.id.progressBar)

        progressBar.visibility = View.VISIBLE
        apiService = RetrofitClient.getApiService()
        val call: Call<JsonClass> = apiService.json()

        call.enqueue(object : Callback<JsonClass> {
            override fun onFailure(call: Call<JsonClass>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Issue: ${t?.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<JsonClass>?, response: Response<JsonClass>?) {
                if (response!!.isSuccessful) {
                    jsonClass = response.body()
                    text.text = jsonClass.widget?.window?.title
                    val layoutParams = text.layoutParams
                    layoutParams.height = jsonClass.widget?.window?.height!!
                    layoutParams.width = jsonClass.widget?.window?.width!!
                    text.layoutParams = layoutParams

                    Glide.with(this@MainActivity)
                        .load(jsonClass.widget?.image?.src)
                        .listener(object  : RequestListener<Drawable?> {
                            override fun onLoadFailed(
                                e: GlideException?,
                                model: Any?,
                                target: Target<Drawable?>?,
                                isFirstResource: Boolean
                            ): Boolean {
                                progressBar.visibility = View.GONE

                                return false
                            }

                            override fun onResourceReady(
                                resource: Drawable?,
                                model: Any?,
                                target: Target<Drawable?>?,
                                dataSource: DataSource?,
                                isFirstResource: Boolean
                            ): Boolean {
                                progressBar.visibility = View.GONE

                                return false
                            }
                        }).into(image)

                    title.text = jsonClass.widget?.text?.data
                    val layoutParamsTitle = text.layoutParams
                    layoutParamsTitle.height = jsonClass.widget?.window?.height!!
                    layoutParamsTitle.width = jsonClass.widget?.window?.width!!
                    title.layoutParams = layoutParamsTitle
                }
            }
        })
    }
}
