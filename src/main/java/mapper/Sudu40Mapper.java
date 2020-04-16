package mapper;

import entity.Humidity;
import entity.Sudu40;
import java.util.Date;
import java.util.List;

public interface Sudu40Mapper {
    int deleteByPrimaryKey(Date now);

    int insert(Sudu40 record);

    int insertSelective(Sudu40 record);

    Sudu40 selectByPrimaryKey(Date now);

    int updateByPrimaryKeySelective(Sudu40 record);

    int updateByPrimaryKey(Sudu40 record);

    List<Sudu40> queryByTime(String start, String end, String number);
}