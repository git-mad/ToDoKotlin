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
        val view: View = inflater.inflate(R.layout.alert_dialog_box, container, false)
        var input : EditText = view.findViewById(R.id.taskNameEditText)
        var createButton : Button = view.findViewById(R.id.create_button)
        var cancelButton : Button = view.findViewById(R.id.cancel_button)
        createButton.setOnClickListener(View.OnClickListener {
            val taskName = input.text.toString()
            inputListener!!.sendInput(taskName) // Sending the EditText data back.
            dialog.dismiss()
        })
        cancelButton.setOnClickListener(View.OnClickListener { dialog.dismiss() })
        return view
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
