package `in`.ac.charusat.sqlitedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_view_all.*

class ViewAllActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all)
        var db=DatabaseHelper(this)
        var std=db.selectAll()

        var add=ArrayAdapter<Student>(this,android.R.layout.simple_list_item_1,std)
        listview.adapter=add
    }
}
