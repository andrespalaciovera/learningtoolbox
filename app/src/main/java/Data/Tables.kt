package Data

import android.app.Person

class Tables {

    abstract class information{
        companion object{
            val _email= "_email"
            val _name= "_name"
            val _password= "_password"
        }
    }

    abstract class procesoFormacion{
        companion object{
            val _email= "_email"
            val _videoName= "_videoName"
            val _topic= "_topic"
        }
    }

    abstract class videos{
        companion object{
            val _videoName= "_videoName"
            val _topic= "_topic"
            val _duration= "_duration"

        }
    }

}
