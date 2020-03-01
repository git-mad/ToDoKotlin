package club.gitmad.todokotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class TaskAdapter(private val taskNames: ArrayList<String>) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var taskName: TextView
        var parentLayout: RelativeLayout
        override fun onClick(view: View) {}

        init {
            taskName = itemView.findViewById(R.id.tvTaskName)
            parentLayout = itemView.findViewById(R.id.taskItemLayout)
            itemView.setOnClickListener(this)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.task_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder,position: Int) {
        viewHolder.taskName.setText(taskNames[position])
    }

    override fun getItemCount(): Int {
        return taskNames.size
    }



}