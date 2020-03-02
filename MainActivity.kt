package `in`.ac.charusat.sqlitedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            var db=DatabaseHelper(this)
           var flag= db.insert(editText.text.toString(),editText2.text.toString())
            if(flag)
            {
                Toast.makeText(this,"Record Inserted!!",Toast.LENGTH_LONG).show()
            }
        }


    }
}
