package com.cpiaoju.base.common.entity.system;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ziyou
 */
@Data
@TableName("t_user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 2276254741180289170L;


    private Long userId;

    private Long roleId;
}
