package com.sucl.swagger.web;

import com.sucl.swagger.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sucl
 * @since 2019/11/5
 */
@Api(value="/user",description="用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value="ID查询用户")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value="用户ID",required=true,dataType="Long",paramType="path")})
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){
        return User.of().setUserId(id);
    }

    @ApiOperation(value="条件查询用户")
    @GetMapping
    public List<User> getUsers(@RequestParam(required = false) String userName,
                               @RequestParam(required = false) String userCaption,
                               @RequestParam(required = false) Integer age){
        List<User> users = new ArrayList<>();
        if(!(userName==null && userCaption==null && age==null)){
            users.add(User.of().setUserName(userName).setUserCaption(userCaption).setAge(age));
        }
        return users;
    }

    @ApiOperation(value="新增用户")
    @ApiImplicitParam(name="user",value="用户",required=true,dataType="User",paramType="body")
    @PostMapping
    public User saveUser(@RequestBody User user){
        return user;
    }

    @ApiOperation(value="根据id删除用户")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value="用户ID",required=true,dataType="Long",paramType="path")})
    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id){
        if(id==-1){
            return false;
        }
        return true;
    }

}
