package com.example.week4task

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    // initializing global variables
    val channelId = "Week4"
    val notificationId = 500
   val productsFragment: Fragment = ProductFragment()
//    val supportFragment: Fragment = SupportFragment()
//    val historyFragment: Fragment = HistoryFragment()
//    val payments: Fragment = PaymentsFragment()
//    val MoreFragment : Fragment = MoreFragment()
//    val bottomNav:BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)


//    private lateinit var myAdapter: cardAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var modelCardList: ArrayList<CardModelClass>

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        if (Build.VERSION.SDK_INT >= 21) {
            window.statusBarColor
        }

        // calls the createNotification function and sets the notification button
        createNotification()
        val notification_btn = findViewById<ImageView>(R.id.notification)
        notification_btn.setOnClickListener {
            sendNotification()
        }
        //replaces the frameLayout with the products fragment
        currentFragment(productsFragment)

    }


    private fun currentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()

    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification Title"
            val descriptionText = "Description of Notification"
            val importanceOfNotication = NotificationManager.IMPORTANCE_DEFAULT
            val channel: NotificationChannel = NotificationChannel(channelId, name, importanceOfNotication).apply {
                description = descriptionText
            }

            val notification: NotificationManager =
                    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notification.createNotificationChannel(channel)
        }
    }

    private fun sendNotification() {
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val builder = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Go To Week 4 Task Now")
                .setContentText("Click to enter week 4 task ")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        with(NotificationManagerCompat.from(this)) {
            notify(notificationId, builder.build())
        }
    }
}