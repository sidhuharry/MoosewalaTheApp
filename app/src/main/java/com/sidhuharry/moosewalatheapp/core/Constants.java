package com.sidhuharry.moosewalatheapp.core;

import com.sidhuharry.moosewalatheapp.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Harvinder_Sidhu
 */
public final class Constants {
    
    public static final String PERF_NAME = "moos";
    
    public static final String PA_LANG_CODE = "pa";
    
    public static final String EN_LANG_CODE = "en";
    
    public static final String USER_LANG = "user_lang";
    
    public static final String IMAGE_ID = "image_id";
    
    public static final int[] QUIZ_IMAGES = new int[]{R.drawable.forget_about_it_1, R.drawable.forget_about_it_2, R.drawable.forget_about_it_3,
            R.drawable.same_beef_1, R.drawable.same_beef_2, R.drawable.same_beef_3, R.drawable.so_high_1, R.drawable.so_high_2, R.drawable.so_high_3};
    
    public static final List<Integer> FILLER_OPTIONS = Arrays
            .asList(R.string.filler_option_1, R.string.filler_option_2, R.string.filler_option_3, R.string.filler_option_4,
                    R.string.filler_option_5, R.string.filler_option_6);
    
    public static final int[] ACTUAL_OPTIONS = new int[]{R.string.so_high, R.string.forget_abt_it, R.string.same_beef};
    
    /**
     * Key - image id
     * Value - correct song name
     */
    public static final Map<Integer, Integer> QUIZ_ANS_MAP = new HashMap() {
        {
            put(R.drawable.forget_about_it_1, R.string.forget_abt_it);
            put(R.drawable.forget_about_it_2, R.string.forget_abt_it);
            put(R.drawable.forget_about_it_3, R.string.forget_abt_it);
            
            put(R.drawable.same_beef_1, R.string.same_beef);
            put(R.drawable.same_beef_2, R.string.same_beef);
            put(R.drawable.same_beef_3, R.string.same_beef);
            
            put(R.drawable.so_high_1, R.string.so_high);
            put(R.drawable.so_high_2, R.string.so_high);
            put(R.drawable.so_high_3, R.string.so_high);
            
        }
    };
    
}
