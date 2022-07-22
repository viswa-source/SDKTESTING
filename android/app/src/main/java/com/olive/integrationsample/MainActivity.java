package com.olive.integrationsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.olive.olivesdk.OliveUPISDKManager;
import com.olive.olivesdk.sdk.OliveEventListener;
import com.olive.olivesdk.sdk.OliveSDKConstants;
import com.olive.olivesdk.sdk.OliveSDKError;
import com.olive.olivesdk.sdk.OliveSdkParam;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements OliveEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button react = findViewById(R.id.react);
        react.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startReactActivity();
            }
        });
        startReactActivity();
    }


    public void startReactActivity(){
        OliveSdkParam param = new OliveSdkParam();
        param.setCustomerName("Atmaram");
        param.setCustomerType("NTB");
        param.setEmailId("atmaram.t@olivecrypto.com");
        param.setMerchId("AXISMOBILE");
        param.setMerchChanId("AXISMOBILE");

        param.setSubmerchantid("674545454");
        param.setMcccode("674545454");
        param.setUnqCustId("");
        param.setTimestamp(new Date().getTime() +"");
        param.setMobilenumber("");
        param.setUnqTxnId(new Date().getTime() +"");
param.setAppDeviceId("123456789012346");
//    param.setMerchToken("5vl47lyyx02p3o8giz5aqz00yeh7eccnhdykwy91hdljn6s8yafy8vxgdvwvwdyg8g81lnjhaiypvri4i9fu2m99qvxds6zj9iujpkusjwzh6sjfofy2ndhvf5jsqqil43lg0b9owp8kusg92rb4quukiyxz3b8j4ftc0nlx01s8sbsklyyk3t25dj23nr13q3z7vdta3a913b6d75ql9fpu2q233qo7zfeoulqkiozfkpuibmqh7fjbj32xl40v");
        param.setMerchToken("");
        String mode = OliveSDKConstants.MODE_DEFAULT;
        OliveUPISDKManager.getInstance().initSDK(MainActivity.this, mode , param);
        OliveUPISDKManager.getInstance().setListener(this);
    }

    @Override
    public void onEventReceived(String mode, Object data) {
        Log.d("TAG", "onEventReceived: mode= "+mode+" with data "+data);
    }

    @Override
    public void onErrorReceived(String mode, OliveSDKError err) {
        Log.d("TAG", "onErrorReceived for: mode= "+mode+" with error "+err);
    }

}