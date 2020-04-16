package service;

import entity.Temperature;
import mapper.TemperatureMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TemperatureService extends DaoProvider {
    TemperatureMapper mapper = getMapper(TemperatureMapper.class);

    public Temperature queryByKey(Date now){
        Temperature temperature = mapper.selectByPrimaryKey(now);
        return temperature;
    }
    
    public void insert(Temperature temperature){
        mapper.insert(temperature);
        commit();
    }

    public List<Temperature> queryByTime(String start, String end, String number){
        List<Temperature> temperatures = mapper.queryByTime(start, end, number);
        return temperatures;
    }

    //解析按时段查询的数据结果
    public ResultHolder calculateDataByDay(String start, String end, String number){
        //用于储存结果集
        ArrayList<Integer> keys = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
        //拿到该时间段的所有数据
        List<Temperature> temperatures = queryByTime(start, end, number);

        //转化为符合Date的格式
        String start_format = start.replace("-", "/");
        String end_format = end.replace("-", "/");

        //分离 日期 与 时段
        String[] start_split = start_format.split(" ");
        //获得日期与时间
        String day = start_split[0];
        String start_time = start_split[1];
        //获取小时 并转化为整型
        String start_time_num = start_time.substring(0, 2);
        int index = Integer.parseInt(start_time_num);

        //开始将查询的结果按时段分类
        //date_index1 date_index2是当前循环的时间区间
        //end_index 是结束的时间，如果当前循环的时间比结束时间早
        //就接着处理
        Date date_index1 = new Date(start_format);
        Date date_index2 = null;
        if (index<10){
            date_index2 = new Date(day +" " + "0"+ ++index + ":00:00");
        }else {
            date_index2 = new Date(day +" " + ++index + ":00:00");
        }

        Date end_index = new Date(end_format);
        while (date_index1.before(end_index)){
            Double result = 0.0;
            int size = 0;
            for (Temperature tem:temperatures) {
                Date now = tem.getNow();
                //判断时间是否再区间内
                if (date_index1.getTime() <= now.getTime() && now.before(date_index2)){
                    result += Double.parseDouble(tem.getTem());
                    size++;
                }
            }
            //计算平均值,并保存到结果集中
            result = result/size;
            if (result.isNaN()){
                result = 0.0;
            }
            keys.add(index -1);
            values.add(result);
            //重置数据
            size = 0;
            result = 0.0;
            //向后移动一个时间区间
            date_index1 = date_index2;
            if (index + 1<10){
                date_index2 = new Date(day +" " + "0"+ ++index + ":00:00");
            }else {
                date_index2 = new Date(day +" " + ++index + ":00:00");
            }
        }
        return new ResultHolder(keys,values);
    }


}
