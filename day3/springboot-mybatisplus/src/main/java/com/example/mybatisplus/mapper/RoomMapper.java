package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.Room;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2024-06-23
 */
public interface RoomMapper extends BaseMapper<Room> {

    Room selectIdWithAdmin(@Param("id") int i);
}
