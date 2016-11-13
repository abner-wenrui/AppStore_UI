package com.abner.appstore.ui.fragment;

import java.util.HashMap;

/**
 * Project   com.abner.appstore.ui.fragment
 *
 * @Author Abner
 * Time   2016/11/2.14:20
 */

public class FragmentFactory {

    private static HashMap<Integer, BaseFragment> mFragmentMap = new HashMap<>();

    public static BaseFragment createFragment(int pos) {
        BaseFragment fragment = mFragmentMap.get(pos);

        if (fragment == null) {
            switch (pos) {
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new AppFragment();
                    break;
                case 2:
                    fragment = new GameFragment();
                    break;
                case 3:
                    fragment = new SubjectFragment();
                    break;
                case 4:
                    fragment = new RecommendFragment();
                    break;
                case 5:
                    fragment = new CategoryFragment();
                    break;
                case 6:
                    fragment = new HotFragment();
                    break;

                default:
                    break;
            }
            mFragmentMap.put(pos, fragment);
        }
        return fragment;
    }
}
