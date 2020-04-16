package mapper;

import entity.Mes;

import java.util.List;

public interface MesMapper {
    int deleteByPrimaryKey(String mobile);

    int insert(Mes record);

    int insertSelective(Mes record);

    Mes selectByPrimaryKey(String mobile);

    int updateByPrimaryKeySelective(Mes record);

    int updateByPrimaryKey(Mes record);

    List<Mes> selectAllMes();
}