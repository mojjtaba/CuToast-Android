package ir.gapgame.ctoast;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CToast {

    String message;
    Activity activity;
    public CToast(String message , Activity activity){
        this.message = message;
        this.activity = activity;

    }
    public void Show(){
        LayoutInflater inflater = activity.getLayoutInflater();
        View  cToast = inflater.inflate(R.layout.toast_view,null,false);
        TextView txtMessage = cToast.findViewById(R.id.txtMessage);
        txtMessage.setText(message);
        Toast newToast = new Toast(activity);
        newToast.setDuration(Toast.LENGTH_SHORT);
        newToast.setView(cToast);
        newToast.setGravity(Gravity.CENTER,0,0);
        newToast.show();
    }
}
