package com.andrijans.playground.framework.api;

import com.andrijans.playground.framework.api.model.Card;
import com.andrijans.playground.framework.api.model.CardsResponse;
import com.andrijans.playground.framework.api.model.Info;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by andrijanstankovic on 09/02/2017.
 */

public interface IApiService {
    @GET ("/cards")
    Observable<CardsResponse> getHearthstoneCards();

    @GET ("/info")
    Observable<Info> getHeartstoneInfo();

    @GET ("/cards/sets/{set}")
    Observable<List<Card>> getCardsBySet(
            @Path ("set") String set
    );
}
