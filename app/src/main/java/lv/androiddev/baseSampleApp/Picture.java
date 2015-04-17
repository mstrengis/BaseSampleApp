package lv.androiddev.baseSampleApp;

import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import org.json.JSONObject;

import lv.androiddev.BaseApp.BaseActivity;
import lv.androiddev.BaseApp.BaseApplication;
import lv.androiddev.BaseApp.utils.BaseItem;

/**
 * Created by martinsstrengis on 17/04/15. Yey
 */
public class Picture extends BaseItem<PictureHolder>{
    public String url, title;
    public int width, height;
    public JSONObject picData;
    public boolean opened = false;

    public Picture(JSONObject pic){
        picData = pic;
        id = pic.optString("url").hashCode();
        width = pic.optInt("width");
        height = pic.optInt("height");
        url = pic.optString("url");
        title = pic.optString("title");
    }

    public String toJSONString(){
        return picData.toString();
    }

    @Override
    public PictureHolder getViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new PictureHolder(layoutInflater.inflate(R.layout.list_picture, viewGroup, false));
    }

    @Override
    public void setDataToHolder(PictureHolder pictureHolder) {
        pictureHolder.image.setImageUrl(url, BaseApplication.IMAGE_LOADER);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            pictureHolder.text.setTransitionName("text" + id);
            pictureHolder.image.setTransitionName("image" + id);
        }

        pictureHolder.text.setText(Html.fromHtml(title));
        if(opened){
            ((RelativeLayout.LayoutParams) pictureHolder.image.getLayoutParams()).leftMargin = 0;
            ((RelativeLayout.LayoutParams) pictureHolder.image.getLayoutParams()).rightMargin = 0;
            ((RelativeLayout.LayoutParams) pictureHolder.image.getLayoutParams()).topMargin = 0;
            pictureHolder.image.getLayoutParams().height = (int) (height * (pictureHolder.image.getResources().getDisplayMetrics().widthPixels) / (float) width);
        }else {
            pictureHolder.image.getLayoutParams().height = (int) (height * (pictureHolder.image.getResources().getDisplayMetrics().widthPixels - BaseActivity.dp(70, pictureHolder.image.getResources().getDisplayMetrics())) / (float) width);
        }
    }
}
