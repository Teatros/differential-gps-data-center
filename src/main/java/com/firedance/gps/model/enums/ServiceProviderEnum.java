package com.firedance.gps.model.enums;

import java.util.Arrays;
import java.util.List;

/**
 * 1天、3天、1个月、2个月、1年、3年
 * @author qi.tang
 */
public enum ServiceProviderEnum {
    CHINA_MOBILE("中国移动", "/RTCM33_GRCE",Arrays.asList("/RTCM33","/RTCM33_GRCE","/RTCM30_GR","/RTCM33_GRC","/RTCM33_GRCEpro","/RTCM33_GRCEJ","/RTCM411","/RTCM33")),
    CHINA_TELECOM("中国电信", "/RTCM33_GRCE",Arrays.asList("/RTCM33")),
    ;

    private String description;
    private String defaultMountPoint;
    private List<String> mountPoints;

    ServiceProviderEnum(String description, String defaultMountPoint, List<String> mountPoints) {
        this.description = description;
        this.defaultMountPoint = defaultMountPoint;
        this.mountPoints = mountPoints;
    }

    public String getDescription() {
        return description;
    }

    public String getDefaultMountPoint() {
        return defaultMountPoint;
    }

    public List<String> getMountPoints() {
        return mountPoints;
    }
}
