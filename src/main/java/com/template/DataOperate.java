package com.template;

import com.template.entity.TUser;
import org.omg.CORBA.UNKNOWN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

//数据库操作
@Component
public class DataOperate {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //创建数据表
    public void  createTable(){
        //创建要执行的slq语句
        String sql = "CREATE TABLE t_user(" +
                "uid int not null  auto_increment PRIMARY KEY," +
                "uname varchar(20) not null," +
                "uage int not null," +
                "usex int)";
        //执行数据库的操作
        try {
            jdbcTemplate.execute(sql);
            System.out.println("创建成功");
        } catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println("创建失败");
        }
    }
    //插入数据库
    public void insertData(){
        String sql = "INSERT INTO t_user(uname,uage,usex) VALUES (?,?,?)";
        //执行sql语句（update 返回值 受影响的行数）
        int IRet = jdbcTemplate.update(sql, "张三", 18, 1);
        System.out.println(IRet);
    }

    public  void  deleteTable(){
        String sql = "drop TABLE t_user";
        jdbcTemplate.execute(sql);
    }
    //查询单个值
    public  void selectOne(){
        String sql = "select uname from t_user where uid=?";
        /*
        queryForObject -> 查询数据
         第一个参数:要执行的sql语句
         第二个参数：查询结果的数据类型 结果是基本数据类型和String,查询结果只能是返回单行单列数据
         第三个参数：执行的sql的语句的参数，可选
         */
        String uName = jdbcTemplate.queryForObject(sql, String.class,1);
        System.out.println(uName);
    }
    //查询一行数据
    public  void  selectObj(){
        String sql = "SELECT * FROM t_user where uid = ?";
        //设置数据库查询结果记录与实体映射关系
        RowMapper<TUser> rowMapper=new BeanPropertyRowMapper<TUser>(TUser.class);
        /*
        queryForObject（）
          第二个参数：查询结果映射的实体类关系(实体属性与字段同名) -> sql执行的结果只能返回一行数据
         */
        TUser user =  jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println(user);
    }

//查询多行数据
    public  void  selectList(){
        String sql = "SELECT * FROM t_user";
        //设置数据库查询结果记录与实体映射关系
        RowMapper<TUser> rowMapper=new BeanPropertyRowMapper<>(TUser.class);
        /*
        queryForObject（）
          第二个参数：查询结果映射的实体类关系(实体属性与字段同名) -> sql执行的结果只能返回一行数据
         */
        List<TUser> user =  jdbcTemplate.query(sql, rowMapper);
        System.out.println(user);
    }

}
