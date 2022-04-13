package com.itheima.demo08_序列化注意事项;

import java.io.Serializable;

public class Address implements Serializable {
    private String province;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Address() {
    }

    public Address(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                '}';
    }
}
