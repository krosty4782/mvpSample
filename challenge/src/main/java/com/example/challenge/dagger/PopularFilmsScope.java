package com.example.challenge.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by mfolcini on 10/09/2016.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PopularFilmsScope {

}
