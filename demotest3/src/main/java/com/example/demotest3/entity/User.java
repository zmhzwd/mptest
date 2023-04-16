package com.example.demotest3.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    //主键策略
    @TableId(type = IdType.ASSIGN_ID)

    private Long id;
    private String name;
    private Integer age;
    private String email;

    //自动填充
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
}
