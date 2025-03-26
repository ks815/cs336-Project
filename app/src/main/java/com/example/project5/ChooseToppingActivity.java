package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * This is an Android Activity Class for Choosing Toppings for Build Your Own.
 * @author Sihua Zhou, Yihang Sun
 */
public class ChooseToppingActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    /**
     * TextView for showing the price of the custom pizza.
     */
    private TextView buildYourOwnPrice;
    /**
     * ListView for showing the toppings of the custom pizza.
     */
    private ListView availableList, selectedList;
    /**
     * Array Adapter for set up list.
     */
    private ArrayAdapter<String> availableAdapter, selectedAdapter;
    /**
     * String passed from parent activity.
     */
    private String style, flavor, crust, size;
    /**
     * Double value used to calculate pizza price.
     */
    private double subtotal;

    /**
     * Initialization for this activity.
     * @param savedInstanceState Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_topping);
        availableAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, Topping.enumToList());
        selectedAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, new ArrayList<>());
        availableList = findViewById(R.id.availableList);
        selectedList = findViewById(R.id.selectedList);
        availableList.setOnItemClickListener(this);
        selectedList.setOnItemClickListener(this);
        availableList.setAdapter(availableAdapter);
        selectedList.setAdapter(selectedAdapter);
        Intent intent = getIntent();
        style = intent.getStringExtra("STYLE");
        flavor = intent.getStringExtra("FLAVOR");
        crust = intent.getStringExtra("CRUST");
        size = intent.getStringExtra("SIZE");
        buildYourOwnPrice = findViewById(R.id.buildYourOwnPrice);
        if(size.equalsIgnoreCase("small")){
            buildYourOwnPrice.setText("8.99"); subtotal = 8.99;
        }else if(size.equalsIgnoreCase("medium")){
            buildYourOwnPrice.setText("10.99"); subtotal = 10.99;
        }else if(size.equalsIgnoreCase("large")){
            buildYourOwnPrice.setText("12.99"); subtotal = 12.99;
        }
    }

    /**
     * OnClick Listener for selecting items.
     * @param adapterView adapterView
     * @param view view
     * @param i i
     * @param l j
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String item = (String) adapterView.getAdapter().getItem(i);
        availableList = findViewById(R.id.availableList);
        selectedList = findViewById(R.id.selectedList);

        if(adapterView.getAdapter().equals(availableAdapter)){
            if(selectedAdapter.getCount() < 7){
                selectedAdapter.add(item);
                availableAdapter.remove(item);
                availableList.setAdapter(availableAdapter);
                selectedList.setAdapter(selectedAdapter);
                double tempPrice = subtotal + BuildYourOwn.pricePerTopping * selectedAdapter.getCount();
                buildYourOwnPrice.setText(String.format("%.2f", tempPrice));
            }else{
                Toast.makeText(getApplicationContext(), "Cannot Choose More Than 7 Toppings!", Toast.LENGTH_SHORT).show();
            }
        }else if(adapterView.getAdapter().equals(selectedAdapter)){
            availableAdapter.add(item);
            selectedAdapter.remove(item);
            availableList.setAdapter(availableAdapter);
            selectedList.setAdapter(selectedAdapter);
            double tempPrice = subtotal + BuildYourOwn.pricePerTopping * selectedAdapter.getCount();
            buildYourOwnPrice.setText(String.format("%.2f", tempPrice));
        }

    }

    /**
     * Method for place ordering after pressing the button.
     * @param view Button
     */
    public void placePizzaOrder(View view){
        ArrayList<String> temp = new ArrayList<>();
        for(int index = 0; index < selectedAdapter.getCount(); index++){
            temp.add(selectedAdapter.getItem(index));
        }
        ArrayList<Topping> toppings = Topping.ListToList(temp);
        if(style.equalsIgnoreCase("Style: Chicago")){
            PizzaFactory pizzaFactory = new ChicagoPizza();
            Pizza pizza = pizzaFactory.createBuildYourOwn();
            pizza.setCrust(Crust.findCrust(crust));
            pizza.setSize(Size.findSize(size));
            pizza.setToppings(toppings);
            MainActivity.CURRENT_ORDER.add(pizza);
            String plainTextOrder = String.format("Build Your Own (Chicago Style - %s), %s%s $%.2f",Crust.findCrust(crust).toString(), pizza.getToppingString(), Size.findSize(size).toString(), pizza.price());
            MainActivity.CURRENT_ORDER.add(plainTextOrder);
        }else{
            PizzaFactory pizzaFactory = new NYPizza();
            Pizza pizza = pizzaFactory.createBuildYourOwn();
            pizza.setCrust(Crust.findCrust(crust));
            pizza.setSize(Size.findSize(size));
            pizza.setToppings(toppings);
            MainActivity.CURRENT_ORDER.add(pizza);
            String plainTextOrder = String.format("Build Your Own (New York Style - %s), %s%s $%.2f",Crust.findCrust(crust).toString(), pizza.getToppingString(), Size.findSize(size).toString(), pizza.price());
            MainActivity.CURRENT_ORDER.add(plainTextOrder);
        }
        Toast.makeText(getApplicationContext(), "Order Added!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, PizzaActivity.class);
        startActivity(intent);
    }
}