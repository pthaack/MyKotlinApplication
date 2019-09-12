package ca.philipyoung.mykotlinapplication

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager

class MainActivity : AppCompatActivity() {
    val mContext: Context = this
    val CASCADED_CLOSE_KEY="cascaded_close"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        unsetCascadeClose()
        launchDashboard()
    }

    fun unsetCascadeClose() {
        val sharedPreferences=PreferenceManager.getDefaultSharedPreferences(mContext)
        if(sharedPreferences!=null){
            var editor = sharedPreferences.edit()
            editor.putBoolean(CASCADED_CLOSE_KEY,false)
            editor.apply()
        }
    }

    fun launchDashboard() {
        Handler().postDelayed({
            val intent = Intent(mContext, ActivityMainDrawer::class.java)
            startActivity(intent)
            finish()
        }, 7500)
    }
}
