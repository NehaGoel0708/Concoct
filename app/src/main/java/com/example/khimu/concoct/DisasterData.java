package com.example.khimu.concoct;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DisasterData extends RecyclerView.Adapter<DisasterData.ViewHolder>{

    private String[] disaster_title={"Earthquake","Hurricanes","Tsunami","Volcano","Hail","Sinkholes",
            "Tornado","WildFires","Landslide","Cyclone"
    };
    private String [] disaster_detail={"Earthquake, any sudden shaking of the ground caused by the passage of seismic waves through Earth’s rocks. Seismic waves are produced when some form of energy stored in Earth’s crust is suddenly released, usually when masses of rock straining against one another suddenly fracture and “slip.” Earthquakes occur most often along geologic faults, narrow zones where rock masses move in relation to one another. ","A low-pressure center, a closed low-level atmospheric circulation, strong winds, and a spiral arrangement of thunderstorms that produce heavy rain\n" +
            "\n" +
            " A hurricane is a tropical cyclone that occurs in the Atlantic Ocean and northeastern Pacific Ocean, and a typhoon occurs in the northwestern Pacific Ocean; while in the south Pacific or Indian Ocean, comparable storms are referred to simply as \"tropical cyclones\" or \"severe cyclonic storms.\n" +
            "\n" +
            "Cyclone\" refers to their winds moving in a circle,[5] whirling round their central clear eye, with their winds blowing counterclockwise in the Northern Hemisphere and clockwise in the Southern Hemisphere.\n","Tsunamis are giant waves caused by earthquakes or volcanic eruptions under the sea.\n" +
            "Tsunami waves may travel as fast as jet planes over deep waters, only slowing down when reaching shallow waters. While tsunamis are often referred to as tidal waves, this name is discouraged by oceanographers because tides have little to do with these giant waves.\n","A volcanic eruption occurs when hot materials from the earth's interior are thrown out of a volcano. Lava, rocks, dust, and gas compounds are some of these \"ejecta\".\n" +
            "(Magma is composed of molten rock and is stored in the Earth's crust. Lava is magma that reaches the surface of our planet through a volcano vent. )\n","Hail is something that occurs in most parts of the world. This does cause a lot of damage at times and it can be very troublesome also but what is hail?  Hail is a variety of differently shaped ice balls or lumps. These are mostly referred to hailstones and in most occasions, are not harmful but in some instances, they can be very dangerous.","A sinkhole is a depression in the ground that has no natural external surface drainage. Basically this means that when it rains, all of the water stays inside the sinkhole and typically drains into the subsurface.","A tornado is a narrow, violently rotating column of air that extends from the base of a thunderstorm to the ground. Because wind is invisible, it is hard to see a tornado unless it forms a condensation funnel made up of water droplets, dust and debris. Tornadoes are the most violent of all atmospheric storms.","Wildfire is a general term which includes forest fires, grassland fires, bushfires, brush fires and any other vegetation fire in countryside areas. Wildfires occur on every continent except Antarctica. They can occur naturally, but many are caused by humans, accidentally or deliberately.","A landslide is a mass movement occurring on steep slopes under the action of gravity. Debris flow is a distinct type of mass movement commonly triggered by intense rainfall and/or melting snow on steep hill slopes. ","In meteorology, a cyclone is a large scale air mass that rotates around a strong center of low atmospheric pressure. Cyclones are characterized by inward spiraling winds that rotate about a zone of low pressure. The largest low-pressure systems are polar vortices and extratropical cyclones of the largest scale."

    };
    private int [] disaster_images={
            R.drawable.earthquake,
            R.drawable.hurricanes,
            R.drawable.tsunami,
            R.drawable.volcano,R.drawable.hail,R.drawable.sinkholes,R.drawable.tornado,
            R.drawable.wildfire,R.drawable.landslide,R.drawable.cyclone
    };

    class ViewHolder extends RecyclerView.ViewHolder{
        public int currItems;
        public ImageView disasterimage;
        public TextView disastertitle;
        public TextView disasterdetail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            disasterimage=(ImageView) itemView.findViewById(R.id.disasterimage);
            disastertitle=(TextView) itemView.findViewById(R.id.disastertitle);
            disasterdetail=(TextView) itemView.findViewById(R.id.disasterdetail);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();

                Snackbar.make(v, "Click detected on item " + position,
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        }
    }

    @NonNull
    @Override
    public DisasterData.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_cv, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull DisasterData.ViewHolder viewHolder, int i) {
        viewHolder.disastertitle.setText(disaster_title[i]);
        viewHolder.disasterdetail.setText(disaster_detail[i]);
        viewHolder.disasterimage.setImageResource(disaster_images[i]);
    }

    @Override
    public int getItemCount() {
        return disaster_title.length;
    }
}
