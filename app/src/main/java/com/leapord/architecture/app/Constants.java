package com.leapord.architecture.app;

import android.os.Environment;

import java.io.File;

/**
 * @author JokerFish
 * @date 2017/10/23
 * @description
 * @email fengzhengbiao@vcard100.com
 */

public interface Constants {

    //================= PATH ====================
    String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    String PATH_CACHE = PATH_DATA + "/NetCache";

    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "leopard";
}
