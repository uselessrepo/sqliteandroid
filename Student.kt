package `in`.ac.charusat.sqlitedatabase

class Student(var id:Int,var name:String,var phone:String)
{
    override fun toString(): String {
        return "Id is $id name is $name phone is $phone"
    }
}