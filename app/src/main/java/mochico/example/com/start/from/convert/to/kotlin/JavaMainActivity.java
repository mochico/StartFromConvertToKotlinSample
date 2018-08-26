package mochico.example.com.start.from.convert.to.kotlin;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mochico.example.com.start.from.convert.to.kotlin.models.JavaItem;

public class JavaMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ItemAdapter adapter = new ItemAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "tapped!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);

        List<JavaItem> items = adapter.getItems();
        for (JavaItem javaItem : items) {
            Log.d("item", "id : " + javaItem.getId() + " name : " + javaItem.getName());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

        private List<JavaItem> items = new ArrayList<>();

        public ItemAdapter() {
            for (int i = 0; i <= 5; i++) {
                items.add(new JavaItem(i, "item" + i));
            }
        }

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ItemViewHolder(View.inflate(parent.getContext(), R.layout.list_item, null));
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            holder.bind(items.get(position));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public List<JavaItem> getItems() {
            return items;
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView id;
        private TextView name;

        public ItemViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.list_item_id);
            name = itemView.findViewById(R.id.list_item_name);
        }

        public void bind(JavaItem javaItem) {
            id.setText(String.valueOf(javaItem.getId()));
            name.setText(javaItem.getName());
        }
    }
}
