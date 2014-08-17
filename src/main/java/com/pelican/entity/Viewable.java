package com.pelican.entity;

import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Nightingale on 17.08.2014.
 */
public interface Viewable {
    /**
     * Add info about itself to modelAndView
     *
     * @param modelAndView mutable input object
     */
    default ModelAndView update(ModelAndView modelAndView) {
        Field[] declaredFields = this.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                field.setAccessible(true);
                modelAndView.addObject(field.getName(), field.get(this));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return modelAndView;
    }

    public static void main(String[] args) {
        FB.BasicProfileData data = new FB.BasicProfileData("url...", "d@go.com", new Date(1992, 20, 3), "female");
        ModelAndView update = data.update(new ModelAndView());
        Map<String, Object> model = update.getModel();
        for (Map.Entry<String, Object> kv: model.entrySet())
            System.out.println(kv.getKey()+" :: "+kv.getValue());
    }
}
