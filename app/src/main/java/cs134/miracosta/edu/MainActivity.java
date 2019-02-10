package cs134.miracosta.edu;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private EditText weightET;
    private TextView addedCostTV;
    private TextView totalCostTV;

    private ShippingItem item;

    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        weightET = findViewById(R.id.weightET);
        addedCostTV = findViewById(R.id.addedCostNum);
        totalCostTV = findViewById((R.id.totalCostNum));



        item = new ShippingItem();



        //weightET.setText(getString(R.string.weightET));
        weightET.setSelection(weightET.getText().length());
        weightET.addTextChangedListener(new TextWatcher() {

            boolean _ignore = false;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!_ignore) {
                    String st = s.toString();
                    // you have no idea how long it took me to realize this needed to be "st = st.replace" and not just "st.replace"
                    st = st.replace(getString(R.string.weightET), "");

                    if (st.length() == 0) {
                        st = "Enter Weight...";
                        return;
                    }


                    _ignore = true;
                    weightET.setText(st);
                    weightET.setSelection(weightET.getText().length());
                    item.updateTotalCost(Integer.parseInt(weightET.getText().toString()));
                    addedCostTV.setText(nf.format(item.getAddedCost()));
                    totalCostTV.setText((nf.format(item.getTotalCost())));
                    _ignore = false;

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });







    }
}
