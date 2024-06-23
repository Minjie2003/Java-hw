# Day2作业

1. 动态sql-ifwhere和forEach练习（多条件查询，批量删除，批量添加）

2. 两种连接查询

## 1.1多条件查询

- 单元测试中进行测试

  ```java
  void queryCondition(){
          //select * from admin where id=#{id} and LoginName=#{loginName}
          Admin admin = new Admin().setId(4L).setLoginName("样例1");
          List<Admin> admins = adminMapper.selectByAdmin(admin);
          System.out.println(admins);
      }
  ```

``` xml

<select id="selectByAdmin" resultMap="BaseResultMap">
        select * from admin
        <where>
            <if test="admin.id != null">
                and id=#{admin.id}
            </if>
            <if test="admin.loginName != null and ''">
                and loginName = #{admin.loginName}
            </if>
        </where>
    </select>

```

![多条件查询](<./imgs/屏幕截图 2024-06-22 202148.png>)

##  1.2批量删除

- 单元测试中进行测试

  ``` java
  @Test
      void deleteCondition(){
        //delete from admin where id=(5,6,7)
          List<Long> list = Arrays.asList(5L,6L,7L);
          adminMapper.deleteByList(list);
  
      }
  ```
  

```xml
<delete id="deleteByList">
    delete from admin where id in
    <foreach collection="ids" separator="," item="id" open="(" close=")">
        #{id}
    </foreach>
</delete>
```

![批量删除](<./imgs/屏幕截图 2024-06-22 212204.png>)

## 1.3 批量添加

- 在单元测试中

  ```java
  @Test
      void addCondition(){
          //insert into admin(loginName,password) values (..) (...)
          Admin admin1 = new Admin().setLoginName("欧文").setPassword("213157");
          Admin admin2 = new Admin().setLoginName("库里").setPassword("965802");
          List<Admin> admins = Arrays.asList(admin1,admin2);
          adminMapper.insertByAdmin(admins);
      }
  ```

```xml
<insert id="insertByAdmin">
    insert into admin(loginName,password) values
    <foreach collection="admins" item="admin" separator=",">
        (#{admin.loginName},#{admin.password})
    </foreach>
</insert>
```

![批量添加](<./imgs/屏幕截图 2024-06-22 214020.png>)

## 2.两种连接查询

### 2.1表a查询表b

1. 创建一个新的sql

   ```sql
   CREATE TABLE room(
       id BIGINT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(20),
       admin_id BIGINT
   );
   ```

2. 需要实现的连接查询

   ```mysql
   select * from room
   LEFT JOIN admin ON room.admin_id=admin.id
   WHERE room.id=1
   
   ```

3. 单元测试其方法

   ```java
   @Test
       void contact1(){
           //select * from room
           //LEFT JOIN admin ON room.admin_id=admin,id
           //WHERE room.id=1
           Room room = roomMapper.selectIdWithAdmin(1);
           System.out.println(room);
       }
   ```

4. xml配置相应的sql

   ```mysql
   	<resultMap id="RoomWithAdmin" type="com.example.mybatisplus.model.domain.Room">
           <id column="id" property="id" />
           <result column="name" property="name" />
           <result column="admin_id" property="adminId" />
           <association property="admin" javaType="com.example.mybatisplus.model.domain.Admin">
               <id column="admin_id" property="id" />
               <result column="loginName" property="loginName" />
               <result column="password" property="password" />
               <result column="lastLoginTime" property="lastLoginTime" />
               <result column="remark" property="remark" />
           </association>
       </resultMap>
       <select id="selectIdWithAdmin" resultMap="RoomWithAdmin">
           select * from room
                LEFT JOIN admin ON room.admin_id=admin.id
           WHERE room.id=#{id}
       </select>
   ```

   ![查询1](<./imgs/屏幕截图 2024-06-23 100312.png>)

### 2.2 表b查询表a

1. 需要实现的连接查询

   ```mysql
   select * from admin
   LEFT JOIN room On room.admin_id=admin.id
   WHERE admin.id=1
   ```

2. 单元测试及其方法

   ```java
   @Test
       void contact2(){
           //select * from admin
           //LEFT JOIN room On room.admin_id=admin.id
           //WHERE admin.id=1
           Admin admin = adminMapper.seleIdWithRoom(2);
           System.out.println(admin);
       }
   ```

3. xml配置相应的sql

   ```mysql
   <resultMap id="AdminWithRoom" type="com.example.mybatisplus.model.domain.Admin">
           <id column="id" property="id" />
           <result column="loginName" property="loginName" />
           <result column="password" property="password" />
           <result column="lastLoginTime" property="lastLoginTime" />
           <result column="remark" property="remark" />
           <collection property="roomlist" ofType="com.example.mybatisplus.model.domain.Room">
               <id column="roomId" property="id" />
               <result column="name" property="name" />
               <result column="id" property="adminId" />
           </collection>
       </resultMap>
       
       <select id="seleIdWithRoom" resultMap="AdminWithRoom">
           select * from admin
                             LEFT JOIN room On room.admin_id=admin.id
           WHERE admin.id=#{id}
       </select>
   ```

   ![连接2](<./imgs/屏幕截图 2024-06-23 101717.png>)











