package com.ldongxu.learn.guice.inject;

import com.google.inject.ImplementedBy;

/**
 * Created by 刘东旭 on 2017/7/17.
 */
@ImplementedBy(ServiceImpl.class)
public interface Service {
    void execute();
}
