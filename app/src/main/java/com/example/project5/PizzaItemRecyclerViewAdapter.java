package com.example.project5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Recycler View Helper Class.
 * @author Sihua Zhou, Yihang Sun
 */
public class PizzaItemRecyclerViewAdapter extends RecyclerView.Adapter<PizzaItemRecyclerViewAdapter.PizzaItemsHolder> {

    /**
     * Context.
     */
    private Context context;
    /**
     * ArrayList for pizza items.
     */
    private ArrayList<PizzaItems> pizzaItems;

    /**
     * Constructor for this helper class.
     * @param context context.
     * @param pizzaItems pizza items.
     */
    public PizzaItemRecyclerViewAdapter(Context context, ArrayList<PizzaItems> pizzaItems){
        this.context = context;
        this.pizzaItems = pizzaItems;
    }

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to represent
     * an item.
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public PizzaItemRecyclerViewAdapter.PizzaItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where you inflate the layout (Giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pizza_recycler_row, parent, false);

        return new PizzaItemRecyclerViewAdapter.PizzaItemsHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull PizzaItemRecyclerViewAdapter.PizzaItemsHolder holder, int position) {
        // Assigning values to the views we created in the pizza_recycler_row layout file
        // based on the position of the recycler view

        holder.pizzaImage.setImageResource(pizzaItems.get(position).getImages());
        holder.pizzaStyle.setText(pizzaItems.get(position).getStyle());
        holder.pizzaFlavor.setText(pizzaItems.get(position).getFlavor());
        holder.pizzaCrust.setText(pizzaItems.get(position).getCrust());
        holder.pizzaToppingList.setText(pizzaItems.get(position).getToppings());
        holder.smallPizzaPrice.setText(pizzaItems.get(position).getSmallPrice());
        holder.mediumPizzaPrice.setText(pizzaItems.get(position).getMediumPrice());
        holder.largePizzaPrice.setText(pizzaItems.get(position).getLargePrice());
        holder.buttonText.setText(pizzaItems.get(position).getButtonText());
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        // The recycler view just wants to know the number of items your want to displayed.
        return pizzaItems.size();
    }

    /**
     * Grabbing the view from our pizza_recycler_view_row layout file.
     */
    public static class PizzaItemsHolder extends RecyclerView.ViewHolder{
        // Grabbing the view from our pizza_recycler_view_row layout file
        // Kinda like in the onCreate method
        private ImageView pizzaImage;
        private TextView pizzaStyle, pizzaFlavor ,pizzaCrust, pizzaToppingList;
        private RadioGroup pizzaSizeGroup;
        private RadioButton smallPizzaPrice, mediumPizzaPrice, largePizzaPrice;
        private Button buttonText;

        /**
         * Pizza Item holders.
         * @param itemView itemView.
         */
        public PizzaItemsHolder(@NonNull View itemView) {
            super(itemView);

            pizzaImage = itemView.findViewById(R.id.pizzaImage);
            pizzaStyle = itemView.findViewById(R.id.pizzaStyle);
            pizzaFlavor = itemView.findViewById(R.id.pizzaFlavor);
            pizzaCrust = itemView.findViewById(R.id.pizzaCrust);
            pizzaToppingList = itemView.findViewById(R.id.pizzaToppingList);
            smallPizzaPrice = itemView.findViewById(R.id.smallPizzaPrice);
            mediumPizzaPrice = itemView.findViewById(R.id.mediumPizzaPrice);
            largePizzaPrice = itemView.findViewById(R.id.largePizzaPrice);
            buttonText = itemView.findViewById(R.id.buttonText);
            setButtonTextOnClick(itemView);
        }

        /**
         * OnClick Method for triggering button to add pizza.
         * @param itemView itemView.
         */
        private void setButtonTextOnClick(@NonNull View itemView){
            buttonText.setOnClickListener(new View.OnClickListener() {
                /**
                 * OnClick Method to add pizza.
                 * @param view Button.
                 */
                @Override
                public void onClick(View view) {
                    buttonText = itemView.findViewById(R.id.buttonText);
                    if(buttonText.getText().equals("Add to Order")){
                        AlertDialog.Builder alert = new AlertDialog.Builder(itemView.getContext());
                        alert.setMessage("Do you want to add this pizza to order?");
                        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (smallPizzaPrice.isChecked()) {
                                    formPizzaOrderNonbuild((String) pizzaStyle.getText(), (String) pizzaFlavor.getText(), (String) pizzaCrust.getText(), "small");
                                } else if (mediumPizzaPrice.isChecked()) {
                                    formPizzaOrderNonbuild((String) pizzaStyle.getText(), (String) pizzaFlavor.getText(), (String) pizzaCrust.getText(), "medium");
                                } else if (largePizzaPrice.isChecked()){
                                    formPizzaOrderNonbuild((String) pizzaStyle.getText(), (String) pizzaFlavor.getText(), (String) pizzaCrust.getText(), "large");
                                }else{
                                    Toast.makeText(itemView.getContext(), "Choose a size!", Toast.LENGTH_LONG).show();
                                }
                                pizzaSizeGroup = itemView.findViewById(R.id.pizzaSizeGroup); pizzaSizeGroup.clearCheck();
                            }

                        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(itemView.getContext(), "Order not added!", Toast.LENGTH_SHORT).show();
                            }
                        });
                        AlertDialog dialog = alert.create();
                        dialog.show();
                    }else if(buttonText.getText().equals("Build Your Own")){
                        Intent chooseTopping = new Intent(itemView.getContext(), ChooseToppingActivity.class);
                        chooseTopping.putExtra("STYLE", pizzaStyle.getText()); chooseTopping.putExtra("FLAVOR", pizzaFlavor.getText()); chooseTopping.putExtra("CRUST", pizzaCrust.getText());
                        if(smallPizzaPrice.isChecked()){
                            chooseTopping.putExtra("SIZE", "small"); itemView.getContext().startActivity(chooseTopping);
                        }else if(mediumPizzaPrice.isChecked()){
                            chooseTopping.putExtra("SIZE", "medium"); itemView.getContext().startActivity(chooseTopping);
                        }else if(largePizzaPrice.isChecked()){
                            chooseTopping.putExtra("SIZE", "large"); itemView.getContext().startActivity(chooseTopping);
                        }else{
                            Toast.makeText(itemView.getContext(), "Choose a size!", Toast.LENGTH_SHORT).show();
                        }
                        pizzaSizeGroup = itemView.findViewById(R.id.pizzaSizeGroup); pizzaSizeGroup.clearCheck();
                    }
                }

                /**
                 * Forming Pizza instance and add into list.
                 * @param style Pizza Style.
                 * @param flavor Pizza Flavor.
                 * @param crust Pizza Crust.
                 * @param size Pizza Size.
                 */
                private void formPizzaOrderNonbuild(String style, String flavor, String crust, String size){
                    String plainTextOrder = "";
                    if(style.equals("Style: Chicago")){
                        PizzaFactory chicago = new ChicagoPizza();
                        if(flavor.equals("Deluxe")){
                            Pizza pizza = chicago.createDeluxe(); pizza.setCrust(Crust.findCrust(crust)); pizza.setSize(Size.findSize(size)); pizza.setToppings(Topping.defaultDeluxeList()); MainActivity.CURRENT_ORDER.add(pizza);
                            plainTextOrder = String.format("Deluxe (Chicago Style - %s), %s%s $%.2f",Crust.findCrust(crust).toString(), pizza.getToppingString(), Size.findSize(size).toString(), pizza.price()); MainActivity.CURRENT_ORDER.add(plainTextOrder);
                        }else if(flavor.equals("BBQ Chicken")){
                            Pizza pizza = chicago.createBBQChicken(); pizza.setCrust(Crust.findCrust(crust)); pizza.setSize(Size.findSize(size)); pizza.setToppings(Topping.defaultBBQChickenList()); MainActivity.CURRENT_ORDER.add(pizza);
                            plainTextOrder = String.format("BBQ Chicken (Chicago Style - %s), %s%s $%.2f",Crust.findCrust(crust).toString(), pizza.getToppingString(), Size.findSize(size).toString(), pizza.price()); MainActivity.CURRENT_ORDER.add(plainTextOrder);

                        }else{
                            Pizza pizza = chicago.createMeatzza(); pizza.setCrust(Crust.findCrust(crust)); pizza.setSize(Size.findSize(size)); pizza.setToppings(Topping.defaultMeatzzaList()); MainActivity.CURRENT_ORDER.add(pizza);
                            plainTextOrder = String.format("Meatzza (Chicago Style - %s), %s%s $%.2f",Crust.findCrust(crust).toString(), pizza.getToppingString(), Size.findSize(size).toString(), pizza.price()); MainActivity.CURRENT_ORDER.add(plainTextOrder);
                        }
                    }else{
                        PizzaFactory newYork = new NYPizza();
                        if(flavor.equals("Deluxe")){
                            Pizza pizza = newYork.createDeluxe(); pizza.setCrust(Crust.findCrust(crust)); pizza.setSize(Size.findSize(size)); pizza.setToppings(Topping.defaultDeluxeList()); MainActivity.CURRENT_ORDER.add(pizza);
                            plainTextOrder = String.format("Deluxe (New York Style - %s), %s%s $%.2f",Crust.findCrust(crust).toString(), pizza.getToppingString(), Size.findSize(size).toString(), pizza.price()); MainActivity.CURRENT_ORDER.add(plainTextOrder);
                        }else if(flavor.equals("BBQ Chicken")){
                            Pizza pizza = newYork.createBBQChicken(); pizza.setCrust(Crust.findCrust(crust)); pizza.setSize(Size.findSize(size)); pizza.setToppings(Topping.defaultBBQChickenList()); MainActivity.CURRENT_ORDER.add(pizza);
                            plainTextOrder = String.format("BBQ Chicken (New York Style - %s), %s%s $%.2f",Crust.findCrust(crust).toString(), pizza.getToppingString(), Size.findSize(size).toString(), pizza.price()); MainActivity.CURRENT_ORDER.add(plainTextOrder);
                        }else{
                            Pizza pizza = newYork.createMeatzza(); pizza.setCrust(Crust.findCrust(crust)); pizza.setSize(Size.findSize(size)); pizza.setToppings(Topping.defaultMeatzzaList()); MainActivity.CURRENT_ORDER.add(pizza);
                            plainTextOrder = String.format("Meatzza (New York Style - %s), %s%s $%.2f",Crust.findCrust(crust).toString(), pizza.getToppingString(), Size.findSize(size).toString(), pizza.price()); MainActivity.CURRENT_ORDER.add(plainTextOrder);
                        }
                    }
                    Toast.makeText(itemView.getContext(), "Order added!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
