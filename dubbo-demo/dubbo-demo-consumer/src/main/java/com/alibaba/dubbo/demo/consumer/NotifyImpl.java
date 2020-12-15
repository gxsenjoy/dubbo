package com.alibaba.dubbo.demo.consumer;

class NotifyImpl implements Notify {
    @Override
    public void oninvoke() {
        System.out.println("-------oninvoke:--------");
    }
}