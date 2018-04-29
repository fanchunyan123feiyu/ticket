package com.sxzhwts.ticket.di.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * 作者：fcy on 2018/4/14 12:56
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface DownloadThread {
}
