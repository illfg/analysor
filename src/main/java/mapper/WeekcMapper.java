package mapper;

import entity.Weekc;

import java.util.List;

public interface WeekcMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Weekc record);

    int insertSelective(Weekc record);

    Weekc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Weekc record);

    int updateByPrimaryKey(Weekc record);

    List<Weekc> queryByYear(int year,String number);
    List<Weekc> queryByMonth(int year,int month,String number);
    List<Weekc> queryByWeek(int year,int month,int week,String number);
}