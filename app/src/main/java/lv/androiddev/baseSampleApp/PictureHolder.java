package lv.androiddev.baseSampleApp;

import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import lv.androiddev.BaseApp.utils.BaseRecyclerViewHolder;

/**
 * Created by martinsstrengis on 17/04/15. Yey
 */
public class PictureHolder extends BaseRecyclerViewHolder {
    public NetworkImageView image;
    public TextView text;
    public PictureHolder(View convertView) {
        super(convertView);

        image = (NetworkImageView) convertView.findViewById(R.id.image);
        text = (TextView) convertView.findViewById(R.id.text);
    }
}