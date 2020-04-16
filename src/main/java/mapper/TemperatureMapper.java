package mapper;

import entity.Temperature;
import java.util.Date;
import java.util.List;

public interface TemperatureMapper {
    int deleteByPrimaryKey(Date now);

    int insert(Temperature record);

    int insertSelective(Temperature record);

    Temperature selectByPrimaryKey(Date now);

    int updateByPrimaryKeySelective(Temperature record);

    int updateByPrimaryKey(Temperature record);

    List<Temperature> queryByTime(String start,String end,String number);
}