package com.nm.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "sys_regional_belong")
public class SysRegionalBelong {
    /**
     * ID
     */
    @Column(name = "ID")
    private String id;

    /**
     * 省编码
     */
    @Column(name = "PROV_NO")
    private String provNo;

    /**
     * 省名称
     */
    @Column(name = "PROV_NAME")
    private String provName;

    /**
     * 市编码
     */
    @Column(name = "CITY_NO")
    private String cityNo;

    /**
     * 市名称
     */
    @Column(name = "CITY_NAME")
    private String cityName;

    /**
     * 县编码
     */
    @Column(name = "AREA_NO")
    private String areaNo;

    /**
     * 县名称
     */
    @Column(name = "AREA_NAME")
    private String areaName;

    /**
     * 获取ID
     *
     * @return ID - ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取省编码
     *
     * @return PROV_NO - 省编码
     */
    public String getProvNo() {
        return provNo;
    }

    /**
     * 设置省编码
     *
     * @param provNo 省编码
     */
    public void setProvNo(String provNo) {
        this.provNo = provNo;
    }

    /**
     * 获取省名称
     *
     * @return PROV_NAME - 省名称
     */
    public String getProvName() {
        return provName;
    }

    /**
     * 设置省名称
     *
     * @param provName 省名称
     */
    public void setProvName(String provName) {
        this.provName = provName;
    }

    /**
     * 获取市编码
     *
     * @return CITY_NO - 市编码
     */
    public String getCityNo() {
        return cityNo;
    }

    /**
     * 设置市编码
     *
     * @param cityNo 市编码
     */
    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    /**
     * 获取市名称
     *
     * @return CITY_NAME - 市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置市名称
     *
     * @param cityName 市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 获取县编码
     *
     * @return AREA_NO - 县编码
     */
    public String getAreaNo() {
        return areaNo;
    }

    /**
     * 设置县编码
     *
     * @param areaNo 县编码
     */
    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    /**
     * 获取县名称
     *
     * @return AREA_NAME - 县名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置县名称
     *
     * @param areaName 县名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}