package com.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thecoachtimer.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder> {

        Context mCtx;
        List<Player> playersList;

        public PlayersAdapter(Context mCtx, List<Player> playersList) {
            this.mCtx = mCtx;
            this.playersList = playersList;
        }

        @NonNull
        @Override
        public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
            return new PlayerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
            Player player = playersList.get(position);

            Glide.with(mCtx)
                    .load(player.getPictureThumbnail())
                    .into(holder.imageView);

            holder.textView.setText(player.getName() !=null ? player.getName().getFirst() : "player name");
        }

        @Override
        public int getItemCount() {
            return 1;
        }

        class PlayerViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView textView;

            public PlayerViewHolder(View itemView) {
                super(itemView);

                imageView = itemView.findViewById(R.id.imageView);
                textView = itemView.findViewById(R.id.textView);
            }
        }
    }

