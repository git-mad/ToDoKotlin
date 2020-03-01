package gitmad.club.todokotlin


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*


class MainActivity : AppCompatActivity(), CustomDialog.OnInputListener {
    private val taskNames = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val toolbar = findViewById<Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar)
        var mainScreenTaskNameList : RecyclerView = findViewById(R.id.task_name_list)
        val manager = LinearLayoutManager(this)
        mainScreenTaskNameList.setLayoutManager(manager)
        val adapter = TaskAdapter(taskNames)
        mainScreenTaskNameList.setAdapter(adapter)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener(View.OnClickListener { addItem() })
    }

    private fun addItem() {
        val dialog = CustomDialog()
        dialog.show(supportFragmentManager, "CustomDialog")
    }


    override fun sendInput(input: String?) {
        if (input != null) {
            taskNames.add(input)
        }
        var mainScreenTaskNameList : RecyclerView = findViewById(R.id.task_name_list)
        Toast.makeText(this, "Task Added", Toast.LENGTH_SHORT).show()
        mainScreenTaskNameList.adapter?.notifyItemInserted(taskNames.size)
    }
}
