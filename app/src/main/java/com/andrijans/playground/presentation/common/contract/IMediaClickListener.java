package com.andrijans.playground.presentation.common.contract;

import com.andrijans.playground.framework.api.model.MediaItemDetails;

/**
 * Created by andrijanstankovic on 12/02/2017.
 */

public interface IMediaClickListener {
    void mediaItemClicked(MediaItemDetails data);
}
