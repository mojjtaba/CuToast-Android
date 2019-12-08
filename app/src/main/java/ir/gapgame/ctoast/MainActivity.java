package ir.gapgame.ctoast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ir.gapgame.cutoast.CuToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerViewAdapter adapter;
    RecyclerView        recyclerView;
    Button              success,warning,error,dark,sound;
    List<DataRecyclerView> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setRecyclerView();


    }

    private void setRecyclerView() {
        list.add(new DataRecyclerView("Jennifer Lopez","Occupation: Actress , singer ,dancer",R.color.color1,R.drawable.jennifer));
        list.add(new DataRecyclerView("Elon Musk","Occupation:Entrepreneur , investor ,engineer ",R.color.color2,R.drawable.elon));
        list.add(new DataRecyclerView("Nelson Mandela","Occupation: activist,politician ,lawyer,philanthropist",R.color.color3,R.drawable.nelson));
        list.add(new DataRecyclerView("Nicole Kidman","Occupation: actress , singer, producer ",R.color.color4,R.drawable.nicole));
        list.add(new DataRecyclerView("Linus Torvalds","Occupation:software engineer ",R.color.color5,R.drawable.linux));
        list.add(new DataRecyclerView("David Beckham","Occupation: Footballer- businessman- model ",R.color.color6,R.drawable.david));
        list.add(new DataRecyclerView("Scarlett Johansson","Occupation: Actress- singer ",R.color.color7,R.drawable.scarlett));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        adapter = new RecyclerViewAdapter(this,list);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        success= findViewById(R.id.success);
        warning = findViewById(R.id.warning);
        error=findViewById(R.id.error);
        sound=findViewById(R.id.sound);
        dark=findViewById(R.id.dark);
        sound.setOnClickListener(this);
        dark.setOnClickListener(this);
        success.setOnClickListener(this);
        warning.setOnClickListener(this);
        error.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(success.equals(v)){
            CuToast.showSuccess(this,"Success Toast!!","The operation was successful ...");
        }
        else if(warning.equals(v)){
            CuToast.showWarning(this,"Warning Toast!!","Internet is disconnected ...");
        }
        else if(error.equals(v)){
            CuToast.showError(this,"Error Toast !!","Operation failed ...");
        }else if(dark.equals(v)){

            if(dark.getTag().toString().equals("on")){
                CuToast.darkMode=false;
                dark.setText("light mode");
                dark.setTag("off");
            }else{
                CuToast.darkMode=true;
                dark.setText("dark mode");
                dark.setTag("on");
            }

        }else if(sound.equals(v)){
            if(sound.getTag().equals("on")){
                CuToast.sound=false;
                sound.setText("sound off");
                sound.setTag("off");
            }else{
                CuToast.sound=true;
                sound.setText("sound on");
                sound.setTag("on");
            }
        }



    }
}