package com.zpaas.test;

import com.zpaas.ConfigurationCenter;
import com.zpaas.utils.PaasContextHolder;

public class AppTest {
    public static void main(String[] args) {
    	ConfigurationCenter cc = (ConfigurationCenter) PaasContextHolder.getContext().getBean("cc");
    }
}
