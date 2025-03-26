package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This is an Android Activity Class for Store Order activity.
 * @author Sihua Zhou, Yihang Sun
 */
public class StoreOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /**
     * Spinner for order number.
     */
    private Spinner spinner;
    /**
     * ListView for list of pizza in certain order.
     */
    private ListView listOfPizzaStoreOrder;
    /**
     * TextView to show total price for this order.
     */
    private TextView totalPrice;
    /**
     * Array Adapter for list of pizzas in store order.
     */
    private ArrayAdapter<String> listOfPizzaStoreOrderAdapter;
    /**
     * Array Adapter for list of order numbers in store order.
     */
    private ArrayAdapter<Integer>  orderNumberListAdapter;

    /**
     * Initialization for this activity.
     * @param savedInstanceState Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order);
        if(MainActivity.STORE_ORDER.getListOfOrder().size() > 0){
            orderNumberListAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, MainActivity.STORE_ORDER.getOrderNumbers());
            spinner = findViewById(R.id.spinner);
            spinner.setAdapter(orderNumberListAdapter);
            spinner.setSelection(0);
            spinner.setOnItemSelectedListener(this);
            System.out.println(MainActivity.STORE_ORDER.getOrderDetail(spinner.getSelectedItemPosition()).getListOfPizzaDisplay().size());
            listOfPizzaStoreOrderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, MainActivity.STORE_ORDER.getOrderDetail(spinner.getSelectedItemPosition()).getListOfPizzaDisplay());
            listOfPizzaStoreOrder = findViewById(R.id.listOfPizzaStoreOrder);
            listOfPizzaStoreOrder.setAdapter(listOfPizzaStoreOrderAdapter);
            totalPrice = findViewById(R.id.totalPrice);
            totalPrice.setText(MainActivity.STORE_ORDER.getOrderDetail(spinner.getSelectedItemPosition()).calculateOrderTotal());
        }else{
            Toast.makeText(this, "Store Order is Empty!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * OnSelected Method to get selected items.
     * @param adapterView adapterView.
     * @param view view.
     * @param i i.
     * @param l l.
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        listOfPizzaStoreOrderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, MainActivity.STORE_ORDER.getOrderDetail(i).getListOfPizzaDisplay());
        listOfPizzaStoreOrder = findViewById(R.id.listOfPizzaStoreOrder);
        listOfPizzaStoreOrder.setAdapter(listOfPizzaStoreOrderAdapter);
        totalPrice = findViewById(R.id.totalPrice);
        totalPrice.setText(MainActivity.STORE_ORDER.getOrderDetail(i).calculateOrderTotal());
    }

    /**
     * Support method for onItemSelected when no selection been made.
     * @param adapterView adapterView.
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /**
     * OnClick method for removing order.
     * @param view Button.
     */
    public void removeOrder(View view){
        if(MainActivity.STORE_ORDER.getOrderNumbers().size() > 0){
            int index = spinner.getSelectedItemPosition();
            MainActivity.STORE_ORDER.getOrderNumbers().remove(MainActivity.STORE_ORDER.getOrderNumbers().get(index));
            MainActivity.STORE_ORDER.getListOfOrder().remove(MainActivity.STORE_ORDER.getListOfOrder().get(index));
            if(MainActivity.STORE_ORDER.getOrderNumbers().size() > 0){
                orderNumberListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,MainActivity.STORE_ORDER.getOrderNumbers());
                spinner.setAdapter(orderNumberListAdapter);
                spinner.setSelection(0);
                listOfPizzaStoreOrderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, MainActivity.STORE_ORDER.getOrderDetail(spinner.getSelectedItemPosition()).getListOfPizzaDisplay());
                listOfPizzaStoreOrder = findViewById(R.id.listOfPizzaStoreOrder);
                listOfPizzaStoreOrder.setAdapter(listOfPizzaStoreOrderAdapter);
                totalPrice = findViewById(R.id.totalPrice);
                totalPrice.setText(MainActivity.STORE_ORDER.getOrderDetail(spinner.getSelectedItemPosition()).calculateOrderTotal());
            }else{
                listOfPizzaStoreOrder.setAdapter(null);
                spinner.setAdapter(null);
                totalPrice.setText("0.00");
            }
        }else{
            Toast.makeText(this, "Store Order is Empty!", Toast.LENGTH_SHORT).show();
        }
    }
}