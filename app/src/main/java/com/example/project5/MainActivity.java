package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * This is an Android Activity Class for Main View Activity.
 * @author Sihua Zhou, Yihang Sun
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Global Value for storing store orders.
     */
    public static StoreOrder STORE_ORDER = new StoreOrder();
    /**
     * Global Value for storing current order.
     */
    public static Order CURRENT_ORDER = new Order(0);

    /**
     * Initialization for this activity.
     * @param savedInstanceState Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    /**
     * OnClick Method for opening pizza ordering activity.
     * @param view Button.
     */
    public void openPizzaOrder(View view){
        Intent pizzaOrder = new Intent(this, PizzaActivity.class);
        startActivity(pizzaOrder);
    }

    /**
     * OnClick Method for opening current order/cart activity.
     * @param view Button.
     */
    public void openCurrentOrder(View view){
        Intent currentOrder = new Intent(this, CurrentOrderActivity.class);
        startActivity(currentOrder);
    }

    /**
     * OnClick Method for opening store order activity.
     * @param view Button.
     */
    public void openStoreOrder(View view){
        Intent storeOrder = new Intent(this, StoreOrderActivity.class);
        startActivity(storeOrder);
    }
}