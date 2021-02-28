package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    //var textView : TextView ? = null //başlagıç değeri olarak null atıyoruz
    lateinit var diceText : TextView // global ve değer vermeye gerek olmayan kullanım
    lateinit var diceButton: Button
    lateinit var diceImage : ImageView
    lateinit var sendButton : Button
    lateinit var sendText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceText = findViewById(R.id.diceText)
        diceButton = findViewById(R.id.diceButton)
        diceImage = findViewById(R.id.diceImage)
        sendButton = findViewById(R.id.sendButton)
        sendText = findViewById(R.id.sendText)

        diceButton.setOnClickListener{

            changeText()
        }

        sendButton.setOnClickListener {
            sendText()
        }
    }

    //rastgele rakam getirme fonksiyonu
    private fun changeText(){
        val randomNumber =(1..6).random()  //1 ile 10 arasında rakamlar üreten random değer.
        //istediğimiz koşul olduğu zaman o değeri getir demek için when ve landa fonksiyonu kullanıyoruz
        val drawableResource =when(randomNumber){
            1 -> R.drawable.dice1 //randomnumber1 olduğunda dice1 resmini getirir.
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
        //ımageview entegre işlemi
        diceImage.setImageResource(drawableResource)

        //textview yazdırma
        //diceText.text = randomNumber.toString()

        //kullanıcıya mesaj gösterme
        //Toast.makeText(context: this, "Number: ${diceText.text}", Toast.LENGHT_SHORT).show() //parametler : hangi activity,verilecek text ya da ("Number: ${diceText.text}"),duruş süresi
        Toast.makeText(this,"Zar Atıldı",Toast.LENGTH_SHORT).show()
    }

    //iki sayfa arası geçişi sağlama
    private fun sendText(){
        val intent = Intent(this, MainActivity2::class.java)//iki değer alır: nereden gönderileceği, nereye gönderileceği
        intent.putExtra("send", sendText.text.toString())
        startActivity(intent)
    }

/*
    override fun onStart() {
        super.onStart()
        println("OnStart Called")
    }

    override fun onResume() {
        super.onResume()
        println("OnResume Called")
    }

    override fun onPause() {
        super.onPause()
        println("OnPause Called")

    }

    override fun onStop() {
        super.onStop()
        println("OnStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("OnDestroy Called")
    }

 */
}