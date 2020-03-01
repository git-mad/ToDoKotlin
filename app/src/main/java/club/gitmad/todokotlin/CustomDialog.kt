package club.gitmad.todokotlin

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class CustomDialog : DialogFragment() {

    interface OnInputListener {
        fun sendInput(input: String?)
    }

    private var inputListener: OnInputListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.alert_dialog_box, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val input: EditText = view.findViewById(R.id.taskNameEditText)

        val createButton: Button = view.findViewById(R.id.create_button)
        createButton.setOnClickListener {
            val taskName = input.text.toString()
            inputListener!!.sendInput(taskName) // Sending the EditText data back.
            dialog.dismiss()
        }

        val cancelButton: Button = view.findViewById(R.id.cancel_button)
        cancelButton.setOnClickListener { dialog.dismiss() }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            inputListener = activity as OnInputListener?
        } catch (e: ClassCastException) {
            Log.e("CustomDialog", "OnInputListener onAttach", e)
        }
    }
}
