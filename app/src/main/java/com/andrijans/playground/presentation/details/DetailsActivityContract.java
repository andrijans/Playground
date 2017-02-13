package com.andrijans.playground.presentation.details;

import com.andrijans.playground.framework.api.model.MediaItemDetails;
import com.andrijans.playground.presentation.common.contract.IBasePresenter;
import com.andrijans.playground.presentation.common.contract.IBaseView;

/**
 * Created by andrijanstankovic on 12/02/2017.
 */

public class DetailsActivityContract {
    public interface View extends IBaseView{
        void setBackdropImage(String imageUrl);
        void setMediaTitle(String title);
        void setOverviewText(String text);
        void setGenres(String genres);
        void setMediaRating(String rating);
        void closeScreen();
    }

    public interface Presenter extends IBasePresenter{
        void bindModel(MediaItemDetails data);
        void navigationBackButtonClicked();
    }
}
