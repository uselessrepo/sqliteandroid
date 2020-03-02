package `in`.ac.charusat.sqlitedatabase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(var context:Context):
    SQLiteOpenHelper (context, DATABASE_NAME,null, VERSION)
{
    override fun onCreate(db: SQLiteDatabase?) {
        var query="create table $TB_NAME($STUD_ID INTEGER PRIMARY KEY AUTOINCREMENT,$NAME VARCHAR(20),$PHOME VARCHAR(10))"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var query="DROP TABLE IF EXISTS $TB_NAME"
        db!!.execSQL(query)
        onCreate(db)
    }
    fun insert(name:String,phone:String):Boolean
    {
        var db=writableDatabase
        var cv=ContentValues()
        cv.put(NAME,name)
        cv.put(PHOME,phone)
        var a=db.insert(TB_NAME,null,cv)
        db.close()
        if(a>0)
            return true
        else
            return false

    }
    fun update(id:Int,name:String,phone:String):Boolean
    {
        var db=writableDatabase
        var cv=ContentValues()
        cv.put(NAME,name)
        cv.put(PHOME,phone)
        var a=db.update(TB_NAME,cv, "$STUD_ID=$id",
            arrayOf<String>(id.toString()))
        if(a>0)
            return true
        else
            return false
    }
    fun selectAll():ArrayList<Student>
    {
        var db=readableDatabase
        var cor:Cursor=db.query(TB_NAME, null,null,null,null,null,null)
        var arrStud=ArrayList<Student>()
        while (cor.moveToNext())
        {
            var id=cor.getInt(0)
            var name=cor.getString(1)
            var phone=cor.getString(2)
            var s=Student(id,name,phone)
            arrStud.add(s)
        }
        return  arrStud
    }



    companion object{
        var DATABASE_NAME="MyDb"
        var VERSION=1
        var TB_NAME="Student"
        var STUD_ID="StudId"
        var NAME="StudName"
        var PHOME="StudPhone"



    }
}