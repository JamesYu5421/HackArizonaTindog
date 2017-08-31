package com.bork.tindog;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

public class DogPics extends AppCompatActivity {

    public static MyAppAdapter myAppAdapter;
    public static ViewHolder viewHolder;
    private ArrayList<Data> array;
    private SwipeFlingAdapterView flingContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dog_pics);

        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        array = new ArrayList<>();
        array.add(new Data("https://upload.wikimedia.org/wikipedia/commons/4/47/American_Eskimo_Dog.jpg", "Hi I am Will. I am one of the goodest boys. \n" +
                "I am an American Eskimo Dog and I just really need a family, but I can settle with a play date with you or maybe just a walk! please pick me up at your local dog shelter"));
        array.add(new Data("https://cdn.pixabay.com/photo/2016/09/05/15/32/pug-1646844_1280.jpg", "Hi I am Emma. I am one good girl \n" +
                "I am a pug and my motto is: 'pugs not drugs'. No one really wants to walk me because I am small, but I really like exercise. We should go on a walk!"));
        array.add(new Data("https://upload.wikimedia.org/wikipedia/commons/1/16/Greenland_Dog.jpg", "Hi I am Wilbert. I am a very good boy \n" +
                "Dogs come into PACC for many reasons: Lifestyle changes, financial challenges, neglect. One of the toughest though is when a caring, responsible owner passes on. Such is the case with Aime a beautiful black and white Boxer mix. You always know when a pet has been given proper attention and this pup was."));
        array.add(new Data("https://upload.wikimedia.org/wikipedia/commons/8/87/%28Pit_Bull%29%2C_%28pitbull%2C_dog%29_beautifull_precious_amazing_%28female_puppy_in_south_america%29.jpg", "Hi I am Frostline \n" +
                "This is Frostline, she is up for euthanasia on Sunday for detiorating in the shelter. One of her huge things is leash reactivity. Jim Filipiak and I spent about 10 minutes working worth her today and this was the end result. She very much wants to please, she just needs someone willing to do the training with her. If interested please check her out more on PACC Pets Need You, or better yet head to Pima Animal Care Center to check her out in person."));
        array.add(new Data("https://upload.wikimedia.org/wikipedia/commons/f/f7/Chihuahua-Dog.JPG", "Hi I am Daisy \n"+
                "She is a spayed female, black and brown Chinese Sharpei mix. Shelter staff thinks she is about 6 years old. They also state that she is house trained, polite on a leash, and good with other dogs. She has been at the shelter since September 23rd, 2016."));
        array.add(new Data("https://upload.wikimedia.org/wikipedia/commons/6/69/Ozbulldog.jpg", "Hi I am Rex wanna walk me? \n" +
                "Rex is a 6 year old neutered male collie/husky mix (85Lbs) who was brought to the shelter after he bite the child in the home. The owner did say that the kid was playing too rough with him. Due to their housing situation the owners are unable to take him back. Rex has been an indoor only dog and is use to being the center of attention. Rex is extremely gentle on a leash and just melts into you and the floor. He also knows sit and loves adults. Rex is unable to co-house here. Due to the bite history and being unable to co-house Rex must leave the shelter with a rescue group by 7pm on 01/12/17."));
        array.add(new Data("https://upload.wikimedia.org/wikipedia/commons/5/50/Golden_Retriever_charge.jpg", "Hi I am Chiquita \n" +
                "Chiquita is sweeter than a ripe banana! We were out early for our walk today, the sun was just barely up. She was so patient with me while I fiddled with my camera to turn on the flash, she just laid down until I had it all ready to go! This girl loves to be loved " +
                "She isn't very interested in cookies, apparently - I tossed one in to her, it landed on her foot, and she just left it there! Silly girl "));

        myAppAdapter = new MyAppAdapter(array, DogPics.this);
        flingContainer.setAdapter(myAppAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {

            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                array.remove(0);
                myAppAdapter.notifyDataSetChanged();
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
            }

            @Override
            public void onRightCardExit(Object dataObject) {

                array.remove(0);
                myAppAdapter.notifyDataSetChanged();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override
            public void onScroll(float scrollProgressPercent) {

                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {

                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);

                myAppAdapter.notifyDataSetChanged();
            }
        });
    }

    public static class ViewHolder {
        public static FrameLayout background;
        public TextView DataText;
        public ImageView cardImage;


    }

    public class MyAppAdapter extends BaseAdapter {


        public List<Data> parkingList;
        public Context context;

        private MyAppAdapter(List<Data> apps, Context context) {
            this.parkingList = apps;
            this.context = context;
        }

        @Override
        public int getCount() {
            return parkingList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View rowView = convertView;


            if (rowView == null) {

                LayoutInflater inflater = getLayoutInflater();
                rowView = inflater.inflate(R.layout.item, parent, false);
                // configure view holder
                viewHolder = new ViewHolder();
                viewHolder.DataText = (TextView) rowView.findViewById(R.id.bookText);
                viewHolder.background = (FrameLayout) rowView.findViewById(R.id.background);
                viewHolder.cardImage = (ImageView) rowView.findViewById(R.id.cardImage);
                rowView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.DataText.setText(parkingList.get(position).getDescription() + "");

            Glide.with(DogPics.this).load(parkingList.get(position).getImagePath()).into(viewHolder.cardImage);

            return rowView;
        }
    }
}
