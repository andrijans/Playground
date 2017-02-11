package com.andrijans.playground.framework.api;

import com.andrijans.playground.framework.api.model.CastResult;
import com.andrijans.playground.framework.api.model.ListMoviesResult;
import com.andrijans.playground.framework.api.model.MediaItemDetails;
import com.andrijans.playground.framework.api.model.SearchData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by andrijanstankovic on 09/02/2017.
 */

public interface IApiService {
    @GET ("search/movie")
    Observable<SearchData> searchMovies(
            @Query ("query") String query,
            @Query("page") int page
    );

    @GET("movie/{id}")
    Observable<MediaItemDetails> getMovieDetails(
            @Path ("id") String id
    );

    @GET("movie/{movie_id}/credits")
    Observable<CastResult> getMovieCast(
            @Path("movie_id") String movieId
    );

    @GET("search/tv")
    Observable<SearchData> searchSeries(
            @Query("query") String query,
            @Query("page") int page
    );

    @GET("tv/{tv_id}")
    Observable<MediaItemDetails> getSeriesDetails(
            @Path("tv_id") String id
    );

    @GET("tv/{tv_id}/credits")
    Observable<CastResult> getSeriesCast(
            @Path("tv_id") String seriesId
    );

    @GET("movie/now_playing")
    Observable<ListMoviesResult> getNowPlaying();

    @GET("tv/popular")
    Observable<ListMoviesResult> getPopularShows();

}
