package itacademy.kg.musicshop;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ResourseAdaptor extends ArrayAdapter<Resourse>{

    Context context;
    int resourse;

    public ResourseAdaptor(@NonNull Context context, int resource, @NonNull ArrayList<Resourse> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourse = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        int image = getItem(position).image;
        String name = getItem(position).name;
        String amount = getItem(position).amount;
        String quantity = getItem(position).quantity;
        String nameUser = getItem(position).nameUser;

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.list_itam,parent,false);

        ImageView tv_image = convertView.findViewById(R.id.image_Itam);
        TextView tv_name = convertView.findViewById(R.id.name_Itam);
        TextView tv_amount = convertView.findViewById(R.id.amount_Itam);
        TextView tv_quantity = convertView.findViewById(R.id.quantity_Itam);
        TextView tv_nameUser = convertView.findViewById(R.id.nameUser_itam);
        Button delent = convertView.findViewById(R.id.delent_Itam);

        delent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInformation information = new UserInformation();
                information.remote(position);
                notifyDataSetChanged();
            }
        });

        tv_image.setImageResource(image);
        tv_name.setText(name);
        tv_amount.setText(amount);
        tv_quantity.setText(quantity);
        tv_nameUser.setText(nameUser);



        return convertView;
    }

}
