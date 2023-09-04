package com.mycompany.myapp.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append(" SELECT tb.* ");
        queryStr.append(" FROM ( ");
        queryStr.append(" SELECT t.*, rownum AS rnum ");
        queryStr.append(" FROM ( ");
        queryStr.append(
            " SELECT o.tracking_Id,o.area_Code,o.cam_Code,o.cam_Id,v.create_Date,o.image_Link,o.image_Link2,");
        queryStr.append(" o.image_Link3,o.image_Link4,o.image_Link5,o.plate_Number,o.tracking_Time,o.AREA_ID,");
        queryStr.append(" v.area_Name,v.province,v.district,v.village,c.cam_name,c.location ");
        queryStr.append(" FROM V_Car_Tracking o ");
        queryStr.append(" JOIN V_AREA v ON o.AREA_ID = v.AREA_ID ");
        queryStr.append(" JOIN V_CAMERA c ON o.CAM_ID = c.CAM_ID ");
        queryStr.append(" WHERE o.area_Id IN (SELECT DISTINCT voa.area_Id from V_Ogn_Area voa WHERE voa.ogn_Id IN ( ");
        queryStr.append(
            " SELECT s.SYS_ORGANIZATION_ID FROM SYS_ORGANIZATION s WHERE s.status=1 START WITH s.SYS_ORGANIZATION_ID = :orgId CONNECT BY s.PARENT_ID = PRIOR s.SYS_ORGANIZATION_ID)) ");
        queryStr.append(" AND c.IS_ACTIVE = 1 AND v.IS_ACTIVE = 1");

        Map<String, Object> mapParam = new HashMap<String, Object>();
        if (true) {
            queryStr.append(" AND lower(o.plate_Number) LIKE :plateNumber ESCAPE '!' ");
        }
        if (true) {
            queryStr.append(" and o.tracking_Time >= to_date(:fromDate,'dd/MM/yyyy hh24:mi:ss')");
        }
        if (true) {
            queryStr.append(" and o.tracking_Time <= to_date(:toDate,'dd/MM/yyyy hh24:mi:ss')");
        }
        if (true) {
            queryStr.append(" and o.area_Id = :areaId ");
        }
        if (true) {
            queryStr.append(" and o.cam_Id = :cameraId ");
        }
        queryStr.append(" ORDER BY o.tracking_Time DESC, o.plate_Number ASC ");
        queryStr.append(" ) t ");
        if (true) {
            queryStr.append(" WHERE rownum <= :PageSize) tb ");
            queryStr.append(" WHERE rnum >= :CurrentPage ");
        } else {
            queryStr.append(" ) tb ");
        }
        System.out.printf(queryStr.toString());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date start = calendar.getTime();
    }
}
