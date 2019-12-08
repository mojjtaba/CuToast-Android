package ir.gapgame.cutoast;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public final  class CuToast {

    //public - User-editable values
    public  static boolean              sound        =   true                       ;//Display toast with sound effects
    public static boolean               darkMode     =   false                      ;//Display for dark themes
    public static boolean               rtl          =   false                      ;//Display for Persian languages
    public static int                   titleSize    =   16                         ;//Title Size
    public static int                   messageSize  =   14                         ;//Message size
    public static ImageView.ScaleType   scaleType    =   ImageView.ScaleType.CENTER_CROP ;//icon default Scale

    //private
    private static  int                       length                = Toast.LENGTH_SHORT    ;
    private static  TextView                  txtTitle,txtMessage                           ;
    private static  ImageView                 icon                                          ;
    private static  RelativeLayout            banner                                        ;
    private static  ConstraintLayout          shadowPanel                                   ;
    private static  View                      view                                          ;
    private static  Activity                  context                                       ;




    private static void initView(Activity activity){
        context = activity;
        LayoutInflater inflater = context.getLayoutInflater();
        //change view for Right to left
        if(rtl){

            view  = inflater.inflate(R.layout.toast_view_rtl,(ViewGroup) context.findViewById(android.R.id.content).getRootView(),false);
        }else{

            view  = inflater.inflate(R.layout.toast_view,(ViewGroup) context.findViewById(android.R.id.content).getRootView(),false);
        }
        //init  view and Components
        txtTitle            =   view.findViewById(R.id.title);
        txtMessage          =   view.findViewById(R.id.message);
        icon                =   view.findViewById(R.id.img_icon);
        banner              =   view.findViewById(R.id.left_banner);
        shadowPanel         =   view.findViewById(R.id.right_parent);

        //check dark mode and change color view
        checkDarkMode();

    }
    //function for change color
    private static void setColor(View myView ,int color){
        Drawable drawable = myView.getBackground();
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        gradientDrawable.setColor(color);
        myView.setBackground(drawable);
    }
    //check dark mode and change color view
    private static void checkDarkMode(){
        icon.setScaleType(scaleType);
        if(darkMode){
            setColor(shadowPanel,context.getResources().getColor(R.color.shadow_dark));
            txtTitle.setTextColor(context.getResources().getColor(R.color.white));
            txtMessage.setTextColor(context.getResources().getColor(R.color.white_gray));
        }else{
            setColor(shadowPanel,context.getResources().getColor(R.color.shadow_light));
            txtTitle.setTextColor(context.getResources().getColor(R.color.dark));
            txtMessage.setTextColor(context.getResources().getColor(R.color.gray));
        }
    }
    //check gravity for the time when the title does not exist
    private static void setGravity(){
        if(rtl){
            txtMessage.setGravity(Gravity.CENTER_VERTICAL|Gravity.RIGHT);
        }else{
            txtMessage.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
        }
    }
   //---------------------------------Custom view---------------------------------
    public static void showCustom(Activity activity , String  title , String message, int Duration , int color , int res){
        length=Duration;
        //init view for toast message
        initView(activity);
        //Title Management
        if(title.trim().equals("")){
            txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
            txtMessage.setTextSize(messageSize+2);
            setGravity();
        }else{
            txtMessage.setTextSize(messageSize);
            txtTitle.setTextSize(titleSize);
        }
        icon.setImageResource(res);
        setColor(banner,color);
        Show(title,message);

    }
    //duration default
    public static void showCustom(Activity activity ,String  title ,String message ,int color , int res){
        //init view for toast message
        initView(activity);
        //Title Management
        if(title.trim().equals("")){
            txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
            txtMessage.setTextSize(messageSize+2);
            setGravity();
        }else{
            txtMessage.setTextSize(messageSize);
            txtTitle.setTextSize(titleSize);
        }
        icon.setImageResource(res);
        setColor(banner,color);
        Show(title,message);

    }
    public static void showCustom(Activity activity ,String  title ,String message ,int color  ){
        //init view for toast message
        initView(activity);
        //Title Management
        if(title.trim().equals("")){
            txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
            txtMessage.setTextSize(messageSize+2);
            setGravity();
        }else{
            txtMessage.setTextSize(messageSize);
            txtTitle.setTextSize(titleSize);
        }
        setColor(banner,color);
        Show(title,message);

    }
    //no title
    public static void showCustom(Activity activity  ,String message,int Duration,int color , int res){
        length=Duration;
        //init view for toast message
        initView(activity);
        //Title Management
        txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
        txtMessage.setTextSize(messageSize+2);
        setGravity();

        icon.setImageResource(res);
        setColor(banner,color);

        Show("",message);

    }
    //no title && duration default
    public static void showCustom(Activity activity  ,String message ,int color , int res){
        //init view for toast message
        initView(activity);
        //Title Management
        txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
        txtMessage.setTextSize(messageSize+2);
        setGravity();
        icon.setImageResource(res);
        setColor(banner,color);
        Show("",message);

    }

    public static void showCustom(Activity activity  ,String message ,int color  ){
        //init view for toast message
        initView(activity);
        //Title Management
        txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
        txtMessage.setTextSize(messageSize+2);
        setGravity();
        setColor(banner,color);
        Show("",message);

    }
    //---------------------------------Custom view---------------------------------


    //---------------------------------success view---------------------------------
    public static void showSuccess(Activity activity ,String  title ,String message,int Duration){
        length=Duration;
        //init view for toast message
        initView(activity);
        //Title Management
        if(title.trim().equals("")){
            txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
            txtMessage.setTextSize(messageSize+2);
            setGravity();
        }else{
            txtMessage.setTextSize(messageSize);
            txtTitle.setTextSize(titleSize);
        }
        //set icon for success message
        icon.setImageResource(R.drawable.success_g);
        setColor(banner,context.getResources().getColor(R.color.shadow_green));
        Show(title,message);

    }

    public static void showSuccess(Activity activity  ,String message,int Duration){
        length=Duration;
        //init view for toast message
        initView(activity);
        //Title Management
        txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
        txtMessage.setTextSize(messageSize+2);
        setGravity();
        icon.setImageResource(R.drawable.success_g);
        setColor(banner,context.getResources().getColor(R.color.shadow_green));
        Show("",message);

    }

    public static void showSuccess(Activity activity ,String  title ,String message){
        //init view for toast message
        initView(activity);
        //Title Management
        if(title.trim().equals("")){
            txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
            txtMessage.setTextSize(messageSize+2);
            setGravity();
        }else{
            txtMessage.setTextSize(messageSize);
            txtTitle.setTextSize(titleSize);
        }

        icon.setImageResource(R.drawable.success_g);
        setColor(banner,context.getResources().getColor(R.color.shadow_green));
        Show(title,message);

    }

    public static void showSuccess(Activity activity  ,String message){
        //init view for toast message
        initView(activity);
        //Title Management
        txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
        txtMessage.setTextSize(messageSize+2);
        setGravity();
        icon.setImageResource(R.drawable.success_g);
        setColor(banner,context.getResources().getColor(R.color.shadow_green));
        Show("",message);

    }
//---------------------------------success view---------------------------------


    //---------------------------------Error view---------------------------------
    public  static void showError(Activity activity ,String  title ,String message,int Duration){
        length=Duration;
        //init view for toast message
        initView(activity);
        //Title Management
        if(title.trim().equals("")){
            txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
            txtMessage.setTextSize(messageSize+2);
            setGravity();
        }else{
            txtMessage.setTextSize(messageSize);
            txtTitle.setTextSize(titleSize);
        }
        icon.setImageResource(R.drawable.error_r);
        setColor(banner,context.getResources().getColor(R.color.shadow_red));
        Show(title,message);
    }

    public  static void showError(Activity activity  ,String message,int Duration){
        length=Duration;
        //init view for toast message
        initView(activity);
        //Title Management
        txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
        txtMessage.setTextSize(messageSize+2);
        setGravity();
        icon.setImageResource(R.drawable.error_r);
        setColor(banner,context.getResources().getColor(R.color.shadow_red));
        Show("",message);
    }

    public  static void showError(Activity activity ,String  title ,String message){
        //init view for toast message
        initView(activity);
        //Title Management
        if(title.trim().equals("")){
            txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
            txtMessage.setTextSize(messageSize+2);
            setGravity();
        }else{
            txtMessage.setTextSize(messageSize);
            txtTitle.setTextSize(titleSize);
        }
        icon.setImageResource(R.drawable.error_r);
        setColor(banner,context.getResources().getColor(R.color.shadow_red));
        Show(title,message);
    }

    public  static void showError(Activity activity  ,String message){
        //init view for toast message
        initView(activity);
        //Title Management
        txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
        txtMessage.setTextSize(messageSize+2);
        setGravity();
        icon.setImageResource(R.drawable.error_r);
        setColor(banner,context.getResources().getColor(R.color.shadow_red));
        Show("",message);
    }

//---------------------------------Error view---------------------------------
//---------------------------------Warning view---------------------------------
    public  static void showWarning(Activity activity ,String  title ,String message,int Duration){
        length=Duration;
        //init view for toast message
        initView(activity);
        //Title Management
        if(title.trim().equals("")){
            txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
            txtMessage.setTextSize(messageSize+2);
            setGravity();
        }else{
            txtMessage.setTextSize(messageSize);
            txtTitle.setTextSize(titleSize);
        }
        icon.setImageResource(R.drawable.warning_y);
        setColor(banner,context.getResources().getColor(R.color.shadow_yellow));
        Show(title,message);
    }

    public  static void showWarning(Activity activity  ,String message,int Duration){
        length=Duration;
        //init view for toast message
        initView(activity);
        //Title Management
        txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
        txtMessage.setTextSize(messageSize+2);
        setGravity();
        icon.setImageResource(R.drawable.warning_y);
        setColor(banner,context.getResources().getColor(R.color.shadow_yellow));
        Show("",message);
    }

    public  static void showWarning(Activity activity ,String  title ,String message){
        //init view for toast message
        initView(activity);
        //Title Management
        if(title.trim().equals("")){
            txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
            txtMessage.setTextSize(messageSize+2);
            setGravity();
        }else{
            txtMessage.setTextSize(messageSize);
            txtTitle.setTextSize(titleSize);
        }
        icon.setImageResource(R.drawable.warning_y);
        setColor(banner,context.getResources().getColor(R.color.shadow_yellow));
        Show(title,message);
    }

    public  static void showWarning(Activity activity  ,String message){
        //init view for toast message
        initView(activity);
        //Title Management
        txtTitle.setLayoutParams(new ConstraintLayout.LayoutParams(txtTitle.getLayoutParams().width,2));
        txtMessage.setTextSize(messageSize+2);
        setGravity();
        icon.setImageResource(R.drawable.warning_y);
        setColor(banner,context.getResources().getColor(R.color.shadow_yellow));
        Show("",message);
    }

    //---------------------------------Warning view---------------------------------
    private static void Show(String title ,String message){
        //set title and message
        txtTitle.setText(title);
        txtMessage.setText(message);
        Toast newToast = new Toast(context.getApplicationContext());
        //Show time management
        if(length == Toast.LENGTH_LONG){
            newToast.setDuration(Toast.LENGTH_LONG);
        }else{
            newToast.setDuration(Toast.LENGTH_SHORT);
        }
        newToast.setView(view);
        newToast.setGravity(Gravity.BOTTOM,0,0);
        //Sound management
        if(sound){
            final MediaPlayer mediaPlayer = MediaPlayer.create(context,R.raw.hollow);
            mediaPlayer.start();
        }
        newToast.show();

    }

}
