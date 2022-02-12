package com.example.lesson17.presentation

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.lesson17.R
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {
        private val IMAGE_URL_LIST = listOf<String>(
            "https://resheto.net/images/mater/pozitivnye_kartinki_2.jpg",
            "https://img2.akspic.ru/previews/5/7/1/6/6/166175/166175-gubka_bob-multfilm-multik-bikini_bottom-nikelodeon-500x.jpg",
            "https://img2.akspic.ru/previews/4/9/4/6/6/166494/166494-igra_v_kalmara_squid_game-500x.jpg",
            "https://avatarko.ru/img/avatar/33/multfilm_lyagushka_32117.jpg",
            "https://st2.depositphotos.com/1064024/10769/i/600/depositphotos_107694484-stock-photo-little-boy.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRmXKAUMbEtzmIr9CdybO3TAYkMP8bcbBvPg&usqp=CAU",
            "https://handcraftguide.com/sites/default/files/styles/original___water/public/sketchingforkids1handcraftguide.com__0.jpg?itok=CiUYaUmE",
            "http://pristor.ru/wp-content/uploads/2018/04/%D0%AF-%D0%BF%D1%80%D0%BE%D1%81%D1%82%D0%BE-%D1%85%D0%BE%D1%87%D1%83-%D1%83%D0%B7%D0%BD%D0%B0%D1%82%D1%8C-%D0%BA%D0%B0%D0%BA-%D1%82%D1%8B-%D0%BA%D0%B0%D1%80%D1%82%D0%B8%D0%BD%D0%BA%D0%B8-%D1%81-%D0%BD%D0%B0%D0%B4%D0%BF%D0%B8%D1%81%D1%8F%D0%BC%D0%B8-%D1%81%D0%B0%D0%BC%D1%8B%D0%B5-%D0%BF%D1%80%D0%B8%D1%8F%D1%82%D0%BD%D1%8B%D0%B5-13.jpg"
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btnChoosePicture.setOnClickListener() {

            CoroutineScope(Dispatchers.Main).launch {
                val sizeOfUrlList = IMAGE_URL_LIST.size
                if (sizeOfUrlList > 0) {
                    var randomNumber = Random.nextInt(0, sizeOfUrlList - 1)
                    loadImage(IMAGE_URL_LIST[randomNumber], ivPicture)
                }
                else {
                    Toast.makeText(requireContext(),
                        "В списке не осталось картинок... :(", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        }
    }

    suspend fun loadImage(imageUrl: String, imageView: ImageView) {
        Glide.with(requireContext())
            .load(imageUrl)
            .into(imageView)
    }
}