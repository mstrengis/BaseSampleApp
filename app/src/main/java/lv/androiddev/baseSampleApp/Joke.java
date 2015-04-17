package lv.androiddev.baseSampleApp;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.json.JSONObject;

import lv.androiddev.BaseApp.utils.BaseItem;

/**
 * Created by martinsstrengis on 17/04/15. Yey
 */
public class Joke extends BaseItem<JokeHolder> {
    public String joke;
    public Joke(JSONObject joke){
        this.joke = joke.optString("joke");
        id = joke.optInt("joke");
        viewType = 1;
    }

    @Override
    public JokeHolder getViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new JokeHolder(layoutInflater.inflate(R.layout.list_joke, viewGroup, false));
    }

    @Override
    public void setDataToHolder(JokeHolder jokeHolder) {
        jokeHolder.joke.setText(Html.fromHtml(joke));
    }
}
