package Data
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.fragment.app.FragmentActivity

class DBHelper (context: FragmentActivity?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object{
        private val DATABASE_VERSION= 2
        private val DATABASE_NAME= "info"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE"+ Tables.information + "(" +
        Tables.information._email + "TEXT PRIMARY KEY, " +
        Tables.information._name + "TEXT NOT NULL, " +
        Tables.information._password + "TEXT NOT NULL)")

        db!!.execSQL("CREATE TABLE"+ Tables.procesoFormacion + "(" +
        Tables.procesoFormacion._email + "TEXT FOREIGN KEY, " +
        Tables.procesoFormacion._videoName + "TEXT FOREIGN KEY NOT NULL, " +
        Tables.procesoFormacion._topic + "TEXT FOREIGN KEY NOT NULL)")

        db!!.execSQL("CREATE TABLE"+ Tables.videos + "(" +
                Tables.videos._videoName + "TEXT PRIMARY KEY, " +
                Tables.videos._topic + "TEXT NOT NULL, " +
                Tables.videos._duration + "TEXT NOT NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val orderErase= "DROP TABLE IF EXIST" + Tables.information + Tables.procesoFormacion + Tables.videos
        db!!.execSQL(orderErase)
        onCreate(db)
    }

    fun insert(email:String, name:String, password:String) {
        val data= ContentValues()
        data.put(Tables.information._email,email)
        data.put(Tables.information._name,name)
        data.put(Tables.information._password,password)
        val db= this.writableDatabase

        db.insert(Tables.information.toString(), null,data)
        db.close()
    }

    fun edit(password: Int, toString: Any, toString1: Any, toString2: Any){
        val num= 1
        val args= arrayOf(num.toString())

        val data= ContentValues()
        data.put(Tables.information._password, password)
        val db= this.writableDatabase

        db.update(Tables.information.toString(), data, "_email= ?", args)
        db.close()
    }


}