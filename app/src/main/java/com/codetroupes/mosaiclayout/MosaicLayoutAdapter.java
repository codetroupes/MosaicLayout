package com.codetroupes.mosaiclayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;


import com.sunfusheng.GlideImageView;

import java.util.List;

public class MosaicLayoutAdapter extends ArrayAdapter<Object> {
	private Context context;
	private List<Image> values;

	public MosaicLayoutAdapter(Context context) {
		super(context, R.layout.row_item);
		this.context = context;
	}

	public void setData(List<Image> values) {
		this.values = values;
	}

	@Override
	public int getCount() {
		return values.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(R.layout.row_item, parent, false);
		GlideImageView image = rowView.findViewById(R.id.image);
//		Picasso.with(context).load(values.get(position).getTbUrl()).into(image);
		image.load(values.get(position).getTbUrl());
		return rowView;

	}
}
