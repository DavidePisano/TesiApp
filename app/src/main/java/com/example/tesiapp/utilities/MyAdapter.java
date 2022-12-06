package com.example.tesiapp.utilities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tesiapp.R;
import com.example.tesiapp.activities.DetailActivity;
import com.example.tesiapp.activities.ProductData;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private Context mContext;
    private List<ProductData> myProductList;

    public MyAdapter(Context mContext, List<ProductData> myProductList) {
        this.mContext = mContext;
        this.myProductList = myProductList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row_item,viewGroup,false);

        return new ProductViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {

        productViewHolder.imageView.setImageResource(myProductList.get(i).getItemImage());
        productViewHolder.mTitle.setText(myProductList.get(i).getItemName());
        productViewHolder.mDescription.setText(myProductList.get(i).getItemDescription());
        productViewHolder.mPrice.setText(myProductList.get(i).getItemPrice());

        productViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("Image",myProductList.get(productViewHolder.getAdapterPosition()).getItemImage());
                intent.putExtra("Description",myProductList.get(productViewHolder.getAdapterPosition()).getItemDescription());
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return myProductList.size();
    }
}

class ProductViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView mTitle, mDescription, mPrice;
    CardView mCardView;

    public ProductViewHolder(View itemView) {
        super(itemView);

        imageView =  itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mDescription = itemView.findViewById(R.id.tvDescription);
        mPrice = itemView.findViewById(R.id.tvPrice);

        mCardView = itemView.findViewById(R.id.myCardView);
    }
}
