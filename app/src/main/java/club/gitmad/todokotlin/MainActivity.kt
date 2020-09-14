package club.gitmad.todokotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), CustomDialog.OnInputListener {
    private val taskNames = mutableListOf<String>()
    private lateinit var rvTaskNames: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup rv

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            addItem()
        }
    }

    private fun addItem() {
        val dialog = CustomDialog()
        dialog.show(supportFragmentManager, "CustomDialog")
    }

    override fun sendInput(input: String) {
        Toast.makeText(this, "Task Added", Toast.LENGTH_SHORT).show()

        taskNames.add(input)
        rvTaskNames.adapter?.notifyItemInserted(taskNames.size)
    }
}
