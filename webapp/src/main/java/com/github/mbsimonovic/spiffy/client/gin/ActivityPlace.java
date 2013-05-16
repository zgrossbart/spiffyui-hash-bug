package com.github.mbsimonovic.spiffy.client.gin;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public abstract class ActivityPlace<T extends BaseActivity> extends Place {
    @Inject
    protected Provider<T> provider;
    protected String token;

    public void init(String token) {
        this.token = token != null ? token : "";
    }

    public String getToken() {
        return this.token != null ? token : "";
    }

    public T getActivity() {
        T t = provider.get();
        t.setPlace(this);
        return t;
    }

    abstract public static class Tokenizer<E extends ActivityPlace<?>> implements PlaceTokenizer<E> {

        @Inject
        Provider<E> provider;

        @Override
        public E getPlace(String token) {
            E place = provider.get();
            place.init(token);
            return place;
        }

        @Override
        public String getToken(E place) {
            return place.getToken();
        }

    }


}
