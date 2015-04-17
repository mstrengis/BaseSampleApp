package lv.androiddev.baseSampleApp;

import android.content.Context;
import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import lv.androiddev.BaseApp.BaseListFragment;
import lv.androiddev.BaseApp.utils.BaseItem;

/**
 * Created by martinsstrengis on 17/04/15. Yey
 */
public class OpenedPictureList extends BaseListFragment {
    public OpenedPictureList(){
        _configDisableLoadMore = true;
        _configFirstElementIsStatic = true;
        layout = R.layout.pictures_fragment;
    }

    @Override
    public void init(){
        try {
            Picture pic = new Picture(new JSONObject(getArguments().getString("pic_data")));
            pic.opened = true;
            data.add(pic);
        }catch (Exception e){
            e.printStackTrace();
        }

        super.init();
    }

    @Override
    public void actionReceived(Context context, Intent intent) {

    }

    @Override
    public void setRequestParams() {
        apiBuilder.setUrl("http://api.icndb.com/jokes/random/10");
    }

    @Override
    public ArrayList<BaseItem> parseData(JSONObject jsonObject) {
        ArrayList<BaseItem> jokes = new ArrayList<>();

        JSONArray arr = jsonObject.optJSONArray("value");
        int l = arr.length();
        for(int i = 0; i < l; i++){
            jokes.add(new Joke(arr.optJSONObject(i)));
        }

        return jokes;
    }
}
