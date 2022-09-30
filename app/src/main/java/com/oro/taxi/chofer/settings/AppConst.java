package com.oro.taxi.chofer.settings;

import android.content.Context;
import android.graphics.Typeface;



public class AppConst {

    public static final String Server_url ="https://estoesdemiparatodos.com/on_demand_taxi_webservice/";
    public static final String Server_urlMain ="https://estoesdemiparatodos.com/";
    public static final String API_GET_TOKEN = "https://estoesdemiparatodos.com/on_demand_taxi_webservice/braintree/main.php";
    public static final String API_CHECK_OUT = "https://estoesdemiparatodos.com/on_demand_taxi_webservice/braintree/checkout.php";
    public static final String MAIN = Server_url;

    public static String fcm_id;

    public static final String ADMOB_ID = "ca-app-pub-6192865524332826~8608785476"; // app id

    public static final String INTERSTIAL_ID = "ca-app-pub-6192865524332826/1391397163"; // app id

    public static Typeface font_quicksand_medium(Context context){
        Typeface typeface= Typeface.createFromAsset(context.getAssets(), "fonts/QuicksandMedium.ttf");
        return typeface;
    }

    public static Typeface font_quicksand_regular(Context context){
        Typeface typeface= Typeface.createFromAsset(context.getAssets(), "fonts/QuicksandRegular.ttf");
        return typeface;
    }

    public static Typeface font_quicksand_semibold(Context context){
        Typeface typeface= Typeface.createFromAsset(context.getAssets(), "fonts/QuicksandSemiBold.ttf");
        return typeface;
    }

}
