package com.example.poclib.test

import android.app.AlertDialog
import android.app.PendingIntent
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.location.LocationManager
import android.util.Log
import android.widget.RemoteViews
import com.example.poclib.R
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created on 21.11.17.
 */
object MyUtils {

    private var service : RequestService? = null
    private var retrofit : Retrofit? = null
    private fun initializeService() {
        if(retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(ManageRequest.BASE_URL_FREE_API_ONE)
                    .client(initializeClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            service = retrofit!!.create(RequestService::class.java)
        }
    }

    private fun initializeClient() : OkHttpClient{
        return OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor())
                .build()
    }

    fun getProducts(callBack : ListeenrRequest){
        var result : ResponseFood? = null
        initializeService()
        val susbscribeResponse = object : Observer<ResponseFood> {
            override fun onComplete() { callBack.getResponseFood(result!!)}
            override fun onError(e: Throwable?) {
                Log.e("E","error ".plus(e!!.message))
                callBack.getError(e)
            }

            override fun onNext(value: ResponseFood?) {
                result = value!!
            }

            override fun onSubscribe(d: Disposable?) {}
        }
        val myObservable : Observable<ResponseFood> = service!!.getProduct()
        myObservable.subscribeOn(Schedulers.newThread())
                .subscribe(susbscribeResponse)

    }

    fun getInstance(context : Context) {
        var remoteView  = RemoteViews(context.packageName, R.layout.widget_test)

        remoteView.setOnClickPendingIntent(R.id.id_btn_sos, createPendingIntent(context))
    }

    private fun createPendingIntent(context : Context) : PendingIntent {
        var intent = Intent(context,NotificationTest::class.java)
        var pendingIntent = PendingIntent.getActivity(context,System.currentTimeMillis().toInt(),intent,PendingIntent.FLAG_CANCEL_CURRENT)
        return pendingIntent
    }

    /**
     * This method allows to check if gps or network is enabled
     *
     * @param context
     * @param mustNetwork @Boolean, true = network
     *                              false = gps, this the default value
     */
    fun checkLocalisation(context : Context, mustNetwork : Boolean = false){
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        if(mustNetwork) {
            checkNetwork(locationManager,context)
        }else{
            checkGPS(locationManager,context)
        }
    }

    private fun checkGPS(lm : LocationManager, context: Context) {
        var gpsEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if(!gpsEnabled){
            var dialogGPS = AlertDialog.Builder(context)
            dialogGPS.setMessage(context.resources.getString(R.string.enabled_gps))
            dialogGPS.setPositiveButton(context.resources.getString(R.string.dialog_positive_btn),object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    //OpenFeature.newIntentEnabledFromSettings(context)
                    OpenFeature.newIntentEnabledGPS(context)
                }
            })
            dialogGPS.setNegativeButton(context.resources.getString(R.string.dialog_negative_btn),object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                }
            })
            dialogGPS.show()
        }
    }

    private fun checkNetwork(lm : LocationManager, context: Context) {
        var networkEnabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        if(!networkEnabled) {
            var dialogNetwork = AlertDialog.Builder(context)
            dialogNetwork.setMessage(context.resources.getString(R.string.enabled_network))
            dialogNetwork.setPositiveButton(context.resources.getString(R.string.dialog_positive_btn),object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    OpenFeature.newIntentEnabledNetwork(context)
                }
            })
            dialogNetwork.setNegativeButton(context.resources.getString(R.string.dialog_negative_btn),object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                }
            })
            dialogNetwork.show()
        }
    }
}