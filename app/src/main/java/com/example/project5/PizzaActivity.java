package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

/**
 * This is an Android Activity Class for Order Pizza.
 * @author Sihua Zhou, Yihang Sun
 */
public class PizzaActivity extends AppCompatActivity {

    /**
     * ArrayList to holder information for pizza items.
     */
    private ArrayList<PizzaItems> pizzaItems = new ArrayList<>();
    /**
     * int array for holding images id.
     */
    private int[] pizzaImages = {R.drawable.chicago_deluxe, R.drawable.chicago_bbqchicken,
            R.drawable.chicago_meatzza, R.drawable.chicago_buildyourown, R.drawable.newyork_deluxe,
            R.drawable.newyork_bbqchicken, R.drawable.newyork_meatzza, R.drawable.newyork_buildyourown};

    /**
     * Initialization for this activity.
     * @param savedInstanceState Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        RecyclerView recyclerView = findViewById(R.id.pizzaRecyclerView);

        setUpPizzaItems();

        PizzaItemRecyclerViewAdapter adapter = new PizzaItemRecyclerViewAdapter(this, pizzaItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Private helper method to  set up recycler view information.
     */
    private void setUpPizzaItems(){
        String[] pizzaStyleList = getResources().getStringArray(R.array.styleList);
        String[] pizzaFlavorList = getResources().getStringArray(R.array.flavorList);
        String[] pizzaCrustList = getResources().getStringArray(R.array.crustList);
        String[] pizzaToppingsList = getResources().getStringArray(R.array.toppingsList);
        String[] pizzaSmallPrice = getResources().getStringArray(R.array.smallPriceList);
        String[] pizzaMediumPrice = getResources().getStringArray(R.array.mediumPriceList);
        String[] pizzaLargePrice = getResources().getStringArray(R.array.largePriceList);
        String[] pizzaOrdertext = getResources().getStringArray(R.array.buttonText);

        for (int index = 0; index < pizzaStyleList.length; index++){
            pizzaItems.add(new PizzaItems(pizzaImages[index], pizzaStyleList[index], pizzaFlavorList[index], pizzaCrustList[index],
                    pizzaToppingsList[index], pizzaSmallPrice[index], pizzaMediumPrice[index],
                    pizzaLargePrice[index], pizzaOrdertext[index]));
        }
    }
}