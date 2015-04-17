package lv.androiddev.baseSampleApp.viewHolders;

import android.view.View;
import android.widget.TextView;

import lv.androiddev.BaseApp.utils.BaseRecyclerViewHolder;
import lv.androiddev.baseSampleApp.R;

/**
 * Created by martinsstrengis on 17/04/15. Yey
 */
public class JokeHolder extends BaseRecyclerViewHolder {
    public TextView joke;
    public JokeHolder(View convertView){
        super(convertView);
        joke = (TextView) convertView.findViewById(R.id.joke);
    }
}
