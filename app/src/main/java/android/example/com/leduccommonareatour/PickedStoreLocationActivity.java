package android.example.com.leduccommonareatour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class PickedStoreLocationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picked_store_location);
        /** Grab the address from the previous intent extras */
        Bundle storeAddress = getIntent().getExtras();
        int address = storeAddress.getInt("Address");
        /** Since the address is just an int, we can compare this variable to match it up with an
         * an associated custom made map image. Eg. if the address is 125 it goes through this list
         * of if and elses to find which image map to attach. Images are named by street name abbreviation,
         * Eg. dw is Discover Way, then the store address. Some stores share the same building and parking lot
         * Some stores, might have their own buidling and parking lot*/
        if(address<=118)
        {
            ImageView locationImage = (ImageView) findViewById(R.id.store_location_image);
            locationImage.setBackgroundResource(R.drawable.dw111to118);
        }
        else if (address==119){
            ImageView locationImage = (ImageView) findViewById(R.id.store_location_image);
            locationImage.setBackgroundResource(R.drawable.dw119);
        }
        else if (address>=120 && address<=130){
            ImageView locationImage = (ImageView) findViewById(R.id.store_location_image);
            locationImage.setBackgroundResource(R.drawable.dw120to130);
        }
        else if (address>=131 && address<=139){
            ImageView locationImage = (ImageView) findViewById(R.id.store_location_image);
            locationImage.setBackgroundResource(R.drawable.dw131to139);
        }
        else if (address>=140 && address<=145){
            ImageView locationImage = (ImageView) findViewById(R.id.store_location_image);
            locationImage.setBackgroundResource(R.drawable.dw140to145);
        }
        else if (address==200){
            ImageView locationImage = (ImageView) findViewById(R.id.store_location_image);
            locationImage.setBackgroundResource(R.drawable.dw200);
        }
        else if (address==201){
            ImageView locationImage = (ImageView) findViewById(R.id.store_location_image);
            locationImage.setBackgroundResource(R.drawable.dw201);
        }
        else if (address>=202 && address<=204){
            ImageView locationImage = (ImageView) findViewById(R.id.store_location_image);
            locationImage.setBackgroundResource(R.drawable.dw202to204);
        }
        else if (address==205){
            ImageView locationImage = (ImageView) findViewById(R.id.store_location_image);
            locationImage.setBackgroundResource(R.drawable.dw205);
        }
        else if (address==206){
            ImageView locationImage = (ImageView) findViewById(R.id.store_location_image);
            locationImage.setBackgroundResource(R.drawable.dw206);
        }
        else if (address==207){
            ImageView locationImage = (ImageView) findViewById(R.id.store_location_image);
            locationImage.setBackgroundResource(R.drawable.dw207);
        }
        else {
            ImageView locationImage = (ImageView) findViewById(R.id.store_location_image);
            locationImage.setBackgroundResource(R.drawable.dw208to212);
        }
    }
}