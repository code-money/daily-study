package cn.zyz.entity;

import cn.zyz.utils.DateUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: heima_ssm
 * @author: zyz
 * @create: 2022-05-30 21:59
 **/

@Data
public class Product {
    private String id; // 主键
    private String productNum; // 编号 唯一
    private String productName; // 名称
    private String cityName; // 出发城市
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date departureTime; // 出发时间
    private String departureTimeStr;
    private double productPrice; // 产品价格
    private String productDesc; // 产品描述
    private Integer productStatus; // 状态 0 关闭 1 开启
    private String productStatusStr;

    public String getProductStatusStr() {
        if (productStatus!=null){
            //状态 0 关闭 1 开启
            if (productStatus==0){
                productStatusStr="关闭";
            }else {
                productStatusStr="开启";
            }
        }
        return productStatusStr;
    }

    public String getDepartureTimeStr() {
        if (departureTime!=null){
            departureTimeStr= DateUtils.dateToStr(departureTime,"yyyy-MM-dd");
        }
        return departureTimeStr;
    }
}



