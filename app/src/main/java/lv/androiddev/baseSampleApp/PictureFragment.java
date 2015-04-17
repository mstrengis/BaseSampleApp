package lv.androiddev.baseSampleApp;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONObject;

import java.util.ArrayList;
import lv.androiddev.BaseApp.BaseFragment;
import lv.androiddev.BaseApp.utils.BaseItem;

/**
 * Created by martinsstrengis on 17/04/15. Yey
 */
public class PictureFragment extends BaseFragment {

    public PictureFragment(){
        layout = R.layout.picture_fragment;
    }

    private NetworkImageView mImage;
    private TextView mText;


    @Override
    public void init() {
        _configDisableLoad = true;
        mImage = (NetworkImageView) rootView.findViewById(R.id.image);
        mText = (TextView) rootView.findViewById(R.id.text);

        mImage.setImageUrl(getArguments().getString("image_url"), App.IMAGE_LOADER);
        mImage.getLayoutParams().height = (int) (getArguments().getInt("height") * getResources().getDisplayMetrics().widthPixels / (float) getArguments().getInt("width"));
        mText.setText(Html.fromHtml(getArguments().getString("title")));
    }

    @Override
    public void actionReceived(Context context, Intent intent) {

    }

    @Override
    public void setRequestParams() {

    }

    @Override
    public ArrayList<BaseItem> parseData(JSONObject jsonObject) {
        return null;
    }
}
