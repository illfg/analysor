package mapper;

import entity.Humidity;
import entity.Temperature;

import java.util.Date;
import java.util.List;

public interface HumidityMapper {


    int deleteByPrimaryKey(Date now);

    int insert(Humidity record);

    int insertSelective(Humidity record);

    Humidity selectByPrimaryKey(Date now);

    int updateByPrimaryKeySelective(Humidity record);

    int updateByPrimaryKey(Humidity record);

    List<Humidity> queryByTime(String start, String end, String number);
}