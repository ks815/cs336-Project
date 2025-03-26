package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * This is an Android Activity Class for Current Order Activity
 * @author Sihua Zhou, Yihang Sun
 */
public class CurrentOrderActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    /**
     * ListView for list of pizza.
     */
    private ListView listOfPizza;
    /**
     * Array Adapter list of pizza.
     */
    private ArrayAdapter<String> listOfPizzaAdapter;
    /**
     * TextView for display fields.
     */
    private TextView orderNumberCurrentOrder, subtotal, salesTaxes, orderTotal;

    /**
     * Initialization for this activity.
     * @param savedInstanceState Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);
        listOfPizzaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1 ,MainActivity.CURRENT_ORDER.getListOfPizzaDisplay());
        listOfPizza = findViewById(R.id.listOfPizza);
        listOfPizza.setOnItemClickListener(this);
        listOfPizza.setAdapter(listOfPizzaAdapter);
        orderNumberCurrentOrder = findViewById(R.id.orderNumberCurrentOrder);
        subtotal = findViewById(R.id.subtotal);
        salesTaxes = findViewById(R.id.salesTaxes);
        orderTotal = findViewById(R.id.orderTotal);
        orderNumberCurrentOrder.setText(MainActivity.CURRENT_ORDER.getOrder_number() + "");
        subtotal.setText(MainActivity.CURRENT_ORDER.calculateSubtotal());
        salesTaxes.setText(MainActivity.CURRENT_ORDER.calculateSalesTax());
        orderTotal.setText(MainActivity.CURRENT_ORDER.calculateOrderTotal());
    }

    /**
     * OnClick Method for cancel order.
     * @param view Button.
     */
    public void cancelOrder(View view){
        if(listOfPizzaAdapter.getCount() > 0){
            AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
            alert.setMessage("Do you want to remove all the pizzas?");
            alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.CURRENT_ORDER.getListOfPizzaDisplay().removeAll(MainActivity.CURRENT_ORDER.getListOfPizzaDisplay());
                    MainActivity.CURRENT_ORDER.getListOfPizza().removeAll(MainActivity.CURRENT_ORDER.getListOfPizza());
                    listOfPizzaAdapter.clear();
                    listOfPizza = findViewById(R.id.listOfPizza);
                    listOfPizza.setAdapter(listOfPizzaAdapter);
                    subtotal.setText(MainActivity.CURRENT_ORDER.calculateSubtotal());
                    salesTaxes.setText(MainActivity.CURRENT_ORDER.calculateSalesTax());
                    orderTotal.setText(MainActivity.CURRENT_ORDER.calculateOrderTotal());
                }
            }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(view.getContext(), "Pizzas remain!", Toast.LENGTH_SHORT).show();
                }
            });
            alert.show();
        }else{
            Toast.makeText(view.getContext(), "Order is Empty!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * OnClick Method for placing order.
     * @param view Button
     */
    public void placeOrder(View view){
        if(listOfPizzaAdapter.getCount() > 0){
            AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
            alert.setMessage("Do you want to place the order?");
            alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.STORE_ORDER.add(MainActivity.CURRENT_ORDER);
                    MainActivity.STORE_ORDER.add((Integer) MainActivity.CURRENT_ORDER.getOrder_number());
                    MainActivity.CURRENT_ORDER = new Order(MainActivity.CURRENT_ORDER.getOrder_number());
                    orderNumberCurrentOrder.setText(MainActivity.CURRENT_ORDER.getOrder_number()+"");
                    subtotal.setText(MainActivity.CURRENT_ORDER.calculateSubtotal());
                    salesTaxes.setText(MainActivity.CURRENT_ORDER.calculateSalesTax());
                    orderTotal.setText(MainActivity.CURRENT_ORDER.calculateOrderTotal());
                    listOfPizza.setAdapter(null);
                    Toast.makeText(view.getContext(), "Order Placed!", Toast.LENGTH_SHORT).show();
                }
            }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(view.getContext(), "Pizzas remain!", Toast.LENGTH_SHORT).show();
                }
            });
            alert.show();
        }else{
            Toast.makeText(view.getContext(), "Order is Empty!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * OnClicker Listener Method for selecting items.
     * @param adapterView adapterView
     * @param view view
     * @param i i
     * @param l j
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String temp = (String) adapterView.getAdapter().getItem(i);
        AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
        alert.setMessage("Do you want to remove this pizza?");
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                int index = MainActivity.CURRENT_ORDER.getListOfPizzaDisplay().indexOf(temp);
                MainActivity.CURRENT_ORDER.remove(temp);
                MainActivity.CURRENT_ORDER.remove(MainActivity.CURRENT_ORDER.getListOfPizza().get(index));
                listOfPizzaAdapter.remove(temp);
                listOfPizza = findViewById(R.id.listOfPizza);
                listOfPizza.setAdapter(listOfPizzaAdapter);
                subtotal.setText(MainActivity.CURRENT_ORDER.calculateSubtotal());
                salesTaxes.setText(MainActivity.CURRENT_ORDER.calculateSalesTax());
                orderTotal.setText(MainActivity.CURRENT_ORDER.calculateOrderTotal());
                Toast.makeText(view.getContext(), "Pizza removed!", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(view.getContext(), "Pizza remains!", Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();
    }
}