### 服务类导读

DaoProvider：这个是为了给所有服务类提供mapper而创建的类
所有Service类都应继承它，以获得mapper，获取数据库操作能力
（其中也是mybatis 的基础用法）

XXXXService：其中是各个实体类的服务类
其中包括了 插入与按时段查询数据的方法；
（先看TemperatureService 温度的服务类，其中有详细的代码注释，其他的代码类似）

CommonService： 这里是按周，按月，按年查询的服务类

ResultService：仅仅用于传递参数
