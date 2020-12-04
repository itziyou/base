package com.cpiaoju.base.server.system.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.cpiaoju.base.common.entity.BaseResponse;
import com.cpiaoju.base.common.entity.QueryRequest;
import com.cpiaoju.base.common.entity.system.SystemUser;
import com.cpiaoju.base.common.exception.BaseException;
import com.cpiaoju.base.common.util.BaseUtil;
import com.cpiaoju.base.server.system.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * @author ziyou
 */
@Slf4j
@Validated
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('user:view')")
    public BaseResponse userList(QueryRequest queryRequest, SystemUser user) {
        Map<String, Object> dataTable = BaseUtil.getDataTable(userService.findUserDetail(user, queryRequest));
        return new BaseResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('user:add')")
    public void addUser(@Valid SystemUser user) throws BaseException {
        try {
            this.userService.createUser(user);
        } catch (Exception e) {
            String message = "新增用户失败";
            log.error(message, e);
            throw new BaseException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('user:update')")
    public void updateUser(@Valid SystemUser user) throws BaseException {
        try {
            this.userService.updateUser(user);
        } catch (Exception e) {
            String message = "修改用户失败";
            log.error(message, e);
            throw new BaseException(message);
        }
    }

    @DeleteMapping("/{userIds}")
    @PreAuthorize("hasAnyAuthority('user:delete')")
    public void deleteUsers(@NotBlank(message = "{required}") @PathVariable String userIds) throws BaseException {
        try {
            String[] ids = userIds.split(StringPool.COMMA);
            this.userService.deleteUsers(ids);
        } catch (Exception e) {
            String message = "删除用户失败";
            log.error(message, e);
            throw new BaseException(message);
        }
    }
}
