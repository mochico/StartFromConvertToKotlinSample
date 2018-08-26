package mochico.example.com.start.from.convert.to.kotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import java.util.ArrayList

import mochico.example.com.start.from.convert.to.kotlin.models.JavaItem

class KotlinMainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var adapter = ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        findViewById<View>(R.id.fab).setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                Snackbar.make(view, "tapped!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }
        })

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setAdapter(adapter)

        val items = adapter.getItems()
        for (javaItem in items) {
            Log.d("item", "id : " + javaItem.id + " name : " + javaItem.name)
        }
    }

    public override fun onCreateOptionsMenu(menu: Menu): Boolean {
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

    public override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    internal inner class ItemAdapter : RecyclerView.Adapter<ItemViewHolder>() {

        private val items = ArrayList<JavaItem>()

        init {
            for (i in 0..5) {
                items.add(JavaItem(i, "item" + i))
            }
        }

        public override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            return ItemViewHolder(View.inflate(parent.getContext(), R.layout.list_item, null))
        }

        public override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            holder.bind(items.get(position))
        }

        public override fun getItemCount(): Int {
            return items.size
        }

        fun getItems(): List<JavaItem> {
            return items
        }
    }

    internal inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val id: TextView
        private val name: TextView

        init {
            id = itemView.findViewById<TextView>(R.id.list_item_id)
            name = itemView.findViewById<TextView>(R.id.list_item_name)
        }

        fun bind(javaItem: JavaItem) {
            id.setText((javaItem.id).toString())
            name.setText(javaItem.name)
        }
    }
}
