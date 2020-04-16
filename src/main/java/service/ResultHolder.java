package service;

import java.util.List;

//仅仅用于传递参数
public class ResultHolder {
    List keys;
    List values;

    public ResultHolder(List keys, List values) {
        this.keys = keys;
        this.values = values;
    }

    public List getKeys() {
        return keys;
    }

    public List getValues() {
        return values;
    }
}
