import com.google.firebase.database.*

class FirebaseCRUD(private val database: FirebaseDatabase) {

    private var emailRef: DatabaseReference = database.getReference("emailAddress")
    private var passwordRef: DatabaseReference = database.getReference("password")
    private var extractedEmailAddress: String? = null
    private var extractedPassword: String? = null

    init {
        initializeDatabaseRefListeners()
    }

    fun setEmailAddress(emailAddress: String) {
        emailRef.setValue(emailAddress)
    }

    fun setPassword(password: String) {
        passwordRef.setValue(password)
    }

    private fun setEmailListener() {
        emailRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                extractedEmailAddress = snapshot.getValue(String::class.java)
            }

            override fun onCancelled(error: DatabaseError) {
                println("Error reading email: ${error.message}")
            }
        })
    }

    private fun setPasswordListener() {
        passwordRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                extractedPassword = snapshot.getValue(String::class.java)
            }

            override fun onCancelled(error: DatabaseError) {
                println("Error reading password: ${error.message}")
            }
        })
    }

    private fun initializeDatabaseRefListeners() {
        setEmailListener()
        setPasswordListener()
    }

    fun getExtractedEmailAddress(): String? = extractedEmailAddress

    fun getExtractedPassword(): String? = extractedPassword
}
