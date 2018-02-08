package com.knjin.customprogress;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Jing
 * @Description
 * @Time 18/2/6
 */
@IntDef({DialogType.NEW_WATTING, DialogType.CHECK_NOW})
@Retention(RetentionPolicy.SOURCE)
public @interface DialogType {
  int NEW_WATTING = 1;
  int CHECK_NOW = 2;
}
