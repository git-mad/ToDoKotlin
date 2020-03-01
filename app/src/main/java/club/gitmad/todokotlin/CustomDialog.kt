package club.gitmad.todokotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class CustomDialog : DialogFragment() {

    private lateinit var etTaskName: EditText
    private lateinit var btnCreate: Button
    private lateinit var btnCancel: Button

    interface OnInputListener {
        fun sendInput(input: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.alert_dialog_box, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etTaskName = view.findViewById(R.id.taskNameEditText)

        btnCreate = view.findViewById(R.id.create_button)
        btnCreate.setOnClickListener {
            val taskName = etTaskName.text.toString()
            (activity as OnInputListener).sendInput(taskName)

            dialog.dismiss()
        }

        btnCancel = view.findViewById(R.id.cancel_button)
        btnCancel.setOnClickListener { dialog.dismiss() }
    }
}
