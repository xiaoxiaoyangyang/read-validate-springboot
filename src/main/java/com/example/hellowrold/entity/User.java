package com.example.hellowrold.entity;

import com.example.hellowrold.annotation.MustEmpty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Data
public class User {
    private String name;

//    @Past(message = "生日必须是一个过去的日期")
    @Past(message = "{user.birthday.past}")
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthday;

    public interface Update{};
    public interface Insert{};


    @NotNull(groups=Update.class ,message="更新时id不能为空")
    @MustEmpty(groups=Insert.class,message="添加时id必须为空")
    private Integer id;
}
