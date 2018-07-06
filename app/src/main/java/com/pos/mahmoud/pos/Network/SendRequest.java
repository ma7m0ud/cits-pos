package com.pos.mahmoud.pos.Network;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.pos.mahmoud.pos.DataBase.TerminalDatabase;
import com.pos.mahmoud.pos.Helpers.TransactionModel;
import com.pos.mahmoud.pos.Helpers.Transactions;
import com.pos.mahmoud.pos.Helpers.TransactionsType;
import com.pos.mahmoud.pos.models.Configration;
import com.pos.mahmoud.pos.models.TransactionItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendRequest {
    private APIService mAPIService;
Configration config;
   public SendRequest(Configration config, Context c){
               this.config=config;
               mAPIService = ApiUtils.getAPIService("https://"+config.getIp()+":"+config.getPort()+"/"+config.getPath()+"/",c);
   }
    public void sendPost(TransactionModel model, TransactionItem item, final RequestCallBack callBack) {

       Call<TransactionModel> call=mAPIService.purchase(item.getPath(),model);

       call.enqueue(new Callback<TransactionModel>() {
            @Override
            public void onResponse(Call<TransactionModel> call, Response<TransactionModel> response) {

                if(response.isSuccessful()) {
                    callBack.onSuccess(response.body());
                }else{
                    callBack.onError();
                }
            }

            @Override
            public void onFailure(Call<TransactionModel> call, Throwable t) {
                t.printStackTrace();
                callBack.onError();
            }
        });
    }

}
