package ir.gapgame.ctoast;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import ir.gapgame.cutoast.CuToast;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHOlder>  {

    Activity context;
    List<DataRecyclerView> list;



    public RecyclerViewAdapter(Activity context , List<DataRecyclerView> list){
        this.context =context;
        this.list= list;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHOlder holder, final int position) {
        holder.image.setImageResource(list.get(position).getRes());
        holder.color.setBackgroundColor(context.getResources().getColor(list.get(position).getColor()));
        holder.title.setText(list.get(position).getTitle());
        holder.description.setText(list.get(position).getDescription());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CuToast.messageSize=13;
                CuToast.showCustom(context,list.get(position).getTitle(),list.get(position).getDescription(),context.getResources().getColor(list.get(position).getColor()),list.get(position).getRes());
            }
        });



    }



    public class MyViewHOlder  extends RecyclerView.ViewHolder{
        TextView title,description,color;
        CircleImageView image;
        ConstraintLayout parent;

        public MyViewHOlder(@NonNull View itemView){
            super(itemView);
            title= itemView.findViewById(R.id.textViewTitle);
            description=itemView.findViewById(R.id.textViewDescription);
            color = itemView.findViewById(R.id.textVIewColor);
            image = itemView.findViewById(R.id.profile_image);
            parent =itemView.findViewById(R.id.recyclerParent);
        }
    }

    @NonNull
    @Override
    public MyViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recyclerview,parent,false);
        return new MyViewHOlder(view);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
