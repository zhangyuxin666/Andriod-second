package cn.edu.sicnu.stu.zhangyuxin.second

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : Activity() {
    private val model = ProgramAdviser()
    private val entries = arrayListOf<String>()
    private lateinit var items: LinearLayout
    private lateinit var count: TextView
    private lateinit var scroll: ScrollView
    private val stateKey get() = javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        val root = (findViewById<android.view.ViewGroup>(android.R.id.content)).getChildAt(0)
        val padding = (16 * resources.displayMetrics.density).toInt()
        root.setOnApplyWindowInsetsListener { view, insets ->
            view.setPadding(padding, padding + insets.systemWindowInsetTop,
                padding, padding + insets.systemWindowInsetBottom)
            insets
        }
        root.requestApplyInsets()
        items = findViewById(R.id.items)
        count = findViewById(R.id.count)
        scroll = findViewById(R.id.scroll)
        val input = findViewById<EditText>(R.id.input)
        val direction = findViewById<Spinner>(R.id.direction)
        val result = findViewById<TextView>(R.id.result)
        savedInstanceState?.getStringArrayList(stateKey)?.forEach { addEntry(it) }
        updateCount()
        findViewById<Button>(R.id.add).setOnClickListener {
            val text = input.text.toString().trim()
            if (text.isEmpty()) input.error = getString(R.string.empty)
            else {
                addEntry(text)
                input.text.clear()
                (getSystemService(INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager)
                    .hideSoftInputFromWindow(input.windowToken, 0)
                scroll.post { scroll.fullScroll(View.FOCUS_DOWN) }
            }
        }
        findViewById<Button>(R.id.clear).setOnClickListener {
            entries.clear()
            items.removeAllViews()
            updateCount()
        }
        findViewById<Button>(R.id.query).setOnClickListener {
            val recommendation = getString(model.recommend(direction.selectedItemPosition))
            result.text = getString(R.string.result, recommendation)
        }
    }

    private fun addEntry(text: String) {
        entries.add(text)
        val label = TextView(this).apply {
            this.text = getString(R.string.item, entries.size, text)
            textSize = 17f
            val padding = (10 * resources.displayMetrics.density).toInt()
            setPadding(padding, padding, padding, padding)
        }
        items.addView(label)
        updateCount()
    }
    private fun updateCount() { count.text = getString(R.string.count, entries.size) }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putStringArrayList(stateKey, entries)
        super.onSaveInstanceState(outState)
    }
}
