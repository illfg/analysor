package service;

import entity.Temperature;
import entity.Weekc;
import mapper.WeekcMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonService extends DaoProvider {
    WeekcMapper mapper = getMapper(WeekcMapper.class);

    public void insert(Weekc weekc){
        mapper.insert(weekc);
        commit();
    }

    public ResultHolder queryByWeek(int year,int month,int week,String number){
        //用于储存结果集
        ArrayList<Integer> keys = new ArrayList<>();
        ArrayList<Weekc> values = new ArrayList<>();

        //拿到该时间段的所有数据
        List<Weekc> weekcs = mapper.queryByWeek(year, month, week, number);

        int start = (week-1)* 7+1;
        //应为很多周数是跨月份的，指定月份再指定周数，就会导致最后几天不属于4个周内
        //这里将多个几天加入到第四周
        int end = 0;
        if (week == 4){
            end = start +9;
        }else {
            end = start + 7;
        }
        //第几天

        //将数据分类
        while (start < end){
            //用于记录这一轮是否有有效数据
            boolean flag = false;
            for (Weekc weekc:weekcs) {
                String day = weekc.getDay();
                int dayi = Integer.parseInt(day);
                //判断时间是否再区间内
                if (dayi == start){
                    keys.add(start);
                    values.add(weekc);
                    flag =true;
                    break;
                }
            }
            if (!flag){
                keys.add(start);
                //给一个空值
                values.add(new Weekc(0,"",week,month,"","",0.0,"",""));
            }
            start++;
        }


        return new ResultHolder(keys,values);
    }

    public ResultHolder queryByMonth(int year,int month,String number){
        //用于储存结果集
        ArrayList<Integer> keys = new ArrayList<>();
        ArrayList<Weekc> values = new ArrayList<>();

        //拿到该时间段的所有数据
        List<Weekc> weekcs = mapper.queryByMonth(year, month, number);
        int start = 1,end = 30;

        //将数据分类排序
        while (start<=end){
            //用于记录这一轮是否有有效数据
            boolean flag = false;
            for (Weekc weekc:weekcs) {
                String day = weekc.getDay();
                int dayi = Integer.parseInt(day);
                //判断时间是否再区间内
                if (dayi == start){
                    keys.add(start);
                    values.add(weekc);
                    flag =true;
                    break;
                }
            }
            if (!flag){
                keys.add(start);
                //给一个空值
                values.add(new Weekc(0,"",0,0,"","",0.0,"",""));
            }
            start++;
        }
        return new ResultHolder(keys,values);
    }

    public ResultHolder queryByYear(int year,String number){
        //用于储存结果集
        ArrayList<Integer> keys = new ArrayList<>();
        ArrayList<Weekc> values = new ArrayList<>();

        //拿到该时间段的所有数据
        List<Weekc> weekcs = mapper.queryByYear(year, number);
        int start = 1,end = 12;

        //将数据分类排序
        while (start<=end){
            //用于记录这一轮是否有有效数据
            boolean flag = false;
            //计算月平均
            Double tems=0.0,hums=0.0,accs=0.0;
            Integer size = 0;
            for (Weekc weekc:weekcs) {
                int month = weekc.getMonth();
                //判断时间是否再区间内
                if (month == start){
                     tems += Double.parseDouble(weekc.getTem());
                     hums += Double.parseDouble(weekc.getHum());
                     accs += weekc.getAcc40();
                    flag =true;
                    size++;
                }
            }

            if (!flag){
                keys.add(start);
                //给一个空值
                values.add(new Weekc(0,"",0,0,"","",0.0,"",""));
            }else {
                //记录计算好的月平均
                keys.add(start);
                tems = tems/size;
                hums = hums/size;
                accs = accs/size;
                //如果是空值，就给个0.0
                if (tems.isNaN())
                    tems = 0.0;
                if (hums.isNaN())
                    hums = 0.0;
                if (accs.isNaN())
                    accs = 0.0;
                values.add(new Weekc(0,"",0,0,"",hums.toString(),
                        accs,tems.toString(),number));
            }
            start++;
        }
        return new ResultHolder(keys,values);
    }

}
