package lv.androiddev.baseSampleApp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

import lv.androiddev.BaseApp.BaseActivity;
import lv.androiddev.BaseApp.BaseListFragment;
import lv.androiddev.BaseApp.utils.BaseItem;
import lv.androiddev.BaseApp.views.BaseRecyclerView;
import lv.androiddev.baseSampleApp.models.Picture;

/**
 * Created by martinsstrengis on 17/04/15. Yey
 */
public class PicturesFragment extends BaseListFragment{
    public PicturesFragment(){
        layout = R.layout.pictures_fragment;
    }

    @Override
    public void init(){
        super.init();

        recyclerView.setOnItemClickListener(new BaseRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(int i, long l, View view) {
                Bundle args = new Bundle();
                Picture pic = (Picture) data.get(i);
                args.putString("image_url", pic.url);
                args.putString("title", pic.title);
                args.putInt("width", pic.width);
                args.putInt("height", pic.height);
                args.putString("pic_data", pic.toJSONString());


                if(randInt(0, 1) == 1){
                    ((BaseActivity) getActivity())
                            .getFragmentTransaction(new OpenedPictureList(), args, true)
                            .addSharedElement(view.findViewById(R.id.image), "image" + pic.id)
                            .addSharedElement(view.findViewById(R.id.text), "text" + pic.id)
                            .commit();
                }else {
                    ((BaseActivity) getActivity())
                            .getFragmentTransaction(new PictureFragment(), args, true)
                            .addSharedElement(view.findViewById(R.id.image), "imageOpen")
                            .addSharedElement(view.findViewById(R.id.text), "textOpen")
                            .commit();
                }
            }

        });
    }

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public void actionReceived(Context context, Intent intent) {

    }

    @Override
    public void setRequestParams() {
        apiBuilder.setUrl("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=bmw%20F30%20m3&start=" + String.valueOf((page - 1) * 4));
    }

    @Override
    public ArrayList<BaseItem> parseData(JSONObject jsonObject) {
        ArrayList<BaseItem> pics = new ArrayList<>();

        JSONArray arr = jsonObject.optJSONObject("responseData").optJSONArray("results");
        for(int i = 0; i < arr.length(); i++){
            pics.add(new Picture(arr.optJSONObject(i)));
        }

        return pics;
    }
}
